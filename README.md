# BackAR

#### Problema: En la actualidad existe un problema en el respaldo de la informacion en el equipo que me encuentro, por lo que muchas cosas se perdian y se eliminaban, por lo que en auditorias no se podia comprobar los registros o entradas, por ello, se realizo el proyecto de mantener un sistem en donde se suban los archivos y mantengan un control entre los correos y los documentos.

## Requerimientos:
#### Servidor Glassfish dentro de la nube
#### Proyecto en Java WebApplication
#### MySQL Database system
#### Conexion a sharepoint
#### Librerias para MySQL
#### Version Java 8
#### IDE de desarrollo: Netbeans  8.0.2 Full application.
#### Manejador de base de datos: MySQL Workbench


## Instalacion
#### 1. Descagar el proyecto mediante la ruta https://github.com/BugPardo/BackAR.git
#### 2. Descomprimir documento en caso de que este encriptado.
#### 3. Abrir proyecto mediante Netbeans 8.0.2 con extension a Java EE
#### 4. Sincronizar servidor Glassfish 
#### 5. Realizar aplicaciones pruebas Junit mediante el IDE Netbeans

##### Hasta este momento solamente se tiene contemplado la carga en servidores locales o servidores con alojamiento web, Heroku no ha estado dentro del sistema.

## Configuracion
#### Es necesario mantener los puestos 8080 libres para realizar la conexion con glassfish y sea posible la carga del sistema completo.
#### Version Java 8 

## Uso.
#### El proyecto esta dividido por 4 modulos de control los cuales manipulan la informacion en los archivos JSP, el cual serian:
#### 1. DatabaseConnection: cuenta con toda la configuracion del servidor, modulos de consulta y inserto de datos.
#### 2. LoginConnection: cuenta con los metodos doget, dopost para la manipulacion de entradas en el sistema de informacion
#### 3. MainDatalogin: contiene la manipulacion para ingreso de datos a la base de datos y archivos adjuntos con un limite definido en la pagina web
#### 4. User: son metodos get y set para el sistema de informacion.

# Descarga
### Clonar: git clone https://github.com/BugPardo/BackAR.git
### Crear Banch:  git branch "NAME BRANCH"
### Gir pull: git pull remote "NAME BRANCH"
### Cargar actualizacion: git push origin "NAME BRANCH"
### Merge: git checkout "NAME BRANCH", git merge "NAME BRANCH"


# Roadmap
### El proyecto se migrara al lenguaje de Python por requerimientos internos, es el motivo por el cual el modulo no ha sido completado correctamente, se realizaron unas auditorias de accesos y se nos fueron limitados ciertos accesos ademas de la incompatilidad del lenguaje Java al servidor de destino.
