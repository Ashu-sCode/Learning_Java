public class Car {
        // private variables can not be accessed directly from outside the class Car
       private String color;
       private String model;
       private int year;

        // constructor to initialize the private variables
        public Car(String color, String model, int year) {
            this.color = color;
            this.model = model;
            this.year = year;
        }

        // getter method (to access private variables safely)
        public String getColor() {
            return color;
        }

        public String getModel() {
            return model;
        }

        public int getYear() {
            return year;
        }

        // setter method (to modify private variables safely)
        public void setColor(String color) {
            this.color = color;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setYear(int year) {
            if(year > 1886) {
                this.year = year;
            }else{
                System.out.println("Invalid year");
            }
        }

        public void displayCarDetails() {
            System.out.println("Color: " + color);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
        }


    }