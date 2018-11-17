# [POST] /searchFor/all

> This endpoint is the more generic endpoint. 
> It return a JSON object composed by the JSON object of the parking data and the JSON object of the weather data.

`Input` : JSON Format 
```javascript 
{
    "parameters": {
        "maxEntries": 10
    }
}
```

Where `maxEntries` is the number of items you wish to retrieve (10 is default).

`Output` : JSON Format

```javascript

ormatted JSON Data
{  
   "dataParking":{  
      "durationRange":{ .. },
      "entries":{ ..  }
   },
   "dataWeather":{  
      "durationRange":{ .. },
      "entries":{ .. }
   }
}

```

For a detailled description about what the `dataParking` object does contain, refer to [/searchFor/parkingall](https://github.com/LucasL13/citypulse-api/blob/master/Documentation/searchFor.parking.all.md)

For a detailled description about what the `dataWeather` object does contain, refer to [/searchFor/weatherall](https://github.com/LucasL13/citypulse-api/blob/master/Documentation/searchFor.weather.all.md)
