
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


[/searchFor/parkingall](#/searchFor/parkingall)

[/searchFor/weatherall](#/searchFor/parkingall)

[/searchFor/parkingall](#/searchFor/parkingall)

[/searchFor/parkingall](#/searchFor/parkingall)

### [[POST] /searchFor/all]()

This endpoint is the more generic endpoint. 

It return a JSON object composed by the JSON object of the parking data and the JSON object of the weather data.


```javascript

{"dataParking": {'someData'}, "dataWeather": {'someData'}}

```

To see what the `dataParking` object does contain, refer to [/searchFor/parkingall](https://github.com/LucasL13/citypulse-api#post-searchforparkingall)

To see what the `dataWeather` object does contain, refer to [/searchFor/weatherall](https://github.com/LucasL13/citypulse-api#post-searchforweatherall)


### [POST] /searchFor/parkingall

`Input` : JSON Format 
```javascript 
{
    "parameters": {
        "maxEntries":
    }
}
```

Where `maxEntries` is the number of items you wish to retrieve.

`Output`

This endpoint will return you a JSON parsed following this format : 

```javascript
{
    "head": {
        "vars": ["point", "val", "unit", "name", "longitude", "latitude", "pTime", "setStart", "setEnd"]
    },
    "results": {
        "bindings": [{
                "point": {
                    "type": "uri",
                    "value": "http://iot.ee.surrey.ac.uk/citypulse/datasets/parking/parkingDataStream#observations_point_8o3ld4h0ibof5pv4n6mjanv7g8"
                },
                "val": {
                    "type": "literal",
                    "value": "26"
                },
                "unit": {
                    "type": "uri",
                    "value": "http://purl.oclc.org/NET/muo/citypulse/unit/trafficvehicle-count"
                },
                "name": {
                    "type": "literal",
                    "value": "Parking Information With ID 8o3ld4h0ibof5pv4n6mjanv7g8"
                },
                "longitude": {
                    "type": "literal",
                    "datatype": "http://www.w3.org/2001/XMLSchema#decimal",
                    "value": "10.2049"
                },
                "latitude": {
                    "type": "literal",
                    "datatype": "http://www.w3.org/2001/XMLSchema#decimal",
                    "value": "56.15679"
                },
                "pTime": {
                    "type": "literal",
                    "datatype": "http://www.w3.org/2001/XMLSchema#dateTime",
                    "value": "2014-09-14T02:01:49"
                },
                "setStart": {
                    "type": "literal",
                    "datatype": "http://www.w3.org/2001/XMLSchema#dateTime",
                    "value": "2014-10-01T00:00:00"
                },
                "setEnd": {
                    "type": "literal",
                    "datatype": "http://www.w3.org/2001/XMLSchema#dateTime",
                    "value": "2014-11-13T23:59:59"
                }
            },
            {
                "another entry etc"
            }
        ]
    }
}
```

### [POST] /searchFor/weatherall

### [GET] /searchFor/dataall


