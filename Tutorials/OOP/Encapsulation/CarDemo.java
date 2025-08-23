package OOP.Encapsulation;
import java.util.*;

class Car {
    private char model;
    private int year;
    private int price;
    private String color;

    public void setModel(char model) { this.model = model; }
    public void setYear(int year) { this.year = year; }
    public void setPrice(int price) { this.price = price; }
    public void setColor(String color) { this.color = color; }

    public void carInfo() {
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
        System.out.println("Color: " + color);
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car car1 = new Car();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the model: ");
        char model = sc.next().charAt(0);

        System.out.print("Enter the year: ");
        int year = sc.nextInt();

        System.out.print("Enter the price: ");
        int price = sc.nextInt();

        sc.nextLine(); // consume leftover newline
        System.out.print("Enter the color: ");
        String color = sc.nextLine();

        car1.setModel(model);
        car1.setYear(year);
        car1.setPrice(price);
        car1.setColor(color);

        System.out.println("\nCar Details:");
        car1.carInfo();
    }
}
