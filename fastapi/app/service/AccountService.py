from app.model.AccountDTO import AccountSignUpDTO

class AccountService:
    @staticmethod
    def signUpAccount(in_data: AccountSignUpDTO):
        import uuid
        from app.connect.AccountConnect import AccountConnect
        create_uuid: uuid = uuid.uuid4()
        result = AccountConnect.signUpAccount(in_data, create_uuid)

        if result is not None:            
            account, classification = result
            account_dict = {column.name: getattr(account, column.name) for column in account.__table__.columns}
            classification_dict = {column.name: getattr(classification, column.name) for column in classification.__table__.columns}            
                
            account_dict.pop("uuid")
            classification_dict.pop("uuid")

            result_dict = {
                "account": account_dict,
                "accountclassification": classification_dict
            }
            return result_dict
        return result
