#Desde un usuario con permisos (root) creamos la base de datos y damos todos los permisos al nuevo usuario sobre ella
CREATE DATABASE IF NOT EXISTS bdalumnoshibernate;
USE bdalumnoshibernate;

CREATE TABLE IF NOT EXISTS alumno(
	dni CHAR(9) PRIMARY KEY,
    nombre VARCHAR(15),
    apellidos VARCHAR(30),
    sexo CHAR(1),
    nota1 INT,
    nota2 INT
);

CREATE TABLE IF NOT EXISTS profesor(
	codigo INT PRIMARY KEY,
    nombre VARCHAR(15),
    apellidos VARCHAR(30),
    sexo CHAR(1),
    antiguedad DATE,
    rendimiento INT
);

#Asignamos todos los privilegios al usuario dentro del BDD (Podría haber creado uno específico)
GRANT ALL PRIVILEGES ON bdalumnoshibernate.* TO usuario WITH GRANT OPTION; 

#Cambiamos la variable de zona horaria para que no nos dé el problema al conectarnos desde eclipse
SET GLOBAL time_zone = '+1:00';