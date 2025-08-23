package src.basics.lesson1;

// No 'public' keyword → this top-level class is package-private (default access)
class InternalHelper {
    static void log(String msg) { // package-private method (no modifier)
        System.out.println("[LOG] " + msg);
    }
}
