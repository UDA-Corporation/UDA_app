create or replace trigger maxJugadores
  before insert or update on jugador
  for each row
  declare
    cont number;
  begin
    SELECT COUNT(equipo_cod) into cont
      FROM jugador
       where equipo_cod=:new.equipo_cod;   
      if cont>5
        then raise_application_error(-20001,'Un equipo no puede tener mas de 6 jugadores');
      end if;  
  end;