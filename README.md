
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

**Pour lancer le serveur API :** 

`java -jar TPWoT-LOIGNON.war`

###### NB : Attendre l'apparation du message `Data model loaded : API is running` avant d'éxécuter la moindre requête. ######

**Pour executer des requêtes :**

 `@POST` `localhost:8090/`+`endpoint`

###### NB : Ne pas oublier d'inclure le corps de la requête au format JSON avec les parametres `input` exigés. ######

## API Endpoints


| Protocol  | Path  | Documentation  |
|---|---|---|
| POST  | searchFor/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/documentation/searchFor.all.md)  |
| POST  | searchFor/mapdata  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/documentation/searchFor.mapdata.md) |
| POST  | searchFor/parking/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/documentation/searchFor.parking.all.md)  |
| POST  | searchFor/weather/all  | [See usage](https://github.com/LucasL13/citypulse-api/blob/master/documentation/searchFor.weather.all.md) |
