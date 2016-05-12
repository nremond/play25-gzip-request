# play25-gzip-request

To reproduce the problem, look at:

`$curl -H "Content-Type: application/json" -X POST http://localhost:9000/foo --data "@body.json"`

vs 

`$curl -H "Content-Type: application/json" -H "Content-Encoding: gzip" -X POST http://localhost:9000/foo --data-binary "@body.json.gz"`
