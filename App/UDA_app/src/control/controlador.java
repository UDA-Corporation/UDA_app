package control;

import Modelo.BD.*;
import Modelo.UML.*;
import java.util.*;
import Views.VLogin.VLogin;
import Views.VRegistro.VRegistro;
import Views.VPrincipal.VPrincipal;
import java.awt.Frame;
import Views.JDError.JDError;
import Views.JDInfo.JDInfo;
import Views.ResultadosyDatos.VClasificacion;
import Views.VLiga.VLiga;
import Views.VEquipo.VEquipo;
import javax.swing.DefaultListModel;
import Views.VPuntos.VPuntos;
import java.text.SimpleDateFormat;
import Excepciones.ResultadoPartido;
import Excepciones.LigaExistente;
import Parsers.DOMClasificacion.ParserDOMClasificacion;
import Parsers.DOMJornadas.ParserDOMJornadas;
import Parsers.SAX.ParserSAXClasificacion;
import Parsers.SAX.ParserSAXJornadas;
import java.io.IOException;
import java.net.MalformedURLException;
import Views.ResultadosyDatos.VJornadas;
import Views.Listados.VEquipos.VEquipos;
import Views.Listados.VPersonas.VPersonas;
import Views.Listados.VPjugadores.VJugadores;
import Views.JDEliminar.JDEliminar;
import Views.Listados.VLiga.VLigas;
import Views.Listados.VPartidos.VPartidos;
import Views.Listados.VPjornadas.VLJornadas;
import static Views.ResultadosyDatos.VJornadas.x;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import Excepciones.JugadoresInsuficientes;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version %G%
 * @since 0.1 alpha
 */

public class controlador {

    static ConexionBD conexion;
    public static boolean modoayuda;
    static final int NROPARTIDOSJORNADA = 8;
    static Liga liga;
    static ArrayList finde;
    static List<Jornadas> jornadas;
    static List<Equipo> equiposBD;
    static List<Equipo> equipos;
    public static List<Jugador> jugadores;
    static List<Partido> partidos;
    static Equipo[][] PartidosEquipo;
    static List equiposP;
    static int posicion1;
    public static Cuenta usu;
    public static Persona persTemp;
    public static Jugador jugTemp;
    public static Dueno dueTemp;
    public static Equipo equipoTemp;
    public static int [] indices;
    public static List<Jugador> jugadoresUpd;
    public static int tipoE;
    static int formula;
    static ArrayList<Equipo> equiposTemp;
    static Liga ligaBD;
    static Jornadas jornadaBD;
    static Partido partidoBD;
    static Date date;
    static List<Liga> ligasBD;
    static List<Dueno> duenos;
    static SimpleDateFormat fmt;
    static final int PUNTOSWIN=3;
    static final int PUNTOSDRAW=1;
    static Collection <Equipo> CollectionEquiposTemp;
    static List <Persona> personas;
    public static DefaultTableModel model = new DefaultTableModel();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, NullPointerException, IOException {
        // TODO code application logic here  
        try {
            inicializar();

            System.out.println("▒█░▒█ ▒█▀▀▄ ░█▀▀█ \n"
                             + "▒█░▒█ ▒█░▒█ ▒█▄▄█ \n"
                             + "░▀▄▄▀ ▒█▄▄▀ ▒█░▒█ \n"
                             + "\n"
                             + "▒█▀▀█ █▀▀█ █▀▀█ █▀▀█ ░ \n"
                             + "▒█░░░ █░░█ █▄▄▀ █░░█ ▄ \n"
                             + "▒█▄▄█ ▀▀▀▀ ▀░▀▀ █▀▀▀ █ \n v1.2");
            VPrincipal vp = new VPrincipal();
            vp.setVisible(true);
        } catch (Exception e) {
            System.out.println("Conecction problem");
        }

    }

    /**
     * funcion que incializa algunas de las variables globales que vamos a usar
     */
    public static void inicializar() {
        conexion = new ConexionBD();
        jornadas = new ArrayList();
        partidos = new ArrayList();
        equiposP = new ArrayList();
        date = new Date();
        fmt = new SimpleDateFormat("dd/MM/yyyy");
    }

    //<editor-fold defaultstate="collapsed" desc=" Control de ventanas ">
    
    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     */
    public static void toVLogin(Frame ventana) {
        ventana.dispose();
        VLogin vl = new VLogin();
        vl.setVisible(true);
    }

    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     */
    public static void toVPrincipal(Frame ventana) {
        ventana.dispose();
        VPrincipal vp = new VPrincipal();
        vp.setVisible(true);
    }

    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     * @param tipo tipo de ventana, dependiendo de el se mostrarar y se ocultaran elementos
     * @param titulo el titulo que recivira la ventana
     * @param tipoventana otro tipo de ventana, dependiendo de el se redigira a una ventana o a otra
     */
    public static void toVRegistro(Frame ventana, int tipo, String titulo, int tipoventana) {
        ventana.dispose();
        VRegistro vr = new VRegistro(tipo, titulo, tipoventana);
        vr.setVisible(true);
    }

    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     * @param tipo dependiendo del tipo sera una modificacion o un alta
     */
    public static void toVEquipo(Frame ventana, int tipo) {
        ventana.dispose();
        VEquipo ve = new VEquipo(tipo);
        ve.setVisible(true);
    }
    
    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     */
    public static void toJFLiga(Frame ventana) {
        ventana.dispose();
        VLiga v = new VLiga();
        v.setVisible(true);
    }

    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     */
    public static void toVPuntos(javax.swing.JFrame ventana) {
        ventana.setVisible(false);
        VPuntos vpunt = new VPuntos();
        vpunt.setVisible(true);
    }
    
    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     * @throws IOException 
     */
    public static void toVClasificacion(Frame ventana) throws IOException {
        ventana.dispose();
        VClasificacion vc = new VClasificacion();
        vc.setVisible(true);
    }
    
    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     * @throws IOException 
     */
    public static void toVJornadas(Frame ventana) throws IOException {
        ventana.dispose();
        VJornadas vj = new VJornadas();
        vj.setVisible(true);
    }
    
    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     * @param tipo dependiendo del tipo llamara a una ventana o a otra
     */
    public static void toVPersonas(javax.swing.JFrame ventana, String tipo){
        ventana.dispose();
        VPersonas vpers = new VPersonas(tipo);
        vpers.setVisible(true);
    }
    
    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     */
    public static void toVJugadores(javax.swing.JFrame ventana){
        ventana.dispose();
        VJugadores vjugs = new VJugadores();
        vjugs.setVisible(true);
    }
    
    /**
     * 
     * @param ventana recive la ventana desde el que es llamado este metodo
     */
    public static void toVequipos(javax.swing.JFrame ventana){
        ventana.dispose();
        VEquipos veqs = new VEquipos();
        veqs.setVisible(true);
    }

    public static void toVLigas(javax.swing.JFrame ventana){
        ventana.dispose();
        VLigas vlgs = new VLigas();
        vlgs.setVisible(true);
    }
    
