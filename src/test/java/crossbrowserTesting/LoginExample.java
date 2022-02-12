package crossbrowserTesting;
import java.io.IOException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;



import configExample.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginExample extends BaseTest {
	@Test(priority = 1)
	public void verifyLogin() {

	driver.findElement(By.id("txtUsername")).sendKeys(conf.adminUser());
	driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(conf.adminPassword());
	driver.findElement(By.id("btnLogin")).click();


	}

	@Test(priority = 2)
	public void verifyDashboard() {

	Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Dashboard"));
	}

	@Test(priority = 3)
	public void verifyLogout() throws Exception {

	Thread.sleep(4000);
	driver.findElement(By.cssSelector("a#welcome")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Logout")).click();


	}
}
