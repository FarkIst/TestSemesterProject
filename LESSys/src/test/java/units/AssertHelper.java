package units;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class AssertHelper {

    public static void assertAnnotations(List<Annotation> classAnnotations, List<Class> annotations){
        if (classAnnotations.size() != annotations.size()) {
            throw new AssertionError("Assertion Mismatch");
        }
        for (Annotation a: classAnnotations){
            if (!annotations.contains(a.annotationType())){
                throw new AssertionError(a.annotationType() + " assertion not found");
            }
        }
    }

    public static void assertField(Class<?> a, String field, Class... annotations) {
        try {
            Field myField = a.getDeclaredField(field);
            assertAnnotations(Arrays.asList(myField.getAnnotations()), Arrays.asList(annotations));
        } catch(NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    public static void assertGetterMethod(Class<?> a, String method, Class... annotations) {
        try {
            Method methodClass = a.getDeclaredMethod(method);
            assertAnnotations(Arrays.asList(methodClass.getAnnotations()), Arrays.asList(annotations));
        } catch(NoSuchMethodException e){
            throw new AssertionError(e);
        }
    }

    public static void assertMethod(Class<?> a, String method, Class<?> type, Class... annotations) {
        try {
            Method methodClass = a.getDeclaredMethod(method, type);
            assertAnnotations(Arrays.asList(methodClass.getAnnotations()), Arrays.asList(annotations));
        } catch(NoSuchMethodException e){
            throw new AssertionError(e);
        }
    }
}
