package Modelo.UML;

import Modelo.UML.Liga;
import Modelo.UML.Partido;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-09T14:00:07")
@StaticMetamodel(Jornadas.class)
public class Jornadas_ { 

    public static volatile SingularAttribute<Jornadas, Date> fechai;
    public static volatile CollectionAttribute<Jornadas, Partido> partidoCollection;
    public static volatile SingularAttribute<Jornadas, Date> fechaf;
    public static volatile SingularAttribute<Jornadas, Liga> ligaCod;
    public static volatile SingularAttribute<Jornadas, Integer> cod;

}