# Web-service-java-y-xml
Se uso GlassFish
## Detalles
### Generar, cargar y subir datos de un xml
Se genera un xml desde java y lo cargamos para subirlo al web service.
El web service se encarga de extraer los datos y guardarlos en postgresql
### Consultar y generar xml de los datos retornados
Pasamos un numero de cedula al web service y se realiza la consulta,
retorna cedula, nombre y apellido.
con esos datos en java generamos el xml.
## Base de datos Postgresql
#### Base: Personas
#### Tabla: personas
#### Campos: cedula, nombre y apellido
## Archivos xml
Los Archivos XML se guardan en la carpeta del proyecto