import jwt
import datetime
from uuid import UUID

class JWTUtil:
    SECRET_KEY = "30overkeys30overkeys30overkeys30overkeys"
    ALGORITHM = "HS256"

    @classmethod
    def generateToken(cls, token_uuid: UUID, minutes: int) -> str:
        expiration = datetime.datetime.utcnow() + datetime.timedelta(minutes=minutes)
        
        payload = {
            "uuid": str(token_uuid),
            "exp": expiration,
            "iat": datetime.datetime.utcnow(),
            "typ": "JWT"
        }

        token = jwt.encode(payload, cls.SECRET_KEY, algorithm=cls.ALGORITHM)
        return token