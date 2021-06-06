package Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment7_6JuneAlert {
	
	
	public WebDriver driver;
	public String url = "https://demoqa.com/alerts";
	
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
		//driver.manage().window().maximize();
		
		
	}	
	
	@AfterSuite
    public void quit()
    {
       driver.quit();
        System.out.println("quit the browser");
    }
	
	@Test
	public void click_dismiss() throws InterruptedException
	{		
		driver.manage().window().maximize();
		
		WebElement alertbutton =	driver.findElement(By.id("alertButton"));
		alertbutton.click();
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void click_accept() throws InterruptedException
	{		
	
		WebElement confirm = driver.findElement(By.id("confirmButton"));
		confirm.click();
		Thread.sleep(5000);
		String s = driver.switchTo().alert().getText();
		System.out.println(s);
		driver.switchTo().alert().accept();
		
		
	}
	
	
	
	@Test
	public void click_sendkeys() throws InterruptedException
	{		
	
		
		WebElement prompt = driver.findElement(By.id("promtButton"));
		prompt.click();
		Thread.sleep(5000);
		driver.switchTo().alert().sendKeys("shabeer");
		
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
	}

}
