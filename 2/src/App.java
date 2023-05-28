import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Methods methodsObject = new Methods();
        Class<? extends Methods> methodsClass = methodsObject.getClass();
        for (Method method : methodsClass.getDeclaredMethods()) {
            int modifier = method.getModifiers();
            if ((Modifier.isPrivate(modifier) || Modifier.isProtected(modifier))
                    && method.isAnnotationPresent(Annotation.class)) {
                method.setAccessible(true);
                Annotation annotation = method.getAnnotation(Annotation.class);
                Parameter[] parameters = method.getParameters();
                List<Object> arguments = new ArrayList<>();
                for (int i = 0; i < parameters.length; i++) {
                    arguments.add(i, 1);
                }
                for (int i = 0; i < annotation.val(); i++) {
                    method.invoke(methodsObject, arguments.toArray());
                }
                System.out.println();
            }
        }
    }
}
