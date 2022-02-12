package xpathExample;
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


public class XpathExample3 {
	WebDriver driver;
	@BeforeTest
	public void launchApp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://accounts.lambdatest.com/register");

	}

	@AfterTest
	public void closeApp() throws Exception {
	Thread.sleep(3000);
	driver.close();
	}

	@Test
	public void SeeMoreClick() throws Exception {

	 WebElement lnkElectronicsStore = driver.findElement(By.xpath("//input[@name=\"email\"]//following::input[contains(@id,'ag')]"));
	lnkElectronicsStore.click();
	}

}
