package mappers;

import units.Location;
import units.User;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class UserMapper {

    private static EntityManager getEntityManager() {
        return DataMapper.emf.createEntityManager();
    }

    public static void setUser(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
}
