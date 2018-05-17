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
        then raise_application_error(-20001,'Un equipo no puede tener mas de 200.000€ de presupuesto');          
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