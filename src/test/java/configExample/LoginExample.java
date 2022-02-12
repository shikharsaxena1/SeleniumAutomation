package configExample;
import java.io.IOException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;



//import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginExample {
	ReadConfig conf;
	WebDriver driver;

	@BeforeTest
	public void launchApp() throws Exception {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();


	conf = new ReadConfig();

	System.out.println(conf.appURL());


	driver.get(conf.appURL());


	}


	@AfterTest
	public void closeApp() {

	driver.close();

	}




	@Test
	public void verifyLogin() {



	driver.findElement(By.id("txtUsername")).sendKeys(conf.adminUser());
	driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(conf.adminPassword());
	driver.findElement(By.id("btnLogin")).click();


	}
}
