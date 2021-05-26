package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import test1.PalindromeExample;

public class Add_tester 
{
	
	@Test
	public void add1()
	{
		Add ob = new Add();
		int out= ob.add(1, 3);
		Assert.assertEquals(out, 3);
	}
	
	@Test
	public void palindrome()
	{
		PalindromeExample a = new PalindromeExample();
		String c = a.palindrone("121");
		Assert.assertEquals(c, "Yes");
		System.out.println("palindrome");
		
	}
	@Test
	public void  test1_palindrome1()
	{
		PalindromeExample a = new PalindromeExample();
		String c = a.palindrone("java");
		Assert.assertEquals(c, "No");
		System.out.println("Test 1 palindrome 1");
		
	}
	@Test(enabled=true, priority=1)
	public void  test2_palindrome2()
	{
		PalindromeExample a = new PalindromeExample();
		String c = a.palindrone("malayalam");
		Assert.assertEquals(c, "Yes");
		System.out.println("Test 2 palindrome 2");
		
	}

	

}






