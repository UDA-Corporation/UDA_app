/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author 1gdaw02
 */
public class JugadoresInsuficientes extends Exception{
    private String mensaje;

    public JugadoresInsuficientes() {}
    
    public JugadoresInsuficientes(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
    
}
