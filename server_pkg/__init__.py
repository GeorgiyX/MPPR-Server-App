#Данный файл выполняется когда мы импортируем наш пакет server_pkg
from flask import Flask
app = Flask(__name__) # __name__ - имя модуля, Flask использует имя модуля как отправную точку при поиске ресуров.
from server_pkg import routes