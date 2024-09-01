# Arquitectura de Spring security 



![](https://github.com/Michael-Chacon/Spring-Security-6/blob/main/docs/Arquitectura%20Spring%20Security.png)

Cuando hacemos una solicitud http al back, dicha solicitud debe pasar por una cadena de filtros

### DelegatingFilterProxy

Esta clase permite crear filtros personalizados y es donde vamos a tener nuestras propias validaciones

### AuthenticationManager

Gestiona todo lo que tiene que ver con la autenticación de usuarios. Podemos autenticarnos mediante varios proveedores.

### Authentication providers

Son mecanismos que podemos usar para autenticarnos, podemos buscar un usuario y contraseña en la db y ese seria un proveedor, pero también podemos autenticarnos usando Google o GitHub, eso se hace mediante Auth2.

### PasswordEncoding

Esta clase codifica las contraseñas y valida que sean correctas.

### UserDetailService

Se encarga de conectarse a la DB y extrae los usuarios.

## Security context holder

Si la autenticación fue exitosa, se guarda el usuario que esta autenticado, Hay dos componentes

- principal: guarda la información general del usuario, usuario password, etc..
- authorities: acá se guardan los permisos



#### Apuntes

https://fierce-cirrus-de1.notion.site/Spring-Security-6-9ba16bdca65543b2a976d3cbc6d02c59?pvs=4

#### Fuente de los apuntes

https://www.youtube.com/watch?v=IPWBQDMIYkc&t=4960s