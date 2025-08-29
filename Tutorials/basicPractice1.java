
// import java.lang.*;
import java.util.*;

public class basicPractice1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name of Student: ");
        String name = scanner.nextLine();

        System.out.print("Enter Marks in English: ");
        int english = scanner.nextInt();

        System.out.print("Enter Marks in Hindi: ");
        int hindi = scanner.nextInt();

        System.out.print("Enter Marks in Math: ");
        int math = scanner.nextInt();

        System.out.print("Enter Marks in Science: ");
        int science = scanner.nextInt();

        System.out.print("Enter Marks in Social: ");
        int social = scanner.nextInt();
        scanner.close();

        int total = english + hindi + math + science + social;
        float percentage = (total * 100) / 500f;

        char Grade;
        if (percentage >= 90) {
            Grade = 'A';
        } else if (percentage >= 80) {
            Grade = 'B';
        } else if (percentage >= 70) {
            Grade = 'C';
        } else if (percentage >= 60) {
            Grade = 'D';
        } else {
            Grade = 'E';
        }

        System.out.println(
                "Student Name: " + name + "\n" + "Total Marks: " + total + "\n" + "Percentage: " + percentage + "% \n" + "Grade: " + Grade);

                
    }

}
