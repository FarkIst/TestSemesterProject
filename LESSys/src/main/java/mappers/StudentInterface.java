package mappers;

import units.Course;
import units.Student;

public interface StudentInterface {
    public Course registerCourse(int id, int courseId);
    public void leaveCourse(int id, int courseId);
    public Student makePayment(int id, int courseId, double paymentId);
}
