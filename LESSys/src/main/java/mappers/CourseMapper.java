package mappers;

import org.hibernate.JDBCException;
import units.Course;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseMapper implements CRUDInterface<Course> {
    private DataMapper dm;

    public CourseMapper(){
        this.dm = new DataMapper(DataVars.PU);
    }

    public CourseMapper(String PU){
        this.dm = new DataMapper(PU);
    }

    private EntityManager getEntityManager() {
        return dm.getEMF().createEntityManager();
    }

    public List<Course> returnAllEntities() {
        return null;
    }

    public Course createEntity(Course entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    public Course readEntity(int id) {
        EntityManager em = getEntityManager();
        Course course = em.find(Course.class, id);
        em.detach(course);
        em.close();
        return course;
    }

    public Course editEntity(Course entity) {
        EntityManager em = getEntityManager();
        Course course = em.merge(entity);
        em.close();
        return course;
    }

    public void deleteEntity(int id) {
        EntityManager em = getEntityManager();
        Course course = em.find(Course.class, id);
        em.remove(course);
        em.close();
    }
}
