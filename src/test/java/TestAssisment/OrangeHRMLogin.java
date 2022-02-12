package TestAssisment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;


public class OrangeHRMLogin {
	WebDriver driver;



	@BeforeTest
	public void launchApp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/");



	}

	@Test
	public void signIn() throws Exception{
	Thread.sleep(3000);
	
	//Here we need to type Username in Username input text box
	driver.findElement(By.xpath("//div[@id='logInPanelHeading']//following-sibling::div//descendant::input[@name=\"txtUsername\"]")).sendKeys("Admin");
	Thread.sleep(3000);
	
	//Here we need to type Password in the Password input text box
	driver.findElement(By.xpath("//div[@id='logInPanelHeading']//following-sibling::div//following-sibling::div//descendant::input[@name=\"txtPassword\"]")).sendKeys("admin123");
	Thread.sleep(4000);
	
	//Here we need to perform Click operation on Login Button
	driver.findElement(By.xpath("//div[@id='divLoginHelpLink']//following-sibling::div//input[@type='submit']")).click();
	Thread.sleep(4000);
	}

	@AfterTest
	public void closeApp() {
	driver.close();
	}
}
