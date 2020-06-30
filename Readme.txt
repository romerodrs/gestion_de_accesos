- Para arrancar el proyecto: mvn spring-boot:run

- El borrado de registro caducados dispone de un cron configurado para que se ejecute cada dia a las 12 PM, se puede modificar esta 
configuracion modificando dentro del fichero application.properties la propiedad: cron.borrarVisitas 

- UI SWAGGER: http://localhost:8080/swagger-ui.html 

- La aplicacion cuenta con una base da datos H2 endebida, que se ejecuta en memoria (esto es unicamente porque esto es un Poc) 
para cambiar la BD seria tan sencillo como cambiar las cadenas de conexion al sistema de persistencia deseado.
UI de la BBDD h2 endebida:
	http://localhost:8080/h2-console
	usuario: user
	contraseña: password