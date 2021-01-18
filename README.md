# Test Spring for Vegan

## Utenze:

1) **Nome utente** : user | **Password**: user
2) **Nome utente** : test | **Passowrd**: test


## Servizi implementati

### Senza autenticazione

* **URL:** http://localhost:8080/comments
* **API RICHIAMATA:** http://jsonplaceholder.typicode.com/posts/1/comments

### Con autenticazione

#### Get Comments by userId

* **URL:** http://localhost:8080/getComments/{userId}
* **API RICHIAMATA:** http://jsonplaceholder.typicode.com/posts/{user_id}/comments


#### Get Posts by userId

* **URL:** http://localhost:8080/getPosts/{userId}
* **API RICHIAMATA:** http://jsonplaceholder.typicode.com/posts/{user_id}

## Dettagli aggiuntivi:

**Framework frontend utilizzato:** React