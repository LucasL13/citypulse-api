
# CityPulse-API
> by Lucas LOIGNON

> Documentation is being completed - stay tuned

## LIVE VERSION IS HERE, CHECK IT OUT : [http://164.132.51.109:4200](http://164.132.51.109:4200)
### Features : Charts, Map and JSON Viewer with data provided by the API Server

#### The live version of the API Server is here : send your requests POST@[http://164.132.51.109:9999](http://164.132.51.109:9999)
#### The live version of front-end API-based service is being added on 17/11/2018:6pm, stay tuned !


+ [Presentation](#presentation)
+ [Technologies](#technologies)
+ [Usage](#usage)
+ [API Endpoints](#api-endpoints)


## Presentation

This project aims to offer a complementary service for [http://iot.ee.surrey.ac.uk/citypulse](http://iot.ee.surrey.ac.uk/citypulse) datasets.
It provide both back-end and front-end service.

## Technologies

The back-end API runs with JavaEE + Spring and the Jena library (for parsing RDF files and querying with SPARQL langage).
The front-end service is handled by Angular CLI, supplied with few modules.
The design layer is made with Bootstrap4.

## Usage

**How to run the API Server :** 

`java -jar TPWoT-LOIGNON.war`

###### NB : You should avoid executing any request to the server until the `Data model loaded : API is running` message has spawned. ######

**How to send requests :**

 `@POST` `localhost:9999/`+`endpoint`

 **OR**

 `@POST` `http://164.132.51.109:9999`+`endpoint`

###### NB : Do not forget to include the body of the request (JSON formatted) with the requiered `input` parameters. ######

## API Endpoints

| Protocol  | Path  | Documentation  |
|--------------------------------------------------------|--------------------------------------------------------|--------------------------------------------------------|
| POST  | searchFor/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/Documentation/searchFor.all.md)  |
| POST  | searchFor/mapdata  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/Documentation/searchFor.mapdata.md) |
| POST  | searchFor/parking/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/Documentation/searchFor.parking.all.md)  |
| POST  | searchFor/weather/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/Documentation/searchFor.weather.all.md) |

