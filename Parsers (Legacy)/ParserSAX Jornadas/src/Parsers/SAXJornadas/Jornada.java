/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers.SAXJornadas;

/**
 *
 * @author marcos
 */
public class Jornada {
    
    private String jornada;
    private String partido;
    private String resultado;

    public Jornada() {
    }
   
    public Jornada(String jornada, String partido, String resultado) {
        this.jornada = jornada;
        this.partido = partido;
        this.resultado = resultado;
    }
    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
        public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Detalles de la noticia - ");
        sb.append("Título:" + getJornada());
        sb.append(", ");
        sb.append("Link:" + getPartido());
        sb.append(", ");
        sb.append("Fecha publicación:" + getResultado());
        sb.append(".");

        return sb.toString();
    }
    
}
