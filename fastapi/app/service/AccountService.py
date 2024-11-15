from app.model.AccountDTO import AccountDTO
from app.common.utils.JWTUtil import JWTUtil

class AccountService:
    @staticmethod
    def signUpAccount(in_data: AccountDTO):
        import uuid
        from app.connect.AccountConnect import AccountConnect
        create_uuid: uuid = uuid.uuid4()
        result = AccountConnect.signUpAccount(in_data, create_uuid)

        if result is not None:            
            account, information = result
            account_dict = {column.name: getattr(account, column.name) for column in account.__table__.columns}
            information_dict = {column.name: getattr(information, column.name) for column in information.__table__.columns}            
                
            account_dict.pop("uuid")
            information_dict.pop("uuid")

            access_token = JWTUtil.generateToken(create_uuid, 10)            
            refresh_token = JWTUtil.generateToken(create_uuid, 60 * 24)

            information_dict["refresh_token"] = refresh_token

            result_dict = {
                "account": account_dict,
                "accountinformation": information_dict,
                "access_token": access_token
            }
            return result_dict
        return result
