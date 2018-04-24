/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import javax.persistence.Persistence;
import Modelo.BD.*;
import Modelo.UML.*;
/**
 *
 * @author unai-
 */
public class controlador {
static CuentaJpaController CuentaBD;
static DuenoJpaController DuenoBD;
static EquipoJpaController EquipoBD;
static JornadasJpaController JornadaBD;
static JugadorJpaController JugadorBD;
static LigaJpaController LigaBD;
static PartidoJpaController PartidoBD;
static PersonaJpaController PersonaBD;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CuentaBD=new CuentaJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        DuenoBD=new DuenoJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        EquipoBD=new EquipoJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        JornadaBD=new JornadasJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        JugadorBD=new JugadorJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        LigaBD=new LigaJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        PartidoBD=new PartidoJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        PersonaBD=new PersonaJpaController(Persistence.createEntityManagerFactory("UDA_appPU"));
        
    }
    
}
