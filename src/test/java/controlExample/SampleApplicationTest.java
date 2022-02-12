package controlExample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SampleApplicationTest {

	
	WebDriver driver;
	@BeforeTest
	public void launchApp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html");

	}

	@AfterTest
	public void closeApp() throws Exception {
	Thread.sleep(3000);
	driver.close();
	}

	@Test
	public void verifyLogin() {
	//conditional wait
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#text3")));

	driver.findElement(By.cssSelector("#text3")).sendKeys("Rahul Tyagi");

	}
}
