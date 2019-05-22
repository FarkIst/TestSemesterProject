package mappers;

import units.Course;
import units.Payment;
import units.Student;

import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.List;

public class StudentMapper extends GenericMapper<Student> implements StudentInterface {
    public StudentMapper() {
        super(Student.class);
    }

    public StudentMapper(String PU) {
        super(Student.class);
    }

    public Course registerCourse(int id, int courseId) {
        Student student = this.em.find(Student.class, id);
        Course course = this.em.find(Course.class, courseId);
        student.addEnrolledCourse(course);
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        return course;
    }

    public void leaveCourse(int id, int courseId) {
        Student student = this.em.find(Student.class, id);
        Course course = this.em.find(Course.class, courseId);
        student.removeEnrolledCourse(course);
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    public Student makePayment(int id, int courseId, double paymentId) {
        Student student = this.em.find(Student.class, id);
        Course course = this.em.find(Course.class, courseId);
        Payment payment = new Payment(student, course, paymentId, Calendar.getInstance());
        student.addCoursePayment(payment);
        em.getTransaction().begin();
        em.persist(payment);
        em.merge(student);
        em.getTransaction().commit();
        return student;
    }
}