    public static void toVpartidos(javax.swing.JFrame ventana){
        ventana.dispose();
        VPartidos vprs = new VPartidos();
        vprs.setVisible(true);
    }
    
    public static void toVLJornadas(javax.swing.JFrame ventana){
        ventana.dispose();
        VLJornadas vjrs = new VLJornadas();
        vjrs.setVisible(true);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" JDialogs ">
    
    /**
     * Jdialog que se usa para mostrar los errores
     * @param ventana recive la ventana desde el que es llamado este metodo
     * @param modal 
     * @param mensaje mensaje que se quiere mostrar en pantalla
     */
    public static void JDError(Frame ventana, boolean modal, String mensaje) {
        JDError jde = new JDError(ventana, modal, mensaje);
        jde.setVisible(true);
    }
    /**
     * Si el mensaje es demasiado largo se usara este metodo
     * @param ventana recive la ventana desde el que es llamado este metodo
     * @param modal 
     * @param mensaje mensaje que se mostrara por pantalla
     * @param mensaje2 mensaje que se mostrar por pantalla
     */
    public static void JDError(Frame ventana, boolean modal, String mensaje, String mensaje2) {
        JDError jde = new JDError(ventana, modal, mensaje, mensaje2);
        jde.setVisible(true);
    }
    
    /**
     * Jdialog que se usa para mostrar confirmaciones o informacion
     * @param ventana recive la ventana desde el que es llamado este metodo
     * @param modal
     * @param mensaje mensaje que se quiere mostrar
     */
    public static void JDInfo(Frame ventana, boolean modal, String mensaje) {
        JDInfo jde = new JDInfo(ventana, modal, mensaje);
        jde.setVisible(true);
    }

    /**
     * Si el mensaje es demasiado largo se usara este metodo
     * @param ventana recive la ventana desde el que es llamado este metodo
     * @param modal
     * @param mensaje mensaje que se quiere mostrar
     * @param mensaje2 mensaje que se quiere mostrar
     */
    public static void JDInfo(Frame ventana, boolean modal, String mensaje, String mensaje2) {
        JDInfo jde = new JDInfo(ventana, modal, mensaje, mensaje2);
        jde.setVisible(true);
    }
    
    /**
     * 
     * @param d recive el Jdialog desde el que es llamado este metodo
     * @param modal
     * @param mensaje mensaje que se quiere mostrar
     */
    public static void JDInfo(javax.swing.JDialog d, boolean modal, String mensaje) {
        JDInfo jde = new JDInfo(d, modal, mensaje);
        jde.setVisible(true);
    }
    
    /**
     * Ventana para eliminar datos de una tabla dependiendo del tipo
     * @param ventana recive la ventana desde el que es llamado este metodo
     * @param modal
     * @param tipo dependiendo del tipo se eliminara de una tabla o de otra
     */
    public static void JDEliminar(Frame ventana, boolean modal, String tipo) {
        JDEliminar jdeliminar = new JDEliminar(ventana, modal, tipo);
        jdeliminar.setVisible(true);
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Login Logout ">
    
    /**
     * Devuelve si se han encontrado los datos y el login es correcto o false si es lo contrario
     * @param usuario nombre de usuario
     * @param pass contraseña
     * @return devuelve si el login es correcto o no
     */
    public static boolean findUsuLogin(String usuario, String pass) {

        boolean login = false;
        Cuenta c = conexion.getCuentaBD().findCuenta(usuario);

        if (codificarPass(c.getPass(), false).equals(pass)||c.getPass().equals(pass)) {
            login = true;
            usu = c;
        }
        return login;
    }
    
    public static String codificarPass(String pass,boolean codificar){
        String cadena="";
        char [] cod = pass.toCharArray();       
        for (int x = 0; x < cod.length; x++) {
            if(codificar){
                cod[x]+=5*4-3*2+1/2;
                cadena+=cod[x];
            }                
            else{
                cod[x]-=5*4-3*2+1/2;
                cadena+=cod[x];
            }
        }        
        return cadena;
    }
    
    public static void cerrarSesion() {
        usu = null;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Buscar ">
    
    /**
     * Busca un nombre en la base de datos
     * @param nick String que se quiere buscar
     * @return devuelve si existe o no
     */
    public static boolean findNickname(String nick) {
        boolean encontrado = false;
        List<Jugador> j = conexion.getJugadorBD().findJugadorEntities();
        int x;
        for (x = 0; x < j.size() && !j.get(x).getNickname().equals(nick); x++) {
        }
        if (x != j.size()) {
            encontrado = true;
        }

        return encontrado;

    }
    
    /**
     * Busca una persona por nombre
     * @param dni clave primaria para facilitar la busqueda
     * @throws Exception 
     */
    public static void findPerByDni(String dni) throws Exception{
        persTemp = conexion.getPersonaBD().findPersona(dni);
        if(persTemp != null)
        {
            if(!persTemp.getTipoPersona().equals("usuario"))
                persTemp = null;
        }    
    }
    
    /**
     * Busca un jugador por nombre
     * @param dni clave primaria para facilitar la busqueda
     * @throws Exception 
     */
    public static boolean findJugByDni(String dni) throws Exception{
        boolean encontrado = true;
        jugTemp = conexion.getJugadorBD().findJugador(dni);
        
        //Signifia que es dueño el que está haciendo la consulta
        if(usu.getPersonaDni().getTipoPersona() == null)
        {
            encontrado = false;
            equipos = conexion.getEquipoBD().findEquipoEntities();
            
            for(Equipo eq : equipos)
            {
                if(eq.getDuenoDni().getDni().equals(usu.getPersonaDni().getDni()))
                {
                    if(eq.getCod().equals(jugTemp.getEquipoCod().getCod()))
                    {
                        encontrado = true;
                    }    
                }    
            }
        } 
        return encontrado;
    }
    
    /**
     * Busca un dueño por nombre
     * @param dni clave primaria para facilitar la busqueda
     * @throws Exception 
     */
    public static void findDueByDni(String dni) throws Exception{
        dueTemp = conexion.getDuenoBD().findDueno(dni);
    }
    
    /**
     * Busca un equipo por nombre
     * @param nombre nombre que se desea buscar en equipo
     * @throws Exception 
     */
    public static boolean findEquipoByNombre(String nombre) throws Exception{
        boolean encontrado = true;
        equipoTemp = conexion.getEquipoBD().findByName(nombre.toUpperCase());
        
        //Signifia que es dueño el que está haciendo la consulta
        if(usu.getPersonaDni().getTipoPersona() == null)
        {
            encontrado = false;
            
            if(equipoTemp.getDuenoDni().getDni().equals(usu.getPersonaDni().getDni()))
                {
                    encontrado = true;    
                } 
        } 
        return encontrado;
    }
    
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Altas ">
    
    /**
     * Inserta en la tabla persona y en cuenta
     * @param dni 
     * @param nombre
     * @param apellido
     * @param calle
     * @param numero
     * @param piso
     * @param ciudad
     * @param cp
     * @param pais
     * @param tel
     * @param usuario
     * @param pass
     * @param tipo_persona
     * @return devuelve true o false
     * @throws Exception 
     */
    public static boolean registrarUsuario(String dni, String nombre, String apellido, String calle, String numero, String piso, String ciudad, String cp, String pais, String tel, String usuario, String pass, String tipo_persona) throws Exception {
        boolean correcto;
        
        if(tipo_persona.equals("dueno"))
            tipo_persona=null;
        Persona u1 = new Persona(dni, nombre, apellido, calle, numero, piso, ciudad, cp, pais, tipo_persona, tel);        
        Cuenta c1 = new Cuenta(usuario, codificarPass(pass,true));
        c1.setPersonaDni(u1);
        tipoE = 1;
        conexion.getPersonaBD().create(u1);

        if (tipo_persona == null) {
            addDueno(dni);
        }

        tipoE = 2;
        u1.addCuenta(c1);
        conexion.getCuentaBD().create(c1);
        correcto = true;
        return correcto;
    }
    
    /**
     * Relaciona la tabla persona con dueño
     * @param dni clave primaria
     * @throws Exception 
     */
    public static void addDueno(String dni) throws Exception {
        Dueno d = new Dueno(dni);
        conexion.getDuenoBD().create(d);
    }
    
    /**
     * Da de alta al jugador en la base de datos
     * @param dni dni del jugador a registrar
     * @param nickname nick del jugador a registrar
     * @param sueldo sueldo del jugador a registrar
     * @param nombre nombre del jugador a registrar
     * @param apellido apellido del jugador a registrar
     * @param calle calle del jugador a registrar
     * @param numero numero del jugador a registrar
     * @param piso piso del jugador a registrar
     * @param ciudad ciudad del jugador a registrar
     * @param cp codigo postal del jugador a registrar
     * @param pais pais del jugador a registrar
     * @param tel telefono del jugador a registrar
     * @return false o true si se inserta o no
     * @throws Exception 
     */
    public static boolean registrarJugador(String dni, String nickname, String sueldo, String nombre, String apellido, String calle, String numero, String piso, String ciudad, String cp, String pais, String tel) throws Exception {

        Jugador j1 = new Jugador(dni, nickname, Integer.parseInt(sueldo), nombre, apellido, calle, numero, piso, ciudad, cp, pais, tel);
        tipoE = 1;
        conexion.getJugadorBD().create(j1);

        return true;
    }
    
    /**
     * 
     * @param nombre
     * @param desc
     * @param dueno
     * @param indices
     * @return
     * @throws Exception 
     */
    public static boolean altaEquipo(String nombre, String desc, int dueno, int[] indices) throws Exception{

        Equipo e1 = new Equipo(Integer.parseInt(conexion.getEquipoBD().autoincrement()), nombre.toUpperCase(), desc);
        
        if(indices.length!=0)
        {
            for(int x = 0; x<indices.length; x++)
                e1.addJugador(jugadores.get(indices[x]));
        }    
        
        e1.setDuenoDni(duenos.get(dueno));
        
        conexion.getEquipoBD().create(e1);
        equipoTemp = null;
        jugadores = null;
        duenos = null;
        return true;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Eliminar ">
    
    /**
     * Elimina un usuario
     * @param pk clave primaria del usuario que se quiere eliminar
     * @throws Exception 
     */
    public static void eliminarUsuario(String pk)throws Exception{
        conexion.getPersonaBD().destroy(pk);
    }
    
    /**
     * Elimina un jugador
     * @param pk clave primaria del usuario que se quiere eliminar
     * @throws Exception 
     */
    public static void eliminarJugador(String pk)throws Exception{
        conexion.getJugadorBD().destroy(pk);
    }
    
    /**
     * Elimina un duaño
     * @param pk clave primaria del usuario que se quiere eliminar
     * @throws Exception 
     */
    public static void eliminarDueno(String pk)throws Exception{
        conexion.getPersonaBD().destroy(pk);
    }
    
    /**
     * Elimina un equipo
     * @param pk clave primaria del usuario que se quiere eliminar
     * @throws Exception 
     */
    public static void eliminarEquipo(String pk)throws Exception{
        Equipo e = conexion.getEquipoBD().findByName(pk);
        conexion.getEquipoBD().destroy(e.getCod());
    }

    public static void eliminarLiga(String pk)throws Exception{
        equipos = conexion.getEquipoBD().findEquipoEntities();       
        for (Equipo e : equipos)
            e.setPartidoCollection(null);
        ligaBD = conexion.getLigaBD().findByName(pk);
        Collection Cjornadas = ligaBD.getJornadasCollection();
        jornadas = new ArrayList(Cjornadas);
        for (Jornadas j : jornadas){
            Collection Cpartidos = j.getPartidoCollection();
            partidos = new ArrayList(Cpartidos);
            for (Partido p : partidos) {
                p.setEquipoCollection(null);
                conexion.getPartidoBD().destroy(p.getCod());
            }
            j.setPartidoCollection(null);
            conexion.getJornadaBD().destroy(j.getCod());
        }
        ligaBD.setJornadasCollection(null);
        conexion.getLigaBD().destroy(ligaBD.getCod());
    }
    /**
     * Borra una persona
     * @param dni clave primaria de la persona que se quiere eliminar
     */
    public static void destroyRegistro(String dni) {
        try {
            conexion.getPersonaBD().destroy(dni);
        } catch (Exception e) {

        }
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" VEquipo ">
    
    /**
     * Rellena el comboBox de la ventana desde la que es llamado este metodo
     * @param cb comboBox que se quiere llenar
     * @return devuelve true si existen dueños y si no false
     * @throws Exception 
     */
    public static boolean llenarDuenos(javax.swing.JComboBox cb) throws Exception {

        duenos = conexion.getDuenoBD().findDuenoEntities();

        if (duenos == null) {
            return false;
        } else {
            for (Dueno du : duenos) {
                cb.addItem(du.getPersona().getNombre());
            }
            return true;
        }

    }
    
    /**
     * Llena la lista de jugadores de la lista de jugadores de la ventana desde la que es llamado
     * @param lista lista que se quiere llenar
     * @param tipo dependiendo del tipo sera un alta o una modificacion
     * @return devuelve el modelo de la lista
     * @throws java.lang.Exception
     */
    public static DefaultListModel<String> llenarJugadores(javax.swing.JList lista, int tipo) throws Exception{
        
        jugadores = (List) conexion.getJugadorBD().findJugadorEntities();
        DefaultListModel<String> model = new DefaultListModel();
        if(tipo != 1)
        {
            for (Jugador ju : jugadores) {
                if (ju.getEquipoCod() == null) 
                {
                    model.addElement(ju.getNombre() + " " + ju.getApellido());
                }
            }
        }    
        else
        {
//             for (Jugador ju : jugadores) 
//             {
//                if (ju.getEquipoCod() == null || ju.getEquipoCod().equals(equipoTemp.getCod())) 
//                {
//                    if(ju.getEquipoCod().equals(equipoTemp.getCod()))
//                            
//                    model.addElement(ju.getNombre() + " " + ju.getApellido());
//                }   
//            }
//            indices = new int [6];
            ArrayList <Integer> intTemp = new ArrayList();
            jugadoresUpd = new ArrayList();
            int contador = 0;
            for(int x = 0; x<jugadores.size(); x++)
            {
                if(jugadores.get(x).getEquipoCod() == null || jugadores.get(x).getEquipoCod().equals(equipoTemp))
                {
                    model.addElement(jugadores.get(x).getNombre() + " " + jugadores.get(x).getApellido());
                    jugadoresUpd.add(jugadores.get(x));
                    if(jugadores.get(x).getEquipoCod()!= null)
                    {
                        intTemp.add(jugadoresUpd.indexOf(jugadores.get(x)));
                    }         
                }
            }    
            indices = new int[intTemp.toArray().length];
            for(int x = 0; x<intTemp.size(); x++)
            {
                indices[x] = intTemp.get(x);
            }    
                
        }
        return model;
    }
    
    public static void quitarEquipoJug() throws Exception{
        Collection temp = equipoTemp.getJugadorCollection();
        ArrayList<Jugador> aTemp = new ArrayList(temp);
        Jugador jug;
        
        for(int x = 0; x<aTemp.size(); x++)
        {
            jug = conexion.getJugadorBD().findJugador(aTemp.get(x).getDni());
            jug.setEquipoCod(null);
            conexion.getJugadorBD().edit(jug);
        }
        
        equipoTemp.setJugadorCollection(null);
            
        
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Update ">
    
    /**
     * Actualiza el equipo
     * @throws Exception 
     */
    public static void updateEquipo() throws Exception{
        
        conexion.getEquipoBD().edit(equipoTemp);
        
        indices = null;
        equipoTemp = null;
        jugadoresUpd = null;
    }

    /**
     * Actualiza la persona
     * @throws Exception 
     */
    public static void updatePersona() throws Exception{
        conexion.getPersonaBD().edit(persTemp);
        persTemp = null;
    }
    
    /**
     * Actualiza el jugador
     * @throws Exception 
     */
    public static void updateJugador() throws Exception{
        conexion.getJugadorBD().edit(jugTemp);
        jugTemp = null;
    }
    
    /**
     * Actualiza el dueño
     * @throws Exception 
     */
    public static void updateDueno() throws Exception{
        conexion.getPersonaBD().edit(dueTemp.getPersona());
        dueTemp = null;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Ventana liga ">
    
    /**
     * Llena la lista 
     * @param lista
     * @return 
     */
    public static DefaultListModel<String> llenarLista(javax.swing.JList lista) {
        equiposBD = conexion.getEquipoBD().findEquipoEntities();
        DefaultListModel<String> model = new DefaultListModel();
        equiposBD.forEach((e) -> {
            model.addElement(e.getNombre());
        });
        return model;
    }
    
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Ventana Puntos ">
    
    /**
     * LLena el combobox de la venta desde la que es llamado este metodo.
     * Controla que las jornadas tengan una fecha anterior a la actual
     * @param liga liga para la que se desea buscar las jornadas
     * @param cbJornadas combobox de jornadas
     */
    public static void llenarJornadas(String liga, javax.swing.JComboBox cbJornadas) {
        if(liga!=null)
            ligaBD = conexion.getLigaBD().findByName(liga);
        boolean finish = false;
        String cadena = "";
        ArrayList<Jornadas> jornadasTemp = new ArrayList();
        int min, done = 0;
        Jornadas jMin = null;
        for (int x = 1; finish != true; x++) {
            min = 100;
            for (Jornadas j : ligaBD.getJornadasCollection()) {
                if (j.getCod() < min && !jornadasReps(j, jornadasTemp)) {
                    min = j.getCod();
                    jMin = j;
                }
            }
            if (x == ligaBD.getJornadasCollection().size()) {
                finish = true;
            } else {
                if (jMin.getFechaf().before(date)) {
                    jornadasTemp.add(jMin);
                    cadena = date(jMin.getFechai()) + " " + date(jMin.getFechaf());
                    if(!partidosCompletos(jMin))
                        cbJornadas.addItem(cadena);
                }

            }
        }
    }
    
    /**
     * Busca la jornada con la fecha correspondiente a la que se recive
     * @param date fecha que se quiere buscar
     * @return objeto Jornada o null si no se encuentra
     */
    public static Jornadas buscarJornada(Date date){
        for (Jornadas j : ligaBD.getJornadasCollection()){
            if(j.getFechai().equals(date))
                return j;
        }        
        return null;
    }

    /**
     * Controla que la jornada introducida no este reptida
     * @param j jornada que se quiere buscar
     * @param js ArrayList de Jornadas en el que se quiere buscar
     * @return true o false si se a encontrado o no
     */
    public static boolean jornadasReps(Jornadas j, ArrayList<Jornadas> js) {
        int x;
        for (x = 0; x < js.size() && !j.equals(js.get(x)); x++) {
        }
        if (x == js.size()) {
            return false;
        }
        return true;
    }

    /**
     * Llena la lista de partidos de la ventana desde la que es llamado este metodo
     * @param fecha fecha de la jornada que se quiere buscar
     * @param cbPartidos comboBox que se quiere llenar
     * @throws Exception 
     */
    public static void llenarPartidos(String fecha, javax.swing.JComboBox cbPartidos) throws Exception {
        String cadena;    
        if(fecha!=null)
            jornadaBD = buscarJornada(toDate(fecha));
        ArrayList<Partido> partidosTemp = new ArrayList();
        boolean finish = false;
        int min;
        Partido pMin = null;
        for (int x = 0; finish != true; x++) {
            min = 100;
            cadena = "";
            for (Partido p : jornadaBD.getPartidoCollection()) {
                if (p.getCod() < min && !partidosReps(p, partidosTemp)) {
                    min = p.getCod();
                    pMin = p;
                }
            }
            if (x == jornadaBD.getPartidoCollection().size()) {
                finish = true;
            } else {
                if (pMin.getFecha().before(date)) {
                    partidosTemp.add(pMin);
                    partidoBD = conexion.getPartidoBD().findPartido(pMin.getCod());
                    for (Equipo e : partidoBD.getEquipoCollection()) {
                        cadena += e.getNombre() + " ";
                    }
                    if(partidoBD.getResultado()==null)
                        cbPartidos.addItem(cadena);
                }
            }
        }
    }
    
    /**
     * Controla que las jornadas a las que se les hayan metido todos los recultados de todos sus
     * partidos no se muestren en el comboBox
     * @param j jornada que se desea buscar
     * @return true o false si estan completos o no
     */
    public static boolean partidosCompletos(Jornadas j){
        int cont=0;
        for (Partido p : j.getPartidoCollection())
            if(p.getResultado()!=null)
                cont++;      
        if(cont==4)
            return true;
        return false;
    }

    /**
     * Secciona un string en una formato de fecha y luego la convierte a fecha
     * @param fecha String de la fecha que se quiere convertir
     * @return devuelte la decha en formato Date
     * @throws Exception 
     */
    public static Date toDate(String fecha) throws Exception {
        String cadena = "";
        int cont = 0;
        for (int x = 0; x < fecha.length() && cont < 8; x++) {
            if (Character.isDigit(fecha.charAt(x))) {
                cadena += fecha.charAt(x);
                cont++;
            } else if (fecha.charAt(x) == '/') {
                cadena += fecha.charAt(x);
            }
        } 
       return fmt.parse(cadena);
    }

    /**
     * Convierte un String en fecha
     * @param fecha fecha que se quiere convertir
     * @return devuelve la fecha en formato Date
     */
    public static String date(Date fecha) {      
        String fechaS = fmt.format(fecha);
        return fechaS;
    }
    
    /**
     * Metodo que recalcula la clasificacion dependiendo de los puntos que tenga cada equipo
     * @throws Exception 
     */
    public static void recalcularClasificacion()throws Exception{
        equipos = conexion.getEquipoBD().findEquipoEntities();
        equiposTemp = new ArrayList();
        boolean finish = false;
        int max;
        Equipo eMax = null;
        for (int x = equipos.size();finish!=true; x--) {
            max = 100;
            for (Equipo e : equipos){
                if(Integer.parseInt(e.getPuntos())<=max&&!equiposTemp(e)){
                    max = Integer.parseInt(e.getPuntos());
                    eMax=e;
                }
            }
            if(x!=0){
                eMax.setPuesto(Integer.toString(x));
                conexion.getEquipoBD().edit(eMax);
                equiposTemp.add(eMax);
            }
            else
                finish = true;              
        }
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Resultados de partidos ">
    
    /**
     * Llena el comboBox de la venta desde la que es llamado este metodo
     * @param cb comboBoc que se quiere llenar
     */
    public static void llenarLiga(javax.swing.JComboBox cb) {
        for (Liga l : conexion.getLigaBD().findLigaEntities()) {
            cb.addItem(l.getNombre());
        }
    }
    
    /**
     * Llena un ArrayList de equipos temporal de los dos equipos que participan el partido
     * @param indice indice el partido seleccionado en el comboBox
     */
    public static void llenarTfPartido(int indice){
        equiposTemp = new ArrayList();
        int x=0;
        for (Partido p : jornadaBD.getPartidoCollection()){
            x++;
            if(x == indice)
                partidoBD = p;
        }
        for (Equipo e : partidoBD.getEquipoCollection()) 
            equiposTemp.add(e);
    }
    
    /**
     * Llena un label con el nombre del equipo 1
     * @return el nombre del equipo 1
     */
    public static String le1(){
        return equiposTemp.get(0).getNombre();
    }
    
    /**
     * Llena un label con el nombre del equipo 2
     * @return el nombre del equipo 2
     */
    public static String le2(){
        return equiposTemp.get(1).getNombre();
    }
    
    /**
     * Dependiendo de si el equipo 1 o el equipo 2 son nulos el ganador sera un equipo u otro
     * si los dos son nulos habran empatado
     * @param e1 nombre del equipo 1
     * @param e2 nombre del equipo 2
     * @throws Exception 
     */
    public static void resultado(String e1, String e2)throws Exception{
        if(partidoBD.getResultado()!=null)
            throw new ResultadoPartido();
        else
            if(e1==null)
                add(e2,false);
            else
                if(e2==null)
                    add(e1,false);
                else
                    if(e1!=null&&e2!=null)
                        add(e1,true);               
    }
    
    /**
     * Inserta los datos en el partido correspondiente
     * @param ganador codigo del equipo ganador
     * @param resultado resultado del partido
     * @param empate si es empate se insertara un s si no null
     * @throws Exception 
     */
    public static void resultadoPartido(String ganador, String resultado, boolean empate)throws Exception{       
        for (Equipo e : partidoBD.getEquipoCollection())
            if(e.getNombre().equals(ganador)){
                if(!empate){
                partidoBD.setCodganador(e.getCod());
                partidoBD.setEmpate(null);
                partidoBD.setResultado(resultado);
            }else{
                partidoBD.setEmpate("s");
                partidoBD.setResultado(resultado);
            }       
        }
        conexion.getPartidoBD().edit(partidoBD);
    }
    
    /**
     * Secciona el String con los dos equipos para sacar uno de los equipos y encontrar el partido correcto
     * @param Sequipo String con los dos nombres de los equipos
     */
    public static void StringEquipos(String Sequipo){        
        CollectionEquiposTemp = new ArrayList ();        
        String cadena = "";
        boolean finish = false;        
        for (int x=0;x<Sequipo.length()&&finish==false;x++)
            if(Character.isAlphabetic(Sequipo.charAt(x))||Character.isDigit(Sequipo.charAt(x)))
                cadena+=Sequipo.charAt(x);
            else
                if(Sequipo.charAt(x)==' ')
                    finish = true;
        for (Partido p : jornadaBD.getPartidoCollection())
            for (Equipo e : p.getEquipoCollection())
                if(e.getNombre().equalsIgnoreCase(cadena)){
                    CollectionEquiposTemp = p.getEquipoCollection();
                    partidoBD=p;
                }
        equiposTemp = new ArrayList(CollectionEquiposTemp);
    }
      
    /**
     * Suma puntos a los equipos dependiendo del resultado
     * @param aSumar equipo al que hay que sumarle puntos
     * @param both si es true habran empatado si no habra ganado uno de los dos equipos
     * @throws Exception 
     */
    public static void add(String aSumar, boolean both)throws Exception{      
        for (Equipo e : equiposTemp){
            if(!both){
                if(e.getNombre().equals(aSumar)){
                    e.addPuntos(PUNTOSWIN);
                    conexion.getEquipoBD().edit(e);
                }
            }else{
                e.addPuntos(PUNTOSDRAW);
                conexion.getEquipoBD().edit(e);
            }
        }     
    }
    
    /**
     * Controla que el partido introducido no este reptido
     * @param p partido que se quiere buscar
     * @param ps ArrayList de Partido en el que se quiere buscar
     * @return true o false si se a encontrado o no
     */
    public static boolean partidosReps(Partido p, ArrayList<Partido> ps) {
        int x;
        for (x = 0; x < ps.size() && !p.equals(ps.get(x)); x++) {
        }
        if (x == ps.size()) {
            return false;
        }
        return true;
    }
    
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Tablas ">
    
    /**
     * Llena una tabla de todos los datos de los equipos
     * @param ColsCont numero de columnas de la tabla
     * @return devuelve un Array de tipo String con todos los datos
     */
    public static String [][]llenarTablaEquipos(int ColsCont){
        Collection <Jugador> Collectionjugadores = new ArrayList();
        ArrayList <Jugador> arrayListJugadores;
        equipos = conexion.getEquipoBD().findEquipoEntities();
        String [][] listadoequipos = new String [equipos.size()][ColsCont];
        for (int z=0;z<listadoequipos.length;z++)
            Arrays.fill(listadoequipos[z], "");
        for (int x = 0; x < equipos.size(); x++) {            
            listadoequipos[x][0] = equipos.get(x).getNombre();    
            listadoequipos[x][1] = equipos.get(x).getDesripcion();
            listadoequipos[x][2] = equipos.get(x).getPuntos();
            listadoequipos[x][3] = equipos.get(x).getPuesto();
            listadoequipos[x][4] = equipos.get(x).getDuenoDni().getPersona().getNombre()+" "+equipos.get(x).getDuenoDni().getPersona().getApellido();
            for (int y = 0; y < equipos.get(x).getJugadorCollection().size(); y++) {
                Collectionjugadores = equipos.get(x).getJugadorCollection();
                arrayListJugadores = new ArrayList(Collectionjugadores);
                listadoequipos[x][5]+=arrayListJugadores.get(y).getNickname()+", ";
            }
        }
        return listadoequipos;
    }
    
    /**
     * Llena una tabla de todos los datos de los jugadores
     * @param ColsCont numero de columnas de la tabla
     * @return devuelve un Array de tipo String con todos los datos
     */
    public static String [][] llenarTablaJugadores(int ColsCont){
        jugadores = conexion.getJugadorBD().findJugadorEntities();
        String [][] listadojugadores = new String [jugadores.size()][ColsCont];
        for (int x=0;x<jugadores.size();x++){
            listadojugadores[x][0] = jugadores.get(x).getDni();
            listadojugadores[x][1] = jugadores.get(x).getNickname();    
            listadojugadores[x][2] = Integer.toString(jugadores.get(x).getSueldo());
            listadojugadores[x][3] = jugadores.get(x).getNombre();
            listadojugadores[x][4] = jugadores.get(x).getApellido();
            listadojugadores[x][5] = jugadores.get(x).getCalle();
            listadojugadores[x][6] = jugadores.get(x).getNro();
            listadojugadores[x][7] = jugadores.get(x).getPiso();
            listadojugadores[x][8] = jugadores.get(x).getCiudad();
            listadojugadores[x][9] = jugadores.get(x).getCp();
            listadojugadores[x][10] = jugadores.get(x).getPais();
            listadojugadores[x][11] = jugadores.get(x).getTlfo();  
            if(jugadores.get(x).getEquipoCod()!=null)
                listadojugadores[x][12] = jugadores.get(x).getEquipoCod().getNombre();  
            else 
                listadojugadores[x][12] = "Sin equipo";  
        }
        return listadojugadores;
    }
    
    public static String [][] llenarTablaLiga(int ColsCont){
        int cont = 0;
        String [][] listadoLigas = new String [conexion.getLigaBD().getLigaCount()][11];
        ligasBD = conexion.getLigaBD().findLigaEntities();
        equipos = conexion.getEquipoBD().findEquipoEntities();
        for (int x=0;x<ligasBD.size();x++){            
            listadoLigas[x][0] = ligasBD.get(x).getNombre();
            for (int y = 2; y < equipos.size(); y++) {
                if(equipos.get(x).getPuesto()!=null){
                    listadoLigas[x][cont] = equipos.get(y).getNombre();
                    cont++;
                }
            }               
        }
        return listadoLigas;
    }
    
    public static String [][] llenarTablaPartidos(int ColsCont){     
        String [][] listadoPartidos = new String [conexion.getPartidoBD().getPartidoCount()][ColsCont];       
        partidos = conexion.getPartidoBD().findPartidoEntities();
        for (int x=0;x<partidos.size();x++){            
            listadoPartidos[x][0]=partidos.get(x).getLugar();
            if(partidos.get(x).getCodganador()!=null)
                listadoPartidos[x][1]=Integer.toString(partidos.get(x).getCodganador());
            listadoPartidos[x][2]=fmt.format(partidos.get(x).getFecha());
            listadoPartidos[x][3]=partidos.get(x).getResultado();
            Collection Collectionequipos = partidos.get(x).getEquipoCollection();
            equipos = new ArrayList(Collectionequipos);
            listadoPartidos[x][4]=equipos.get(0).getNombre();
            listadoPartidos[x][5]=equipos.get(1).getNombre();                      
        }
        return listadoPartidos;
    }
    
    public static String [][] llenarTablaJornadas(int ColsCont){        
        String [][] listadoJornadas = new String [conexion.getJornadaBD().getJornadasCount()][ColsCont];
        jornadas = conexion.getJornadaBD().findJornadasEntities();
        int cont=1;
        for (int x=0;x<jornadas.size();x++){
            listadoJornadas[x][0] = "Jornada "+cont;
            listadoJornadas[x][1] = fmt.format(jornadas.get(x).getFechai());
            listadoJornadas[x][2] = fmt.format(jornadas.get(x).getFechaf());
            cont++;
        }
        return listadoJornadas;
    }
    
    /**
     * 
     * @param tipo dependiendo del tipo se llenara una tabla u otra
     * @return la llamada a otro metodo que devolvera un String
     */
    public static String [][] llenarTablaPersonas(String tipo){       
        switch(tipo){
            case "dueno":
                duenos = conexion.getDuenoBD().findDuenoEntities();
                return tablaDuenos();               
            case "usuario":
                personas = conexion.getPersonaBD().findByTipo("usuario");               
                return tablaPeronas();
            case "admin":
                personas = conexion.getPersonaBD().findByTipo("admin");
                return tablaPeronas();               
        }
        return null;
    }

    /**
     * Llena la tabla personas
     * @return devuelve un Array de tipo String con todos los datos
     */
    public static String [][]tablaPeronas(){       
        String [][] listadopersonas = new String [personas.size()][11];
        for (int x=0;x<personas.size();x++){
            listadopersonas[x][0]=personas.get(x).getDni();
            listadopersonas[x][1]=personas.get(x).getNombre();
            listadopersonas[x][2]=personas.get(x).getApellido();
            listadopersonas[x][3]=personas.get(x).getCalle();
            listadopersonas[x][4]=personas.get(x).getNro();
            listadopersonas[x][5]=personas.get(x).getPiso();
            listadopersonas[x][6]=personas.get(x).getCiudad();
            listadopersonas[x][7]=personas.get(x).getCp();
            listadopersonas[x][8]=personas.get(x).getPais();
            listadopersonas[x][9]=personas.get(x).getTlfo();            
        }
        return listadopersonas;
    }
    
    /**
     * Llena la tabla de los dueños
     * @return devuelve un Array de tipo String con todos los datos
     */
    public static String [][] tablaDuenos(){
        
        String [][] listadoDuenos = new String [conexion.getDuenoBD().getDuenoCount()][11];       
        for (int x=0;x<duenos.size();x++){
            listadoDuenos[x][0]=duenos.get(x).getPersona().getDni();
            listadoDuenos[x][1]=duenos.get(x).getPersona().getNombre();
            listadoDuenos[x][2]=duenos.get(x).getPersona().getApellido();
            listadoDuenos[x][3]=duenos.get(x).getPersona().getCalle();
            listadoDuenos[x][4]=duenos.get(x).getPersona().getNro();
            listadoDuenos[x][5]=duenos.get(x).getPersona().getPiso();
            listadoDuenos[x][6]=duenos.get(x).getPersona().getCiudad();
            listadoDuenos[x][7]=duenos.get(x).getPersona().getCp();
            listadoDuenos[x][8]=duenos.get(x).getPersona().getPais();
            listadoDuenos[x][9]=duenos.get(x).getPersona().getTlfo();            
        }
        return listadoDuenos;
    }
    
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Algoritmo Liga ">
    
    /**
     * Prepara los equipos que van a jugar la liga antes de crearla
     * @param indices indices de los equipos seleccionados
     * @param nombre nombre que se le pondra a la liga
     * @param calendar fecha en la que empezara
     * @throws Exception 
     */
    public static void indices(int[] indices, String nombre, Calendar calendar) throws Exception {
        equipos = new ArrayList();
        for (int x = 0; x < indices.length; x++) {
            equipos.add(equiposBD.get(x));
        }
        generarLiga(nombre, calendar);
    }

    /**
     * Genera la liga en su totalidad, divide las 14 jornadas en 4 partidos
     * en los que jugaran dos equipos sin repetirse por dia y jornada
     * @param nombre nombre que queremos darle a la liga
     * @param fecha fecha en la que empieza
     * @throws Exception 
     */
    public static void generarLiga(String nombre, Calendar fecha) throws Exception {
        String cadena="";
        //La liga se genera solo si no hay otra liga creada        
        if(conexion.getLigaBD().getLigaCount()==1)
            throw new LigaExistente();
        for (Equipo e : equipos){
            if(e.getJugadorCollection().size()!=6)
                cadena+=e.getNombre()+", ";            
        }
        if(!cadena.equalsIgnoreCase(""))
            throw new JugadoresInsuficientes(cadena);
        
        int cont = 1;
        //Al comenzar la liga se ponen los puntos de todos los equipos a 0 y el puesto del 1 al 8
        for (Equipo e : equipos){
            e.setPuntos("0");
            e.setPuesto(Integer.toString(cont));
            conexion.getEquipoBD().edit(e);
            cont++;
        }
        partidos = new ArrayList();
        //Formula con la que controlamos que haya 4 partidos por jornada siempre
        formula = (((equipos.size() - 1) * equipos.size()) / ((equipos.size() - 1) * 2));
        PartidosEquipo = generarPartidos();
        boolean zig = true;
        //Creamos el objeto liga
        liga = new Liga(codigoLiga(), nombre.toUpperCase());
        //Hacemos ese objeto persistente
        conexion.getLigaBD().create(liga);
        buscarFinesDeSemana(fecha);
        //Recorremos todos los fines de semana
        for (int y = 0; y < finde.size() / 2; y += 2) {
            //Creamos el objeto Jornada correspondiente a ese fin de semana
            Jornadas j = new Jornadas(codigoJornada(), (Date) finde.get(y), (Date) finde.get(y + 1));
            //Asignamos la jornada a la liga
            j.setLigaCod(liga);
            //Añadimos la jornada a un ArrayList de Jornadas
            jornadas.add(j);
            //Hacemos persistente la jornada
            conexion.getJornadaBD().create(j);
            //Recorremos lo que serian los 4 partidos que tiene una jornada
            for (int z = 0; z < formula / 2; z++) {
                Partido p = null;
                if (zig) {
                    //Recorremos los partidos del primer dia de la jornada
                    for (int p1 = 0; p1 < formula / 2; p1++) {
                        //Creamos el objeto partido
                        p = new Partido(codigoPartido(), "Espana", j.getFechai());
                        //Añadimos ese partido a un ArrayList de partidos
                        partidos.add(p);
                        //Asignamos el partido a la jornada
                        j.addPartidosCollection(p);
                        //Y la jornada al partido
                        p.setJornadasCod(j);
                        //Hacemos persistente el partido
                        conexion.getPartidoBD().create(p);
                        zig = false;
                    }
                } else {
                    //Recorremos los partidos del segundo dia de la jornada (contenido indentico a la anterior repetitiva)
                    for (int p2 = 0; p2 < formula / 2; p2++) {
                        p = new Partido(codigoPartido(), "Espana", j.getFechaf());
                        partidos.add(p);
                        j.addPartidosCollection(p);
                        p.setJornadasCod(j);
                        conexion.getPartidoBD().create(p);
                        zig = true;
                    }
                }
            }
        }
        emparejar();
    }

    /**
     * Realiza todas las combinaciones posibles de los equipos sin que se repitan
     * @return Array con todas las combinaciones
     */
    public static Equipo[][] generarPartidos() {
        boolean zig = true;
        boolean stop = false;
        int x = 0, y = 0, z = 0, t = 0, cont = 0;
        //Creamos el Array que contendra todas las combinaciones de los equipos de dimensiones [56]((numero de equipos - 1)* numero de equipos ))[2]
        Equipo[][] equiposPartidos = new Equipo[(equipos.size()) * (equipos.size() - 1)][formula / 2];
        do {
            do {
                stop = false;
                t = 0;
                do {
                    do {
                        if (!equipos.get(x).equals(equipos.get(y))) {
                            if (zig) {
                                equiposPartidos[z][t] = equipos.get(x);
                                zig = false;
                                stop = true;
                                t++;
                            } else {
                                equiposPartidos[z][t] = equipos.get(y);
                                zig = true;
                                stop = true;
                                y++;
                                cont++;
                                t++;
                            }
                        } else {
                            y++;
                        }
                        if (cont == equipos.size() - 1) {
                            x++;
                            y = 0;
                            cont = 0;
                        }
                    } while (t < 2);
                } while (x < equipos.size() & stop == false);
                z++;
            } while (t < equiposPartidos[t].length);
        } while (z < equiposPartidos.length);
        return equiposPartidos;
    }

    /**
     * A partir de la fecha otorgada busca todos lo fines de semana que cubran las jornadas,
     * una jornada por fin de semana
     * @param calendar fecha de inicio de la liga
     * @throws Exception 
     */
    public static void buscarFinesDeSemana(Calendar calendar) throws Exception{
        finde = new ArrayList();        
        int x = 0;
        //El bucla para cuando x sea igual que el numero de jornadas 
        while (x != (equipos.size() - 1) * equipos.size()) {
            //Se encarga de añadir al ArrayList de los fines de semana solo los sabados y los domingos
            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SATURDAY:
                case Calendar.SUNDAY:
                    //La clase calendario contiene la hora, formateamos la forma al patron indicado dd/MM/yyyy
                    //la parseamos y la introducimos en el ArrayList que contendra las fechas de los fines de semana
                    finde.add(fmt.parse(fmt.format(calendar.getTime())));
                    x++;
                    break;
            }
            //Añadimos un dia al calendario
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    /**
     * Utiliza todas las combinaciones de los partidos y los introduce en cada fin de semana
     * Sin que se repita ningun equipo por jornada ni dia
     * @throws Exception 
     */
    public static void emparejar() throws Exception {
        boolean first = true, found = false, finished = false;
        equiposTemp = new ArrayList();
        int contador = 0, contacuatro = 0, contaTotal = 0;
        //Recorremos el Array en su indice vertical que contiene todas las combinaciones de los partidos
        for (int x = 0; x < PartidosEquipo.length && finished == false; x++) {
            found = false;
            //Recorremos el mismo Array pero en su indice horizontal
            for (int y = 0; y < PartidosEquipo[y].length & found == false; y++){
                //Si el partido no esta ya en el ArrayList temporal (equiposTemp) o si esa combinacion todavia no se ha introducido entra en la condicion
                if (!equiposTemp(PartidosEquipo[x][y]) && !equiposTemp(PartidosEquipo[x][y + 1]) && PartidosEquipo[x][y] != null && PartidosEquipo[x][y + 1] != null) {
                    equiposP = new ArrayList();
                    //Recorremos una vez mas el indice horizontal del Array de todas las combinaciones
                    for (int g = 0; g < PartidosEquipo[y].length; g++) {
                        //Introducimos los dos equipos en un array que posteriormente se hara persistente junto con el partido
                        equiposP.add(PartidosEquipo[x][g]);
                        //Introducimos los dos equipos ne el ArrayList temporal para controlar que no se repitan
                        equiposTemp.add(PartidosEquipo[x][g]);
                        //Como la acabamos de usar una cominacion correctamente la hacemos null
                        PartidosEquipo[x][g] = null;
                    }
                    //Añadimos al partido el ArrayList de sus dos equipos correspondiente
                    partidos.get(contador).setEquipoCollection(equiposP);
                    //Editamos el partido en la base de datos
                    conexion.getPartidoBD().edit(partidos.get(contador));
                    contador++;
                    contacuatro++;
                    contaTotal++;
                    //Cuanto el Array de combinaciones llegue a su fin finalizaremos el algoritmo
                    if (contaTotal == PartidosEquipo.length) {
                        finished = true;
                    }
                    //Cada cuatro partidos limpiamos el ArrayList temporal para proseguir con la siguiente jornada
                    if (contacuatro == formula) {
                        contacuatro = 0;
                        x = 0;
                        equiposTemp = new ArrayList();
                    }
                    found = true;
                } else {
                    found = true;
                }
            }
        }
        PartidosEquipo = null;
    }

    /**
     * Controla que los equipos no se repitan
     * @param e Recibe el equipo que ya ha sido utilizado
     * @return true o false si lo ha encontrado o no
     */
    public static boolean equiposTemp(Equipo e) {
        int x;
        for (x = 0; x < equiposTemp.size() && !equiposTemp.get(x).equals(e); x++) {}
        if (x == equiposTemp.size()) 
            return false;        
        return true;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Codigos autoincrementales ">
    
    /**
     * Se encarga de autoincrementar el codigo cogiendo el mayor de la tabla
     * @return devuelve el codigo de la liga
     */
    public static int codigoLiga() {
        return Integer.parseInt(conexion.getLigaBD().autoincrement());
    }

    /**
     * Se encarga de autoincrementar el codigo cogiendo el mayor de la tabla
     * @return devuelve el codigo de la Jornada
     */
    public static int codigoJornada() {
        return Integer.parseInt(conexion.getJornadaBD().autoincrement());
    }

    /**
     * Se encarga de autoincrementar el codigo cogiendo el mayor de la tabla
     * @return devuelve el codigo de el partido
     */
    public static int codigoPartido() {
        return Integer.parseInt(conexion.getPartidoBD().autoincrement());
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Resultados y datos ">
    public static void inicioVJornadas() {
        File xml = new File("BDD(Jornadas).xml");
        if(xml.exists() && !xml.isDirectory()) { 
            ParserSAXJornadas JornadasSAX = new ParserSAXJornadas();
            JornadasSAX.ejecutar();
        } else {
            try {
                ParserDOMJornadas JornadasDOM = new ParserDOMJornadas();
                JornadasDOM.ejecutar();
            } catch (ParserConfigurationException | TransformerException ex) {
                Logger.getLogger(VJornadas.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        if (ParserSAXJornadas.Jornadasexpirado){
            ParserSAXJornadas JornadasSAX = new ParserSAXJornadas();
            JornadasSAX.ejecutar();
        }
    }
    
    public static void inicioVClasificacion() {
        control.controlador.model.setRowCount(0);
        control.controlador.model.setColumnCount(0);
        File xml = new File("BDD(Clasificacion).xml");
        if(xml.exists() && !xml.isDirectory()) { 
            ParserSAXClasificacion ClasificacionSAX = new ParserSAXClasificacion();
            ClasificacionSAX.ejecutar();
        } else {
            try {
                ParserDOMClasificacion ClasificacionDOM = new ParserDOMClasificacion();
                ClasificacionDOM.ejecutar();
            } catch (ParserConfigurationException | TransformerException ex) {
                Logger.getLogger(VClasificacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ParserSAXClasificacion.Clasificacionexpirado){
            ParserSAXClasificacion ClasificacionSAXexpiradoXML = new ParserSAXClasificacion();
            ClasificacionSAXexpiradoXML.ejecutar();
        }
        Object[] columns = {"Nombre","Puntos","Puesto"};
        model.setColumnIdentifiers(columns);
        for (int i = 0; i < 32; i++) {
            Object[] row = new Object[3];
            row[0] = Parsers.SAX.ParserSAXClasificacion.Equipos[i];
            row[1] = Parsers.SAX.ParserSAXClasificacion.Equipos[i+2];
            row[2] = Parsers.SAX.ParserSAXClasificacion.Equipos[i+3];
            i += 3;
            model.addRow(row);
            Arrays.fill(row,null);
        } 
    }
    
    public static void rellenarTablaJornadas(int J) {
        control.controlador.model.setRowCount(0);
        control.controlador.model.setColumnCount(0);
        for (int i = 0; i < 14; i++) {
            x = i * 15;
            if (J == Integer.parseInt(ParserSAXJornadas.Jornadas[x].toString())) break;
        }
        Object[] columns = {"Equipo 1","Equipo 2","Resultado"};
        model.setColumnIdentifiers(columns);
        for (int i = (x + 3); i < (x + 15); i++) {
            int y = i + 12;
            Object[] row = new Object[3];
            row = Arrays.copyOfRange(Parsers.SAX.ParserSAXJornadas.Jornadas,i,y);
            model.addRow(row);
            Arrays.fill(row,null);
            i += 2;
        }
    }
    //</editor-fold>
    
    /**
     * Salir de la aplicacion
     */
    public static void exit(){
        System.exit(0);
    }
}
