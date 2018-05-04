/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import javax.persistence.Persistence;

/**
 *
 * @author 1gdaw02
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

    public CuentaJpaController getCuentaBD() {
        return CuentaBD;
    }

    public DuenoJpaController getDuenoBD() {
        return DuenoBD;
    }

    public EquipoJpaController getEquipoBD() {
        return EquipoBD;
    }

    public JornadasJpaController getJornadaBD() {
        return JornadaBD;
    }

    public JugadorJpaController getJugadorBD() {
        return JugadorBD;
    }

    public LigaJpaController getLigaBD() {
        return LigaBD;
    }

    public PartidoJpaController getPartidoBD() {
        return PartidoBD;
    }

    public PersonaJpaController getPersonaBD() {
        return PersonaBD;
    }
    
    
}
