# hexagonal
proyecto de ejemplo con arquitectura hexagonal, h2, jpa.

# Implementacion
Este es solo una de las muchas maneras en que se 
puede implementar una arquitectura hexagonal basada 
en clean code o ddd, a continuacion explicare cada capa.

En este ejemplo se tendra el siguiente flujo:

1- infrastructure - controller.

2- domain - port - input.

3- application - usecase.

4- domain - port - output.

5- infrastructure - adapter.

6- infrastructure - repository.

Notese que en pasos intermedios estas los mappers.

## domain --------------------------------------
En la capa de dominio se encuentra lo que seria el 
core o en lo que se basa el proyecto.

### commons:
En esta carpeta tengo lo que serian las contantes
y las excepciones personalizadas.
### models:
Aqui se encuentran las representaciones de nuestra data
ya sea en dto o una copia de la entidad (sin el @Entity)
y asi mismo el mapper para convertir de entidad a dto y de dto a entidad.
### port:
estas son las interfaces de nuestro proyecto, se dividen en
2: input y output, siendo una la interfaz que entra directamente
desde el controlador, y el output quien implementado
en la capa de infrastructura.

# Application ------------------------
Aqui se encuentran los casos de uso (implementacion de la
interface de entrada, input), y tambien las configuraciones del proyecto como
el metodo main.

# infrastructure ---------------------
Aca se encuentra la implementacion externa del proyecto, entiendase
como base de datos, llamados a apis externas, nube, etc.

## adapter:
Aqui se encuentra la implementacion de la interfaz output que 
esta en el dominio.
## controller:
Aca estan los controladores y el controller advice del proyecto.
## models:
Asi mismo como en el dominio, tendremos los dtos personalizados,
en este caso de los errores del controllerAdvice, aca
mismo se encuentra la entidad ahora si marcada con @Entity
ya que esta representa una tabla de base de datos en este caso.
No olvidar los mappers necesarios.
## Repository:
Aca se encuentra en repositorio de la entidad.

# NOTAS:
Si se desea hacer un llamado a una api externa o la
implementacion no corresponde a una base de datos, se
pueden personalizar las carpetas y archivos a la necesidad
siempre y cuando tengamos presente, que en el dominio
el output debe ser claro respecto a lo que va a implementar
la infrastructura.

Las carpetas pueden llamarse de diferentes maneras segun como se implemente
o quien la implemente, asi mismo como el nombre de los archivos, e incluso
donde van las capas.

Hay ejemplos donde el usecase esta dentro del dominio, o incluso algunos
donde el controller va dentro de application, esto ya es criterio
de cada quien.

Lo unico importante es tener en cuenta el flujo y ya con esto
se pueden entender las demas arquitecturas basadas en ddd, o clean code.