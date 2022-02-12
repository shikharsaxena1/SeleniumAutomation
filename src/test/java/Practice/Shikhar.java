package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shikhar {

	
	WebDriver driver;
	@BeforeTest
	public void launchApp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");

	}
	
	@AfterTest
	public void closeApp() {
	driver.close();
	}
	
	@Test
	public void signin() throws Exception {
	WebElement ele = driver.findElement(By.xpath("(//a[contains(@class,'nav-a nav-a-2')])[3]"));
	
	//Creating object of an Action class
	Actions action = new Actions(driver);
	
	action.moveToElement(ele).perform();
	Thread.sleep(4000);
	
	driver.findElement(By.xpath("//span[@class='nav-text']")).click();
	Thread.sleep(6000);
	
	//validation
	//Assert.assertEquals(actualAppTitle, expectedTitle);
	String expectedtext = "Save time";
	String actualtext = driver.findElement(By.xpath("//h3[text()='Save time']")).getText();
	Assert.assertEquals(actualtext, expectedtext);
	Thread.sleep(6000);
	}
	
	
}
