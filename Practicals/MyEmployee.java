class MyEmployee{
	private int id;
	private String name;
	
	// Parameterized Constructor
	public MyEmployee(int i , String n){
		id = i; // this.id = id;
		name = n; // this.name = name;
	}
	// Copy Constructor
	public MyEmployee(MyEmployee other){
		this.id = other.id; // copying the values (copy id)
		this.name = other.name; //copy name
	}

	// Getters
	public int getId(){return id;}
	public String getName(){return name;}
	

	public static void main(String[] args){
	
		MyEmployee e1 = new MyEmployee(34, "Hello");	// Parameterized Constructor
		
		MyEmployee e2 = new MyEmployee(e1); // Copy Constructor

		MyEmployee e3 = new MyEmployee(35, "Welcome!");	// Parameterized Constructor
		
		MyEmployee e4 = new MyEmployee(e3); // Copy Constructor

        	System.out.println("e1 -> " + e1.getName() + " , " + e1.getId());
        	System.out.println("e2 -> " + e2.getName() + " , " + e2.getId());
		
        	System.out.println("e3 -> " + e3.getName() + " , " + e3.getId());
        	System.out.println("e4 -> " + e4.getName() + " , " + e4.getId());
	  }
	
}
