FROM python:3.8

RUN mkdir /code
WORKDIR /code

COPY . .
RUN pip3 install -r requirements.txt
EXPOSE 5000

RUN cd src

ENV FLASK_APP=src/main.py

CMD [ "python3", "-m" , "flask", "run", "--host=0.0.0.0"]