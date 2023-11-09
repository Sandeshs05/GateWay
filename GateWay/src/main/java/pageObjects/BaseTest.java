package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
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
	@BeforeTest(alwaysRun = true)
	public void StartApplication()
	{
		driver = BrowserFactory.startBrowser(prop.getBrowser(), prop.getURL());
		driver.get("https://awesomeqa.com/ui/");
	}
	@AfterTest (alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
	public void loginPage()
	{
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.xpath("//a[.='Login']")).click();
	}
}
