package Modelo.UML;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "EQUIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByCod", query = "SELECT e FROM Equipo e WHERE e.cod = :cod")
    , @NamedQuery(name = "Equipo.findByNombre", query = "SELECT e FROM Equipo e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Equipo.findByDesripcion", query = "SELECT e FROM Equipo e WHERE e.desripcion = :desripcion")
    , @NamedQuery(name = "Equipo.findByPuntos", query = "SELECT e FROM Equipo e WHERE e.puntos = :puntos")
    , @NamedQuery(name = "Equipo.findByPuesto", query = "SELECT e FROM Equipo e WHERE e.puesto = :puesto")})
public class Equipo implements Serializable {

    public static final String findName = "Equipo.findByNombre";
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD")
    private Integer cod;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESRIPCION")
    private String desripcion;
    @Basic(optional = true)
    @Column(name = "PUNTOS")
    private String puntos;
    @Basic(optional = true)
    @Column(name = "PUESTO")
    private String puesto;
    @JoinTable(name = "EQUIPO_JUEGA", joinColumns = {
        @JoinColumn(name = "EQUIPO_COD", referencedColumnName = "COD")}, inverseJoinColumns = {
        @JoinColumn(name = "PARTIDO_COD", referencedColumnName = "COD")})
    @ManyToMany
    private Collection<Partido> partidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoCod")
    private Collection<Jugador> jugadorCollection;
    @JoinColumn(name = "DUENO_DNI", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private Dueno duenoDni;

    public Equipo() {
    }

    public Equipo(Integer cod) {
        this.cod = cod;
    }

    public Equipo(Integer cod, String nombre, String desripcion, String puntos, String puesto) {
        this.cod = cod;
        this.nombre = nombre;
        this.desripcion = desripcion;
        this.puntos = puntos;
        this.puesto = puesto;
    }
    
    public Equipo(Integer cod, String nombre, String desripcion) {
        this.cod = cod;
        this.nombre = nombre;
        this.desripcion = desripcion;
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

    public String getDesripcion() {
        return desripcion;
    }

    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
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

    @XmlTransient
    public Collection<Partido> getPartidoCollection() {
        return partidoCollection;
    }

    public void setPartidoCollection(Collection<Partido> partidoCollection) {
        this.partidoCollection = partidoCollection;
    }

    @XmlTransient
    public Collection<Jugador> getJugadorCollection() {
        return jugadorCollection;
    }

    public void setJugadorCollection(Collection<Jugador> jugadorCollection) {
        this.jugadorCollection = jugadorCollection;
    }
    
    public void addJugador(Jugador j1){
        if(jugadorCollection == null)
            jugadorCollection = new ArrayList();
        this.jugadorCollection.add(j1);
    }
    
    public void addPuntos(int addPuntos){
        int temp = Integer.parseInt(puntos);
        temp += addPuntos;
        puntos=Integer.toString(temp);
    }

    public Dueno getDuenoDni() {
        return duenoDni;
    }

    public void setDuenoDni(Dueno duenoDni) {
        this.duenoDni = duenoDni;
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
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UML.Equipo[ cod=" + cod + " ]";
    }
    
}
