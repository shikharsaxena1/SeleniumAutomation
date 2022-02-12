package alertExample;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertExampleDemo {

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
	public void simpleAlert() {

	//Click on - Show Me Alert button
	driver.findElement(By.xpath("//input[contains(@value,'Me Alert')]")).click();
	//Alert - validate text
	//accept - OK
	//dismiss - Cancel/ esc
	//sendKeys
	//Handle Alert
	//driver.switchTo()
	//Alert / frame / window
	Alert myAlert = driver.switchTo().alert();
	System.out.println("*********"+myAlert.getText());
	Assert.assertEquals(myAlert.getText(), "Hi.. This is alert message!");
	//accept
	myAlert.dismiss();


	}

	@Test
	public void confirmAlert() {
	driver.findElement(By.xpath("//*[contains(text(),'Conf')]")).click();
	//Switch to alert
	Alert confirmAlert = driver.switchTo().alert();
	//Validation step
	Assert.assertTrue(confirmAlert.getText().contains("OK' or 'Cancel'"));
	confirmAlert.accept();
	String AlertText = driver.findElement(By.cssSelector("div#demo")).getText();
	System.out.println("Alert verification: " + AlertText);
	//validation step
	Assert.assertEquals(AlertText, "You pressed OK!", "verification of Alert get failed.");

	}
	@AfterMethod
	public void waitExample() throws Exception {
	System.out.println("wait after each method");
	Thread.sleep(2000);
	}

	@Test
	public void promptAlert() {
	driver.findElement(By.xpath("//*[contains(text(),'Prompt')]")).click();
	//Switch to alert
	Alert promptAlert = driver.switchTo().alert();
	//Validation step
	Assert.assertTrue(promptAlert.getText().contains("Name Please"));

	promptAlert.sendKeys("Rahul");
	promptAlert.accept();

	}
}
