package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utilities.BrowserFactory;
import utilities.configDataReader;

public class BaseTest {
	
	public WebDriver driver;
	public configDataReader prop;	
	
	@BeforeSuite
	public void setUpSuite()
	{
		prop=new configDataReader();
	}	
	@BeforeMethod(alwaysRun = true)
	public void StartApplication()
	{
		driver = BrowserFactory.startBrowser(prop.getBrowser(), prop.getURL());
	}
	@AfterMethod (alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
	}
	public void loginPage()
	{
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.xpath("//a[.='Login']")).click();
	}
}
