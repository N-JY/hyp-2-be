import pytest
from fastapi.testclient import TestClient
from app.HyperMedicusApplication import app
from app.model.AccountDTO import AccountSignUpDTO
from app.resources.Sqlalchemy import SessionLocal
from app.service import AccountService

client = TestClient(app)

@pytest.fixture
def accountSignupDto():
    return AccountSignUpDTO(
        password="password",
        name="Test Name",
        email="test@email.com",
        phone="123-456-7890",
        nation="Test Nation",
        hospital="Test Hospital",
        department="Test Department"
    )

@pytest.fixture(autouse=True)
def db_session():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.rollback()
        db.close()

def testSignUpAccount(accountSignupDto):
    response = client.post("/api/account/signup", json=accountSignupDto.dict())
    assert response.status_code == 200
    print(response.json())