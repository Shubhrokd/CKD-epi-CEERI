from flask import Flask, request, jsonify
import numpy as np
import pickle

model = pickle.load(open("rfmodel2.pkl", "rb"))
app = Flask(__name__)


@app.route("/")
def index():
    return "Hello world"


@app.route("/predict", methods=["POST"])
def predict():
    htn = request.form.get("htn")
    hemo = request.form.get("hemo")
    dm = request.form.get("dm")
    cad = request.form.get("cad")
    appet = request.form.get("appet")
    pe = request.form.get("pe")
    ane = request.form.get("ane")
    age = request.form.get("age")
    atc = request.form.get("atc")

    input_query = np.array([[htn, hemo, dm, cad, appet, pe, ane, age, atc]])
    result = model.predict(input_query)

    # return jsonify({"Result": int(result)})

    if int(result) == 1:
        return jsonify({"Result": "CKD Positive"})
    elif int(result) == 0:
        return jsonify({"Result": "CKD Negative"})
    else:
        return jsonify({"Error"})


if __name__ == "__main__":
    app.run(debug=True)
