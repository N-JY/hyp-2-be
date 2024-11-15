from fastapi import APIRouter
from app.model.AccountDTO import AccountDTO
from app.service.AccountService import AccountService
from typing import Dict
from app.payload.response.ApiResponse import ApiResponse
from http import HTTPStatus

router = APIRouter(
    prefix="/api/account"
)

@router.post("/signup", response_model=ApiResponse)
def signUpAccount(data: AccountDTO):
    retrun_msg = AccountService.signUpAccount(data)
    return ApiResponse.ok(code=HTTPStatus.OK.value, message=HTTPStatus.OK.phrase, data=retrun_msg)