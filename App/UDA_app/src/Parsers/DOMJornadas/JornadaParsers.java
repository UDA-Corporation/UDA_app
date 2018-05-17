/**
 * @author Unai Puelles
 * @author Daniel Barragues
 * @author Alejandro Diaz de Otalora
 * @version %G%
 * @since 0.1 alpha
 */
package Parsers.DOMJornadas;

public class JornadaParsers {
    private String codigoJornada;
    private String fechaInicio;
    private String fechaFinal;

    public JornadaParsers(String codigoJornada, String fechaInicio, String fechaFinal) {
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
