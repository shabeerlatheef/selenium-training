package test;

import java.util.Scanner;

public class PalindromeExample {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	     System.out.print("Enter your integer: ");
	   String  s = in.nextLine(); 
	   PalindromeExample ob = new PalindromeExample();
	   String h = ob.palindrone(s);
	   System.out.println(h);
	}
		public String palindrone (String s)
		{
		
		   int length = s.length()-1;   
		   String r = "";
	      for ( int i = s.length() - 1; i >= 0; i-- )  
	         r = r + s.charAt(i);  
	      if (s.equals(s))  
	         return "Yes";  
	      else  
	         return "No";   
	   }  

}
