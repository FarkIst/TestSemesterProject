package units;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.*;

public class SubjectTest {
    @Test
    public void classType(){
        List<Class> annotList = new ArrayList<Class>();
        annotList.add(Entity.class);
        annotList.add(Table.class);
        annotList.add(Inheritance.class);
        System.out.println(Subject.class.getAnnotations().length);
        AssertHelper.assertAnnotations(Arrays.asList(Subject.class.getAnnotations()), annotList);
    }

    @Test
    public void fieldAnnotations() {
        AssertHelper.assertField(Subject.class, "id", Id.class, GeneratedValue.class);
        AssertHelper.assertField(Subject.class, "name");
        AssertHelper.assertField(Subject.class, "courses", OneToMany.class);
    }

    @Test
    public void methodAnnotations() {
        AssertHelper.assertGetterMethod(Subject.class, "getId");
        AssertHelper.assertGetterMethod(Subject.class, "getName");
        AssertHelper.assertGetterMethod(Subject.class, "getCourses");
        AssertHelper.assertGetterMethod(Subject.class, "hasRun3ConsecutiveYears");
        AssertHelper.assertMethod(Subject.class, "setName", String.class);
        AssertHelper.assertMethod(Subject.class, "setId", int.class);
        AssertHelper.assertMethod(Subject.class, "addCourse", Course.class);
        AssertHelper.assertMethod(Subject.class, "removeCourse", Course.class);
    }

    @Test
    public void id() {
        GeneratedValue val;
        try {
            Field field = Subject.class.getDeclaredField("id");
            val = field.getAnnotation(GeneratedValue.class);
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }

        Assert.assertEquals(GenerationType.AUTO, val.strategy());
    }

    @Test
    public void hasRun3ConsecutiveYears() {
        Subject subject = new Subject();
        Course course = new Course();

        subject.addCourse(course);

        Date today = new Date();
        Calendar todaysCalender = Calendar.getInstance();
        todaysCalender.setTime(today);
        int currYear = todaysCalender.get(Calendar.YEAR);
        String scen = "";
        if (todaysCalender.get(Calendar.MONTH) >= 4){
            scen = "a";
        } else {
            scen = "b";
            currYear --;
        }

        Set<Semester> set = new HashSet<Semester>();

        for (int i = 0; i<6; i++){
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            if (scen.equals("b")){
                from.set(currYear, 8, 1);
                to.set(currYear, 11, 21);
                scen = "a";
            } else {
                from.set(currYear, 0, 1);
                to.set(currYear, 4, 1);
                currYear --;
                scen = "b";
            }
            Semester semester = new Semester(from, to);
            set.add(semester);
        }
        course.setSemesterCourses(set);

        Assert.assertEquals(subject.hasRun3ConsecutiveYears(), true);
    }

    @Test
    public void hasRun3ConsecutiveYearsFalse() {
        Subject subject = new Subject();
        Course course = new Course();

        subject.addCourse(course);

        Date today = new Date();
        Calendar todaysCalender = Calendar.getInstance();
        todaysCalender.setTime(today);
        int currYear = todaysCalender.get(Calendar.YEAR);
        String scen = "";
        if (todaysCalender.get(Calendar.MONTH) >= 4){
            scen = "a";
        } else {
            scen = "b";
            currYear --;
        }

        Set<Semester> set = new HashSet<Semester>();

        for (int i = 0; i<5; i++){
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            if (scen.equals("b")){
                from.set(currYear, 8, 1);
                to.set(currYear, 11, 21);
                scen = "a";
            } else {
                from.set(currYear, 0, 1);
                to.set(currYear, 4, 1);
                currYear --;
                scen = "b";
            }
            Semester semester = new Semester(from, to);
            set.add(semester);
        }
        course.setSemesterCourses(set);

        Assert.assertEquals(subject.hasRun3ConsecutiveYears(), false);
    }

}