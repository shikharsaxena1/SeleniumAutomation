package alertExample;
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
public class Actionexample {
	WebDriver driver;

	@BeforeTest
	public void launchApp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.guru99.com/test/simple_context_menu.html");


	}


	@AfterTest
	public void closeApp() throws Exception {
	Thread.sleep(3000);
	driver.close();

	}




	@Test
	public void contextClick() throws Exception {



	WebElement btnDouble = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));


	//Right Click - COntext Click
	Actions act = new Actions(driver);
	act.doubleClick(btnDouble).perform();




	//Handle Alert
	String alertText = driver.switchTo().alert().getText();
	System.out.println(alertText);
	Assert.assertEquals(alertText, "You double clicked me.. Thank You..");
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	}

}
