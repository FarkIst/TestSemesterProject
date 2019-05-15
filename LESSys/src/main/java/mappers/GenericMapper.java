package mappers;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class GenericMapper< T extends Serializable> {
    private DataMapper dm;
    private Class< T > myClass;
    public GenericMapper(Class< T > myClass){
        this.dm = new DataMapper(DataVars.PU);
        this.myClass = myClass;
    }

    public GenericMapper(String PU, Class< T > myClass){
        this.dm = new DataMapper(PU);
        this.myClass = myClass;
    }

    private EntityManager getEntityManager() {
        return dm.getEMF().createEntityManager();
    }

    public List< T > returnAllEntities() {
        EntityManager em = getEntityManager();
        return em.createQuery( "from " + myClass.getName() )
                .getResultList();
    }

    public void createEntity(T entity) {
        EntityManager em = getEntityManager();
        em.persist( entity );
    }

    public T readEntity(int id) {
        EntityManager em = getEntityManager();
        return em.find( myClass, id );
    }

    public void editEntity(T entity) {
        EntityManager em = getEntityManager();
        em.merge(entity);
    }

    public void deleteEntity(int id) {
        EntityManager em = getEntityManager();
        T entity = readEntity(id);
        em.remove(entity);
    }
}
