# example

Below Apis are there-

1. POST - http://localhost:8080/example/api/users/create

Request-body
```
{
    "name":"ABC",
    "email":"wwee@eee.com",
     "birthDate":"01-01-2001"
}
```
Response-body

```
{
    "id": 1,
    "name": "ABC",
    "email": "wwee@eee.com",
    "birthDate": "2001-01-01"
}

```


2. GET - http://localhost:8080/example/api/users/{userId}

 http://localhost:8080/example/api/users/1

ResponseBody
   
```
{
    "id": 1,
    "name": "ABC",
    "email": "wwee@eee.com",
    "birthDate": "2001-01-01"
}

```

3. getall users,  GET - http://localhost:8080/example/api/users

 http://localhost:8080/example/api/users

 
ResponseBody
```
[
    {
        "id": 1,
        "name": "ABC",
        "email": "wwee@eee.com",
        "birthDate": "2001-01-01"
    },
    {
        "id": 2,
        "name": "XYZ",
        "email": "wwee@eee.com",
        "birthDate": "2001-01-01"
    }
]
```

4. DELETE - http://localhost:8080/example/api/users/{userId}

 http://localhost:8080/example/api/users/1
 
ResponseBody
   
```
    204 - no content
```
