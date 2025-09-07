public class Car {
    // private variables can not be accessed directly from outside the class Car
    private String color;
    private String model;
    private String brand;
    private int year;
    private int speed;

    // constructor to initialize the private variables
    public Car(String color, String model, int year, int speed, String brand) {
        this.color = color;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.speed = speed;
    }

    // getter method (to access private variables safely)
    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getSpeed() {
        return speed;
    }

    // setter method (to modify private variables safely)
    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        if (year > 1886) {
            this.year = year;
        } else {
            System.out.println("Invalid year");
        }
    }

    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        } else {
            System.out.println("❌ Speed cannot be negative.");
        }
    }

    public void displayCarDetails() {
        System.out.println("Color: " + color);
        System.out.println("Model: " + model);
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Speed: " + speed);
    }

  public void drive () {
    System.out.println("The car is driving at " + speed + " km/h.");
  }

}
