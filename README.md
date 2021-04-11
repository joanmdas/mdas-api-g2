# MDAS diseño de software 2

## Build
1) `make build`
2) `make test`
Nota: se necesita acceso a internet para ejecutar los tests de forma satisfactoria.

## Puesta en marcha en terminal
```
java -jar ./build/libs/mdas-api-g2.jar charizard
```

## Puesta en marcha en servidor
```
java -jar ./build/libs/mdas-api-g2.jar server
```
Nota: es igual que para el terminal, pero antes de poner el Pokemon, se pone `server`.

Para acceder al servidor en local:
```
curl http://127.0.0.1:8090/pokemonTypes/charizard
```
