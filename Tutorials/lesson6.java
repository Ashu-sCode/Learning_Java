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

    }

}