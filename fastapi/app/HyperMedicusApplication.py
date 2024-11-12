from fastapi import FastAPI
from .resources.Sqlalchemy import Base, engine
from .rds.entity import AccountEntity

Base.metadata.create_all(bind=engine)

app = FastAPI()

@app.get("/")
def home():
    return {"home":"home"}

if __name__ == "__main__":
    import uvicorn
    uvicorn.run("HyperMedicusApplication:app", host="0.0.0.0")
