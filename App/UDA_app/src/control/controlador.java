/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.io.IOException;
import java.net.MalformedURLException;
import Views.ResultadosyDatos.VJornadas;
import Views.Listados.VEquipos.VEquipos;
import Views.Listados.VPersonas.VPersonas;
import Views.Listados.VPjugadores.VJugadores;
import Views.JDEliminar.JDEliminar;

/**
 *
 * @author unai-
 */
public class controlador {

    static ConexionBD conexion;
    public static boolean modoayuda;
    static final int NROPARTIDOSJORNADA = 8;
    static Liga liga;
    static ArrayList finde;
    static ArrayList<Jornadas> jornadas;
    static List<Equipo> equiposBD;
    static List<Equipo> equipos;
    static List<Jugador> jugadores;
    static List<Partido> partidos;
    static Equipo[][] PartidosEquipo;
    static List equiposP;
    static int posicion1;
    public static Cuenta usu;
    public static Persona persTemp;
    public static Jugador jugTemp;
    public static Dueno dueTemp;
    public static Equipo equipoTemp;
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
                             + "▒█▄▄█ ▀▀▀▀ ▀░▀▀ █▀▀▀ █ \n v0.8 alpha");
            VPrincipal vp = new VPrincipal();
            vp.setVisible(true);
        } catch (Exception e) {
            System.out.println("Conecction problem");
        }

    }

    public static void inicializar() {
        conexion = new ConexionBD();
        jornadas = new ArrayList();
        partidos = new ArrayList();
        equiposP = new ArrayList();
        date = new Date();
        fmt = new SimpleDateFormat("dd/MM/yyyy");
    }

    public static void toVLogin(Frame ventana) {
        ventana.dispose();
        VLogin vl = new VLogin();
        vl.setVisible(true);
    }

    public static void toVPrincipal(Frame ventana) {
        ventana.dispose();
        VPrincipal vp = new VPrincipal();
        vp.setVisible(true);
    }

    public static void toVRegistro(Frame ventana, int tipo, String titulo, int tipoventana) {
        ventana.dispose();
        VRegistro vr = new VRegistro(tipo, titulo, tipoventana);
        vr.setVisible(true);
    }

    public static void toVEquipo(Frame ventana, int tipo) {
        ventana.dispose();
        VEquipo ve = new VEquipo(tipo);
        ve.setVisible(true);
    }
    
    public static void toJFLiga(Frame ventana) {
        ventana.dispose();
        VLiga v = new VLiga();
        v.setVisible(true);
    }

    public static void toVPuntos(javax.swing.JFrame ventana) {
        ventana.setVisible(false);
        VPuntos vpunt = new VPuntos();
        vpunt.setVisible(true);
    }
    
    public static void toVClasificacion(Frame ventana) throws IOException {
        ventana.dispose();
        VClasificacion vc = new VClasificacion();
        vc.setVisible(true);
    }
    
    public static void toVJornadas(Frame ventana) throws IOException {
        ventana.dispose();
        VJornadas vj = new VJornadas();
        vj.setVisible(true);
    }
    
    public static void toVPersonas(javax.swing.JFrame ventana, String tipo){
        ventana.dispose();
        VPersonas vpers = new VPersonas(tipo);
        vpers.setVisible(true);
    }
    public static void toVJugadores(javax.swing.JFrame ventana){
        ventana.dispose();
        VJugadores vjugs = new VJugadores();
        vjugs.setVisible(true);
    }
    public static void toVequipos(javax.swing.JFrame ventana){
        ventana.dispose();
        VEquipos veqs = new VEquipos();
        veqs.setVisible(true);
    }

    public static void JDError(Frame ventana, boolean modal, String mensaje) {

        JDError jde = new JDError(ventana, modal, mensaje);
        jde.setVisible(true);
    }

    public static void JDError(Frame ventana, boolean modal, String mensaje, String mensaje2) {

        JDError jde = new JDError(ventana, modal, mensaje, mensaje2);
        jde.setVisible(true);
    }

    public static void JDInfo(Frame ventana, boolean modal, String mensaje) {

        JDInfo jde = new JDInfo(ventana, modal, mensaje);
        jde.setVisible(true);
    }

    public static void JDInfo(Frame ventana, boolean modal, String mensaje, String mensaje2) {

        JDInfo jde = new JDInfo(ventana, modal, mensaje, mensaje2);
        jde.setVisible(true);
    }
    
    public static void JDInfo(javax.swing.JDialog d, boolean modal, String mensaje) {

        JDInfo jde = new JDInfo(d, modal, mensaje);
        jde.setVisible(true);
    }
    
    public static void JDEliminar(Frame ventana, boolean modal, String tipo) {
        JDEliminar jdeliminar = new JDEliminar(ventana, modal, tipo);
        jdeliminar.setVisible(true);
    }

    public static boolean findUsuLogin(String usuario, String pass) {

        boolean login = false;
        Cuenta c = conexion.getCuentaBD().findCuenta(usuario);

        if (c.getPass().equals(pass)) {
            login = true;
            usu = c;
        }
        return login;
    }

    public static void cerrarSesion() {
        usu = null;
    }

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
    
    public static void findPerByDni(String dni) throws Exception{
        persTemp = conexion.getPersonaBD().findPersona(dni);
        if(!persTemp.getTipoPersona().equals("usuario"))
            persTemp = null;
    }
    
    public static void findJugByDni(String dni) throws Exception{
        jugTemp = conexion.getJugadorBD().findJugador(dni);
    }
    
    public static void findDueByDni(String dni) throws Exception{
        dueTemp = conexion.getDuenoBD().findDueno(dni);
    }
    
    public static void findEquipoByNombre(String nombre) throws Exception{
        
        equipoTemp = conexion.getEquipoBD().findByName(nombre.toUpperCase());
    }
    
    public static boolean registrarUsuario(String dni, String nombre, String apellido, String calle, String numero, String piso, String ciudad, String cp, String pais, String tel, String usuario, String pass, String tipo_persona) throws Exception {
        boolean correcto;
        
        if(tipo_persona.equals("dueno"))
            tipo_persona=null;
        Persona u1 = new Persona(dni, nombre, apellido, calle, numero, piso, ciudad, cp, pais, tipo_persona, tel);

        Cuenta c1 = new Cuenta(usuario, pass);
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

    public static void addDueno(String dni) throws Exception {
        Dueno d = new Dueno(dni);
        conexion.getDuenoBD().create(d);
    }

    public static boolean registrarJugador(String dni, String nickname, String sueldo, String nombre, String apellido, String calle, String numero, String piso, String ciudad, String cp, String pais, String tel) throws Exception {

        Jugador j1 = new Jugador(dni, nickname, Integer.parseInt(sueldo), nombre, apellido, calle, numero, piso, ciudad, cp, pais, tel);
        tipoE = 1;
        conexion.getJugadorBD().create(j1);

        return true;
    }
    
    public static void updatePersona() throws Exception{
        conexion.getPersonaBD().edit(persTemp);
        persTemp = null;
    }
    
    public static void updateJugador() throws Exception{
        conexion.getJugadorBD().edit(jugTemp);
        jugTemp = null;
    }
    
    public static void updateDueno() throws Exception{
        conexion.getPersonaBD().edit(dueTemp.getPersona());
        dueTemp = null;
    }
    
    public static void destroyRegistro(String dni) {
        try {
            conexion.getPersonaBD().destroy(dni);
        } catch (Exception e) {

        }
    }

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
    
    public static DefaultListModel<String> llenarJugadores(javax.swing.JList lista) {

        jugadores = (List) conexion.getJugadorBD().findJugadorEntities();
        DefaultListModel<String> model = new DefaultListModel();
        for (Jugador ju : jugadores) {
            if (ju.getEquipoCod() == null) {
                model.addElement(ju.getNombre() + " " + ju.getApellido());
            }
        }
        return model;
    }

    public static boolean altaEquipo(String nombre, String desc, int dueno, int[] indices) throws Exception{

        Equipo e1 = new Equipo(Integer.parseInt(conexion.getEquipoBD().autoincrement()), nombre.toUpperCase(), desc);
        
        if(indices.length!=0)
        {
            for(int x = 0; x<indices.length; x++)
                e1.addJugador(jugadores.get(indices[x]));
        }    
        
        e1.setDuenoDni(duenos.get(dueno));
        
        conexion.getEquipoBD().create(e1);
        jugadores = null;
        duenos = null;
        return true;
    }

    public static DefaultListModel<String> llenarLista(javax.swing.JList lista) {
        equiposBD = conexion.getEquipoBD().findEquipoEntities();
        DefaultListModel<String> model = new DefaultListModel();
        equiposBD.forEach((e) -> {
            model.addElement(e.getNombre());
        });
        return model;
    }

    public static void llenarLiga(javax.swing.JComboBox cb) {
        for (Liga l : conexion.getLigaBD().findLigaEntities()) {
            cb.addItem(l.getNombre());
        }
    }
    
    public static String [][]llenarTablaEquipos(int ColsCont){
        Collection <Jugador> Collectionjugadores = new ArrayList();
        ArrayList <Jugador> arrayListJugadores;
        equipos = conexion.getEquipoBD().findEquipoEntities();
        String [][] listadoequipos = new String [equipos.size()][ColsCont];
        for (int x = 0; x < equipos.size(); x++) {
            listadoequipos[x][0] = Integer.toString(equipos.get(x).getCod());
            listadoequipos[x][1] = equipos.get(x).getNombre();    
            listadoequipos[x][2] = equipos.get(x).getDesripcion();
            listadoequipos[x][3] = equipos.get(x).getPuntos();
            listadoequipos[x][4] = equipos.get(x).getPuesto();
            listadoequipos[x][5] = equipos.get(x).getDuenoDni().getPersona().getNombre()+" "+equipos.get(x).getDuenoDni().getPersona().getApellido();
            for (int y = 0; y < equipos.get(x).getJugadorCollection().size(); y++) {
                Collectionjugadores = equipos.get(x).getJugadorCollection();
                arrayListJugadores = new ArrayList(Collectionjugadores);
                listadoequipos[x][6]+=arrayListJugadores.get(y).getNickname()+"\n";
            }
        }
        return listadoequipos;
    }
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
            listadojugadores[x][12] = jugadores.get(x).getEquipoCod().getNombre();  
             
        }
        return listadojugadores;
    }
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
    
    public static void eliminarUsuario(String pk)throws Exception{
        conexion.getPersonaBD().destroy(pk);
    }
    public static void eliminarJugador(String pk)throws Exception{
        conexion.getJugadorBD().destroy(pk);
    }
    public static void eliminarDueno(String pk)throws Exception{
        conexion.getPersonaBD().destroy(pk);
    }
    public static void eliminarEquipo(String pk)throws Exception{
        conexion.getEquipoBD().destroy(Integer.parseInt(pk));
    }
    
    public static void recalcularClasificacion()throws Exception{
        equipos = conexion.getEquipoBD().findEquipoEntities();
        equiposTemp = new ArrayList();
        boolean finish = false;
        int max;
        Equipo eMax = null;
        for (int x = equipos.size();finish!=true; x--) {
            max = 100;
            for (Equipo e : equipos){
                if(Integer.parseInt(e.getPuntos())<=max&&!equiposReps(e)){
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
    public static boolean equiposReps(Equipo e){
        int x;
        for (x = 0; x < equiposTemp.size()&&!equiposTemp.get(x).equals(e); x++) {}
        if(x==equiposTemp.size())
            return false;
        return true;
    }
    
    public static void REllenarJornadas(String liga, javax.swing.JComboBox cbJornadas){
        llenarJornadas(null, cbJornadas);
    }
    
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
    
    public static Jornadas buscarJornada(Date date){
        for (Jornadas j : ligaBD.getJornadasCollection()){
            if(j.getFechai().equals(date))
                return j;
        }        
        return null;
    }

    public static boolean jornadasReps(Jornadas j, ArrayList<Jornadas> js) {
        int x;
        for (x = 0; x < js.size() && !j.equals(js.get(x)); x++) {
        }
        if (x == js.size()) {
            return false;
        }
        return true;
    }

    
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
    
    public static boolean partidosCompletos(Jornadas j){
        int cont=0;
        for (Partido p : j.getPartidoCollection())
            if(p.getResultado()!=null)
                cont++;      
        if(cont==4)
            return true;
        return false;
    }

    public static Date toDate(String fecha) throws Exception {
        String cadena = "";
        int cont = 0;
        for (int x = 0; x < fecha.length() && cont < 8; x++) {//Aqui
            if (Character.isDigit(fecha.charAt(x))) {
                cadena += fecha.charAt(x);
                cont++;
            } else if (fecha.charAt(x) == '/') {
                cadena += fecha.charAt(x);
            }
        }
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        return fmt.parse(cadena);
    }

    public static String date(Date fecha) {      
        String fechaS = fmt.format(fecha);
        return fechaS;
    }
    
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
    public static String le1(){
        return equiposTemp.get(0).getNombre();
    }
    public static String le2(){
        return equiposTemp.get(1).getNombre();
    }
    
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
    
    public static void StringEquipos(String Sequipo){
        if(Sequipo==null)
            Sequipo="catch";
        CollectionEquiposTemp = new ArrayList ();
        System.out.println(Sequipo);
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
    
    public static void REllenarPartidos(javax.swing.JComboBox cbPartidos)throws Exception{
        llenarPartidos(null,cbPartidos);
    }
    
    
    
    public static void add(String aSumar,boolean both)throws Exception{      
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
    
    public static boolean partidosReps(Partido p, ArrayList<Partido> ps) {
        int x;
        for (x = 0; x < ps.size() && !p.equals(ps.get(x)); x++) {
        }
        if (x == ps.size()) {
            return false;
        }
        return true;
    }

    public static void indices(int[] indices, String nombre, Calendar calendar) throws Exception {
        equipos = new ArrayList();
        for (int x = 0; x < indices.length; x++) {
            equipos.add(equiposBD.get(x));
        }
        generarLiga(nombre, calendar);
    }

    public static void generarLiga(String nombre, Calendar fecha) throws Exception {
        equipos = new ArrayList();
        equipos = conexion.getEquipoBD().findEquipoEntities();
        formula = (((equipos.size() - 1) * equipos.size()) / ((equipos.size() - 1) * 2));
        PartidosEquipo = generarPartidos();
        boolean zig = true;
        liga = new Liga(codigoLiga(), nombre);
        conexion.getLigaBD().create(liga);
        buscarFinesDeSemana(fecha);
        for (int y = 0; y < finde.size() / 2; y += 2) {
            Jornadas j = new Jornadas(codigoJornada(), (Date) finde.get(y), (Date) finde.get(y + 1));
            j.setLigaCod(liga);
            jornadas.add(j);
            conexion.getJornadaBD().create(j);
            for (int z = 0; z < formula / 2; z++) {
                Partido p = null;
                if (zig) {
                    for (int p1 = 0; p1 < formula / 2; p1++) {
                        p = new Partido(codigoPartido(), "Espana", j.getFechai());
                        partidos.add(p);
                        j.addPartidosCollection(p);
                        p.setJornadasCod(j);
                        conexion.getPartidoBD().create(p);
                        zig = false;
                    }
                } else {
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

    public static Equipo[][] generarPartidos() {
        boolean zig = true;
        boolean stop = false;
        int x = 0, y = 0, z = 0, t = 0, cont = 0;
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

    public static void buscarFinesDeSemana(Calendar calendar) throws Exception{
        finde = new ArrayList();        
        int x = 0;
        while (x != (equipos.size() - 1) * 8) {
            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SATURDAY:
                case Calendar.SUNDAY:                    
                    String formatted = fmt.format(calendar.getTime());                   
                    finde.add(fmt.parse(formatted));
                    x++;
                    break;
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    public static List emparejar() throws Exception {
        boolean first = true, found = false, finished = false;
        equiposTemp = new ArrayList();
        int contador = 0, contacuatro = 0, contaTotal = 0;
        for (int x = 0; x < PartidosEquipo.length && finished == false; x++) {
            found = false;
            for (int y = 0; y < PartidosEquipo[y].length & found == false; y++) {
                if (!equiposTemp(PartidosEquipo[x][y]) && !equiposTemp(PartidosEquipo[x][y + 1]) && PartidosEquipo[x][y] != null && PartidosEquipo[x][y + 1] != null) {
                    equiposP = new ArrayList();
                    for (int g = 0; g < PartidosEquipo[y].length; g++) {
                        equiposP.add(PartidosEquipo[x][g]);
                        equiposTemp.add(PartidosEquipo[x][g]);
                        PartidosEquipo[x][g] = null;
                    }
                    partidos.get(contador).setEquipoCollection(equiposP);
                    conexion.getPartidoBD().edit(partidos.get(contador));
                    contador++;
                    contacuatro++;
                    contaTotal++;
                    if (contaTotal == PartidosEquipo.length) {
                        finished = true;
                    }
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
        return equiposP;
    }

    public static boolean equiposTemp(Equipo e) {
        int x;
        for (x = 0; x < equiposTemp.size() && !equiposTemp.get(x).equals(e); x++) {
        }
        if (x == equiposTemp.size()) {
            return false;
        }
        return true;
    }

    public static int codigoLiga() {
        return Integer.parseInt(conexion.getLigaBD().autoincrement());
    }

    public static int codigoJornada() {
        return Integer.parseInt(conexion.getJornadaBD().autoincrement());
    }

    public static int codigoPartido() {
        return Integer.parseInt(conexion.getPartidoBD().autoincrement());
    }
    
    public static void exit(){
        System.exit(0);
    }
    
}
