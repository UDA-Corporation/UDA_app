create or replace package packProcedures is
procedure borrarLiga
  (vnombreLiga varchar2);
end;

create or replace package body packProcedures is
  procedure borrarLiga 
    (vnombreLiga varchar2)
     is
       vCodliga liga.cod%type;
        begin
          select cod into vCodliga from liga where nombre = vnombreliga;        
          
          delete from equipo_juega where partido_cod in (select partido.cod from equipo_juega, partido, jornadas
          where equipo_juega.partido_cod=partido.cod
          and partido.jornadas_cod=jornadas.cod
          and jornadas.liga_cod=vCodLiga);
          
          delete from partido where cod in (select partido.cod from partido, jornadas
          where partido.jornadas_cod=jornadas.cod
          and jornadas.liga_cod=vCodLiga);
          
          delete from jornadas where cod in (select jornadas.cod from jornadas
          where jornadas.liga_cod=vCodLiga);
          
          delete from liga where cod=vCodLiga;
          commit;
  end;
end;
/
execute PACKPROCEDURES.borrarLiga('DANIEL');