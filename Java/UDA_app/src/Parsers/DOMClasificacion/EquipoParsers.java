/**
 * @author Unai Puelles
 * @author Daniel Barragues
 * @author Alejandro Diaz de Otalora
 * @version %G%
 * @since 0.1 alpha
 */
package Parsers.DOMClasificacion;

public class EquipoParsers {
    private String codigoEquipo;
    private String puntos;
    private String puesto;
    private String nombre;
    
    public EquipoParsers(String codigoEquipo, String puntos, String puesto, String nombre) {
        this.codigoEquipo = codigoEquipo;
        this.puntos = puntos;
        this.puesto = puesto;
        this.nombre = nombre;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
