package Modelo.BD;

import javax.persistence.Persistence;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version 1.0 
 */

public class ConexionBD {
    private CuentaJpaController CuentaBD;
    private DuenoJpaController DuenoBD;
    private EquipoJpaController EquipoBD;
    private JornadasJpaController JornadaBD;
    private JugadorJpaController JugadorBD;
    private LigaJpaController LigaBD;
    private PartidoJpaController PartidoBD;
    private PersonaJpaController PersonaBD;

    /**
     * Inicializa todas las clases del jpa para usar sus metodos
     */
    public ConexionBD() {
        CuentaBD=new CuentaJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        DuenoBD=new DuenoJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        EquipoBD=new EquipoJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        JornadaBD=new JornadasJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        JugadorBD=new JugadorJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        LigaBD=new LigaJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        PartidoBD=new PartidoJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        PersonaBD=new PersonaJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
    }

    /**
     * Funcion que devuelve el controlador de cuenta
     * @return CuentaJpaController
     */
    public CuentaJpaController getCuentaBD() {
        return CuentaBD;
    }

    /**
     * Funcion que devuelve el controlador de dueño
     * @return DuenoJpaController
     */
    public DuenoJpaController getDuenoBD() {
        return DuenoBD;
    }

    /**
     * Funcion que devuelve el controlador de equipo
     * @return EquipoJpaController
     */
    public EquipoJpaController getEquipoBD() {
        return EquipoBD;
    }

    /**
     * Funcion que devuelve el controlador de Jornada
     * @return JornadasJpaController
     */
    public JornadasJpaController getJornadaBD() {
        return JornadaBD;
    }

    /**
     * Funcion que devuelve el controlador de jugador
     * @return JugadorJpaController
     */
    public JugadorJpaController getJugadorBD() {
        return JugadorBD;
    }

    /**
     * Funcion que devuelve el controlador de liga
     * @return LigaJpaController
     */
    public LigaJpaController getLigaBD() {
        return LigaBD;
    }

    /**
     * Funcion que devuelve el controlador de partido
     * @return PartidoJpaController
     */
    public PartidoJpaController getPartidoBD() {
        return PartidoBD;
    }

    /**
     * Funcion que devuelve el controlador de persona
     * @return PersonaJpaController
     */
    public PersonaJpaController getPersonaBD() {
        return PersonaBD;
    }
    
    
}
