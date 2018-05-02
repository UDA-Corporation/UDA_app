/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserdom;

public class Jornada {
    private String codigoJornada;
    private String fechaInicio;
    private String fechaFinal;

    public Jornada(String codigoJornada, String fechaInicio, String fechaFinal) {
        this.codigoJornada = codigoJornada;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        
    }

    public String getcodigoJornada(){
        return codigoJornada;
    }
        
    public void setcodigoJornada(String codigoJornada){
        this.codigoJornada = codigoJornada;
    }
    
    public String getfechaInicio(){
        return fechaInicio;
    }
    
    public void setfechaInicio(String fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    
    public String getfechaFinal(){
        return fechaFinal;
    }
    
    public void setfechaFinal(String fechaFinal){
        this.fechaFinal = fechaFinal;
    }
    
    /*public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" { Detalles de los datos --");
        sb.append("Partido:" + getpartido());
        sb.append(", ");
        sb.append("Resultado:" + getresultado());
        sb.append(", ");
        sb.append("CodigoJornada:" + getcodigoJornada());

        return sb.toString();
    }*/
}
