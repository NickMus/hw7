import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestTest {
    public static void main(String[] args) {

        start(MyTest.class);
    }

    static void start(Class className) {
        List<Method> methodList = new ArrayList<>();
        Method[] m = className.getDeclaredMethods();

        for (Method method : m) {
            if (method.isAnnotationPresent(Test.class)) {
                methodList.add(method);
            }
        }

        methodList.sort(Comparator.comparingInt((Method i) -> i.getAnnotation(Test.class).value()).reversed());

        for (Method method : m) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (methodList.size() > 0 && methodList.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException();
                }
                methodList.add(0, method);
            }

        }

        for (Method method : m) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (methodList.get(methodList.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException();
                }
                methodList.add(method);
            }
        }





        for (Method method : m) {
            try {
                method.invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
