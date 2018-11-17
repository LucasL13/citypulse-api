
# [POST] /searchFor/mapdata

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
  "head": {
    "vars": [
      "longitude",
      "latitude"
    ]
  },
  "results": {
    "bindings": [
      {
        "longitude": {
          "type": "literal",
          "datatype": "http://www.w3.org/2001/XMLSchema#decimal",
          "value": "10.2049"
        },
        "latitude": {
          "type": "literal",
          "datatype": "http://www.w3.org/2001/XMLSchema#decimal",
          "value": "56.15679"
        }
      },
      {
        "longitude": {
          "type": "literal",
          "datatype": "http://www.w3.org/2001/XMLSchema#decimal",
          "value": "10.21149"
        },
        "latitude": {
          "type": "literal",
          "datatype": "http://www.w3.org/2001/XMLSchema#decimal",
          "value": "56.14952"
        }
      }
    ]
  }
}
```
