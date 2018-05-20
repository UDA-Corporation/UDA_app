package Modelo.BD;

import Modelo.BD.exceptions.NonexistentEntityException;
import Modelo.BD.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.UML.Jornadas;
import Modelo.UML.Equipo;
import Modelo.UML.Partido;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version 1.0 
 */

public class PartidoJpaController implements Serializable {

    public PartidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Partido partido) throws PreexistingEntityException, Exception {
        if (partido.getEquipoCollection() == null) {
            partido.setEquipoCollection(new ArrayList<Equipo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jornadas jornadasCod = partido.getJornadasCod();
            if (jornadasCod != null) {
                jornadasCod = em.getReference(jornadasCod.getClass(), jornadasCod.getCod());
                partido.setJornadasCod(jornadasCod);
            }
            Collection<Equipo> attachedEquipoCollection = new ArrayList<Equipo>();
            for (Equipo equipoCollectionEquipoToAttach : partido.getEquipoCollection()) {
                equipoCollectionEquipoToAttach = em.getReference(equipoCollectionEquipoToAttach.getClass(), equipoCollectionEquipoToAttach.getCod());
                attachedEquipoCollection.add(equipoCollectionEquipoToAttach);
            }
            partido.setEquipoCollection(attachedEquipoCollection);
            em.persist(partido);
            if (jornadasCod != null) {
                jornadasCod.getPartidoCollection().add(partido);
                jornadasCod = em.merge(jornadasCod);
            }
            for (Equipo equipoCollectionEquipo : partido.getEquipoCollection()) {
                equipoCollectionEquipo.getPartidoCollection().add(partido);
                equipoCollectionEquipo = em.merge(equipoCollectionEquipo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPartido(partido.getCod()) != null) {
                throw new PreexistingEntityException("Partido " + partido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Partido partido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Partido persistentPartido = em.find(Partido.class, partido.getCod());
            Jornadas jornadasCodOld = persistentPartido.getJornadasCod();
            Jornadas jornadasCodNew = partido.getJornadasCod();
            Collection<Equipo> equipoCollectionOld = persistentPartido.getEquipoCollection();
            Collection<Equipo> equipoCollectionNew = partido.getEquipoCollection();
            if (jornadasCodNew != null) {
                jornadasCodNew = em.getReference(jornadasCodNew.getClass(), jornadasCodNew.getCod());
                partido.setJornadasCod(jornadasCodNew);
            }
            Collection<Equipo> attachedEquipoCollectionNew = new ArrayList<Equipo>();
            for (Equipo equipoCollectionNewEquipoToAttach : equipoCollectionNew) {
                equipoCollectionNewEquipoToAttach = em.getReference(equipoCollectionNewEquipoToAttach.getClass(), equipoCollectionNewEquipoToAttach.getCod());
                attachedEquipoCollectionNew.add(equipoCollectionNewEquipoToAttach);
            }
            equipoCollectionNew = attachedEquipoCollectionNew;
            partido.setEquipoCollection(equipoCollectionNew);
            partido = em.merge(partido);
            if (jornadasCodOld != null && !jornadasCodOld.equals(jornadasCodNew)) {
                jornadasCodOld.getPartidoCollection().remove(partido);
                jornadasCodOld = em.merge(jornadasCodOld);
            }
            if (jornadasCodNew != null && !jornadasCodNew.equals(jornadasCodOld)) {
                jornadasCodNew.getPartidoCollection().add(partido);
                jornadasCodNew = em.merge(jornadasCodNew);
            }
            for (Equipo equipoCollectionOldEquipo : equipoCollectionOld) {
                if (!equipoCollectionNew.contains(equipoCollectionOldEquipo)) {
                    equipoCollectionOldEquipo.getPartidoCollection().remove(partido);
                    equipoCollectionOldEquipo = em.merge(equipoCollectionOldEquipo);
                }
            }
            for (Equipo equipoCollectionNewEquipo : equipoCollectionNew) {
                if (!equipoCollectionOld.contains(equipoCollectionNewEquipo)) {
                    equipoCollectionNewEquipo.getPartidoCollection().add(partido);
                    equipoCollectionNewEquipo = em.merge(equipoCollectionNewEquipo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = partido.getCod();
                if (findPartido(id) == null) {
                    throw new NonexistentEntityException("The partido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Partido partido;
            try {
                partido = em.getReference(Partido.class, id);
                partido.getCod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The partido with id " + id + " no longer exists.", enfe);
            }
            Jornadas jornadasCod = partido.getJornadasCod();
            if (jornadasCod != null) {
                jornadasCod.getPartidoCollection().remove(partido);
                jornadasCod = em.merge(jornadasCod);
            }
            Collection<Equipo> equipoCollection = partido.getEquipoCollection();
            for (Equipo equipoCollectionEquipo : equipoCollection) {
                equipoCollectionEquipo.getPartidoCollection().remove(partido);
                equipoCollectionEquipo = em.merge(equipoCollectionEquipo);
            }
            em.remove(partido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Partido> findPartidoEntities() {
        return findPartidoEntities(true, -1, -1);
    }

    public List<Partido> findPartidoEntities(int maxResults, int firstResult) {
        return findPartidoEntities(false, maxResults, firstResult);
    }

    private List<Partido> findPartidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Partido.class));
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

    public Partido findPartido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Partido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPartidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Partido> rt = cq.from(Partido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /**
     * Autoincrementa el codigo del partido cogiendo el maximo + 1
     * @return codigo
     */
    public String autoincrement(){
        try{
            String jpql="select max(cod) from partido";
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
