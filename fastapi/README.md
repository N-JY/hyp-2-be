# FastAPI

- python : 3.11
- venv\Scripts\activate
- source venv/bin/activate
- deactivate

- pip install poetry
- poetry init

- poetry add fastapi uvicorn python-dotenv sqlalchemy

- poetry add pymysQL psycopg2

- fastapi scripts run
    - path : fastapi
    - .\venv\Scripts\python.exe app\HyperMedicusApplication.py

- pytest scripts run
    - path : fastapi
    - pytest -s

- fastapi uvicorn run
    - path : fastapi
    - uvicorn app.HyperMedicusApplication:app --host 0.0.0.0 --port 8000
