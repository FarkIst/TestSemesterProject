package units;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

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

    }

}