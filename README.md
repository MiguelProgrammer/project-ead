# project-ead
 
This project called project-ead, implemented rules, the best pratics programmer and more, just for remember e pratices.
 
### clean architecture
<br><img src="https://i.imgur.com/dmZ7kIK.png" alt="clean architecture" width="800" class="img-thumbnail"> 

<br><img src="https://i.imgur.com/9ie6BLt.png" alt="run app" width="800" class="img-thumbnail"> 

### Object Pageable hateoas
```json
{
    "content": [
        {
            "userID": "c0e071f0-b10e-4e87-b555-a0de386cd4ea",
            "userName": "MiguelProgrammer",
            "email": "silva@mackenzista.com.br",
            "fullName": "Miguel Pereira da Silva",
            "userStatus": "ACTIVE",
            "userType": "STUDENT",
            "phoneNumber": "11912345678",
            "cpf": "30030030030",
            "imageUrl": "minhafoto2.jpg",
            "creationDate": "13-06-2023 02:45:43",
            "lastUpdateDate": "14-06-2023 02:04:03",
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8087/users/c0e071f0-b10e-4e87-b555-a0de386cd4ea"
                }
            ]
        },
        {
            "userID": "fac95e90-29b3-442e-803e-ff23f5ad90c7",
            "userName": "MiguelProgrammerS",
            "email": "miguel@gmail.com",
            "fullName": "Miguel Pereira da Silva",
            "userStatus": "ACTIVE",
            "userType": "STUDENT",
            "phoneNumber": "11912345678",
            "cpf": "30030030030",
            "creationDate": "15-06-2023 02:41:23",
            "lastUpdateDate": "15-06-2023 02:41:23",
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8087/users/fac95e90-29b3-442e-803e-ff23f5ad90c7"
                }
            ]
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageNumber": 0,
        "pageSize": 10,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 2,
    "totalPages": 1,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "numberOfElements": 2,
    "size": 10,
    "number": 0,
    "empty": false
}
```

