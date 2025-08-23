package basics.lesson1;
public class User {
    private final String name; // private + final (immutable field)

    public User(String name) {
        this.name = name;
    }

    public String getName() { // public method to access private data
        return name;
    }
}
