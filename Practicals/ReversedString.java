class ReverseString{
	
	public static void main(String str[]){

		String s = "Ashutosh";
		String a = "";
		
		for(int i = s.length()-1; i>=0; i--){

				 a += s.charAt(i);	

			}
		System.out.printf("Reversd String is: " + a);

		
	}

}