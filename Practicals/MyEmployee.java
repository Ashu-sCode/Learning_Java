class MyEmployee{
	private int id;
	private String name;
	
	public MyEmployee(int i , String n){
		id = i;
		name = n;
	}

	public MyEmployee(MyEmployee other){
		this.id = other.id;
		this.name = other.name;
	}


	public int getId(){return id;}
	public String getName(){return name;}
	

	public static void main(String[] args){
	
		MyEmployee e1 = new MyEmployee(34, "Hello");	
		
		MyEmployee e2 = new MyEmployee(e1);

		MyEmployee e3 = new MyEmployee(35, "Welcome!");	
		
		MyEmployee e4 = new MyEmployee(e3);

        	System.out.println("e1 -> " + e1.getName() + " , " + e1.getId());
        	System.out.println("e2 -> " + e2.getName() + " , " + e2.getId());
		
        	System.out.println("e3 -> " + e3.getName() + " , " + e3.getId());
        	System.out.println("e4 -> " + e4.getName() + " , " + e4.getId());
	  }
	
}
