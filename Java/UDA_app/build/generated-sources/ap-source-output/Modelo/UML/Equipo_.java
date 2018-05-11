package Modelo.UML;

import Modelo.UML.Dueno;
import Modelo.UML.Jugador;
import Modelo.UML.Partido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-09T14:00:07")
@StaticMetamodel(Equipo.class)
public class Equipo_ { 

    public static volatile SingularAttribute<Equipo, String> puesto;
    public static volatile CollectionAttribute<Equipo, Partido> partidoCollection;
    public static volatile SingularAttribute<Equipo, Dueno> duenoDni;
    public static volatile CollectionAttribute<Equipo, Jugador> jugadorCollection;
    public static volatile SingularAttribute<Equipo, Integer> cod;
    public static volatile SingularAttribute<Equipo, String> puntos;
    public static volatile SingularAttribute<Equipo, String> nombre;
    public static volatile SingularAttribute<Equipo, String> desripcion;

}