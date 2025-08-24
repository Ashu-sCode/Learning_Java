
public class lesson5 {

    public static void main(String[] args) {

        System.out.println("=== Encapsulation Example ===");

        // Creating an object of class Car
        Car car = new Car("Red", "Toyota", 2022);

        System.out.println("--- Original Car Info ---");

        car.displayCarDetails();

        // Acessing variables from outside the class Car
        // car.color = "Blue"; // this will give error because color is private
        // car.model = "Honda"; // this will give error because model is private
        // car.year = 2021; // this will give error because year is private

        // Use Getters to access private variables safely

        System.out.println("\n--- Original Car Info using Getters ---");

        System.out.println("Color: " + car.getColor());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());

        // Use Setters to modify private variables safely
        car.setColor("Red");
        car.setModel("Suzuki");
        car.setYear(2022);

        System.out.println("\n--- Updated Car Info ---");
        car.displayCarDetails();

    }

}
