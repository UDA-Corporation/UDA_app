package Modelo.UML;

import Modelo.UML.Cuenta;
import Modelo.UML.Dueno;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-09T14:00:07")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> piso;
    public static volatile SingularAttribute<Persona, Dueno> dueno;
    public static volatile SingularAttribute<Persona, String> tipoPersona;
    public static volatile SingularAttribute<Persona, String> calle;
    public static volatile SingularAttribute<Persona, String> nro;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, String> cp;
    public static volatile CollectionAttribute<Persona, Cuenta> cuentaCollection;
    public static volatile SingularAttribute<Persona, String> pais;
    public static volatile SingularAttribute<Persona, String> ciudad;
    public static volatile SingularAttribute<Persona, String> apellido;
    public static volatile SingularAttribute<Persona, String> tlfo;
    public static volatile SingularAttribute<Persona, String> dni;

}