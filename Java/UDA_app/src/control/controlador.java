/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import Modelo.BD.*;
import Modelo.UML.*;

/**
 *
 * @author unai-
 */
public class controlador {
static ConexionBD conexion;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        try {
            conexion=new ConexionBD();
        } catch (Exception e) {
            System.out.println("Conecction problem");
        }
        
    }
    
}
