# App_media_library: Programa para compartir contenido multimedia
## Presetación
Este es un proyecto de una plataforma en la que compartir tus series, peliculas y canciones favoritas.  
Se basa en una pagina web hecha con javaEE  
## Requisitos
Para poder clonar el proyecto
#### Software para el desarillo
* Java JDK17
* Eclipse V 2025-3
* Mysql sever V8.0
#### Librerias descargads de Maven
* mysql diver j 9.3.0
* lombok

# Organizacion del proyecto
### organizacion de paquetes
* **com.ipartek**: este paquete contendra las claves java que cargara el proyecto
* **com.ipartek.modelo**: Gestion de la DB
* **com.ipartek.modelo.dto**: Clases que se encargan de enlazar con las tablas de la BD

# Organizacion de las vistas
La interfaz de usuario estan relizada con **HTML** y **CSS**, los archivos estan en formato JSP utilizando la sintaxis antigua.

# Configurar el proyecto
Para poder arracar el proyeto sera necesario contar con un BD
se sumistra el codigo SQL con las tablas y datos de prueba para poder crear dichar BD en MySwl. se encuentra [AQUI](https://github.com/lops16/App_media_library/tree/main/SQL)
