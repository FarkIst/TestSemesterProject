package mappers;

import units.Course;
import units.Payment;
import units.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentMapper extends GenericMapper<Student> implements StudentInterface {
    public StudentMapper(){
        super(Student.class);
    }

    public StudentMapper(String PU){
        super(Student.class);
    }

    public Course registerCourse(Student student, Course course) {
        return null;
    }

    public void leaveCourse(Student student, Course course) {

    }

    public Student makePayment(Student student, Course course, Payment payment) {
        return null;
    }
}
