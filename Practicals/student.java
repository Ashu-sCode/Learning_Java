public class student {
    
    String name;
    int rollNumber;
    String course;

    student(String name) {
        this.name = name;
    }

    student(String name, int rollNumber) {
        this(name);
        this.rollNumber = rollNumber;
    }

    student(String name, int rollNumber, String course) {
        this(name, rollNumber);
        this.course = course;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll Number: " + rollNumber + ", Course: " + course);
    }


    /**
     * Test the student class by creating 3 objects and calling their display()
     * methods. The output should be 3 lines, each showing the name, roll number
     * and course of the student.
     */
    public static void main(String[] args) {
        student s1 = new student("Alice");
        student s2 = new student("Bob", 101);
        student s3 = new student("Charlie", 102, "Computer Science");

        s1.display();
        s2.display();
        s3.display();
    }

}
