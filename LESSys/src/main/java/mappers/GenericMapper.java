package mappers;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public abstract class GenericMapper< T extends Serializable> implements CRUDInterface<T>{
    private Class< T > myClass;
    private DataMapper dm;
    protected EntityManager em;

    public GenericMapper(Class< T > myClass){
        this.dm = new DataMapper(DataVars.PU);
        this.em = getEntityManager();
        this.myClass = myClass;
    }

    public GenericMapper(String PU, Class< T > myClass){
        this.dm = new DataMapper(PU);
        this.em = getEntityManager();
        this.myClass = myClass;
    }

    private EntityManager getEntityManager() {
        return dm.getEMF().createEntityManager();
    }

    public Collection<T> returnAllEntities() {
        Query query = em.createQuery("from " + myClass.getName() + " u");
        return (Collection<T>) query.getResultList();
    }

    public T createEntity(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    public T readEntity(int id) {
        return this.em.find( myClass, id );
    }

    public T editEntity(T entity) {
        em.getTransaction().begin();
        entity = em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    public void deleteEntity(int id) {
        T entity = readEntity(id);
        em.getTransaction().begin();
        this.em.remove(entity);
        em.getTransaction().commit();
    }
}
