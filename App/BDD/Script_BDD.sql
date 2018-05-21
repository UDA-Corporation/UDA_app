/*AUTHOR UDA CORPORATION
*Alejandro Diaz de Otalora
*Luis Daniel Barragues
*Unai Puelles
*/

--DROP TABLES para eliminar las tablas
DROP TABLE CUENTA CASCADE CONSTRAINTS;
DROP TABLE EQUIPO CASCADE CONSTRAINTS;
DROP TABLE EQUIPO_JUEGA CASCADE CONSTRAINTS;
DROP TABLE JORNADAS CASCADE CONSTRAINTS;
DROP TABLE LIGA CASCADE CONSTRAINTS;
DROP TABLE JUGADOR CASCADE CONSTRAINTS;
DROP TABLE PARTIDO CASCADE CONSTRAINTS;
DROP TABLE PERSONA CASCADE CONSTRAINTS;
DROP TABLE DUENO CASCADE CONSTRAINTS;

/*CREACION DE TABLAS*/
--Creación de la tabla persona
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
	tipo_persona varchar(10),
    tlfo     VARCHAR2 (9) NOT NULL 
  ) ;
  
--Creación de la tabla cuenta
CREATE TABLE Cuenta
  (
    id NVARCHAR2 (15) PRIMARY KEY ,
    pass        VARCHAR2 (16) NOT NULL ,
    Persona_dni VARCHAR2 (9) NOT NULL,
    CONSTRAINT Cuenta_Persona_FK FOREIGN KEY ( Persona_dni ) REFERENCES Persona ( dni ) 
  ) ;

--Creación de la tabla dueño (en la que utilizamos el nombre sin "ñ" ya que la base de datos no la permite)
CREATE TABLE Dueno
  (
    dni        VARCHAR2 (9) PRIMARY KEY,
    CONSTRAINT Dueno_Persona_FK FOREIGN KEY ( dni ) REFERENCES Persona ( dni ) 
  ) ;
  

--Creación de la tabla dueño
CREATE TABLE Equipo
  (
    cod        NUMBER (5) PRIMARY KEY ,
    nombre     VARCHAR2 (30) NOT NULL ,
    desripcion VARCHAR2 (100) NOT NULL ,
    puntos     VARCHAR2(3),
    puesto     VARCHAR2(2),
    Dueno_dni  VARCHAR2 (9) NOT NULL,
    CONSTRAINT Equipo_Dueno_FK FOREIGN KEY ( Dueno_dni ) REFERENCES Dueno ( dni )
  ) ;

--Creación de la tabla liga
CREATE TABLE Liga( 
  cod NUMBER(5) PRIMARY KEY,
  nombre varchar2(15)not null
  ) ;
  
--Creación de la tabla jornada  
CREATE TABLE Jornadas
  (
    cod    NUMBER (5) PRIMARY KEY ,
    fechaI   DATE NOT NULL ,
    fechaF   DATE NOT NULL ,
    Liga_cod NUMBER (5) NOT NULL,
    CONSTRAINT Jornadas_Liga_FK FOREIGN KEY ( Liga_cod ) REFERENCES Liga ( cod )
  ) ;
  
--Creación de la tabla partido  
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
  
--Creación de la tabla equipo_juega (relación entre la tabla equipo y partido)  
CREATE TABLE Equipo_juega
  (
    Equipo_cod  NUMBER (5) NOT NULL ,
    Partido_cod NUMBER (5) NOT NULL,
    CONSTRAINT Relation_13_PK PRIMARY KEY ( Equipo_cod, Partido_cod ),
    CONSTRAINT FK_ASS_8 FOREIGN KEY ( Equipo_cod ) REFERENCES Equipo ( cod ) ,
    CONSTRAINT FK_ASS_9 FOREIGN KEY ( Partido_cod ) REFERENCES Partido ( cod )    
  ) ; 

--Creación de la tabla jugador
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
    Equipo_cod NUMBER (5),
    CONSTRAINT Jugador_Equipo_FK FOREIGN KEY ( Equipo_cod ) REFERENCES Equipo ( cod )
  ) ;
/
create or replace package paquete_mutante as
  codigoEquipo jugador.equipo_cod%type := null;
  sueldoJugadorTotal jugador.sueldo%type := null; 
end;
/
create or replace trigger MaxJugadoresMutante
after insert or update on jugador
for each row
begin
  paquete_mutante.codigoEquipo := :new.equipo_cod;
end;
/
create or replace trigger MaxSueldoMutante
after insert or update on jugador
for each row
  begin
    paquete_mutante.sueldoJugadorTotal := :new.sueldo;
end;
/
create or replace trigger maxJugadores
  after insert or update on jugador
  declare
    cont number;
  begin
    SELECT COUNT(equipo_cod) into cont
      FROM jugador
       where equipo_cod=paquete_mutante.codigoEquipo;   
      if cont>6
        then raise_application_error(-20001,'Un equipo no puede tener mas de 6 jugadores');
      end if;  
  end;  
/ 
create or replace trigger maxSalario
  after insert or update on jugador
    declare
      cont number;
    begin    
      select sum(sueldo) into cont from jugador where equipo_cod=paquete_mutante.codigoEquipo;  
      cont:=cont+paquete_mutante.sueldoJugadorTotal;
      if cont > 200000
        then raise_application_error(-20001,'Un equipo no puede tener mas de 200.000� de presupuesto');          
      end if;     
end;
/
create or replace trigger maxEquipos
before insert or update or delete on equipo
for each row
declare
  cont number;
  begin
    select count(cod)
      into cont from equipo;
      if cont = 8
        then raise_application_error(-20001,'Debe haber solo 8 equipos');
        else
          if cont < 8
            then insert into equipo values (:new.cod,:new.nombre,:new.desripcion,:new.puntos,:new.puesto,:new.dueno_dni);
          end if;     
      end if;
  end;
  drop trigger maxEquipos;