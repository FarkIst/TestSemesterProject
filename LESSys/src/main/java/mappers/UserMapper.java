package mappers;

import units.Location;
import units.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserMapper implements CRUDInterface<User>{
    private DataMapper dm;

    public UserMapper(){
        this.dm = new DataMapper(DataVars.PU);
    }

    public UserMapper(String PU){
        this.dm = new DataMapper(PU);
    }

    private EntityManager getEntityManager() {
        return dm.getEMF().createEntityManager();
    }

    public List<User> returnAllEntities() {
        return null;
    }

    public User createEntity(User entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    public User readEntity(int id) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        em.detach(user);
        em.close();
        return user;
    }

    public User editEntity(User entity) {
        EntityManager em = getEntityManager();
        User user = em.merge(entity);
        em.close();
        return user;
    }

    public void deleteEntity(int id) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        em.remove(user);
        em.close();
    }
}
