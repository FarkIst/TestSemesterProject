package units;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CourseTest {
    @Test
    public void classType(){
        List<Class> annotList = new ArrayList<Class>();
        annotList.add(Entity.class);
        annotList.add(Table.class);
        annotList.add(Inheritance.class);
        AssertHelper.assertAnnotations(Arrays.asList(Course.class.getAnnotations()), annotList);
    }

    @Test
    public void fieldAnnotations() {
        AssertHelper.assertField(Course.class, "id", Id.class, GeneratedValue.class);
        AssertHelper.assertField(Course.class, "name");
        AssertHelper.assertField(Course.class, "teachingHours");
        AssertHelper.assertField(Course.class, "subject", ManyToOne.class, JoinColumn.class);
        AssertHelper.assertField(Course.class, "teacher", ManyToOne.class, JoinColumn.class);
        AssertHelper.assertField(Course.class, "enrolledStudents", ManyToMany.class);
        AssertHelper.assertField(Course.class, "courseSchedules", OneToMany.class);
        AssertHelper.assertField(Course.class, "semesterCourses", ManyToMany.class, JoinTable.class);
        AssertHelper.assertField(Course.class, "coursePayments", OneToMany.class);
    }

    @Test
    public void methodAnnotations() {
        AssertHelper.assertGetterMethod(Course.class, "getId");
        AssertHelper.assertGetterMethod(Course.class, "getName");
        AssertHelper.assertGetterMethod(Course.class, "getTeachingHours");
        AssertHelper.assertGetterMethod(Course.class, "getSubject");
        AssertHelper.assertGetterMethod(Course.class, "getTeacher");
        AssertHelper.assertGetterMethod(Course.class, "getEnrolledStudents");
        AssertHelper.assertGetterMethod(Course.class, "getCourseSchedules");
        AssertHelper.assertGetterMethod(Course.class, "getSemesterCourses");
        AssertHelper.assertGetterMethod(Course.class, "getCoursePayments");
        AssertHelper.assertMethod(Course.class, "setId", int.class);
        AssertHelper.assertMethod(Course.class, "setName", String.class);
        AssertHelper.assertMethod(Course.class, "setSubject", Subject.class);
        AssertHelper.assertMethod(Course.class, "setTeacher", TeachingStaff.class);
        AssertHelper.assertGetterMethod(Course.class, "isOver20TeachingHours");
    }

    @Test
    public void isOver20TeachingHoursFunctionality() {
        Course course = new Course();
        Assert.assertEquals(course.isOver20TeachingHours(), false);

        course.setTeachingHours(22);
        Assert.assertEquals(course.isOver20TeachingHours(), true);

        course.setTeachingHours(19);
        Assert.assertEquals(course.isOver20TeachingHours(), false);

        course.setTeachingHours(20);
        Assert.assertEquals(course.isOver20TeachingHours(), true);
    }

    @Test
    public void id() {
        GeneratedValue val;
        try {
            Field field = Course.class.getDeclaredField("id");
            val = field.getAnnotation(GeneratedValue.class);
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }

        Assert.assertEquals(GenerationType.AUTO, val.strategy());
    }

}