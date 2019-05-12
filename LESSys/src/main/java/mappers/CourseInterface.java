package mappers;

import units.Course;
import units.Room;
import units.Student;

public interface CourseInterface extends CRUDInterface<Course> {
    public Course addStudenttoCourse(Course course, Student student);
}
