
# [POST] /searchFor/parkingall

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

This endpoint will return you a JSON parsed following this format : 

```javascript
{
  "durationRange": {
    "head": {
      "vars": [
        "SEStart",
        "SEEnd"
      ]
    },
    "results": {
      "bindings": [
        {
          "SEStart": {
            "type": "literal",
            "datatype": "http://www.w3.org/2001/XMLSchema#dateTime",
            "value": "2014-10-01T00:00:00"
          },
          "SEEnd": {
            "type": "literal",
            "datatype": "http://www.w3.org/2001/XMLSchema#dateTime",
            "value": "2014-11-13T23:59:59"
          }
        }
      ]
    }
  },
  "entries": {
    "head": {
      "vars": [
        "point",
        "val",
        "unit",
        "name",
        "longitude",
        "latitude",
        "pTime"
      ]
    },
    "results": {
      "bindings": [
        {
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
          }
        },
        {
            "another entry etc.."
        }
      ]
    }
  }
}
```
