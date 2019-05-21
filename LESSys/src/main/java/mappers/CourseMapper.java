package mappers;

import units.Course;
import units.Student;

public class CourseMapper extends GenericMapper<Course> implements CourseInterface{
    public CourseMapper() {
        super(Course.class);
    }

    public CourseMapper(String PU) {
        super(PU, Course.class);
    }

    public void addStudentToCourse(int id, int studentId) {
        Course course = this.em.find(Course.class, id);
        Student student = this.em.find(Student.class, studentId);
        student.addEnrolledCourse(course);
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }
}
