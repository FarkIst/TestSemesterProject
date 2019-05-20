import mappers.TeacherStaffMapper;
import units.Course;
import units.TeachingStaff;

public class Runner {

    public static void main(String[] args){
        TeachingStaff ts = new TeachingStaff();
        Course course = new Course();

        ts.addEnrolledCourses(course);
        TeacherStaffMapper um = new TeacherStaffMapper();
        um.createEntity(ts);

        System.out.println("Hello World");
    }
}
