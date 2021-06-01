package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment1_june {
	
	
	public WebDriver driver;
	public String url = "https://www.saucedemo.com/";
	
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
	
	@Test(enabled=false)
	public void products()
	{
		List<WebElement> links =driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
		System.out.println(links.size());
		for(WebElement link:links)
		{
			
			System.out.println(link.getText() + "amount: ");
			
			
		}
		//div[@class="inventory_item_name"]
		
		//div[@class="inventory_item_price"]
	}
	
	
	
	 @AfterClass
	    public void quit()
	    {
	        driver.quit();
	        System.out.println("quit the browser");
	    }
	 @Test(dataProvider="data1")
	 public void login(String UserName,String Password)
	 {
		 WebElement username = driver.findElement(By.id("user-name"));
		 WebElement password = driver.findElement(By.id("password"));
		 WebElement login = driver.findElement(By.id("login-button"));
		 
		 username.sendKeys(UserName);
		 password.sendKeys(Password);
		 login.click();
		 
		 String a = driver.findElement(By.xpath("//span[@class='title']")).getText();
		 Assert.assertEquals("PRODUCTS", a);
		//span[@class='title']
		 
		 List<WebElement> links =driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
			System.out.println(links.size());
			for(WebElement link:links)
			{
				System.out.println("Product name: " + link.getText() + " amount: ");
				List<WebElement> amount = driver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
				
			}
	 }
	 
	 
	 @DataProvider(name="data1")
	 public Object[][] dataprovider() throws IOException
	 {
			FileInputStream fs = new FileInputStream("E:\\java program\\Excel\\login.xlsx");
			//Creating a workbook
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
	int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
	int cellcount=sheet.getRow(0).getLastCellNum();
	System.out.println(sheet.getLastRowNum());
	System.out.println(cellcount);
	Object ob[][] = new Object[rowCount-1][cellcount-1];
int k=0;int l=0;
	        //iterate over all the row to print the data present in each cell.
	        for(int i=1;i<rowCount;i++){
	            
	            //get cell count in a row
	            
	            //iterate over each cell to print its value
	            
	            for(int j=1;j<cellcount;j++){
	                Cell cell = sheet.getRow(i).getCell(j);
	   
	switch(cell.getCellType())
	{
	case Cell.CELL_TYPE_STRING:
	    ob[k][l]=sheet.getRow(i).getCell(j).getStringCellValue();
	    break;
	case Cell.CELL_TYPE_NUMERIC:
		 ob[k][l]=sheet.getRow(i).getCell(j).getNumericCellValue();
	    break;
		
	       default:
	    	   System.out.println("Error");}
	l++;
	    	   }
	           k++;
	        }
	        
	        System.out.println(Arrays.deepToString(ob));
	        return(ob);
		}

}
