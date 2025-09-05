import java.util.Scanner;

class p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any char to see its ASCII Value: ");

       
        String input = sc.nextLine();

        // print ASCII value (String(Char) → int)
        System.out.println("\nCharacter → ASCII Value");
        System.out.println("------------------------");

	   for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            System.out.println(ch + " → " + (int) ch);
        }

        sc.close();
    }
}
