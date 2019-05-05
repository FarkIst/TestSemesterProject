import mappers.CourseMapper;
import mappers.LocationMapper;
import mappers.UserMapper;
import units.Course;
import units.TeachingStaff;
import units.User;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args){


        TeachingStaff ts = new TeachingStaff();
        Course course = new Course();
        ts.addEnrolledCourses(course);
        UserMapper.setUser(ts);




        System.out.println("Hello World");
    }
}
