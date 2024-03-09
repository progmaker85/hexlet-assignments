package exercise.daytime;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    // BEGIN
    public void init() {
        System.out.println("Night been created");
    }
    // END
}
