public class lesson4 {
    public static void main (String[] args) {
        // OOP in Java

        // What is OOP?
        // Object-Oriented Programming (OOP) is a programming paradigm that uses objects and their interactions to design software and software applications.

        // What is a class?
        // A class is a blueprint or template for creating objects. It defines the properties (fields) and behaviors (methods) that objects of that class will have.

        // What is an object?
        // An object is an instance of a class. It is a real-world entity that has attributes (fields) and behaviors (methods).


        // Class with instance variables and instance methods
        class Person{
            String name;
            int age;

            // Constructor
            Person(){
                name = "Unknown";
                age = 0;
            }

            void sayHello(){
                System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
            }


        }

        // Creating objects
        Person person1 = new Person();
        Person person2 = new Person();

        // Accessing instance variables
        person1.name = "John";
        person1.age = 25;

        // Accessing instance methods
        person1.sayHello();

        // Accessing instance variables and instance methods
        person2.name = "Jane";
        person2.age = 30;
        System.out.println("Hello, my name is " + person2.name );
    }
}
