public class lesson8 {

    public static void main(String[] args) {
        shape s1 = new Circle(); // Upcasting
        shape s2 = new Rectangle();

        s1.setColor("Red");
        s1.draw();

        s2.setColor("Blue");
        s2.draw();

        System.out.printf("\nExplanation:\n"
                + "1. The 'Shape' class is ABSTRACT (cannot be instantiated).\n"
                + "   - It has an abstract method: draw().\n"
                + "   - It has a concrete method: setColor().\n"
                + "2. The 'Circle' and 'Rectangle' classes extend 'Shape'.\n"
                + "   - They MUST provide implementation for draw().\n"
                + "3. Abstraction helps to focus on WHAT to do, not HOW to do.\n");

    }

}
