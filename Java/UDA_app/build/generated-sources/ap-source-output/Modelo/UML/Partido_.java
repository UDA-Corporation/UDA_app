package Modelo.UML;

import Modelo.UML.Equipo;
import Modelo.UML.Jornadas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-09T14:00:07")
@StaticMetamodel(Partido.class)
public class Partido_ { 

    public static volatile SingularAttribute<Partido, Jornadas> jornadasCod;
    public static volatile SingularAttribute<Partido, Date> fecha;
    public static volatile SingularAttribute<Partido, String> resultado;
    public static volatile SingularAttribute<Partido, String> lugar;
    public static volatile SingularAttribute<Partido, String> empate;
    public static volatile CollectionAttribute<Partido, Equipo> equipoCollection;
    public static volatile SingularAttribute<Partido, Integer> cod;
    public static volatile SingularAttribute<Partido, Integer> codganador;

}