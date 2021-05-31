package Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Assignment2_28May {
	public WebDriver driver;
	public String url = "https://www.skyscanner.co.in/";
	public String url1 = "https://www.skyscanner.co.in/flights";
	List<WebElement> links = new ArrayList<WebElement>();
		
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
		driver.manage().window().maximize();
		driver.navigate().to(url1);
		System.out.println(driver.getCurrentUrl());
		
		
	}	
	
	
	@Test
    public void test1()
    {
		links=driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		for(WebElement link:links)
		{

			System.out.println(link.getText());
		}
	}
	@Test
	 public void test2()
	    {
		List<WebElement> pngList = new ArrayList<WebElement>();
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		for(WebElement image : imageList)
		{
			if(image.getAttribute("src").endsWith(".png"))
			{
				pngList.add(image);
			}
		}
		for(WebElement png : pngList)
		{
			System.out.println(png.getAttribute("alt"));
		}
	    }
	
	
	 @AfterTest
	    public void quit()
	    {
	        driver.quit();
	      
	    }
	
}