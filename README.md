# MovieRental App

ApiREST **movierental**. Read me in progress.



## Create files and folders

The file explorer is accessible using the button in left corner of the navigation bar. You can create a new file by clicking the **New file** button in the file explorer. You can also create folders by clicking the **New folder** button.

**ApiREST POSTMAN**
## Creating user endpoint:
Creating user endpoint:
http://localhost:8080/webapp/users/

URI: /users
HTTP Method: POST



**Body example**

    {
    "email" : "email@gmail.com",
    "password" : "test123"
    }
**HTTP Headers**

    Content-Type: application/json
    Accept: application/json
   
## Login user endpoint:
Login user enpoint:
http://localhost:8080/webapp/users/login

URI:/users/login
HTTP Method: POST

**HTTP Headers Response**

    Authorization: istrategies <token>
    UserID: <userId>


## Get All Users endpoint:
URI: /users
HTTP Method: GET

**HTTP Headers**

    Content-Type: application/json
    Accept: application/json
    Authorization: istrategies <token>

**Body Response**

    [
    	{
    		"id": 1,
    		"username": "WalterBates",
    		"email": "walter.bates@email.com"
    	}
    ]


![JWT](https://github.com/chriscrm/movierentalapp/blob/main/jwtdiagram.jpeg)


**SWAGGER api-docs**
http://localhost:8080/webapp/api/v2/api-docs

**SWAGGER UI**
http://localhost:8080/webapp/api/swagger-ui/
