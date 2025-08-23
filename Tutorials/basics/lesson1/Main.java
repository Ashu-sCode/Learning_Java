package basics.lesson1;
public class Main {
    public static void main(String[] args) {
        User u = new User("Ashutosh");
        System.out.println(u.getName());

        // InternalHelper is accessible here because it's in the same (default) package
        InternalHelper.log("Hello from Main");
    }
}
