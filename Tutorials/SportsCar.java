public class SportsCar extends Car{

    private Boolean turbo;

   public SportsCar(String color, String model, int year, int speed, String brand, Boolean turbo) {
        super(color, model, year, speed, brand);
        this.turbo = turbo;
    }


    public void enableTurbo() {
      if (turbo == true) {
        System.out.println("Turbo is already enabled.");
           setSpeed(getSpeed() + 100);
    } else {
        turbo = true;
        setSpeed(getSpeed() + 100);
        System.out.println("Turbo has been enabled.");
      }
    }

    @Override
    public void drive() {
        System.out.println("The sports car is driving at " + getSpeed() + " km/h.");
    }

      public void drive(String driverName) {
        System.out.println(driverName + " is driving the SportsCar at " + getSpeed() + " km/h. 🏎️");
    }
}
