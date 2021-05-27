package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Assignment1 {

	public WebDriver driver;
	public String url = "https://www.skyscanner.net/";
		
	@BeforeSuite
	public void browsersetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	@BeforeClass	
	public void appsetup()
	{
		driver.get(url);
		System.out.println(url);
		System.out.println(driver.getCurrentUrl());
		
	}	
	
	@Test
    public void title()
    {
		System.out.println(driver.getTitle());
		System.out.println("Shabeer Test");
	}
	
	@Test
	public void otherpage()
	{
		driver.navigate().to("https://demoqa.com");
		System.out.println(driver.getCurrentUrl());
	}

	 @AfterTest
	    public void quit()
	    {
	        driver.quit();
	        System.out.println("quit the browser");
	    }
	
}