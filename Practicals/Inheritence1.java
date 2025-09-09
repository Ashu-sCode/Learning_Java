import java.util.*;

class ThisSuper{
	
	String name; 
	long salary;

	ThisSuper(String name, long salary){
		this.salary = salary;
		this.name = name;
	}

	public void m1(){
		System.out.println("Welcome " + name + "!!!");	
		System.out.println("Your Salary is:" + salary);
	}


}

class MainClass extends ThisSuper{
	
	MainClass(String name, long salary){
		super(name,salary);
	}

	@Override
	public void m1(){
		super.m1();
		System.out.println("This is Extension");
	}	

	public static void main(String a[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name : ");
		String name = sc.nextLine();
		System.out.print("Enter your Salary : ");
		long salary = sc.nextLong();
		sc.close();
		MainClass object1 = new MainClass(name, salary);
		object1.m1();	
	}

}