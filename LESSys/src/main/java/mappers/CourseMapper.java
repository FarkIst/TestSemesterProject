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

    public Course addStudenttoCourse(Course course, Student student) {
        return null;
    }
}
