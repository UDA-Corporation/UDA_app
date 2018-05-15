package Modelo.BD;

import Modelo.BD.exceptions.NonexistentEntityException;
import Modelo.BD.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.UML.Equipo;
import Modelo.UML.Jugador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version 1.0 
 */

public class JugadorJpaController implements Serializable {

    public JugadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Jugador jugador) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo equipoCod = jugador.getEquipoCod();
            if (equipoCod != null) {
                equipoCod = em.getReference(equipoCod.getClass(), equipoCod.getCod());
                jugador.setEquipoCod(equipoCod);
            }
            em.persist(jugador);
            if (equipoCod != null) {
                equipoCod.getJugadorCollection().add(jugador);
                equipoCod = em.merge(equipoCod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findJugador(jugador.getDni()) != null) {
                throw new PreexistingEntityException("Jugador " + jugador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Jugador jugador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugador persistentJugador = em.find(Jugador.class, jugador.getDni());
            Equipo equipoCodOld = persistentJugador.getEquipoCod();
            Equipo equipoCodNew = jugador.getEquipoCod();
            if (equipoCodNew != null) {
                equipoCodNew = em.getReference(equipoCodNew.getClass(), equipoCodNew.getCod());
                jugador.setEquipoCod(equipoCodNew);
            }
            jugador = em.merge(jugador);
            if (equipoCodOld != null && !equipoCodOld.equals(equipoCodNew)) {
                equipoCodOld.getJugadorCollection().remove(jugador);
                equipoCodOld = em.merge(equipoCodOld);
            }
            if (equipoCodNew != null && !equipoCodNew.equals(equipoCodOld)) {
                equipoCodNew.getJugadorCollection().add(jugador);
                equipoCodNew = em.merge(equipoCodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = jugador.getDni();
                if (findJugador(id) == null) {
                    throw new NonexistentEntityException("The jugador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugador jugador;
            try {
                jugador = em.getReference(Jugador.class, id);
                jugador.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jugador with id " + id + " no longer exists.", enfe);
            }
            Equipo equipoCod = jugador.getEquipoCod();
            if (equipoCod != null) {
                equipoCod.getJugadorCollection().remove(jugador);
                equipoCod = em.merge(equipoCod);
            }
            em.remove(jugador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Jugador> findJugadorEntities() {
        return findJugadorEntities(true, -1, -1);
    }

    public List<Jugador> findJugadorEntities(int maxResults, int firstResult) {
        return findJugadorEntities(false, maxResults, firstResult);
    }

    private List<Jugador> findJugadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jugador.class));
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

    public Jugador findJugador(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Jugador.class, id);
        } finally {
            em.close();
        }
    }

    public int getJugadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Jugador> rt = cq.from(Jugador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
