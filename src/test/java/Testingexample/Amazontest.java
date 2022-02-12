package Testingexample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazontest {

	
	
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
	public void searchItems() {
	String serachText = "iphone";
	driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys(serachText);
	driver.findElement(By.xpath("//input[@value='Go']")).click();
	String expectedTitle="Amazon.in : iphone";
	String actualAppTitle = driver.getTitle();
	System.out.println("Application Title after search: " + actualAppTitle);
	//validation
	//Assert.assertEquals(actualAppTitle, expectedTitle);
	Assert.assertTrue(actualAppTitle.contains(serachText));
	}

}
