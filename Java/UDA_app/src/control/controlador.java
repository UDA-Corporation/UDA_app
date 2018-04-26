/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import Modelo.BD.*;
import Modelo.UML.*;
import java.util.*;
import Views.Login.VLogin;
import Views.Registro.VRegistro;
import Views.VPrincipal.VPrincipal;
import java.awt.Frame;
import Views.JDError.JDError;

/**
 *
 * @author unai-
 */
public class controlador {
static ConexionBD conexion;
public static boolean modoayuda;
static final int NROPARTIDOSJORNADA=8;
static Liga liga;
static ArrayList finde;
static ArrayList <Jornadas> jornadas;
static ArrayList <Equipo> equipos;
static ArrayList <Partido> partidos;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        try {
            conexion=new ConexionBD();  
            equipos=new ArrayList();
            jornadas=new ArrayList();
            Equipo e=new Equipo(1, "Fnatic", "Fnatic", "Fnatic", "Fnatic");        
            Equipo e2=new Equipo(2, "TSM", "Fnatic", "Fnatic", "Fnatic");       
            Equipo e3=new Equipo(3, "Team LIquid", "Fnatic", "Fnatic", "Fnatic");
            Equipo e4=new Equipo(4, "Origen", "Fnatic", "Fnatic", "Fnatic");
            Equipo e5=new Equipo(5, "STK", "Fnatic", "Fnatic", "Fnatic");
            Equipo e6=new Equipo(6, "Samsung White", "Fnatic", "Fnatic", "Fnatic");
            Equipo e7=new Equipo(7, "UOL", "Fnatic", "Fnatic", "Fnatic");
            Equipo e8=new Equipo(8, "SK", "Fnatic", "Fnatic", "Fnatic");
        
            equipos.add(e);
            equipos.add(e2);
            equipos.add(e3);
            equipos.add(e4);
            equipos.add(e5);
            equipos.add(e6);
            equipos.add(e7);
            equipos.add(e8);   
            generarCalendario();
            System.out.println("Done"); 
//            System.out.println("▒█░▒█ ▒█▀▀▄ ░█▀▀█ \n" +
//                               "▒█░▒█ ▒█░▒█ ▒█▄▄█ \n" +
//                               "░▀▄▄▀ ▒█▄▄▀ ▒█░▒█ \n" +
//                               "\n" +
//                               "▒█▀▀█ █▀▀█ █▀▀█ █▀▀█ ░ \n" +
//                               "▒█░░░ █░░█ █▄▄▀ █░░█ ▄ \n" +
//                               "▒█▄▄█ ▀▀▀▀ ▀░▀▀ █▀▀▀ █ \n v0.2 alpha");
//            VPrincipal vp = new VPrincipal();
//            vp.setVisible(true);
        } catch (Exception e) {
            System.out.println("Conecction problem");
        }
        
    }
    public static void toVLogin(){     
        VLogin vl = new VLogin();
        vl.setVisible(true);
    }
    
    public static void toVPrincipal(Frame ventana){    
        ventana.dispose();
        VPrincipal vp = new VPrincipal();
        vp.setVisible(true);
    }
    public static void toVRegistro(Frame ventana){
        ventana.dispose();
        VRegistro vr = new VRegistro();
        vr.setVisible(true);
    }
    
    public static void JDError(Frame ventana, boolean modal, String mensaje){
        
        JDError jde = new JDError(ventana, modal, mensaje);
        jde.setVisible(true);
    }
    
    public static void JDError(Frame ventana, boolean modal, String mensaje, String mensaje2){
        
        JDError jde = new JDError(ventana, modal, mensaje, mensaje2);
        jde.setVisible(true);
    }
    
    public static void JDInfo(Frame ventana, boolean modal, String mensaje){
        
        JDError jde = new JDError(ventana, modal, mensaje);
        jde.setVisible(true);
    }
    
    public static void JDInfo(Frame ventana, boolean modal, String mensaje, String mensaje2){
        
        JDError jde = new JDError(ventana, modal, mensaje, mensaje2);
        jde.setVisible(true);
    }    
    public static void generarCalendario()throws Exception{     
        boolean zig=true;
        int formula=(((equipos.size()-1)*equipos.size())/((equipos.size()-1)*2));
        liga=new Liga(codigoLiga(),"LVP");
        conexion.getLigaBD().create(liga);
        buscarFinesDeSemana();        
        for(int y=0;y<finde.size();y+=2){            
            Jornadas j=new Jornadas(codigoJornada(),(Date)finde.get(y),(Date)finde.get(y+1));  
            j.setLigaCod(liga);
            jornadas.add(j);
            for(int z=0;z<formula/2;z++){                
                Partido p=null;             
                if(zig){
                    ArrayList <Partido> partidos=new ArrayList();                    
                    for(int p1=0;p1<formula/2;p1++){                       
                        p=new Partido(codigoPartido(), "Espana", j.getFechai());
                        partidos.add(p);
                        j.addPartidosCollection(p);
                        conexion.getPartidoBD().create(p);
                        zig=false;
                    }
                }else{
                    ArrayList <Partido> partidos=new ArrayList();
                    for(int p2=0;p2<formula/2;p2++){
                        p=new Partido(codigoPartido(), "Espana", j.getFechaf());
                        partidos.add(p);
                        j.addPartidosCollection(p);
                        conexion.getPartidoBD().create(p);
                        zig=true;
                    }
                }
                p.setJornadasCod(j);
                conexion.getPartidoBD().create(p);
            }
            conexion.getJornadaBD().create(j);
        }
        
    }
    public static void buscarFinesDeSemana(){
        finde=new ArrayList();;       
        Calendar calendar=Calendar.getInstance();
        int x=0;
        while(x!=(equipos.size()-1)*4){
            switch(calendar.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                finde.add(calendar.getTime());
                x++;
            break;
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
    public static int codigoLiga(){
        return Integer.parseInt(conexion.getLigaBD().autoincrement());
    }
    public static int codigoJornada(){
        return Integer.parseInt(conexion.getJornadaBD().autoincrement());
    }
    public static int codigoPartido(){
        return Integer.parseInt(conexion.getPartidoBD().autoincrement());
    }
}
