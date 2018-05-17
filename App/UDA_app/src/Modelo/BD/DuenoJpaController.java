package Modelo.BD;

import Modelo.BD.exceptions.IllegalOrphanException;
import Modelo.BD.exceptions.NonexistentEntityException;
import Modelo.BD.exceptions.PreexistingEntityException;
import Modelo.UML.Dueno;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.UML.Persona;
import Modelo.UML.Equipo;
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

public class DuenoJpaController implements Serializable {

    public DuenoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dueno dueno) throws IllegalOrphanException, PreexistingEntityException, Exception {
        if (dueno.getEquipoCollection() == null) {
            dueno.setEquipoCollection(new ArrayList<Equipo>());
        }
        List<String> illegalOrphanMessages = null;
        Persona personaOrphanCheck = dueno.getPersona();
        if (personaOrphanCheck != null) {
            Dueno oldDuenoOfPersona = personaOrphanCheck.getDueno();
            if (oldDuenoOfPersona != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Persona " + personaOrphanCheck + " already has an item of type Dueno whose persona column cannot be null. Please make another selection for the persona field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persona = dueno.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getDni());
                dueno.setPersona(persona);
            }
            Collection<Equipo> attachedEquipoCollection = new ArrayList<Equipo>();
            for (Equipo equipoCollectionEquipoToAttach : dueno.getEquipoCollection()) {
                equipoCollectionEquipoToAttach = em.getReference(equipoCollectionEquipoToAttach.getClass(), equipoCollectionEquipoToAttach.getCod());
                attachedEquipoCollection.add(equipoCollectionEquipoToAttach);
            }
            dueno.setEquipoCollection(attachedEquipoCollection);
            em.persist(dueno);
            if (persona != null) {
                persona.setDueno(dueno);
                persona = em.merge(persona);
            }
            for (Equipo equipoCollectionEquipo : dueno.getEquipoCollection()) {
                Dueno oldDuenoDniOfEquipoCollectionEquipo = equipoCollectionEquipo.getDuenoDni();
                equipoCollectionEquipo.setDuenoDni(dueno);
                equipoCollectionEquipo = em.merge(equipoCollectionEquipo);
                if (oldDuenoDniOfEquipoCollectionEquipo != null) {
                    oldDuenoDniOfEquipoCollectionEquipo.getEquipoCollection().remove(equipoCollectionEquipo);
                    oldDuenoDniOfEquipoCollectionEquipo = em.merge(oldDuenoDniOfEquipoCollectionEquipo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDueno(dueno.getDni()) != null) {
                throw new PreexistingEntityException("Dueno " + dueno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dueno dueno) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dueno persistentDueno = em.find(Dueno.class, dueno.getDni());
            Persona personaOld = persistentDueno.getPersona();
            Persona personaNew = dueno.getPersona();
            Collection<Equipo> equipoCollectionOld = persistentDueno.getEquipoCollection();
            Collection<Equipo> equipoCollectionNew = dueno.getEquipoCollection();
            List<String> illegalOrphanMessages = null;
            if (personaNew != null && !personaNew.equals(personaOld)) {
                Dueno oldDuenoOfPersona = personaNew.getDueno();
                if (oldDuenoOfPersona != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Persona " + personaNew + " already has an item of type Dueno whose persona column cannot be null. Please make another selection for the persona field.");
                }
            }
            for (Equipo equipoCollectionOldEquipo : equipoCollectionOld) {
                if (!equipoCollectionNew.contains(equipoCollectionOldEquipo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Equipo " + equipoCollectionOldEquipo + " since its duenoDni field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getDni());
                dueno.setPersona(personaNew);
            }
            Collection<Equipo> attachedEquipoCollectionNew = new ArrayList<Equipo>();
            for (Equipo equipoCollectionNewEquipoToAttach : equipoCollectionNew) {
                equipoCollectionNewEquipoToAttach = em.getReference(equipoCollectionNewEquipoToAttach.getClass(), equipoCollectionNewEquipoToAttach.getCod());
                attachedEquipoCollectionNew.add(equipoCollectionNewEquipoToAttach);
            }
            equipoCollectionNew = attachedEquipoCollectionNew;
            dueno.setEquipoCollection(equipoCollectionNew);
            dueno = em.merge(dueno);
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.setDueno(null);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.setDueno(dueno);
                personaNew = em.merge(personaNew);
            }
            for (Equipo equipoCollectionNewEquipo : equipoCollectionNew) {
                if (!equipoCollectionOld.contains(equipoCollectionNewEquipo)) {
                    Dueno oldDuenoDniOfEquipoCollectionNewEquipo = equipoCollectionNewEquipo.getDuenoDni();
                    equipoCollectionNewEquipo.setDuenoDni(dueno);
                    equipoCollectionNewEquipo = em.merge(equipoCollectionNewEquipo);
                    if (oldDuenoDniOfEquipoCollectionNewEquipo != null && !oldDuenoDniOfEquipoCollectionNewEquipo.equals(dueno)) {
                        oldDuenoDniOfEquipoCollectionNewEquipo.getEquipoCollection().remove(equipoCollectionNewEquipo);
                        oldDuenoDniOfEquipoCollectionNewEquipo = em.merge(oldDuenoDniOfEquipoCollectionNewEquipo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = dueno.getDni();
                if (findDueno(id) == null) {
                    throw new NonexistentEntityException("The dueno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dueno dueno;
            try {
                dueno = em.getReference(Dueno.class, id);
                dueno.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dueno with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Equipo> equipoCollectionOrphanCheck = dueno.getEquipoCollection();
            for (Equipo equipoCollectionOrphanCheckEquipo : equipoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dueno (" + dueno + ") cannot be destroyed since the Equipo " + equipoCollectionOrphanCheckEquipo + " in its equipoCollection field has a non-nullable duenoDni field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Persona persona = dueno.getPersona();
            if (persona != null) {
                persona.setDueno(null);
                persona = em.merge(persona);
            }
            em.remove(dueno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dueno> findDuenoEntities() {
        return findDuenoEntities(true, -1, -1);
    }

    public List<Dueno> findDuenoEntities(int maxResults, int firstResult) {
        return findDuenoEntities(false, maxResults, firstResult);
    }

    private List<Dueno> findDuenoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dueno.class));
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

    public Dueno findDueno(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dueno.class, id);
        } finally {
            em.close();
        }
    }

    public int getDuenoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dueno> rt = cq.from(Dueno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
