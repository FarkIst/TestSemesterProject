package units;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.*;

public class UserTest {
    @Test
    public void classType(){
        List<Class> annotList = new ArrayList<Class>();
        annotList.add(Entity.class);
        annotList.add(Table.class);
        annotList.add(Inheritance.class);
        annotList.add(DiscriminatorColumn.class);
        AssertHelper.assertAnnotations(Arrays.asList(User.class.getAnnotations()), annotList);
    }

    @Test
    public void fieldAnnotations() {
         AssertHelper.assertField(User.class, "id", Id.class, GeneratedValue.class);
         AssertHelper.assertField(User.class, "name");
         AssertHelper.assertField(User.class, "birthDate", Temporal.class);
    }

    @Test
    public void methodAnnotations() {
        AssertHelper.assertGetterMethod(User.class, "getId");
        AssertHelper.assertGetterMethod(User.class, "getName");
        AssertHelper.assertGetterMethod(User.class, "getBirthDate");
        AssertHelper.assertMethod(User.class, "setBirthDate", Calendar.class);
        AssertHelper.assertMethod(User.class, "setId", int.class);
        AssertHelper.assertMethod(User.class, "setName", String.class);
    }

    @Test
    public void id() {
        GeneratedValue val;
        try {
            Field field = User.class.getDeclaredField("id");
            val = field.getAnnotation(GeneratedValue.class);
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }

        Assert.assertEquals(GenerationType.AUTO, val.strategy());
    }

}