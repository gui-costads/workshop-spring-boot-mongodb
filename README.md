# About

Projetc to create a Rest application with Spring Boot and MongoDB designed by Nelio Alves in course "Java Completo" on udemy plataform

## Clone repository
Open terminal and enter the commands
```
mkdir workshop-spring-mongo
cd  workshop-spring-mongo
git clone git@github.com:gui-costads/workshop-spring-boot-mongodb.git
```
## Run project
```
./mvnw spring-boot:run

```
## Install MongoDB
[MongoDB](https://www.mongodb.com/docs/manual/installation/)

## Install Postman
[Postman](https://www.postman.com/downloads/)

## Run Mongodb
Open terminal
```
mongod
```

## Test features in Postman
### Users
localhost:8080/users

Methods: 
 - get all users 
 - get by id
 - update by id
 - delete by id

```
  {
   {
        "id": "6430a975012f7d6a0df097ca",
        "name": "Maria Brown",
        "email": "maria@gmail.com"
    }
  }
```

### Posts
localhost:8080/posts

Methods: 
 - get by id: "/{id}"
 - get byt title: "/titlesearch?text="
 - get by title(body,comment, title) or data:  "/fullsearch?"
 
 
```
 {
   {
    "id": "6430a975012f7d6a0df097cd",
    "date": "2023-02-01T00:00:00.000+00:00",
    "title": "Partiu Viagem",
    "body": "Vou viajar",
    "author": {
        "id": "6430a975012f7d6a0df097ca",
        "name": "Maria Brown"
    },
    "comments": [
        {
            "text": "Boa viagem!",
            "date": "2023-02-01T00:00:00.000+00:00",
            "author": {
                "id": "6430a975012f7d6a0df097cb",
                "name": "Alex Green"
            }
        },
        {
            "text": "Aproveite!",
            "date": "2023-02-02T00:00:00.000+00:00",
            "author": {
                "id": "6430a975012f7d6a0df097cc",
                "name": "Bob Grey"
            }
        },
        {
            "text": "Tenha um otímo dia!",
            "date": "2023-02-03T00:00:00.000+00:00",
            "author": {
                "id": "6430a975012f7d6a0df097cb",
                "name": "Alex Green"
            }
        }
    ]
}
```


## Built with

[![My Skills](https://skillicons.dev/icons?i=java,spring,postman,mongodb,maven&theme=light)](https://skillicons.dev)
