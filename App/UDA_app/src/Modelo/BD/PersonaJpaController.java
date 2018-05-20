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
import Modelo.UML.Cuenta;
import Modelo.UML.Persona;
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

public class PersonaJpaController implements Serializable {

    public PersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persona persona) throws PreexistingEntityException, Exception {
        if (persona.getCuentaCollection() == null) {
            persona.setCuentaCollection(new ArrayList<Cuenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dueno dueno = persona.getDueno();
            if (dueno != null) {
                dueno = em.getReference(dueno.getClass(), dueno.getDni());
                persona.setDueno(dueno);
            }
            Collection<Cuenta> attachedCuentaCollection = new ArrayList<Cuenta>();
            for (Cuenta cuentaCollectionCuentaToAttach : persona.getCuentaCollection()) {
                cuentaCollectionCuentaToAttach = em.getReference(cuentaCollectionCuentaToAttach.getClass(), cuentaCollectionCuentaToAttach.getId());
                attachedCuentaCollection.add(cuentaCollectionCuentaToAttach);
            }
            persona.setCuentaCollection(attachedCuentaCollection);
            em.persist(persona);
            if (dueno != null) {
                Persona oldPersonaOfDueno = dueno.getPersona();
                if (oldPersonaOfDueno != null) {
                    oldPersonaOfDueno.setDueno(null);
                    oldPersonaOfDueno = em.merge(oldPersonaOfDueno);
                }
                dueno.setPersona(persona);
                dueno = em.merge(dueno);
            }
            for (Cuenta cuentaCollectionCuenta : persona.getCuentaCollection()) {
                Persona oldPersonaDniOfCuentaCollectionCuenta = cuentaCollectionCuenta.getPersonaDni();
                cuentaCollectionCuenta.setPersonaDni(persona);
                cuentaCollectionCuenta = em.merge(cuentaCollectionCuenta);
                if (oldPersonaDniOfCuentaCollectionCuenta != null) {
                    oldPersonaDniOfCuentaCollectionCuenta.getCuentaCollection().remove(cuentaCollectionCuenta);
                    oldPersonaDniOfCuentaCollectionCuenta = em.merge(oldPersonaDniOfCuentaCollectionCuenta);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPersona(persona.getDni()) != null) {
                throw new PreexistingEntityException("Persona " + persona + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persona persona) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persistentPersona = em.find(Persona.class, persona.getDni());
            Dueno duenoOld = persistentPersona.getDueno();
            Dueno duenoNew = persona.getDueno();
            Collection<Cuenta> cuentaCollectionOld = persistentPersona.getCuentaCollection();
            Collection<Cuenta> cuentaCollectionNew = persona.getCuentaCollection();
            List<String> illegalOrphanMessages = null;
            if (duenoOld != null && !duenoOld.equals(duenoNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Dueno " + duenoOld + " since its persona field is not nullable.");
            }
            for (Cuenta cuentaCollectionOldCuenta : cuentaCollectionOld) {
                if (!cuentaCollectionNew.contains(cuentaCollectionOldCuenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cuenta " + cuentaCollectionOldCuenta + " since its personaDni field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (duenoNew != null) {
                duenoNew = em.getReference(duenoNew.getClass(), duenoNew.getDni());
                persona.setDueno(duenoNew);
            }
            Collection<Cuenta> attachedCuentaCollectionNew = new ArrayList<Cuenta>();
            for (Cuenta cuentaCollectionNewCuentaToAttach : cuentaCollectionNew) {
                cuentaCollectionNewCuentaToAttach = em.getReference(cuentaCollectionNewCuentaToAttach.getClass(), cuentaCollectionNewCuentaToAttach.getId());
                attachedCuentaCollectionNew.add(cuentaCollectionNewCuentaToAttach);
            }
            cuentaCollectionNew = attachedCuentaCollectionNew;
            persona.setCuentaCollection(cuentaCollectionNew);
            persona = em.merge(persona);
            if (duenoNew != null && !duenoNew.equals(duenoOld)) {
                Persona oldPersonaOfDueno = duenoNew.getPersona();
                if (oldPersonaOfDueno != null) {
                    oldPersonaOfDueno.setDueno(null);
                    oldPersonaOfDueno = em.merge(oldPersonaOfDueno);
                }
                duenoNew.setPersona(persona);
                duenoNew = em.merge(duenoNew);
            }
            for (Cuenta cuentaCollectionNewCuenta : cuentaCollectionNew) {
                if (!cuentaCollectionOld.contains(cuentaCollectionNewCuenta)) {
                    Persona oldPersonaDniOfCuentaCollectionNewCuenta = cuentaCollectionNewCuenta.getPersonaDni();
                    cuentaCollectionNewCuenta.setPersonaDni(persona);
                    cuentaCollectionNewCuenta = em.merge(cuentaCollectionNewCuenta);
                    if (oldPersonaDniOfCuentaCollectionNewCuenta != null && !oldPersonaDniOfCuentaCollectionNewCuenta.equals(persona)) {
                        oldPersonaDniOfCuentaCollectionNewCuenta.getCuentaCollection().remove(cuentaCollectionNewCuenta);
                        oldPersonaDniOfCuentaCollectionNewCuenta = em.merge(oldPersonaDniOfCuentaCollectionNewCuenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = persona.getDni();
                if (findPersona(id) == null) {
                    throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
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
            Persona persona;
            try {
                persona = em.getReference(Persona.class, id);
                persona.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Dueno duenoOrphanCheck = persona.getDueno();
            if (duenoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Dueno " + duenoOrphanCheck + " in its dueno field has a non-nullable persona field.");
            }
            Collection<Cuenta> cuentaCollectionOrphanCheck = persona.getCuentaCollection();
            for (Cuenta cuentaCollectionOrphanCheckCuenta : cuentaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Cuenta " + cuentaCollectionOrphanCheckCuenta + " in its cuentaCollection field has a non-nullable personaDni field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> findPersonaEntities() {
        return findPersonaEntities(true, -1, -1);
    }

    public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
        return findPersonaEntities(false, maxResults, firstResult);
    }

    private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persona.class));
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

    public Persona findPersona(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persona> rt = cq.from(Persona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    /**
     * Busca la persona por tipo en la base de datos
     * @param tipo tipo de la persona
     * @return objeto persona
     */
    public List <Persona> findByTipo(String tipo){        
        Query consulta = this.getEntityManager().createNamedQuery(Persona.findTipo);
        consulta.setParameter("tipoPersona", tipo);
        List<Persona> lista = consulta.getResultList(); 
        return lista;
    }
}
