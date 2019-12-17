from flask import request
from server_pkg import app
import json
from server_pkg.recognizer import *


@app.route("/")
def hello_route():
    return "Hello from Flask!"

@app.route("/api/predict_cpu", methods = ["POST"])
def predict_cpu():
    return json.dumps(get_predict_json(get_data_frame_from_JSON(request.json)))
