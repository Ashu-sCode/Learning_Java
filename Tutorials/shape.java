abstract class shape {
    String color;

    // abstract method
    abstract void draw();

    // concrete method
    void setColor(String color) {
        this.color = color;
        System.out.println("Color set to " + color);
    }
}

class Circle extends shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}