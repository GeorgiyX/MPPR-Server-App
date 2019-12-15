import pickle

def save_obj(obj, name ):
    with open('obj/'+ name + '.save', 'wb') as f:
        pickle.dump(obj, f, pickle.HIGHEST_PROTOCOL)

def load_obj(name ):
    with open('obj/' + name + '.save', 'rb') as f:
        return pickle.load(f)