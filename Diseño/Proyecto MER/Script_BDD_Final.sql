DROP TABLE CUENTA CASCADE CONSTRAINTS;
DROP TABLE EQUIPO CASCADE CONSTRAINTS;
DROP TABLE EQUIPO_JUEGA CASCADE CONSTRAINTS;
DROP TABLE JORNADAS CASCADE CONSTRAINTS;
DROP TABLE LIGA CASCADE CONSTRAINTS;
DROP TABLE JUGADOR CASCADE CONSTRAINTS;
DROP TABLE PARTIDO CASCADE CONSTRAINTS;
DROP TABLE PERSONA CASCADE CONSTRAINTS;
DROP TABLE dueno CASCADE CONSTRAINTS;



CREATE TABLE Persona
  (
    dni      VARCHAR2 (9) PRIMARY KEY ,
    nombre   VARCHAR2 (15) NOT NULL ,
    apellido VARCHAR2 (20) NOT NULL ,
    calle    VARCHAR2 (40) NOT NULL ,
    nro      VARCHAR2 (3) NOT NULL ,
    piso     VARCHAR2 (3) NOT NULL ,
    ciudad   VARCHAR2 (20) NOT NULL ,
    cp       VARCHAR2 (5) NOT NULL ,
    pais     VARCHAR2 (20) NOT NULL ,
	tipo_persona varchar(10) NOT NULL,
    tlfo     VARCHAR2 (9) NOT NULL 
  ) ;
  

CREATE TABLE Cuenta
  (
    id NVARCHAR2 (15) PRIMARY KEY ,
    pass        VARCHAR2 (16) NOT NULL ,
    Persona_dni VARCHAR2 (9) NOT NULL,
    CONSTRAINT Cuenta_Persona_FK FOREIGN KEY ( Persona_dni ) REFERENCES Persona ( dni ) 
  ) ;


CREATE TABLE Dueno
  (
    dni        VARCHAR2 (9) PRIMARY KEY,
    CONSTRAINT Dueno_Persona_FK FOREIGN KEY ( dni ) REFERENCES Persona ( dni ) 
  ) ;
  


CREATE TABLE Equipo
  (
    cod        NUMBER (5) PRIMARY KEY ,
    nombre     VARCHAR2 (30) NOT NULL ,
    desripcion VARCHAR2 (100) NOT NULL ,
    puntos     VARCHAR2(3) NOT NULL ,
    puesto     VARCHAR2(2) NOT NULL ,
    tipo       VARCHAR2(10) ,
    Dueno_dni  VARCHAR2 (9) NOT NULL,
    CONSTRAINT Equipo_Dueno_FK FOREIGN KEY ( Dueno_dni ) REFERENCES Dueno ( dni )
  ) ;


CREATE TABLE Liga( 
  cod NUMBER(5) PRIMARY KEY,
  nombre varchar2(15)not null
  ) ;
  
  
CREATE TABLE Jornadas
  (
    cod    NUMBER (5) PRIMARY KEY ,
    fechaI   DATE NOT NULL ,
    fechaF   DATE NOT NULL ,
    Liga_cod NUMBER (5) NOT NULL,
    CONSTRAINT Jornadas_Liga_FK FOREIGN KEY ( Liga_cod ) REFERENCES Liga ( cod )
  ) ;
  
  
CREATE TABLE Partido
  (
    cod            NUMBER (5) PRIMARY KEY ,
    lugar          VARCHAR2 (15) NOT NULL ,
    codGanador     NUMBER (5),
    empate         VARCHAR2(1),
    fecha          DATE NOT NULL ,
    resultado      VARCHAR2(4),
    Jornadas_cod    NUMBER (5)NOT NULL,
    CONSTRAINT Partido_Jornadas_FK FOREIGN KEY ( Jornadas_cod ) REFERENCES Jornadas ( cod )
  ) ;
  
  
CREATE TABLE Equipo_juega
  (
    Equipo_cod  NUMBER (5) NOT NULL ,
    Partido_cod NUMBER (5) NOT NULL,
    CONSTRAINT Relation_13_PK PRIMARY KEY ( Equipo_cod, Partido_cod ),
    CONSTRAINT FK_ASS_8 FOREIGN KEY ( Equipo_cod ) REFERENCES Equipo ( cod ) ,
    CONSTRAINT FK_ASS_9 FOREIGN KEY ( Partido_cod ) REFERENCES Partido ( cod )    
  ) ; 


CREATE TABLE Jugador
  (
    dni      VARCHAR2 (9) PRIMARY KEY ,
    nickname VARCHAR2 (15) NOT NULL ,
    sueldo   NUMBER (7) NOT NULL ,
    nombre   VARCHAR2 (15) NOT NULL ,
    apellido VARCHAR2 (20) NOT NULL ,
    calle    VARCHAR2 (40) NOT NULL ,
    nro      VARCHAR2 (3) NOT NULL ,
    piso     VARCHAR2 (3) NOT NULL ,
    ciudad   VARCHAR2 (20) NOT NULL ,
    cp       VARCHAR2 (5) NOT NULL ,
    pais     VARCHAR2 (20) NOT NULL ,
    tlfo     VARCHAR2 (9) NOT NULL ,
    Equipo_cod NUMBER (5) NOT NULL,
    CONSTRAINT Jugador_Equipo_FK FOREIGN KEY ( Equipo_cod ) REFERENCES Equipo ( cod )
  ) ;