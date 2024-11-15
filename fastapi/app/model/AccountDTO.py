from pydantic import BaseModel, EmailStr

class AccountDTO(BaseModel):
    password: str
    name: str
    email: EmailStr
    phone: str
    nation: str
    hospital: str
    department: str