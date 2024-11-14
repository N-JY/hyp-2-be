import uuid
from app.rds.entity.AccountEntity import Account, AccountClassification
from app.model.AccountDTO import AccountSignUpDTO
from app.resources.Sqlalchemy import SessionLocal
import pandas as pd
import json

class AccountConnect:
    @staticmethod
    def database():
        return SessionLocal()

    @staticmethod    
    def signUpAccount(in_data: AccountSignUpDTO, in_uuid: uuid):
        new_account = Account(
            uuid=in_uuid,
            password=in_data.password
        )

        
        new_classification = AccountClassification(
            uuid=in_uuid,
            name=in_data.name,
            email=in_data.email,
            phone=in_data.phone,
            nation=in_data.nation,
            hospital=in_data.hospital,
            department=in_data.department
        )
        
        db = AccountConnect.database()
        try:
            db.add(new_account)
            db.add(new_classification)   
            db.commit()
        finally:
            db.close()

        result = AccountConnect.getAccount(in_uuid)
        
        return result
    
    @staticmethod
    def getAccount(in_uuid: uuid):
        db = AccountConnect.database()
        try:
            result = db.query(Account, AccountClassification).join(
                AccountClassification, Account.uuid == AccountClassification.uuid
            ).filter(Account.uuid == in_uuid).first()

            return result
        finally:
            db.close()

