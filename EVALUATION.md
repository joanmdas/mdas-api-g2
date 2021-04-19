# Evaluación reto 1

## Hace todos los puntos pedidos (40%)
#### Dado un nombre vía argumento, devolver sus tipos
OK
#### Dado un nombre vía endpoint, devolver sus tipos
OK
#### Si no existe el pokemon, ¿se lanza una excepción de dominio?
OK
#### Si la api da timeout, ¿se lanza una excepción de dominio?
La API da un 500, debería devolver un código de error esperado y que se traduzca
en la capa de infraestructura desde una excepción de dominio. Tened en cuenta que
en `PokemonTypesException` capturáis un status code != de 404,
pero un timeout no devolverá ningún código de error,
sino un timeout :).

Ejemplo para reproducirlo: no teniendo conexión a internet
#### Si se lanza una excepción desde el dominio, ¿se traduce en infraestructura a un código HTTP/un error legible en consola?
OK cmd

Por HTTP: Devuelve un 200 y rompe contrato con el cliente, ya que usando el mismo HTTP status code, a veces devuelve "types" y a veces "message".
Quizá sería mejor idea devolver un 404 NOT FOUND cuando no se encuentra el pokemon y un 200 OK cuando todo va bien :)

**Error principal: no convertir excepciones de dominio en infra**

**Puntuación final: 32/40**

## Se aplican conceptos explicados (30%)
#### Separación correcta de capas (application, domain, infrastructure + BC/module/layer)
En general hay una buena separación de capas y responsabilidades. Sin embargo:

No se deberían menter conceptos técnicos como `Serializable` (clase de infraestructura) en dominio

#### Aggregates + VOs
Existe PokemonTypes

Sin embargo, no existe el agregado PokemonType,
el VO PokemonName, ni el VO Type.

#### No se trabajan con tipos primitivos en dominio
El nombre del pokemon y el tipo de pokemon, son strings

#### Hay servicios de dominio
Se llama directamente al repository en vez de usar un searcher (servicio de dominio)

#### Hay use cases en aplicación reutilizables
OK

#### Se aplica el patrón repositorio
OK

**Error principal: Usar primitivos en dominio y no usar servicios de dominio**

**Puntuación final: 25/40**

## Facilidad setup + README (20%)
#### El README contiene al menos los apartados "cómo ejecutar la aplicación", "cómo user la aplicación"
OK
#### Es sencillo seguir el apartado "cómo ejecutar la aplicación"
OK

**Puntuación final: 20/20**

## Extra
- Hay tests de integración
- Hay makefile
- Commits en "baby steps". Pequeños y legibles

**Puntuación: +10**

## Observaciones
- La clase `PokemonTypeCommandLine` podría estar en un package distinto a controller, por ejemplo `cmd` (ya que no es un controlador de una api rest)
- ¿Es necesario tener en las clases `serialVersionUID` y extender de `Serializable`?

**PUNTUACIÓN FINAL: 87/100**
