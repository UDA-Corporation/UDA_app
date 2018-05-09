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
import Views.VLiga.VLiga;
import Views.VEquipo.VEquipo;
import javax.swing.DefaultListModel;
import Views.VPuntos.VPuntos;
import java.text.SimpleDateFormat;

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
    public static int tipoE;
    static int formula;
    static ArrayList<Equipo> equiposTemp;
    static Liga ligaBD;
    static Jornadas jornadaBD;
    static Partido partidoBD;
    static Date date;
    static List<Liga> ligasBD;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        try {
            inicializar();

            System.out.println("▒█░▒█ ▒█▀▀▄ ░█▀▀█ \n"
                    + "▒█░▒█ ▒█░▒█ ▒█▄▄█ \n"
                    + "░▀▄▄▀ ▒█▄▄▀ ▒█░▒█ \n"
                    + "\n"
                    + "▒█▀▀█ █▀▀█ █▀▀█ █▀▀█ ░ \n"
                    + "▒█░░░ █░░█ █▄▄▀ █░░█ ▄ \n"
                    + "▒█▄▄█ ▀▀▀▀ ▀░▀▀ █▀▀▀ █ \n v0.6 alpha");
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

    public static void toVEquipo(Frame ventana) {
        ventana.dispose();
        VEquipo ve = new VEquipo();
        ve.setVisible(true);
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

    public static boolean registrarUsuario(String dni, String nombre, String apellido, String calle, String numero, String piso, String ciudad, String cp, String pais, String tel, String usuario, String pass, String tipo_persona) throws Exception {
        boolean correcto;

        Persona u1 = new Persona(dni, nombre, apellido, calle, numero, piso, ciudad, cp, pais, tipo_persona, tel);

        Cuenta c1 = new Cuenta(usuario, pass);
        c1.setPersonaDni(u1);
        tipoE = 1;
        conexion.getPersonaBD().create(u1);

        if (tipo_persona.equals("dueno")) {
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

    public static void destroyRegitro(String dni) {
        try {
            conexion.getPersonaBD().destroy(dni);
        } catch (Exception e) {

        }
    }

    public static boolean llenarDuenos(javax.swing.JComboBox cb) throws Exception {

        List<Dueno> d = conexion.getDuenoBD().findDuenoEntities();

        if (d == null) {
            return false;
        } else {
            for (Dueno du : d) {
                cb.addItem(du.getPersona().getNombre());
            }
            return true;
        }

    }

    public static DefaultListModel<String> llenarJugadores(javax.swing.JList lista) {

        jugadores = conexion.getJugadorBD().findJugadorEntities();
        DefaultListModel<String> model = new DefaultListModel();
        for (Jugador ju : jugadores) {
            if (ju.getEquipoCod() == null) {
                model.addElement(ju.getNombre() + " " + ju.getApellido());
            }
        }
        return model;
    }

    public static boolean altaEquipo(String nombre, String desc, String dueno, int[] indices) {

        //ME HE QUEDADO AQUI (Unai)
        return false;
    }

    public static DefaultListModel<String> llenarLista(javax.swing.JList lista) {
        equiposBD = conexion.getEquipoBD().findEquipoEntities();
        DefaultListModel<String> model = new DefaultListModel();
        for (Equipo e : equiposBD) {
            model.addElement(e.getNombre());
        }
        return model;
    }

    public static void llenarLiga(javax.swing.JComboBox cb) {
        for (Liga l : conexion.getLigaBD().findLigaEntities()) {
            cb.addItem(l.getNombre());
        }
    }

    public static void llenarJornadas(String liga, javax.swing.JComboBox cbJornadas) {
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
                    cbJornadas.addItem(cadena);
                }

            }
        }
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
        String cadena = "";
        Date test = toDate(fecha);
        jornadaBD = conexion.getJornadaBD().findByDate(test);
        ArrayList<Partido> partidosTemp = new ArrayList();
        boolean finish = false;
        int min, done = 0;
        Partido pMin = null;
        for (int x = 1; finish != true; x++) {
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
                    cbPartidos.addItem(cadena);
                }
            }
        }
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
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fechaS = df.format(fecha);
        return fechaS;
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
        System.out.println("");

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

    public static void buscarFinesDeSemana(Calendar calendar) {
        finde = new ArrayList();
        int x = 0;
        while (x != (equipos.size() - 1) * 8) {
            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SATURDAY:
                case Calendar.SUNDAY:
                    finde.add(calendar.getTime());
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

}
