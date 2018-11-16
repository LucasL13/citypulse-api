
# CityPulse-API

[Presentation](#presentation)

[Technologies](#technologies)

[Utilisation](#utilisation)

[API Endpoints](#api-endpoints)


## Presentation

This project aims to offer a complementary service for [http://iot.ee.surrey.ac.uk/citypulse](http://iot.ee.surrey.ac.uk/citypulse) datasets.
It provide both back-end and front-end service.

## Technologies

The back-end API runs with JavaEE + Spring and the Jena library (for parsing RDF files and querying with SPARQL langage).
The front-end service is handled by Angular CLI, supplied with few modules.

## Utilisation

## API Endpoints


| Protocol  | Path  | Documentation  |
|---|---|---|
| POST  | searchFor/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/searchFor.all.md)  |
| POST  | searchFor/mapdata  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/searchFor.mapdata.md) |
| POST  | searchFor/parking/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/searchFor.parking.all.md)  |
| POST  | searchFor/weather/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/searchFor.weather.all.md) |

### [POST] /searchFor/all

### [POST] /searchFor/parkingall

### [POST] /searchFor/weatherall

### [GET] /searchFor/dataall


