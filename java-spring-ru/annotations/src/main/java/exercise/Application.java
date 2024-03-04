package exercise;

import exercise.annotation.Inspect;
import exercise.model.Address;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (var method : Address.class.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(Inspect.class)) {
                continue;
            }
            System.out.println("Method " + method.getName() + " returns a value of type " + method.getReturnType().getSimpleName());
        }
        // END
    }
}
