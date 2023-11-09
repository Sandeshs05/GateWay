package TestCase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import pageObjects.BaseTest;

public class Tests extends BaseTest {
	
	@Test
	public void TC001()
	{
		driver.findElement(By.cssSelector(".button.special")).click();
		driver.findElement(By.id("card_nmuber")).sendKeys("1234567890123456");
		driver.findElement(By.id("month")).sendKeys("07");
		driver.findElement(By.id("year")).sendKeys("2027");
		driver.findElement(By.id("cvv_code")).sendKeys("123");
		driver.findElement(By.cssSelector(".button.special")).click();
		String confirmMsg=driver.findElement(By.xpath("//h2[normalize-space()='Payment successfull!']")).getText();
		assertEquals(confirmMsg, "Payment successfull!");
	}
	
	@Test
	public void TC002()
	{
		driver.findElement(By.cssSelector(".button.special")).click();
		driver.findElement(By.id("card_nmuber")).sendKeys("123456789012345");
		driver.findElement(By.id("month")).sendKeys("07");
		driver.findElement(By.id("year")).sendKeys("2027");
		driver.findElement(By.id("cvv_code")).sendKeys("123");
		driver.findElement(By.cssSelector(".button.special")).click();
		Alert alert = driver.switchTo().alert();
		String alertText=alert.getText();
		assertEquals(alertText, "Check card number is 16 digits!");
	}
	@Test
	public void TC003()
	{
		driver.findElement(By.cssSelector(".button.special")).click();
		driver.findElement(By.id("card_nmuber")).sendKeys("1234567890123456");
		driver.findElement(By.id("month")).sendKeys("07");
		driver.findElement(By.id("year")).sendKeys("2027");
		driver.findElement(By.id("cvv_code")).sendKeys("@!#");
		driver.findElement(By.id("message2")).getText().equalsIgnoreCase("Special characters are not allowed");
	} 
}
