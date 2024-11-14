import sys
import os

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from fastapi import FastAPI
from app.resources.Sqlalchemy import Base, engine
from app.rds.entity import AccountEntity
from app.controller import AccountController

Base.metadata.create_all(bind=engine)

app = FastAPI()

@app.get("/")
def home():
    return {"home":"home"}

app.include_router(AccountController.router)

if __name__ == "__main__":
    import uvicorn
    uvicorn.run("HyperMedicusApplication:app", host="0.0.0.0")
