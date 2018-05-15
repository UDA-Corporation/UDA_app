package Modelo.UML;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version 1.0 
 */

@Entity
@Table(name = "JORNADAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jornadas.findAll", query = "SELECT j FROM Jornadas j")
    , @NamedQuery(name = "Jornadas.findByCod", query = "SELECT j FROM Jornadas j WHERE j.cod = :cod")
    , @NamedQuery(name = "Jornadas.findByFechai", query = "SELECT j FROM Jornadas j WHERE j.fechai = :fechai")
    , @NamedQuery(name = "Jornadas.findByFechaf", query = "SELECT j FROM Jornadas j WHERE j.fechaf = :fechaf")})
public class Jornadas implements Serializable {

    public static final String findByDate = "Jornadas.findByFechai";
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD")
    private Integer cod;
    @Basic(optional = false)
    @Column(name = "FECHAI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechai;
    @Basic(optional = false)
    @Column(name = "FECHAF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jornadasCod")
    private Collection<Partido> partidoCollection;
    @JoinColumn(name = "LIGA_COD", referencedColumnName = "COD")
    @ManyToOne(optional = false)
    private Liga ligaCod;

    public Jornadas() {
    }

    public Jornadas(Integer cod) {
        this.cod = cod;
    }

    public Jornadas(Integer cod, Date fechai, Date fechaf) {
        this.cod = cod;
        this.fechai = fechai;
        this.fechaf = fechaf;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Date getFechai() {
        return fechai;
    }

    public void setFechai(Date fechai) {
        this.fechai = fechai;
    }

    public Date getFechaf() {
        return fechaf;
    }

    public void setFechaf(Date fechaf) {
        this.fechaf = fechaf;
    }

    @XmlTransient
    public Collection<Partido> getPartidoCollection() {
        return partidoCollection;
    }

    public void setPartidoCollection(Collection<Partido> partidoCollection) {
        this.partidoCollection = partidoCollection;
    }
    public void addPartidosCollection(Partido p){
        this.partidoCollection.add(p);
    }
    public Liga getLigaCod() {
        return ligaCod;
    }

    public void setLigaCod(Liga ligaCod) {
        this.ligaCod = ligaCod;
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
        if (!(object instanceof Jornadas)) {
            return false;
        }
        Jornadas other = (Jornadas) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UML.Jornadas[ cod=" + cod + " ]";
    }
    
}
