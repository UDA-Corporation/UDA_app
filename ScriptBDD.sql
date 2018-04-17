DROP TABLE CALENDARIO;
drop table jugador;
drop table equipo;
DROP TABLE LOCAL;
DROP TABLE VISITANTE;
DROP TABLE PARTIDO;
DROP TABLE DUENO;

CREATE TABLE equipo (
  cod NUMBER(11) primary key,
  Nombre varchar(20) NOT NULL,
  Descripcion varchar(45) NOT NULL  
);

CREATE TABLE jugador (
  cod NUMBER(11) primary key,
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

CREATE TABLE calendario (
  cod NUMBER(11) NOT NULL PRIMARY KEY,
  partido_cod NUMBER(11) NOT NULL,
  CONSTRAINT CAL_PK PRIMARY KEY (cod)
);

CREATE TABLE dueno (
  dni varchar(9) NOT NULL,
  nombre varchar(45) NOT NULL,
  apellido varchar(45) NOT NULL,
  calle varchar(20) NOT NULL,
  num varchar(3) NOT NULL,
  piso varchar(3) NOT NULL,
  ciudad varchar(45) NOT NULL,
  cp varchar(9) NOT NULL,
  pais varchar(45) NOT NULL,
  equipo_cod NUMBER(11) NOT NULL,
  CONSTRAINT DUENO_PK PRIMARY KEY (dni)
  );
  
CREATE TABLE local (
  equipo_cod number(11) NOT NULL,
  partido_cod number(11) NOT NULL,
  CONSTRAINT LOCAL_PK PRIMARY KEY (equipo_cod, partido_cod)
);


CREATE TABLE partido (
  cod number(11) NOT NULL,
  lugar varchar(45) NOT NULL,
  codGanador number(11),
  empate BOOLEAN,
  fecha DATE NOT NULL,
  CONSTRAINT PARTIDO_PK PRIMARY KEY (cod)
);


CREATE TABLE visitante (
  equipo_cod number(11) NOT NULL,
  partido_cod number(11) NOT NULL,
  CONSTRAINT VISITANTE_PK PRIMARY KEY (equipo_cod, partido_cod)
);