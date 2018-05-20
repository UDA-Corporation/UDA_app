package Modelo.BD;

import Modelo.BD.exceptions.IllegalOrphanException;
import Modelo.BD.exceptions.NonexistentEntityException;
import Modelo.BD.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.UML.Jornadas;
import Modelo.UML.Liga;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version %G%
 */

public class LigaJpaController implements Serializable {

    public LigaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Liga liga) throws PreexistingEntityException, Exception {
        if (liga.getJornadasCollection() == null) {
            liga.setJornadasCollection(new ArrayList<Jornadas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Jornadas> attachedJornadasCollection = new ArrayList<Jornadas>();
            for (Jornadas jornadasCollectionJornadasToAttach : liga.getJornadasCollection()) {
                jornadasCollectionJornadasToAttach = em.getReference(jornadasCollectionJornadasToAttach.getClass(), jornadasCollectionJornadasToAttach.getCod());
                attachedJornadasCollection.add(jornadasCollectionJornadasToAttach);
            }
            liga.setJornadasCollection(attachedJornadasCollection);
            em.persist(liga);
            for (Jornadas jornadasCollectionJornadas : liga.getJornadasCollection()) {
                Liga oldLigaCodOfJornadasCollectionJornadas = jornadasCollectionJornadas.getLigaCod();
                jornadasCollectionJornadas.setLigaCod(liga);
                jornadasCollectionJornadas = em.merge(jornadasCollectionJornadas);
                if (oldLigaCodOfJornadasCollectionJornadas != null) {
                    oldLigaCodOfJornadasCollectionJornadas.getJornadasCollection().remove(jornadasCollectionJornadas);
                    oldLigaCodOfJornadasCollectionJornadas = em.merge(oldLigaCodOfJornadasCollectionJornadas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLiga(liga.getCod()) != null) {
                throw new PreexistingEntityException("Liga " + liga + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Liga liga) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Liga persistentLiga = em.find(Liga.class, liga.getCod());
            Collection<Jornadas> jornadasCollectionOld = persistentLiga.getJornadasCollection();
            Collection<Jornadas> jornadasCollectionNew = liga.getJornadasCollection();
            List<String> illegalOrphanMessages = null;
            for (Jornadas jornadasCollectionOldJornadas : jornadasCollectionOld) {
                if (!jornadasCollectionNew.contains(jornadasCollectionOldJornadas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Jornadas " + jornadasCollectionOldJornadas + " since its ligaCod field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Jornadas> attachedJornadasCollectionNew = new ArrayList<Jornadas>();
            for (Jornadas jornadasCollectionNewJornadasToAttach : jornadasCollectionNew) {
                jornadasCollectionNewJornadasToAttach = em.getReference(jornadasCollectionNewJornadasToAttach.getClass(), jornadasCollectionNewJornadasToAttach.getCod());
                attachedJornadasCollectionNew.add(jornadasCollectionNewJornadasToAttach);
            }
            jornadasCollectionNew = attachedJornadasCollectionNew;
            liga.setJornadasCollection(jornadasCollectionNew);
            liga = em.merge(liga);
            for (Jornadas jornadasCollectionNewJornadas : jornadasCollectionNew) {
                if (!jornadasCollectionOld.contains(jornadasCollectionNewJornadas)) {
                    Liga oldLigaCodOfJornadasCollectionNewJornadas = jornadasCollectionNewJornadas.getLigaCod();
                    jornadasCollectionNewJornadas.setLigaCod(liga);
                    jornadasCollectionNewJornadas = em.merge(jornadasCollectionNewJornadas);
                    if (oldLigaCodOfJornadasCollectionNewJornadas != null && !oldLigaCodOfJornadasCollectionNewJornadas.equals(liga)) {
                        oldLigaCodOfJornadasCollectionNewJornadas.getJornadasCollection().remove(jornadasCollectionNewJornadas);
                        oldLigaCodOfJornadasCollectionNewJornadas = em.merge(oldLigaCodOfJornadasCollectionNewJornadas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = liga.getCod();
                if (findLiga(id) == null) {
                    throw new NonexistentEntityException("The liga with id " + id + " no longer exists.");
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
            Liga liga;
            try {
                liga = em.getReference(Liga.class, id);
                liga.getCod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The liga with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Jornadas> jornadasCollectionOrphanCheck = liga.getJornadasCollection();
            for (Jornadas jornadasCollectionOrphanCheckJornadas : jornadasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Liga (" + liga + ") cannot be destroyed since the Jornadas " + jornadasCollectionOrphanCheckJornadas + " in its jornadasCollection field has a non-nullable ligaCod field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(liga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Liga> findLigaEntities() {
        return findLigaEntities(true, -1, -1);
    }

    public List<Liga> findLigaEntities(int maxResults, int firstResult) {
        return findLigaEntities(false, maxResults, firstResult);
    }

    private List<Liga> findLigaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Liga.class));
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

    public Liga findLiga(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Liga.class, id);
        } finally {
            em.close();
        }
    }

    public int getLigaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Liga> rt = cq.from(Liga.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /**
     * Autoincrementa el codigo de la liga
     * @return codigo
     */
    public String autoincrement(){
        try{
            String jpql="select max(cod) from liga";
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
     * Busca la liga por nombre
     * @param name nombre de la liga
     * @return objeto liga
     */
    public Liga findByName(String name){       
            Query consulta = this.getEntityManager().createNamedQuery(Liga.findName);
            consulta.setParameter("nombre", name);
            List<Liga> lista = consulta.getResultList(); 
            return lista.get(0);    
    }
}
