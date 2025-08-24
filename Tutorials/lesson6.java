public class lesson6 {

    public static void main(String[] args) {

        SportsCar ferrari = new SportsCar("Red", "F8 Tributo", 2023, 200, "Ferrari", false);

        System.out.println("Initial speed: " + ferrari.getSpeed());

        ferrari.enableTurbo(); // Turbo has been enabled. Speed boosted!
        System.out.println("Speed after turbo: " + ferrari.getSpeed());

        ferrari.enableTurbo(); // Turbo is already enabled. Increasing speed by 100.
        System.out.println("Speed after second turbo: " + ferrari.getSpeed());

        ferrari.enableTurbo(); // Turbo is already enabled. Increasing speed by 100.
        System.out.println("Speed after Third turbo: " + ferrari.getSpeed());


           System.out.printf(
                "┌───────────────────────────┐\n" +
                "│           Car             │   ← Parent Class\n" +
                "├───────────────────────────┤\n" +
                "│ - color : String          │\n" +
                "│ - model : String          │\n" +
                "│ - year : int              │\n" +
                "│ - speed : int             │\n" +
                "│ - brand : String          │\n" +
                "├───────────────────────────┤\n" +
                "│ + startEngine()           │\n" +
                "│ + accelerate()            │\n" +
                "│ + brake()                 │\n" +
                "│ + getSpeed() : int        │\n" +
                "│ + setSpeed(int)           │\n" +
                "│ ... (other getters/setters)│\n" +
                "└───────────────────────────┘\n" +
                "             ▲\n" +
                "             │ extends\n" +
                "             │\n" +
                "┌───────────────────────────┐\n" +
                "│        SportsCar          │   ← Child Class\n" +
                "├───────────────────────────┤\n" +
                "│ - turbo : Boolean         │\n" +
                "├───────────────────────────┤\n" +
                "│ + enableTurbo()           │\n" +
                "└───────────────────────────┘\n"
        );

    System.out.printf(
            "Explanation:\n" +
            "1. The 'Car' class is the Parent class (Base Class).\n" +
            "   - Attributes (with '-' sign → private): color, model, year, speed, brand.\n" +
            "   - Methods (with '+' sign → public): startEngine(), accelerate(), brake(), getSpeed(), setSpeed(), etc.\n" +
            "2. The 'SportsCar' class is the Child class (Derived Class).\n" +
            "   - Inherits all attributes & methods of Car.\n" +
            "   - Has an extra attribute: turbo (boolean).\n" +
            "   - Has an extra method: enableTurbo().\n" +
            "3. Relationship: 'SportsCar' extends 'Car' (Inheritance).\n" +
            "   → SportsCar gets all features of Car, plus some additional specialized ones.\n"
        );

    }

}