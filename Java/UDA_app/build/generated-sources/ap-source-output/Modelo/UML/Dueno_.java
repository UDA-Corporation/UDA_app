package Modelo.UML;

import Modelo.UML.Equipo;
import Modelo.UML.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-09T14:00:07")
@StaticMetamodel(Dueno.class)
public class Dueno_ { 

    public static volatile SingularAttribute<Dueno, Persona> persona;
    public static volatile CollectionAttribute<Dueno, Equipo> equipoCollection;
    public static volatile SingularAttribute<Dueno, String> dni;

}