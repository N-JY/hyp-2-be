from pydantic import BaseModel, EmailStr

class AccountSignUpDTO(BaseModel):
    password: str
    name: str
    email: EmailStr
    phone: str
    nation: str
    hospital: str
    department: str