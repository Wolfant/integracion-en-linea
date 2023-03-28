import json

class Customer():
    def __init__(self, id, name, gender, customer_dni, customer_channel):
        self.id = id
        self.name = name
        self.gender = gender
        self.customer_dni = customer_dni
        self.customer_channel = customer_channel
    
    def toJSON(self):
        return json.dumps(self, default=lambda o: o.__dict__, 
            sort_keys=True, indent=4)