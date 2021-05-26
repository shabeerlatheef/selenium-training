package test;

public class Add {

	public static void main(String[] args) 
	{
		
		//Add.add(5,6);
		//Add.add(5,7f);
		
	}
		public static int add(int a, int b)
		{
		int c=a+b;
		System.out.println("Integer add: " +c);
			return(c);
		}
		public static void add(int a, float b)
		{
			float c=a+b;
			System.out.println("Float and int add: " +c);
		}
}
	
