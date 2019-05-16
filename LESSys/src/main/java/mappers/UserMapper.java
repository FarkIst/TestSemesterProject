package mappers;

import units.User;

import javax.persistence.EntityManager;
import java.util.Arrays;
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
        User user1 = new User(1);
        user1.setName("George");
        User user2 = new User(2);
        user1.setName("Daniel");
        return Arrays.asList(user1, user2);
    }

    public User createEntity(User entity) {
        EntityManager em = getEntityManager();
        User newUser = new User();
        em.getTransaction().begin();
        newUser = em.merge(entity);
        em.getTransaction().commit();
        em.close();
        return newUser;
    }

    public User readEntity(int id) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public User editEntity(User entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        entity = em.merge(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    public void deleteEntity(int id) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }
}
