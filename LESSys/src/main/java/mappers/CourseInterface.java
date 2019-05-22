package mappers;

import units.Course;
import units.Student;

public interface CourseInterface extends CRUDInterface<Course> {
    public Student addStudentToCourse(int id, int studentId);
}
