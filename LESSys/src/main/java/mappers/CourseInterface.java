package mappers;

import units.Course;

public interface CourseInterface extends CRUDInterface<Course> {
    public void addStudentToCourse(int id, int studentId);
}
