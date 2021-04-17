# MDAS Disseny de Software 2

## Pre-conditions
- Java 11 installed
- make installed in order to execute the Makefile

## Build
1) `make build`
2) `make test`
Note: It's necesary an Internet connection to execute the test successfully.

## Execute with terminal
```
java -jar ./build/libs/mdas-api-g2.jar <PokemonName>
java -jar ./build/libs/mdas-api-g2.jar <PokemonId>
java -jar ./build/libs/mdas-api-g2.jar charizard
java -jar ./build/libs/mdas-api-g2.jar 100
```

## Execute with server
```
java -jar ./build/libs/mdas-api-g2.jar server
```
Note: same as executing with terminal, but instead of `<PokemonId>` use `server`.

In order to test the endpoints, you can import the postman [collection](/docs/Disseny2.postman_collection.json)
and [environment](/docs/Disseny2.postman_environment.json).

## Types module
Execute "Get Pokemon Types" in the postman application. You can change the pokemon to search by modifying the last
parameter of the URI. For example:

```
http://localhost:8090/pokemonTypes/<PokemonName>
http://localhost:8090/pokemonTypes/<PokemonId>
http://localhost:8090/pokemonTypes/charizard
http://localhost:8090/pokemonTypes/100
```

## Users module
### Create user
Execute "Create User" in the postman application.

The response body will contain the userId created. This value will be stored in the postman environment for later use
in other requests.

### Add favorite pokemon
Execute "Add favorite pokemon" in the postman application. This request contains the header "user_id" that contains the
user identifier generated in the last execution of "Create user".

The expected response is 201 code. It can also return a JSON with the message that the user was not found.
