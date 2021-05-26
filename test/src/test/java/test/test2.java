package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test1.PalindromeExample;

public class test2 {
	
	@BeforeTest
	public void beforetest()
	{
		System.out.println("BeforeTest");
	}
	
	@AfterTest
	public void aftertest()
	{
		System.out.println("AfterTest");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("BeforeClass");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("Afterclass");
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("AfterSuite");
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Before Method1");
	}
	
	
	@Test
	public void test1()
	{
		PalindromeExample a = new PalindromeExample();
		String c = a.palindrone("java");
		Assert.assertEquals(c, "Yes");
		System.out.println("Test1");
		
	}
	@Test(enabled=true)
	public void  test2()
	{
		PalindromeExample a = new PalindromeExample();
		String c = a.palindrone("java");
		Assert.assertEquals(c, "Yes");
		System.out.println("Test 2 enabled=true");
		
	}
	
	@Test(enabled=false)
	public void  test3()
	{
		PalindromeExample a = new PalindromeExample();
		String c = a.palindrone("java");
		Assert.assertEquals(c, "Yes");
		System.out.println("Test 3 enabled=false");
		
	}
	@Test(enabled=true, priority=1)
	public void  test5()
	{
		PalindromeExample a = new PalindromeExample();
		String c = a.palindrone("java");
		Assert.assertEquals(c, "Yes");
		System.out.println("Test 5 enabled=true, priority=1");
		
	}
	@Test(enabled=true, priority=2)
	public void  test4()
	{
		PalindromeExample a = new PalindromeExample();
		String c = a.palindrone("java");
		Assert.assertEquals(c, "Yes");
		System.out.println("Test 4 enabled=true, priority=2");
		
	}
	
	@AfterMethod
	public void  Aftermethod()
	{
		PalindromeExample a = new PalindromeExample();
		String c = a.palindrone("java");
		Assert.assertEquals(c, "Yes");
		System.out.println("After method");
		
	}

}
