package Modelo.UML;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version 1.0 
 */

@Entity
@Table(name = "JUGADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j")
    , @NamedQuery(name = "Jugador.findByDni", query = "SELECT j FROM Jugador j WHERE j.dni = :dni")
    , @NamedQuery(name = "Jugador.findByNickname", query = "SELECT j FROM Jugador j WHERE j.nickname = :nickname")
    , @NamedQuery(name = "Jugador.findBySueldo", query = "SELECT j FROM Jugador j WHERE j.sueldo = :sueldo")
    , @NamedQuery(name = "Jugador.findByNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Jugador.findByApellido", query = "SELECT j FROM Jugador j WHERE j.apellido = :apellido")
    , @NamedQuery(name = "Jugador.findByCalle", query = "SELECT j FROM Jugador j WHERE j.calle = :calle")
    , @NamedQuery(name = "Jugador.findByNro", query = "SELECT j FROM Jugador j WHERE j.nro = :nro")
    , @NamedQuery(name = "Jugador.findByPiso", query = "SELECT j FROM Jugador j WHERE j.piso = :piso")
    , @NamedQuery(name = "Jugador.findByCiudad", query = "SELECT j FROM Jugador j WHERE j.ciudad = :ciudad")
    , @NamedQuery(name = "Jugador.findByCp", query = "SELECT j FROM Jugador j WHERE j.cp = :cp")
    , @NamedQuery(name = "Jugador.findByPais", query = "SELECT j FROM Jugador j WHERE j.pais = :pais")
    , @NamedQuery(name = "Jugador.findByTlfo", query = "SELECT j FROM Jugador j WHERE j.tlfo = :tlfo")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @Column(name = "NICKNAME")
    private String nickname;
    @Basic(optional = false)
    @Column(name = "SUELDO")
    private int sueldo;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "CALLE")
    private String calle;
    @Basic(optional = false)
    @Column(name = "NRO")
    private String nro;
    @Basic(optional = false)
    @Column(name = "PISO")
    private String piso;
    @Basic(optional = false)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "CP")
    private String cp;
    @Basic(optional = false)
    @Column(name = "PAIS")
    private String pais;
    @Basic(optional = false)
    @Column(name = "TLFO")
    private String tlfo;
    @JoinColumn(name = "EQUIPO_COD", referencedColumnName = "COD")
    @ManyToOne(optional = true)
    private Equipo equipoCod;

    public Jugador() {
    }

    public Jugador(String dni) {
        this.dni = dni;
    }

    public Jugador(String dni, String nickname, int sueldo, String nombre, String apellido, String calle, String nro, String piso, String ciudad, String cp, String pais, String tlfo) {
        this.dni = dni;
        this.nickname = nickname;
        this.sueldo = sueldo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.nro = nro;
        this.piso = piso;
        this.ciudad = ciudad;
        this.cp = cp;
        this.pais = pais;
        this.tlfo = tlfo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTlfo() {
        return tlfo;
    }

    public void setTlfo(String tlfo) {
        this.tlfo = tlfo;
    }

    public Equipo getEquipoCod() {
        return equipoCod;
    }

    public void setEquipoCod(Equipo equipoCod) {
        this.equipoCod = equipoCod;
    }
    
    public void setUpdate(int sueldo, String nombre, String apellido, String calle, String nro, String piso, String ciudad, String cp, String pais, String tlfo){
        this.sueldo = sueldo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.nro = nro;
        this.piso = piso;
        this.ciudad = ciudad;
        this.cp = cp;
        this.pais = pais;
        this.tlfo = tlfo; 
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UML.Jugador[ dni=" + dni + " ]";
    }
    
}
