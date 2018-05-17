package Modelo.UML;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "PARTIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p")
    , @NamedQuery(name = "Partido.findByCod", query = "SELECT p FROM Partido p WHERE p.cod = :cod")
    , @NamedQuery(name = "Partido.findByLugar", query = "SELECT p FROM Partido p WHERE p.lugar = :lugar")
    , @NamedQuery(name = "Partido.findByCodganador", query = "SELECT p FROM Partido p WHERE p.codganador = :codganador")
    , @NamedQuery(name = "Partido.findByEmpate", query = "SELECT p FROM Partido p WHERE p.empate = :empate")
    , @NamedQuery(name = "Partido.findByFecha", query = "SELECT p FROM Partido p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Partido.findByResultado", query = "SELECT p FROM Partido p WHERE p.resultado = :resultado")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD")
    private Integer cod;
    @Basic(optional = false)
    @Column(name = "LUGAR")
    private String lugar;
    @Column(name = "CODGANADOR")
    private Integer codganador;
    @Column(name = "EMPATE")
    private String empate;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "RESULTADO")
    private String resultado;
    @ManyToMany(mappedBy = "partidoCollection")
    private Collection<Equipo> equipoCollection;
    @JoinColumn(name = "JORNADAS_COD", referencedColumnName = "COD")
    @ManyToOne(optional = false)
    private Jornadas jornadasCod;

    public Partido() {
    }

    public Partido(Integer cod) {
        this.cod = cod;
    }

    public Partido(Integer cod, String lugar, Date fecha) {
        this.cod = cod;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getCodganador() {
        return codganador;
    }

    public void setCodganador(Integer codganador) {
        this.codganador = codganador;
    }

    public String getEmpate() {
        return empate;
    }

    public void setEmpate(String empate) {
        this.empate = empate;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @XmlTransient
    public Collection<Equipo> getEquipoCollection() {
        return equipoCollection;
    }

    public void setEquipoCollection(Collection<Equipo> equipoCollection) {
        this.equipoCollection = equipoCollection;
    }

    public Jornadas getJornadasCod() {
        return jornadasCod;
    }

    public void setJornadasCod(Jornadas jornadasCod) {
        this.jornadasCod = jornadasCod;
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
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UML.Partido[ cod=" + cod + " ]";
    }
    
}
