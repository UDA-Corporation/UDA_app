package Modelo.UML;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version 1.0 
 */

@Entity
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByDni", query = "SELECT p FROM Persona p WHERE p.dni = :dni")
    , @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Persona.findByCalle", query = "SELECT p FROM Persona p WHERE p.calle = :calle")
    , @NamedQuery(name = "Persona.findByNro", query = "SELECT p FROM Persona p WHERE p.nro = :nro")
    , @NamedQuery(name = "Persona.findByPiso", query = "SELECT p FROM Persona p WHERE p.piso = :piso")
    , @NamedQuery(name = "Persona.findByCiudad", query = "SELECT p FROM Persona p WHERE p.ciudad = :ciudad")
    , @NamedQuery(name = "Persona.findByCp", query = "SELECT p FROM Persona p WHERE p.cp = :cp")
    , @NamedQuery(name = "Persona.findByPais", query = "SELECT p FROM Persona p WHERE p.pais = :pais")
    , @NamedQuery(name = "Persona.findByTipoPersona", query = "SELECT p FROM Persona p WHERE p.tipoPersona = :tipoPersona")
    , @NamedQuery(name = "Persona.findByTlfo", query = "SELECT p FROM Persona p WHERE p.tlfo = :tlfo")})
public class Persona implements Serializable {

    public static final String findTipo = "Persona.findByTipoPersona";
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;
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
    @Basic(optional = true)
    @Column(name = "TIPO_PERSONA")
    private String tipoPersona;
    @Basic(optional = false)
    @Column(name = "TLFO")
    private String tlfo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Dueno dueno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaDni")
    private Collection<Cuenta> cuentaCollection;

    public Persona() {
    }

    public Persona(String dni) {
        this.dni = dni;
    }

    public Persona(String dni, String nombre, String apellido, String calle, String nro, String piso, String ciudad, String cp, String pais, String tipoPersona, String tlfo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.nro = nro;
        this.piso = piso;
        this.ciudad = ciudad;
        this.cp = cp;
        this.pais = pais;
        this.tipoPersona = tipoPersona;
        this.tlfo = tlfo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getTlfo() {
        return tlfo;
    }

    public void setTlfo(String tlfo) {
        this.tlfo = tlfo;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
    
    public void setUpdate(String nombre, String apellido, String calle, String nro, String piso, String ciudad, String cp, String pais, String tlfo){
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

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }
    
    public void addCuenta(Cuenta c1){
        
        if(cuentaCollection == null)
            cuentaCollection = new ArrayList();
        this.cuentaCollection.add(c1);
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UML.Persona[ dni=" + dni + " ]";
    }
    
}
