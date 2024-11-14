from app.resources.Sqlalchemy import Base
from sqlalchemy import Column, String, Integer
from sqlalchemy.dialects.postgresql import UUID
from sqlalchemy.sql.sqltypes import TIMESTAMP

class Account(Base):
    __tablename__ = 'account'
    
    uuid = Column(UUID(as_uuid=True), primary_key=True, nullable=False)
    password = Column(String(128), nullable=True, default=None)
    password_updated_datetime = Column(String(14), nullable=True, default='99991231235959')
    password_notice_datetime = Column(String(14), nullable=True, default='99991231235959')
    created_datetime = Column(String(14), nullable=True, default='99991231235959')
    last_login_datetime = Column(String(14), nullable=True, default='99991231235959')
    login_count = Column(String(10), nullable=True, default='0')
    refresh_token = Column(String(512), nullable=True, default=None)
    status = Column(String(1), nullable=True, default='A')
    termination_datetime = Column(String(14), nullable=True, default='99991231235959')

class AccountClassification(Base):
    __tablename__ = 'account_classification'
    
    uuid = Column(UUID(as_uuid=True), primary_key=True, nullable=False)
    name = Column(String(30), nullable=True, default=None)
    email = Column(String(30), nullable=True, default=None)
    phone = Column(String(15), nullable=True, default=None)
    nation = Column(String(30), nullable=True, default=None)
    hospital = Column(String(30), nullable=True, default=None)
    department = Column(String(30), nullable=True, default=None)


class AccountVerification(Base):
    __tablename__ = 'account_verification'
    
    uuid = Column(UUID(as_uuid=True), primary_key=True, nullable=False)
    sequence = Column(String(10), nullable=True)
    classification = Column(String(8), nullable=True)
    classification_id = Column(String(255), nullable=True)
    verification = Column(String(1), nullable=True)
    verification_code = Column(String(8), nullable=True)
    verification_datetime = Column(String(14), nullable=True, default='99991231235959')
    status = Column(String(1), nullable=True, default='A')