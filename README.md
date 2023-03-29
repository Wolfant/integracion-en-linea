# integracion-en-linea
Deber de integración en linea 

# Enunciado
## Integración en linea
La empresa XYZ ha tenido un crecimiento constante, paso de tener una oficina a tener 20 oficinas en todo el país, además de abrir presencia en plataformas para masificar sus productos y atraer a más clientes utilizando Facebook y WhatsApp para empresas, en donde de igual manera ha tenido una gran acogida; utilizan la versión comercial en la nube del fabricante de Odoo, reduciendo los problemas de lentitud e intermitencia que tenían entre las diferentes oficinas, con la finalidad de gestionar de una manera adecuada a la gran cantidad de clientes que actualmente tiene la empresa, han utilizado el módulo de CRM con buenos resultados.

Por relaciones comerciales, la empresa paso a formar parte de un consorcio o grupo con la finalidad de generar negocios entre las empresas del grupo, por lo que dentro del grupo existen empresas especializadas para manejar perfiles de clientes en función de la preferencia de compra de los clientes.

La empresa XYZ ya tiene perfilado a sus clientes por medio del módulo del CRM
La empresa 123 es una empresa especializada en manejar clientes cuyo perfil de compras en linea, son clientes que realizan todas sus transacciones solamente por canales digitales.
La empresa ABC se especializa en manera clientes que si bien son abordados en linea, la compras y la transacción la prefieren realizar por canales presenciales como las oficinas.
Se necesita una solución en linea que permita pasar los clientes de la empresa XYZ a las empresas 123 y ABC en función del perfil del canal de compras del cliente, las empresas 123 y ABC utilizan sistemas de información o plataformas distintas, han logrado desarrollar un servicio web para recibir la información del cliente de la empresa XYZ, se han puesto de acuerdo para intercambiar la información en forma JSON.

Desarrolle una solución tipo prueba de concepto, que permita realizar un escenarios que simule el ambiente antes descrito, utilizando un framework de integración asi como un patrón de integración que permita transmitir la información de los clientes.

# Rutas en Camel

Creacion de rutas de camel basadas en payload del Consumer

## Flujo
```
                          .---> Customer channel f2f -> f2f-service
Customer --> camer-routes /
                         \
                          .-->  Customer channel Digital -> digital-service -> sqlite
```

## Servicio f2f-service

Servicio en flask, para realizar pruebas en solitario se puede usar la colecion de
ThunderClient en:

```
 f2f-service/thunder-collection_ms-f2f-flask.json
```

### Iniciar servicio flask

``` 
    cd f2f-service
    python3 -m venv .venv
    source .venv/bin/activate
    python3 -m pip install -r requirements.txt
    python3 main.py
```

## Servicio digital-service

Servicio en NestJs, para realizar pruebas en solitario se puede usar la colecion de
ThunderClient en:

```
 f2f-service/thunder-collection_ms-digital-nestjs.json
```

la base de datos es: db.sqlite


### Iniciar servicio NestJs

``` 
    cd digital-service
    npm install
    npm run start:dev
```

# Servicio de  Ruta en Camel

Aplicativo de camel que ejecuta rutas en base al payload enviado
se puede usar la coleccion en ThuderClient para revisar el funcionamiento de la rutas en

````
 camel-rute/thunder-collection_camel-routes.json
````
### Iniciar Camel

``` 
    cd camel-rute
    ./mvnw clean package
    ./mvnw spring-boot:run
```

