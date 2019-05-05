package mappers;

import units.Location;

import javax.persistence.EntityManager;

public abstract class LocationMapper {

    public static EntityManager getEntityManager() {
        return DataMapper.emf.createEntityManager();
    }

    public static void setLocation(Location location) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(location);
        em.getTransaction().commit();
    }
}
