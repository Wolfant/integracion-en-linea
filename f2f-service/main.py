import json
import customer
from flask import Flask, jsonify, request, abort

app = Flask(__name__)
CUSTOMER_ARRAY=[];

@app.route('/customer/findAll', methods = ['GET'])
def returnAll():
    if(request.method == 'GET'):
        return jsonify(CUSTOMER_ARRAY)

@app.route('/customer/<int:id>', methods = ['GET'])
def findByCode(id):
    if(request.method == 'GET'):
        for customer in CUSTOMER_ARRAY:
            if(customer['id'] == id):
                return jsonify(customer)
        abort(404)

@app.route('/customer', methods = ['POST'])
def addNew():
    body = json.loads(request.data)
    if(request.headers.get('Content-Type')=='application/json'):
        new_customer = customer.Customer(body['id'],body['name'], body['gender'],
                                      body['customer_dni'], body['customer_channel']) 
        CUSTOMER_ARRAY.append(json.loads(new_customer.toJSON()))
        return "OK"
    else:
        abort(400, "No valido")

if __name__=='__main__':
    app.run(debug=True)

