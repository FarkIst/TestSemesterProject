package mappers;

import units.Course;
import units.User;

import java.util.List;

public interface TeacherStaffInterface extends StaffInterface{
    public boolean isExperienced();
    public Course signUpCourse();
    public List<Course> getEnrolledCourses();
    public Course removeEntrolledCourses();
    public Course addEnrolledCourses();
    public List<Course> setEnrolledCourse();
    public List<Course> getCourseHistory();
    public List<User> getEnrolledStudents(Course course);
}
