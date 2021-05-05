## Hace todos los puntos pedidos (40%)

#### Permite obtener los detalles de un pokemon vía endpoint

Ok

#### Si no existe el pokemon, ¿se lanza una excepción de dominio?

Ok

#### Si la api da timeout, ¿se lanza una excepción de dominio?

Ok, aunque realmente se está lanzando la excepción `PokemonDetailsException` para todos los errores, no una excepción de
dominio propia para un error del client (timeout, error de conexión...)

#### Si se lanza una excepción desde el dominio, ¿se traduce en infraestructura a un código HTTP?

Ok aunque se da siempre un 404 ante cualquier error y esto no da visibilidad de que está ocurriendo en el sistema

#### Tests de aceptación

Ok

#### Tests de integración

Ok

**Puntuación: 32/40**

## Se aplican conceptos explicados (40%)

#### Separación correcta de capas (application, domain, infrastructure + BC/module/layer)

Ok

#### Aggregates + VOs

Existe PokemonTypes. Sin embargo, dentro de este tenemos un listado de Strings en vez de un listado de PokemonType (otro
VO).

#### No se trabajan con tipos primitivos en dominio

Tenemos el tipo de pokemon como un primitivo (string) en vez de un PokemonType

#### Hay servicios de dominio

No :-(

Penalizo este apartado especialmente porque lo he pedido en los 3 retos :(

#### Hay use cases en aplicación reutilizables

Ok

#### Se aplica el patrón repositorio

Ok

#### Se utilizan object mothers

No

**Puntuación: 20/40**

## Facilidad setup + README (20%)

#### El README contiene al menos los apartados "cómo ejecutar la aplicación", "cómo user la aplicación"

Ok

#### Es sencillo seguir el apartado "cómo ejecutar la aplicación"

Ok

**Puntuación: 20/20**

## Extras

- Seguís actualizando la colección de postman
- Habéis añadido tests para el resto de casos de uso, ¡bien hecho!

**Puntuación: +10**

## Observaciones

- No entiendo muy bien el que se haya hecho una separación entre types y pokemons, pudiendo ser pokemons un módulo de
  pokemons y types otro módulo. No es que esté mal, puede haber muchas razones de peso para que un contexto tenga
  sentido por sí mismo y no sea un módulo dentro de otro contexto, pero es llamativo. Ya que un bounded context puede
  tener tantos módulos como necesite.

**PUNTUACIÓN FINAL: 82/100**
