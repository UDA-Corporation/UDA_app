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
import Views.JDInfo.JDInfo;
import static java.awt.SystemColor.window;

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
public static Cuenta usu;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        try {
            conexion=new ConexionBD();  
//            equipos=new ArrayList();
//            jornadas=new ArrayList();
//            Equipo e=new Equipo(1, "Fnatic", "Fnatic", "Fnatic", "Fnatic");        
//            Equipo e2=new Equipo(2, "TSM", "Fnatic", "Fnatic", "Fnatic");       
//            Equipo e3=new Equipo(3, "Team LIquid", "Fnatic", "Fnatic", "Fnatic");
//            Equipo e4=new Equipo(4, "Origen", "Fnatic", "Fnatic", "Fnatic");
//            Equipo e5=new Equipo(5, "STK", "Fnatic", "Fnatic", "Fnatic");
//            Equipo e6=new Equipo(6, "Samsung White", "Fnatic", "Fnatic", "Fnatic");
//            Equipo e7=new Equipo(7, "UOL", "Fnatic", "Fnatic", "Fnatic");
//            Equipo e8=new Equipo(8, "SK", "Fnatic", "Fnatic", "Fnatic");
//        
//            equipos.add(e);
//            equipos.add(e2);
//            equipos.add(e3);
//            equipos.add(e4);
//            equipos.add(e5);
//            equipos.add(e6);
//            equipos.add(e7);
//            equipos.add(e8);   
//            generarCalendario();
//            System.out.println("Done"); 
            System.out.println("▒█░▒█ ▒█▀▀▄ ░█▀▀█ \n" +
                               "▒█░▒█ ▒█░▒█ ▒█▄▄█ \n" +
                               "░▀▄▄▀ ▒█▄▄▀ ▒█░▒█ \n" +
                               "\n" +
                               "▒█▀▀█ █▀▀█ █▀▀█ █▀▀█ ░ \n" +
                               "▒█░░░ █░░█ █▄▄▀ █░░█ ▄ \n" +
                               "▒█▄▄█ ▀▀▀▀ ▀░▀▀ █▀▀▀ █ \n v0.3 alpha");
            VPrincipal vp = new VPrincipal();
            vp.setVisible(true);
        } catch (Exception e) {
            System.out.println("Conecction problem");
        }
        
    }
    public static void toVLogin(Frame ventana){
        ventana.dispose();
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
        
        JDInfo jde = new JDInfo(ventana, modal, mensaje);
        jde.setVisible(true);
    }
    
    public static void JDInfo(Frame ventana, boolean modal, String mensaje, String mensaje2){
        
        JDInfo jde = new JDInfo(ventana, modal, mensaje, mensaje2);
        jde.setVisible(true);
    }    
    
    public static boolean findUsuLogin(String usuario, String pass){
        
        boolean login = false;
        Cuenta c = conexion.getCuentaBD().findCuenta(usuario);
        
        
        if(c.getPass().equals(pass))
        {
            login = true;
            usu = c;
        }
        return login;
           
    }
    
    public static void cerrarSesion(){
        usu = null;

    }
    
    public static void generarCalendario()throws Exception{ 
        equipos=conexion.getEquipoBD().findEquipoEntities();
        PartidosEquipo=generarPartidos();
        emparejar();
        boolean zig=true;
        int formula=(((equipos.size()-1)*equipos.size())/((equipos.size()-1)*2));
        liga=new Liga(codigoLiga(),"LVP");
        conexion.getLigaBD().create(liga);
        buscarFinesDeSemana();        
        for(int y=0;y<finde.size();y+=2){            
            Jornadas j=new Jornadas(codigoJornada(),(Date)finde.get(y),(Date)finde.get(y+1));  
            j.setLigaCod(liga);
            jornadas.add(j);
            conexion.getJornadaBD().create(j);
            for(int z=0;z<formula/2;z++){                
                Partido p=null;             
                if(zig){
                    ArrayList <Partido> partidos=new ArrayList();                    
                    for(int p1=0;p1<formula/2;p1++){                       
                        p=new Partido(codigoPartido(), "Espana", j.getFechai());
                        partidos.add(p);
                        j.addPartidosCollection(p);
                        equipos.get(posicion1);
                        zig=false;
                    }
                }else{
                    ArrayList <Partido> partidos=new ArrayList();
                    for(int p2=0;p2<formula/2;p2++){
                        p=new Partido(codigoPartido(), "Espana", j.getFechaf());
                        partidos.add(p);
                        j.addPartidosCollection(p);
                        zig=true;
                    }
                }
                p.setJornadasCod(j);
                conexion.getPartidoBD().create(p);
            }
        }
        
    }
    public static List emparejar(){        
        boolean first=true,found=false;        
        for (int x=0;x<PartidosEquipo.length;x++){
            found=false;            
            for(int y=0;y<PartidosEquipo[y].length&found==false;y++){ 
                if(first){                   
                    equiposP.add(PartidosEquipo[x][y]);
                    PartidosEquipo[x][y]=null;
                    if(y==PartidosEquipo[y].length-1)
                        first=false;
                    //found=true;
                }else                   
                    if (!equiposP.get(y).equals(PartidosEquipo[x][y])&&!equiposP.get(y+1).equals(PartidosEquipo[x][y+1])){ 
                        equiposP.remove(0);
                        equiposP.add(PartidosEquipo[x][y]);
                        PartidosEquipo[x][y]=null;                   
                    if(y==PartidosEquipo[y].length-1)
                        found=true; 
                    }else
                        found=true;
            }            
        }                            
        return equiposP;
    }
    public static void buscarFinesDeSemana(){
        finde=new ArrayList();   
        Calendar calendar=Calendar.getInstance();
        int x=0;
        while(x!=(equipos.size()-1)*8){
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
    public static Equipo [][] generarPartidos(){
        boolean zig=true;
        boolean stop=false;
        int x=0,y=0,z=0,t=0,cont=0;
        Equipo [][] equiposPartidos=new Equipo [56][2];
        do{
            do{
                stop=false;  
                t=0;
                do{                   
                    do{                     
                        if(!equipos.get(x).equals(equipos.get(y))){
                            if(zig){
                                equiposPartidos[z][t]=equipos.get(x);
                                zig=false;
                                stop=true;                                    
                                t++;                                
                            }else{
                                equiposPartidos[z][t]=equipos.get(y);
                                zig=true;
                                stop=true;   
                                y++;     
                                cont++;
                                t++;
                            }
                        }else
                            y++;
                        if (cont==equipos.size()-1){
                            x++;
                            y=0;
                            cont=0;
                        }
                    }while(t<2);               
                }while(x<equipos.size()&stop==false);  
                z++;
            }while(t<equiposPartidos[t].length);           
        }while(z<equiposPartidos.length);
//        String cadena="";
//        for(int hola=0;hola<equiposPartidos.length;hola++){
//            cadena="";
//            for(int hola2=0;hola2<equiposPartidos[hola2].length;hola2++){
//                if(hola2==0)
//                    cadena=Integer.toString(equiposPartidos[hola][hola2].getCod());                    
//                else{
//                    cadena+=equiposPartidos[hola][hola2].getCod();
//                    System.out.println(cadena);
//                }
//                
//            }
//        }
        return equiposPartidos;
    }
}
