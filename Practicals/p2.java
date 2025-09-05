import java.util.Scanner;

class p2{

	public static void main (String args[]){

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Your Email: ");
		String email = sc.nextLine();
		
		System.out.println("Enter Your Pass: ");
		String pass = sc.nextLine();
		
		System.out.println("Welcome User " + email);
		System.out.println("Your Password is : ");
		for(int i=0; i<=pass.length(); i++){
				
				System.out.print("*");

			}


	}


}