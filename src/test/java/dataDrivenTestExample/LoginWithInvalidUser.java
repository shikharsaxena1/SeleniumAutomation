package dataDrivenTestExample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginWithInvalidUser {
	WebDriver driver;
	@BeforeTest
	public void launchApp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@AfterTest
	public void closeApp() throws Exception {
	Thread.sleep(3000);
	driver.close();
	}
	@Test(dataProvider = "db")
	public void verifyLogin(String userName, String password) throws Exception {
	driver.findElement(By.id("txtUsername")).clear();
	driver.findElement(By.id("txtUsername")).sendKeys(userName);
	Thread.sleep(1000);
	driver.findElement(By.name("txtPassword")).clear();
	driver.findElement(By.name("txtPassword")).sendKeys(password);
	driver.findElement(By.cssSelector("input#btnLogin")).click();
	Boolean errorMessage = driver.findElement(By.cssSelector("span#spanMessage")).isDisplayed();
	Assert.assertTrue(errorMessage);
	String errorText = driver.findElement(By.cssSelector("span#spanMessage")).getText();
	System.out.println(errorText);

	Thread.sleep(4000);

	}
	@DataProvider(name= "sample")
	public Object[][] sampleTestData() {

	Object[][] data = {{"rahul@gmail.com", "demo@123"},{"sahil@gmail.com", "password@123"},{"abhishek@gmail.com", "12345"}};
	//extract data from excel/csv/database/json/xml
	return data;
	}
	@DataProvider(name= "db")
	public Object[][] DatabaseTestData() {

	Object[][] data = {{"rahul1@gmail.com", "demo@123"},{"sahil1@gmail.com", "password@123"},{"abhishek1@gmail.com", "12345"}};
	//extract data from excel/csv/database/json/xml
	return data;
	}
}
