# Bootcamp EX01

Este repositorio incluye una API que permite realizar las siguientes funcionalidades.


#### RF.1  Los  usuarios tienen que poder crear Partidas (grupos) para un determinado videojuego.
`POST localhost:8181/party/new?partyName={...}&gameId={...}`

Ejemplo: `POST localhost:8181/party/new?partyName=Partida1&gameId=2`

#### RF.2 Los usuarios tienen que poder buscar Partidas seleccionando un videojuego.
`GET localhost:8181/game/getParties?gameId={...}`

Ejemplo: `GET localhost:8181/game/getParties?gameId=1`

#### RF.3 Los usuarios pueden entrar y salir de una Party
Supongamos que un usuario no puede estar a dos partidas a la vez

##### Entrar a una party
`POST localhost:8181/user/enterParty?userId=1&partyId=1`

Ejemplo: `POST localhost:8181/user/enterParty?userId={...}&partyId={...}`

##### Salir de una party
`POST localhost:8181/user/exitParty?userId={...}`

Ejemplo `POST localhost:8181/user/exitParty?userId=1`

#### RF.4 Los  usuarios  tienen  que  poder  enviar  mensajes  a  la  Party. Estos mensajes tienen que poder ser editados y borrados por su usuario creador.

##### Enviar mensaje
`POST localhost:8181/message/new?userId={...}&partyId={...}&text={...}`

Ejemplo: `POST localhost:8181/message/new?userId=2&partyId=1&text=Al lío`

##### Editar mensaje
`POST localhost:8181/message/edit?userId={...}&messageId={...}&text={...}`

Ejemplo: `POST localhost:8181/message/edit?userId=1&messageId=1&text=Hola!!!`

##### Borrar mensaje
`DELETE localhost:8181/message/delete?userId={...}&messageId={...}`

Ejemplo: `DELETE localhost:8181/message/delete?userId=1&messageId=1`

#### RF.5  Los mensajes que existan en una Party se tienen que visualizar como un chat común
`GET localhost:8181/party/getMessages?partyId={...}`

Ejemplo: `localhost:8181/party/getMessages?partyId=1`

#### RF.6 Los usuarios pueden introducir y modiﬁcar sus datos de perﬁl
##### Cambiar username
`POST localhost:8181/user/editUsername?username={...}&userId={...}`

Ejemplo: `POST localhost:8181/user/editUsername?username=exemple&userId=1`

##### Cambiar email
`POST localhost:8181/user/editPassword?hash={...}&userId={...}`

Ejemplo: `POST localhost:8181/user/editEmail?email=exemple@exemple.com&userId=1`

##### Cambiar password
`POST localhost:8181/user/editPassword?hash={...}&userId={...}`

Ejemplo: `POST localhost:8181/user/editPassword?hash=fe28f7g43b1938r74b8203&userId=1`