import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        DifferentMethods differentMethods = new DifferentMethods();
        for (Method method : DifferentMethods.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Repeat.class) && (Modifier.isProtected(method.getModifiers()) || Modifier.isPrivate(method.getModifiers()))) {
                method.setAccessible(true);
                Repeat repeat = method.getAnnotation(Repeat.class);
                for (int i = 0; i < repeat.value(); i++) {
                    method.invoke(differentMethods, repeat.value());
                }
            }
        }
    }
}