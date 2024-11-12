from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.declarative import declarative_base
import os
from dotenv import load_dotenv

load_dotenv(verbose=True)
DATABASE_SETTING = os.environ["DATABASE_SETTING"]

if (DATABASE_SETTING == "POSTGRESQL"):
    DATABASE_URL= os.environ["DATABASE_URL_POSTGRESQL"]
else:
    DATABASE_URL = os.environ["DATABASE_URL_MARIADB"]

engine = create_engine(DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
Base = declarative_base()
