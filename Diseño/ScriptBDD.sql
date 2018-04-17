/*Author: UDA Corp.*/
/*License: MIT*/
drop table equipo_juega;
DROP TABLE partido;
DROP TABLE calendario;
drop table jugador;
DROP TABLE DUENO;
drop table jugador;
drop table equipo;

 
--Crear tabla equipo
CREATE TABLE equipo ( 
cod NUMBER(11) primary key, 
Nombre varchar(20) NOT NULL,
Descripcion varchar(45) NOT NULL 
); 

--Crear tabla jugador
CREATE TABLE jugador ( cod NUMBER(11) primary key, 
nombre varchar(20) NOT NULL, 
apellido varchar(20) NOT NULL, 
nickname varchar(15) NOT NULL, 
sueldo NUMBER(11) NOT NULL, 
calle varchar(45) NOT NULL, 
nro varchar(3) NOT NULL, 
piso varchar(3) NOT NULL, 
ciudad varchar(45) NOT NULL, 
cp varchar(9) NOT NULL, 
pais varchar(45) NOT NULL, 
equipo_cod NUMBER(11) REFERENCES EQUIPO (cod) on delete cascade
); 

--Crear tabla dueno
CREATE TABLE dueno ( 
dni varchar(9) NOT NULL, nombre varchar(45) primary key, 
apellido varchar(45) NOT NULL, 
calle varchar(20) NOT NULL, 
num varchar(3) NOT NULL, 
piso varchar(3) NOT NULL, 
ciudad varchar(45) NOT NULL, 
cp varchar(9) NOT NULL, 
pais varchar(45) NOT NULL, 
equipo_cod NUMBER(11) references equipo (cod) on delete cascade
 ); 

--Crear tabla calendario
CREATE TABLE calendario ( 
cod NUMBER(11) PRIMARY KEY
);

--Crear tabla partido
CREATE TABLE partido ( 
cod number(11) primary key, 
lugar varchar(45) NOT NULL, 
codGanador number(11), 
empate varchar(1), 
fecha DATE NOT NULL,
calendario_cod number(11) references calendario (cod) on delete cascade
); 

--Crear relacion entre equipo y partido: equipo_juega
create table equipo_juega (
partido_cod number (11) references partido (cod)on delete cascade,
equipo_cod number (11) references equipo (cod) on delete cascade
);