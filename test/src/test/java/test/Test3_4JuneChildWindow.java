package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test3_4JuneChildWindow {
	
	
	public WebDriver driver;
	public String url = "https://demoqa.com/browser-windows";
	
	List<WebElement> links = new ArrayList<WebElement>();
	
		
	@BeforeClass
	public void browsersetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	@BeforeMethod
	public void appsetup()
	{
		driver.get(url);
		driver.manage().window().maximize();
				
	}	
	
	@Test
	public void childwindow()
	{
		String parentWindow = driver.getWindowHandle();
		
		System.out.println(parentWindow);
		
		WebElement newwindow = driver.findElement(By.xpath("//button[@id='windowButton']"));
		
		for (int i =0; i<10; i++)
			newwindow.click();	
		
		
		Set<String> newBrowser = driver.getWindowHandles();
		
		for(String i:newBrowser)
		{
			System.out.println(i);
		    if(!(i.equals(parentWindow)))
		    {
		    	driver.switchTo().window(i);
		    	System.out.println(driver.getCurrentUrl());
		    
		   WebElement head = driver.findElement(By.id("sampleHeading"));
		   
		  Assert.assertEquals(head.getText(), "This is a sample page");
		  driver.close();
		  System.out.println("Close child window browser");
		   
		    }
		}
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
		
		
		
		
		driver.close();
		
		
		
	}

}
