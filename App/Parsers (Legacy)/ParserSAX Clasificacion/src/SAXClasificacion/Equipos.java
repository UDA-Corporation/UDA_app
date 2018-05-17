/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAXClasificacion;

/**
 *
 * @author danie
 */
public class Equipos {
    private String Nombre;
    private String codEquipo;
    private String puesto;
    private String puntos;
    
    public Equipos() {
    }

    public Equipos(String Nombre, String codEquipo, String puesto, String puntos) {
        this.Nombre = Nombre;
        this.codEquipo = codEquipo;
        this.puesto = puesto;
        this.puntos = puntos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }
    
        public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Nombre: " + getNombre());
        sb.append(", ");
        sb.append("Codigo de equipo: " + getCodEquipo());
        sb.append(", ");
        sb.append("Puntos: " + getPuntos());
        sb.append(", ");
        sb.append("Puesto: " + getPuesto());
        sb.append(".");

        return sb.toString();
    }
    
}