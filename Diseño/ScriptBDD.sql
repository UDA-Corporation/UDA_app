/*Author: UDA Corp.*/
/*License: MIT license*/
drop table equipo_juega;
DROP TABLE partido;
DROP TABLE calendario;
drop table jugador;
DROP TABLE DUENO;
drop table jugador;
drop table equipo;

 
--Crear tabla equipo
CREATE TABLE equipo ( 
cod NUMBER(3) primary key GENERATED ALWAYS as IDENTITY(start with 1 INCREMENT  BY 1 MAX VALUE 999), 
nombre varchar2(20) NOT NULL,
descripcion varchar2(45) NOT NULL 
); 

--Crear tabla jugador
CREATE TABLE jugador ( 
dni varchar2(9) primary key, 
nombre varchar2(20) NOT NULL, 
apellido varchar2(20) NOT NULL, 
nickname varchar2(15) NOT NULL, 
sueldo NUMBER(11) NOT NULL, 
calle varchar2(45) NOT NULL, 
nro varchar2(3) NOT NULL, 
piso varchar2(3) NOT NULL, 
ciudad varchar2(45) NOT NULL, 
cp varchar2(9) NOT NULL, 
pais varchar2(45) NOT NULL, 
telefono varchar2(9) NOT NULL,
equipo_cod NUMBER(11) REFERENCES EQUIPO (cod) on delete cascade
); 

--Crear tabla dueno
CREATE TABLE dueno ( 
dni varchar2(9) PRIMARY KEY, 
nombre varchar2(45) NOT NULL, 
apellido varchar2(45) NOT NULL, 
calle varchar2(20) NOT NULL, 
num varchar2(3) NOT NULL, 
piso varchar2(3) NOT NULL, 
ciudad varchar2(45) NOT NULL, 
cp varchar2(9) NOT NULL, 
pais varchar2(45) NOT NULL,
telefono varchar2(9) NOT NULL, 
equipo_cod NUMBER(11) references equipo (cod) on delete cascade
 ); 

--Crear tabla calendario
CREATE TABLE calendario ( 
cod NUMBER(11) PRIMARY KEY,

);

--Crear tabla partido
CREATE TABLE partido ( 
cod number(11) primary key GENERATED ALWAYS as IDENTITY(start with 1 INCREMENT  BY 1 MAX VALUE 999), 
lugar varchar2(45) NOT NULL, 
codGanador number(11), 
empate varchar2(1), 
fecha DATE NOT NULL,
calendario_cod number(11) references calendario (cod) on delete cascade
); 

--Crear relacion entre equipo y partido: equipo_juega
create table equipo_juega (
partido_cod number (11) references partido (cod)on delete cascade,
equipo_cod number (11) references equipo (cod) on delete cascade
);