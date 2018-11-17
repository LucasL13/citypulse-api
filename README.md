
# CityPulse-API
## by Lucas LOIGNON

`Documentation is being completed - stay tuned`

[Presentation](#presentation)

[Technologies](#technologies)

[Usage](#usage)

[API Endpoints](#api-endpoints)


## Presentation

This project aims to offer a complementary service for [http://iot.ee.surrey.ac.uk/citypulse](http://iot.ee.surrey.ac.uk/citypulse) datasets.
It provide both back-end and front-end service.

## Technologies

The back-end API runs with JavaEE + Spring and the Jena library (for parsing RDF files and querying with SPARQL langage).
The front-end service is handled by Angular CLI, supplied with few modules.

## Usage

**How to run the API Server :** 

`java -jar TPWoT-LOIGNON.war`

###### NB : You should avoid executing any request to the server until the `Data model loaded : API is running` message has spawned. ######

**How to send requests :**

 `@POST` `localhost:8090/`+`endpoint`

###### NB : Do not forget to include the body of the request (JSON formatted) with the requiered `input` parameters. ######

## API Endpoints

<p align="center">
aaaa 
 </p>


| Protocol  | Path  | Documentation  |
|--------------------------------------------------------|--------------------------------------------------------|--------------------------------------------------------|
| POST  | searchFor/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/documentation/searchFor.all.md)  |
| POST  | searchFor/mapdata  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/documentation/searchFor.mapdata.md) |
| POST  | searchFor/parking/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/documentation/searchFor.parking.all.md)  |
| POST  | searchFor/weather/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/documentation/searchFor.weather.all.md) |

