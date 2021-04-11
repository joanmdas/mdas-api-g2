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
Note: same as executing with terminal, but insted of `<PokemonId>` use `server`.

Access in local with `curl` or directly with web browser:
```
curl http://127.0.0.1:8090/pokemonTypes/<PokemonName>
curl http://127.0.0.1:8090/pokemonTypes/<PokemonId>
curl http://127.0.0.1:8090/pokemonTypes/charizard
curl http://127.0.0.1:8090/pokemonTypes/100
```
