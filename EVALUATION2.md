## Hace todos los puntos pedidos (40%)

#### Permite crear usuarios vía endpoint

OK

#### Permite añadir favoritos vía endpoint

OK

#### Si el pokemon ya está marcado como favorito, ¿se lanza una excepción de dominio?

No. Siempre devuelve un 201 CREATED

#### Si el usuario no existe, ¿se lanza una excepción de dominio?

OK

#### Si se lanza una excepción desde el dominio, ¿se traduce en infraestructura a un código HTTP?

OK, aunque el mensaje recibido no es muy legible:
> User com.lasalle.sd2.g2.users.domain.UserId@37b27f3a not found

Además si no meto un UUID como `user_id` en el header, da un 500 y un error no controlado

#### Hay tests unitarios

OK. Algunos comentarios:

- El `CreateUserTest` no es un test unitario porque se inyecta la implementación del repositorio en lugar de mockearla
  (¡no importar infra en application!). En cambio en el
  `AddFavoritePokemonTest` se está haciendo correctamente

- Los tests del package `domain` pueden tener sentido si los objetos que se están testeando tienen lógica de dominio. No
  considero que esos tests estén mal o sobren, pero creo que sería más acertado tenerlos si hubiese más lógica de
  dominio en los agregados, entidades o value objects. A día de hoy, los que tenéis tienen poca lógica. Si hubierais
  delegado la responsabilidad de no tener un pokemon favorito repetido dentro del agregado `User` o dentro
  de `FavoritePokemons`, ahí si tendría mucho sentido hacer este tipo de tests.

- Como no hay servicios de dominio, no tenéis tests de servicios de dominio :P

**Puntuación: 30/40**

## Se aplican conceptos explicados (40%)

#### Separación correcta de capas (application, domain, infrastructure + BC/module/layer)

OK. Aunque la funcionalidad de comprobar si el pokemon se puede o no insertar debería estar en el dominio. Si usáis un
Set de java no se insertará, pero no devolverá un error a través del endpoint, que es una de las funcionalidades que se
pedían.

Podéis hacer un set, pero también tenéis que hacer un guard que se asegure que no exista antes de insertarlo, ya que si
mañana cambiamos de un `Set` a un `List` (que es un detalle de implementación y por tanto, de infraestructura), nos
cambiaría las especificaciones de dominio.

#### Aggregates + VOs

OK. Aunque falta el Value Object `PokemonId`

#### No se trabajan con tipos primitivos en dominio

OK. Aunque en la entidad `Pokemon` hay un Integer en vez de un Value Object que contenga el id.

#### Hay servicios de dominio

No. Se llama directamente al repositorio desde el caso de uso.

#### Hay use cases en aplicación reutilizables

OK

#### Se aplica el patrón repositorio

OK

#### Se utilizan object mothers

No

**Puntuación: 30/40**

## Facilidad setup + README (20%)

#### El README contiene al menos los apartados "cómo ejecutar la aplicación", "cómo user la aplicación"

OK

#### Es sencillo seguir el apartado "cómo ejecutar la aplicación"

OK. Sugerencia: podéis añadir un `run` al makefile que lance la build y levante la aplicación :)

**Puntuación: 20/20**

## Extra

- Se han añadido postman collections al proyecto

**Puntuación: +5**

## Observaciones

¡Buen trabajo!

**PUNTUACIÓN FINAL: 85/100**
