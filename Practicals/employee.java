import java.util.Scanner;

class Employee {

    String name;
    long salary;

    Employee(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    void addBonus(long bonus) {
        salary += bonus;
    }

    void show() {
        System.out.println("Name: " + name + ", Salary: " + salary);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter salary: ");
        long salary = sc.nextLong();

        Employee emp = new Employee(name, salary);
        System.out.println("Before bonus:");
        emp.show();

        System.out.print("Enter bonus amount: ");
        long bonus = sc.nextLong();
        emp.addBonus(bonus);
        System.out.println("After bonus:");
        emp.show();

        sc.close();
    }

}