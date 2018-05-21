package Modelo.BD;

import Modelo.BD.exceptions.IllegalOrphanException;
import Modelo.BD.exceptions.NonexistentEntityException;
import Modelo.BD.exceptions.PreexistingEntityException;
import Modelo.UML.Jornadas;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.UML.Liga;
import Modelo.UML.Partido;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version 1.0 
 */

public class JornadasJpaController implements Serializable {

    public JornadasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Jornadas jornadas) throws PreexistingEntityException, Exception {
        if (jornadas.getPartidoCollection() == null) {
            jornadas.setPartidoCollection(new ArrayList<Partido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Liga ligaCod = jornadas.getLigaCod();
            if (ligaCod != null) {
                ligaCod = em.getReference(ligaCod.getClass(), ligaCod.getCod());
                jornadas.setLigaCod(ligaCod);
            }
            Collection<Partido> attachedPartidoCollection = new ArrayList<Partido>();
            for (Partido partidoCollectionPartidoToAttach : jornadas.getPartidoCollection()) {
                partidoCollectionPartidoToAttach = em.getReference(partidoCollectionPartidoToAttach.getClass(), partidoCollectionPartidoToAttach.getCod());
                attachedPartidoCollection.add(partidoCollectionPartidoToAttach);
            }
            jornadas.setPartidoCollection(attachedPartidoCollection);
            em.persist(jornadas);
            if (ligaCod != null) {
                ligaCod.getJornadasCollection().add(jornadas);
                ligaCod = em.merge(ligaCod);
            }
            for (Partido partidoCollectionPartido : jornadas.getPartidoCollection()) {
                Jornadas oldJornadasCodOfPartidoCollectionPartido = partidoCollectionPartido.getJornadasCod();
                partidoCollectionPartido.setJornadasCod(jornadas);
                partidoCollectionPartido = em.merge(partidoCollectionPartido);
                if (oldJornadasCodOfPartidoCollectionPartido != null) {
                    oldJornadasCodOfPartidoCollectionPartido.getPartidoCollection().remove(partidoCollectionPartido);
                    oldJornadasCodOfPartidoCollectionPartido = em.merge(oldJornadasCodOfPartidoCollectionPartido);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findJornadas(jornadas.getCod()) != null) {
                throw new PreexistingEntityException("Jornadas " + jornadas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Jornadas jornadas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jornadas persistentJornadas = em.find(Jornadas.class, jornadas.getCod());
            Liga ligaCodOld = persistentJornadas.getLigaCod();
            Liga ligaCodNew = jornadas.getLigaCod();
            Collection<Partido> partidoCollectionOld = persistentJornadas.getPartidoCollection();
            Collection<Partido> partidoCollectionNew = jornadas.getPartidoCollection();
            List<String> illegalOrphanMessages = null;
            for (Partido partidoCollectionOldPartido : partidoCollectionOld) {
                if (!partidoCollectionNew.contains(partidoCollectionOldPartido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Partido " + partidoCollectionOldPartido + " since its jornadasCod field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (ligaCodNew != null) {
                ligaCodNew = em.getReference(ligaCodNew.getClass(), ligaCodNew.getCod());
                jornadas.setLigaCod(ligaCodNew);
            }
            Collection<Partido> attachedPartidoCollectionNew = new ArrayList<Partido>();
            for (Partido partidoCollectionNewPartidoToAttach : partidoCollectionNew) {
                partidoCollectionNewPartidoToAttach = em.getReference(partidoCollectionNewPartidoToAttach.getClass(), partidoCollectionNewPartidoToAttach.getCod());
                attachedPartidoCollectionNew.add(partidoCollectionNewPartidoToAttach);
            }
            partidoCollectionNew = attachedPartidoCollectionNew;
            jornadas.setPartidoCollection(partidoCollectionNew);
            jornadas = em.merge(jornadas);
            if (ligaCodOld != null && !ligaCodOld.equals(ligaCodNew)) {
                ligaCodOld.getJornadasCollection().remove(jornadas);
                ligaCodOld = em.merge(ligaCodOld);
            }
            if (ligaCodNew != null && !ligaCodNew.equals(ligaCodOld)) {
                ligaCodNew.getJornadasCollection().add(jornadas);
                ligaCodNew = em.merge(ligaCodNew);
            }
            for (Partido partidoCollectionNewPartido : partidoCollectionNew) {
                if (!partidoCollectionOld.contains(partidoCollectionNewPartido)) {
                    Jornadas oldJornadasCodOfPartidoCollectionNewPartido = partidoCollectionNewPartido.getJornadasCod();
                    partidoCollectionNewPartido.setJornadasCod(jornadas);
                    partidoCollectionNewPartido = em.merge(partidoCollectionNewPartido);
                    if (oldJornadasCodOfPartidoCollectionNewPartido != null && !oldJornadasCodOfPartidoCollectionNewPartido.equals(jornadas)) {
                        oldJornadasCodOfPartidoCollectionNewPartido.getPartidoCollection().remove(partidoCollectionNewPartido);
                        oldJornadasCodOfPartidoCollectionNewPartido = em.merge(oldJornadasCodOfPartidoCollectionNewPartido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = jornadas.getCod();
                if (findJornadas(id) == null) {
                    throw new NonexistentEntityException("The jornadas with id " + id + " no longer exists.");
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
            Jornadas jornadas;
            try {
                jornadas = em.getReference(Jornadas.class, id);
                jornadas.getCod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jornadas with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Partido> partidoCollectionOrphanCheck = jornadas.getPartidoCollection();
            for (Partido partidoCollectionOrphanCheckPartido : partidoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Jornadas (" + jornadas + ") cannot be destroyed since the Partido " + partidoCollectionOrphanCheckPartido + " in its partidoCollection field has a non-nullable jornadasCod field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Liga ligaCod = jornadas.getLigaCod();
            if (ligaCod != null) {
                ligaCod.getJornadasCollection().remove(jornadas);
                ligaCod = em.merge(ligaCod);
            }
            em.remove(jornadas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Jornadas> findJornadasEntities() {
        return findJornadasEntities(true, -1, -1);
    }

    public List<Jornadas> findJornadasEntities(int maxResults, int firstResult) {
        return findJornadasEntities(false, maxResults, firstResult);
    }

    private List<Jornadas> findJornadasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jornadas.class));
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

    public Jornadas findJornadas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Jornadas.class, id);
        } finally {
            em.close();
        }
    }

    public int getJornadasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Jornadas> rt = cq.from(Jornadas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /**
     * Autoincrementa el codigo de la jornada
     * @return codigo
     */
    public String autoincrement(){
        try{
            String jpql="select max(cod) from jornadas";
            Query cons=this.getEntityManager().createNativeQuery(jpql);
            List lista = cons.getResultList();  
            String cod=lista.get(0).toString();
            cod=Integer.toString(Integer.parseInt(cod)+1);
            return cod;
        }catch(Exception e){
            return "1";
        }           
    }
        
}
