# Add Suburb API

Adds a suburb.

* **URL**

  /suburbs

* **Method:**

  `POST`

*  **URL Params**

  None 
   
* **Data Params**

```json
{
  "name": "Warranwood",
  "state": "VIC",
  "postCode": "/postcodes/1"
}
```
  
  **Required:**
  `name=[string]`
  `state=[string]`
  `postCode=[reference to post code HATEOAS resource]`
  

* **Success Response:**
  * **Code:** 200
   **Content:** 
```json
  {
    "name": "Warranwood",
    "state": "VIC",
    "_links": {
        "self": {
            "href": "http://localhost:8080/suburbs/38"
        },
        "suburb": {
            "href": "http://localhost:8080/suburbs/38"
        },
        "postCode": {
            "href": "http://localhost:8080/suburbs/38/postCode"
        }
    }
}
``` 
* **Error Response:**
  
  * **Code:** 400 BAD REQUEST

    **Content**
```json    
{
    "httpStatus": "409 - CONFLICT",
    "errorCode": "2e482454-5148-4bf4-9ab7-84c7f65b318f",
    "errorMessage": "Data integrity violation error. Please contact an administrator and quote '2e482454-5148-4bf4-9ab7-84c7f65b318f'"
}
```

* **Sample Call:**
  ```
    POST /suburbs
    {
 		"name": "Warranwood1",
  		"state": "VIC",
  		"postCode": "/postcodes/1"
    }
  ```