from sklearn.tree import DecisionTreeClassifier
import pandas as pd
from server_pkg.utils import *

decision_tree_loaded = load_obj("decision_tree_trained_model")
data_code = load_obj("data_code")
product_collection = load_obj("product_collection")



def get_data_frame_from_JSON(json):
    # Сначала объеденим три последних ключа:
    json["VT_TBT_EmbOption"] = str(json["Intel_Virtualization_Technology"]) + " + " + str(
        json["Intel_Turbo_Boost_Technology"]) + " + " + str(json["Embedded_Options_Available"])
    del json["Intel_Virtualization_Technology"]
    del json["Intel_Turbo_Boost_Technology"]
    del json["Embedded_Options_Available"]
    # подготовим DF:
    for key, val in json.items():
        if key in data_code:
            # Нужна проверка если мы указали не существующий Lanunch Date
            json[key] = data_code[key][val]
    return pd.DataFrame(json, index=[0])

def get_predict_json(df):
    predict_val = decision_tree_loaded.predict(df)
    return {"cpu_series" : product_collection[str(predict_val[0])]}
