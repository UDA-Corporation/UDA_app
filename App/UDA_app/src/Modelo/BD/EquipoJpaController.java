package Modelo.BD;

import Modelo.BD.exceptions.IllegalOrphanException;
import Modelo.BD.exceptions.NonexistentEntityException;
import Modelo.BD.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.UML.Dueno;
import Modelo.UML.Equipo;
import Modelo.UML.Partido;
import java.util.ArrayList;
import java.util.Collection;
import Modelo.UML.Jugador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version %G%
 */

public class EquipoJpaController implements Serializable {

    public EquipoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Equipo equipo) throws PreexistingEntityException, Exception {
        if (equipo.getPartidoCollection() == null) {
            equipo.setPartidoCollection(new ArrayList<Partido>());
        }
        if (equipo.getJugadorCollection() == null) {
            equipo.setJugadorCollection(new ArrayList<Jugador>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dueno duenoDni = equipo.getDuenoDni();
            if (duenoDni != null) {
                duenoDni = em.getReference(duenoDni.getClass(), duenoDni.getDni());
                equipo.setDuenoDni(duenoDni);
            }
            Collection<Partido> attachedPartidoCollection = new ArrayList<Partido>();
            for (Partido partidoCollectionPartidoToAttach : equipo.getPartidoCollection()) {
                partidoCollectionPartidoToAttach = em.getReference(partidoCollectionPartidoToAttach.getClass(), partidoCollectionPartidoToAttach.getCod());
                attachedPartidoCollection.add(partidoCollectionPartidoToAttach);
            }
            equipo.setPartidoCollection(attachedPartidoCollection);
            Collection<Jugador> attachedJugadorCollection = new ArrayList<Jugador>();
            for (Jugador jugadorCollectionJugadorToAttach : equipo.getJugadorCollection()) {
                jugadorCollectionJugadorToAttach = em.getReference(jugadorCollectionJugadorToAttach.getClass(), jugadorCollectionJugadorToAttach.getDni());
                attachedJugadorCollection.add(jugadorCollectionJugadorToAttach);
            }
            equipo.setJugadorCollection(attachedJugadorCollection);
            em.persist(equipo);
            if (duenoDni != null) {
                duenoDni.getEquipoCollection().add(equipo);
                duenoDni = em.merge(duenoDni);
            }
            for (Partido partidoCollectionPartido : equipo.getPartidoCollection()) {
                partidoCollectionPartido.getEquipoCollection().add(equipo);
                partidoCollectionPartido = em.merge(partidoCollectionPartido);
            }
            for (Jugador jugadorCollectionJugador : equipo.getJugadorCollection()) {
                Equipo oldEquipoCodOfJugadorCollectionJugador = jugadorCollectionJugador.getEquipoCod();
                jugadorCollectionJugador.setEquipoCod(equipo);
                jugadorCollectionJugador = em.merge(jugadorCollectionJugador);
                if (oldEquipoCodOfJugadorCollectionJugador != null) {
                    oldEquipoCodOfJugadorCollectionJugador.getJugadorCollection().remove(jugadorCollectionJugador);
                    oldEquipoCodOfJugadorCollectionJugador = em.merge(oldEquipoCodOfJugadorCollectionJugador);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEquipo(equipo.getCod()) != null) {
                throw new PreexistingEntityException("Equipo " + equipo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Equipo equipo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo persistentEquipo = em.find(Equipo.class, equipo.getCod());
            Dueno duenoDniOld = persistentEquipo.getDuenoDni();
            Dueno duenoDniNew = equipo.getDuenoDni();
            Collection<Partido> partidoCollectionOld = persistentEquipo.getPartidoCollection();
            Collection<Partido> partidoCollectionNew = equipo.getPartidoCollection();
            Collection<Jugador> jugadorCollectionOld = persistentEquipo.getJugadorCollection();
            Collection<Jugador> jugadorCollectionNew = equipo.getJugadorCollection();
            List<String> illegalOrphanMessages = null;
            for (Jugador jugadorCollectionOldJugador : jugadorCollectionOld) {
                if (!jugadorCollectionNew.contains(jugadorCollectionOldJugador)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Jugador " + jugadorCollectionOldJugador + " since its equipoCod field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (duenoDniNew != null) {
                duenoDniNew = em.getReference(duenoDniNew.getClass(), duenoDniNew.getDni());
                equipo.setDuenoDni(duenoDniNew);
            }
            Collection<Partido> attachedPartidoCollectionNew = new ArrayList<Partido>();
            for (Partido partidoCollectionNewPartidoToAttach : partidoCollectionNew) {
                partidoCollectionNewPartidoToAttach = em.getReference(partidoCollectionNewPartidoToAttach.getClass(), partidoCollectionNewPartidoToAttach.getCod());
                attachedPartidoCollectionNew.add(partidoCollectionNewPartidoToAttach);
            }
            partidoCollectionNew = attachedPartidoCollectionNew;
            equipo.setPartidoCollection(partidoCollectionNew);
            Collection<Jugador> attachedJugadorCollectionNew = new ArrayList<Jugador>();
            for (Jugador jugadorCollectionNewJugadorToAttach : jugadorCollectionNew) {
                jugadorCollectionNewJugadorToAttach = em.getReference(jugadorCollectionNewJugadorToAttach.getClass(), jugadorCollectionNewJugadorToAttach.getDni());
                attachedJugadorCollectionNew.add(jugadorCollectionNewJugadorToAttach);
            }
            jugadorCollectionNew = attachedJugadorCollectionNew;
            equipo.setJugadorCollection(jugadorCollectionNew);
            equipo = em.merge(equipo);
            if (duenoDniOld != null && !duenoDniOld.equals(duenoDniNew)) {
                duenoDniOld.getEquipoCollection().remove(equipo);
                duenoDniOld = em.merge(duenoDniOld);
            }
            if (duenoDniNew != null && !duenoDniNew.equals(duenoDniOld)) {
                duenoDniNew.getEquipoCollection().add(equipo);
                duenoDniNew = em.merge(duenoDniNew);
            }
            for (Partido partidoCollectionOldPartido : partidoCollectionOld) {
                if (!partidoCollectionNew.contains(partidoCollectionOldPartido)) {
                    partidoCollectionOldPartido.getEquipoCollection().remove(equipo);
                    partidoCollectionOldPartido = em.merge(partidoCollectionOldPartido);
                }
            }
            for (Partido partidoCollectionNewPartido : partidoCollectionNew) {
                if (!partidoCollectionOld.contains(partidoCollectionNewPartido)) {
                    partidoCollectionNewPartido.getEquipoCollection().add(equipo);
                    partidoCollectionNewPartido = em.merge(partidoCollectionNewPartido);
                }
            }
            for (Jugador jugadorCollectionNewJugador : jugadorCollectionNew) {
                if (!jugadorCollectionOld.contains(jugadorCollectionNewJugador)) {
                    Equipo oldEquipoCodOfJugadorCollectionNewJugador = jugadorCollectionNewJugador.getEquipoCod();
                    jugadorCollectionNewJugador.setEquipoCod(equipo);
                    jugadorCollectionNewJugador = em.merge(jugadorCollectionNewJugador);
                    if (oldEquipoCodOfJugadorCollectionNewJugador != null && !oldEquipoCodOfJugadorCollectionNewJugador.equals(equipo)) {
                        oldEquipoCodOfJugadorCollectionNewJugador.getJugadorCollection().remove(jugadorCollectionNewJugador);
                        oldEquipoCodOfJugadorCollectionNewJugador = em.merge(oldEquipoCodOfJugadorCollectionNewJugador);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = equipo.getCod();
                if (findEquipo(id) == null) {
                    throw new NonexistentEntityException("The equipo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo equipo;
            try {
                equipo = em.getReference(Equipo.class, id);
                equipo.getCod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Jugador> jugadorCollectionOrphanCheck = equipo.getJugadorCollection();
            for (Jugador jugadorCollectionOrphanCheckJugador : jugadorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Equipo (" + equipo + ") cannot be destroyed since the Jugador " + jugadorCollectionOrphanCheckJugador + " in its jugadorCollection field has a non-nullable equipoCod field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Dueno duenoDni = equipo.getDuenoDni();
            if (duenoDni != null) {
                duenoDni.getEquipoCollection().remove(equipo);
                duenoDni = em.merge(duenoDni);
            }
            Collection<Partido> partidoCollection = equipo.getPartidoCollection();
            for (Partido partidoCollectionPartido : partidoCollection) {
                partidoCollectionPartido.getEquipoCollection().remove(equipo);
                partidoCollectionPartido = em.merge(partidoCollectionPartido);
            }
            em.remove(equipo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Equipo> findEquipoEntities() {
        return findEquipoEntities(true, -1, -1);
    }

    public List<Equipo> findEquipoEntities(int maxResults, int firstResult) {
        return findEquipoEntities(false, maxResults, firstResult);
    }

    private List<Equipo> findEquipoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Equipo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Equipo findEquipo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Equipo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Equipo> rt = cq.from(Equipo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /**
     * Autoincrementa el codigo del equipo
     * @return codigo
     */
    public String autoincrement(){
        try{
            String jpql="select max(cod) from equipo";
            Query cons=this.getEntityManager().createNativeQuery(jpql);
            List lista = cons.getResultList();  
            String cod=lista.get(0).toString();
            cod=Integer.toString(Integer.parseInt(cod)+1);
            return cod;
        }catch(Exception e){
            return "1";
        }           
    }
    
    /**
     * Busca al equipo por nombre
     * @param name nombre del equipo
     * @return objeto equipo
     */
    public Equipo findByName(String name){       
            Query consulta = this.getEntityManager().createNamedQuery(Equipo.findName);
            consulta.setParameter("nombre", name);
            List<Equipo> lista = consulta.getResultList(); 
            return lista.get(0);   
    }
    
}
