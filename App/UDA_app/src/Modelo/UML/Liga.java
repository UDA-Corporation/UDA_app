package Modelo.UML;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version %G%
 */

@Entity
@Table(name = "LIGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liga.findAll", query = "SELECT l FROM Liga l")
    , @NamedQuery(name = "Liga.findByCod", query = "SELECT l FROM Liga l WHERE l.cod = :cod")
    , @NamedQuery(name = "Liga.findByNombre", query = "SELECT l FROM Liga l WHERE l.nombre = :nombre")})
public class Liga implements Serializable {

    public static final String findName = "Liga.findByNombre";
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD")
    private Integer cod;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ligaCod")
    private Collection<Jornadas> jornadasCollection;

    public Liga() {
    }

    public Liga(Integer cod) {
        this.cod = cod;
    }

    public Liga(Integer cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Jornadas> getJornadasCollection() {
        return jornadasCollection;
    }

    public void setJornadasCollection(Collection<Jornadas> jornadasCollection) {
        this.jornadasCollection = jornadasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod != null ? cod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Liga)) {
            return false;
        }
        Liga other = (Liga) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UML.Liga[ cod=" + cod + " ]";
    }
    
}
