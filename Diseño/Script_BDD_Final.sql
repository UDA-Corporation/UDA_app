-- Generado por Oracle SQL Developer Data Modeler 4.1.1.888
--   en:        2018-04-18 12:06:29 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g

DROP TABLE ADMIN CASCADE CONSTRAINTS;
DROP TABLE CUENTA CASCADE CONSTRAINTS;
DROP TABLE DUENO CASCADE CONSTRAINTS;
DROP TABLE EQUIPO CASCADE CONSTRAINTS;
DROP TABLE EQUIPO_JUEGA CASCADE CONSTRAINTS;
DROP TABLE JORNADAS CASCADE CONSTRAINTS;
DROP TABLE LIGA CASCADE CONSTRAINTS;
DROP TABLE JUGADOR CASCADE CONSTRAINTS;
DROP TABLE PARTIDO CASCADE CONSTRAINTS;
DROP TABLE PERSONA CASCADE CONSTRAINTS;
DROP TABLE USUARIO CASCADE CONSTRAINTS;

CREATE TABLE Admin
  ( dni VARCHAR2 (9) NOT NULL
  ) ;
ALTER TABLE Admin ADD CONSTRAINT Admin_PK PRIMARY KEY ( dni ) ;


CREATE TABLE Cuenta
  (
    id NVARCHAR2 (15) NOT NULL ,
    pass        VARCHAR2 (16) NOT NULL ,
    Persona_dni VARCHAR2 (9) NOT NULL
  ) ;
ALTER TABLE Cuenta ADD CONSTRAINT Cuenta_PK PRIMARY KEY ( id ) ;


CREATE TABLE Dueno
  (
    dni        VARCHAR2 (9) NOT NULL
  ) ;
ALTER TABLE Dueno ADD CONSTRAINT Dueno_PK PRIMARY KEY ( dni ) ;


CREATE TABLE Equipo
  (
    cod        NUMBER (5) NOT NULL ,
    nombre     VARCHAR2 (30) NOT NULL ,
    desripcion VARCHAR2 (100) NOT NULL ,
    Dueno_dni  VARCHAR2 (9) NOT NULL
  ) ;
ALTER TABLE Equipo ADD CONSTRAINT Equipo_PK PRIMARY KEY ( cod ) ;


CREATE TABLE Equipo_juega
  (
    Equipo_cod  NUMBER (5) NOT NULL ,
    Partido_cod NUMBER (5) NOT NULL
  ) ;
ALTER TABLE Equipo_juega ADD CONSTRAINT Relation_13_PK PRIMARY KEY ( Equipo_cod, Partido_cod ) ;


CREATE TABLE Jornadas
  (
    cod_1    NUMBER NOT NULL ,
    fechaI   DATE NOT NULL ,
    fechaF   DATE NOT NULL ,
    Liga_cod NUMBER NOT NULL
  ) ;
ALTER TABLE Jornadas ADD CONSTRAINT Jornadas_PK PRIMARY KEY ( cod_1 ) ;


CREATE TABLE Jugador
  (
    dni      VARCHAR2 (9) NOT NULL ,
    nickname VARCHAR2 (15) NOT NULL ,
    sueldo   NUMBER NOT NULL ,
    nombre   VARCHAR2 (15) NOT NULL ,
    apellido VARCHAR2 (20) NOT NULL ,
    calle    VARCHAR2 (40) NOT NULL ,
    nro      VARCHAR2 (3) NOT NULL ,
    piso     VARCHAR2 (3) NOT NULL ,
    ciudad   VARCHAR2 (20) NOT NULL ,
    cp       VARCHAR2 (5) NOT NULL ,
    pais     VARCHAR2 (20) NOT NULL ,
    tlfo     VARCHAR2 (9) NOT NULL ,
    id NVARCHAR2 (1) NOT NULL ,
    Equipo_cod NUMBER (5) NOT NULL
  ) ;


CREATE TABLE Liga
  ( cod NUMBER NOT NULL
  ) ;
ALTER TABLE Liga ADD CONSTRAINT Liga_PK PRIMARY KEY ( cod ) ;


CREATE TABLE Partido
  (
    cod            NUMBER (5) NOT NULL ,
    lugar          VARCHAR2 (15) NOT NULL ,
    codGanador     NUMBER (5) NOT NULL ,
    empate         CHAR (1) NOT NULL ,
    fecha          DATE NOT NULL ,
    Jornadas_cod_1 NUMBER NOT NULL
  ) ;
ALTER TABLE Partido ADD CONSTRAINT Partido_PK PRIMARY KEY ( cod ) ;


CREATE TABLE Persona
  (
    dni      VARCHAR2 (9) NOT NULL ,
    nombre   VARCHAR2 (15) NOT NULL ,
    apellido VARCHAR2 (20) NOT NULL ,
    calle    VARCHAR2 (40) NOT NULL ,
    nro      VARCHAR2 (3) NOT NULL ,
    piso     VARCHAR2 (3) NOT NULL ,
    ciudad   VARCHAR2 (20) NOT NULL ,
    cp       VARCHAR2 (5) NOT NULL ,
    pais     VARCHAR2 (20) NOT NULL ,
    tlfo     VARCHAR2 (9) NOT NULL 
  ) ;
ALTER TABLE Persona ADD CONSTRAINT Persona_PK PRIMARY KEY ( dni ) ;


CREATE TABLE Usuario
  ( dni VARCHAR2 (9) NOT NULL
  ) ;
ALTER TABLE Usuario ADD CONSTRAINT Usuario_PK PRIMARY KEY ( dni ) ;


ALTER TABLE Admin ADD CONSTRAINT Admin_Persona_FK FOREIGN KEY ( dni ) REFERENCES Persona ( dni ) ;

ALTER TABLE Cuenta ADD CONSTRAINT Cuenta_Persona_FK FOREIGN KEY ( Persona_dni ) REFERENCES Persona ( dni ) ;

ALTER TABLE Dueno ADD CONSTRAINT Dueno_Persona_FK FOREIGN KEY ( dni ) REFERENCES Persona ( dni ) ;

ALTER TABLE Equipo ADD CONSTRAINT Equipo_Dueno_FK FOREIGN KEY ( Dueno_dni ) REFERENCES Dueno ( dni ) ;

ALTER TABLE Equipo_juega ADD CONSTRAINT FK_ASS_8 FOREIGN KEY ( Equipo_cod ) REFERENCES Equipo ( cod ) ;

ALTER TABLE Equipo_juega ADD CONSTRAINT FK_ASS_9 FOREIGN KEY ( Partido_cod ) REFERENCES Partido ( cod ) ;

ALTER TABLE Jornadas ADD CONSTRAINT Jornadas_Liga_FK FOREIGN KEY ( Liga_cod ) REFERENCES Liga ( cod ) ;

ALTER TABLE Jugador ADD CONSTRAINT Jugador_Equipo_FK FOREIGN KEY ( Equipo_cod ) REFERENCES Equipo ( cod ) ;

ALTER TABLE Partido ADD CONSTRAINT Partido_Jornadas_FK FOREIGN KEY ( Jornadas_cod_1 ) REFERENCES Jornadas ( cod_1 ) ;

ALTER TABLE Usuario ADD CONSTRAINT Usuario_Persona_FK FOREIGN KEY ( dni ) REFERENCES Persona ( dni ) ;

