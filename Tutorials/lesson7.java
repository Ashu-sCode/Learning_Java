public class lesson7 {

    public static void main(String[] args) {

        Car car = new Car("Red", "Toyota", 2022, 100, "Honda");

        car.drive();

        System.out.println("--------------------");

        // Child Class Object's car

        SportsCar ferrari = new SportsCar("Red", "F8 Tributo", 2023, 200, "Ferrari", false);

        ferrari.drive(); // Calls Overriden sportsCar drive()
        ferrari.drive("Ashutosh");// calls overLoaded drive(String driverName)
        ferrari.enableTurbo();
        ferrari.drive("Ashutosh");

        System.out.println("--------------------");

        Car ref = new SportsCar("Blue", "F8 Tributo", 2024, 250, "Ferrari", true);// Upcasting

        ref.drive();
     
            System.out.printf(
            "Explanation:\n" +
            "1. Polymorphism means 'many forms'.\n" +
            "2. Compile-time Polymorphism → Method Overloading.\n" +
            "   - Example: accelerate() & accelerate(int speed) in Car.\n" +
            "3. Runtime Polymorphism → Method Overriding.\n" +
            "   - Example: SportsCar overrides startEngine().\n" +
            "4. Parent reference holding Child object: Car myCar = new SportsCar();\n" +
            "   - At runtime, JVM decides which method to call.\n"
        );

    }

}