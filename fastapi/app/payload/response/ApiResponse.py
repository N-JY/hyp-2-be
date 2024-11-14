from pydantic import BaseModel
from typing import Optional, TypeVar

T = TypeVar('T')

class ApiResponse(BaseModel):
    code: int
    message: str
    data: Optional[T] = None

    @classmethod
    def ok(cls, code: int, message: str, data: Optional[T] = None):
        return cls(
            code=code,
            message=message,
            data=data
        )