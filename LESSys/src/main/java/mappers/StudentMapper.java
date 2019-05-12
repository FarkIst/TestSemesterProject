package mappers;

import units.Course;
import units.Payment;
import units.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentMapper implements StudentInterface {
    private DataMapper dm;

    public StudentMapper(){
        this.dm = new DataMapper(DataVars.PU);
    }

    public StudentMapper(String PU){
        this.dm = new DataMapper(PU);
    }

    private EntityManager getEntityManager() {
        return dm.getEMF().createEntityManager();
    }

    public Course registerCourse(Student student, Course course) {
        return null;
    }

    public void leaveCourse(Student student, Course course) {

    }

    public Student makePayment(Student student, Course course, Payment payment) {
        return null;
    }

    public List<Student> returnAllEntities() {
        return null;
    }

    public Student createEntity(Student entity) {
        return null;
    }

    public Student readEntity(int id) {
        return null;
    }

    public Student editEntity(Student entity) {
        return null;
    }

    public void deleteEntity(int id) {

    }
}
