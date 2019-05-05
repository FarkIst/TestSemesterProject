package mappers;

import units.Course;

import javax.persistence.EntityManager;

public abstract class CourseMapper {

    public static EntityManager getEntityManager() {
        return DataMapper.emf.createEntityManager();
    }

    public static void setCourse(Course course) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
    }

}
