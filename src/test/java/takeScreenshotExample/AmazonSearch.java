package takeScreenshotExample;
import java.io.File;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
public class AmazonSearch {
	WebDriver driver;

	@BeforeTest
	public void launchApp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");


	}


	@AfterTest
	public void closeApp() throws Exception {
	Thread.sleep(3000);
	driver.close();

	}




	@Test
	public void contextClick() throws Exception {





	driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone");
	driver.findElement(By.cssSelector("#nav-search-submit-button")).click();

	//take screenshot
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	File targetLocation = new File("./screenshot/demo.PNG");

	FileUtils.copyFile(screenshotFile, targetLocation);

	}

}
