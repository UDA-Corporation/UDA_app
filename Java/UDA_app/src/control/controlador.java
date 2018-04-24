/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import Modelo.BD.*;
import Modelo.UML.*;
import java.util.ArrayList;

/**
 *
 * @author unai-
 */
public class controlador {
static ConexionBD conexion;
public static boolean modoayuda;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        try {
            conexion=new ConexionBD(); 
            conexion.getJornadaBD().autoincrement();
        } catch (Exception e) {
            System.out.println("Conecction problem");
        }
        
    }
    public static void generarCalendario(){
        ArrayList <Equipo>equipos=new ArrayList();
        Equipo [] randomEquipos=new Equipo[equipos.size()];
        int a;
        for(int x=0;x<equipos.size();x++){
            do{
                a=(int)(Math.random()*8);
            }while(randomEquipos[a]!=null);
                randomEquipos[a]=(equipos.get(x));
        }
        
        Liga liga=new Liga(1);
        liga.setNombre("LVP");
        int cont=0;
        do{
            
        }while(cont>3);
        
        
    }
    
}
