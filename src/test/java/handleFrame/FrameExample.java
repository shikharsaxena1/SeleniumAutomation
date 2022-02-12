package handleFrame;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameExample {
	WebDriver driver;
	@BeforeTest
	public void launchApp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://paytm.com/");

	}

	@AfterTest
	public void closeApp() throws Exception {
	Thread.sleep(3000);
	driver.close();
	}

	@Test
	public void simpleAlert() throws Exception {

	//Click on - Show Me Alert button
	driver.findElement(By.xpath("//span[text()='Sign In']")).click();
	//Thread.sleep(10000);
	//Alert/frame/window
	//Switch to frame - multiple way
	//index
	//name/id
	//webelement
	//index - 0
	//Thread.sleep(1000);
	//index
	//driver.switchTo().frame(0);
	//name or id - demoframe
	//driver.switchTo().frame("demoframe");
	WebElement myFrame = driver.findElement(By.xpath("//*[contains(@src,'isIframe')]"));
	driver.switchTo().frame(myFrame);
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Watch')]")));
	
	String actualheading = driver.findElement(By.cssSelector(".content")).getText();
	System.out.println(actualheading);
	
	Assert.assertEquals(actualheading, "Scan QR code with Paytm App to login", "Verification of heading get failed.");
	Assert.assertEquals(actualheading, "Scan QR code with Paytm App to login");
	
	
	
	//watch -video
	driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).click();




	}
}
