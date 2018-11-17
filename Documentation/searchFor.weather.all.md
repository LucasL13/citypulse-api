
### [POST] /searchFor/parkingall

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
            "value": "2014-08-01T00:00:00"
          },
          "SEEnd": {
            "type": "literal",
            "datatype": "http://www.w3.org/2001/XMLSchema#dateTime",
            "value": "2014-09-30T00:00:00"
          }
        }
      ]
    }
  },
  "entries": {
    "head": {
      "vars": [
        "pTime",
        "unit",
        "val"
      ]
    },
    "results": {
      "bindings": [
        {
          "pTime": {
            "type": "literal",
            "datatype": "http://www.w3.org/2001/XMLSchema#dateTime",
            "value": "2014-09-07T15:50:00"
          },
          "unit": {
            "type": "uri",
            "value": "http://purl.oclc.org/NET/muo/ucum/unit/fractionpercent"
          },
          "val": {
            "type": "literal",
            "value": "73"
          }
        },
        {
          "another entry etc.."
          }
        }
      ]
    }
  }
}
```
