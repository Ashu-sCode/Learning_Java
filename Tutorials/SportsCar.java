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
        System.out.println("Turbo has been enabled.");
      }
    }

}
