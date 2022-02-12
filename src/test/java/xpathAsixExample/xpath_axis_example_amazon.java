package xpathAsixExample;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class xpath_axis_example_amazon {
	@Test
	public void xpathAsix() throws Exception {​​​
	 System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("rolex");
	driver.findElement(By.xpath("//input[@value='Go']")).click();
	Thread.sleep(5000);
	// driver.findElement(By.cssSelector("div._bGlmZ_item_awNhH:nth-child(3)")).click();
	 WebElement rolex_icon = driver.findElement(By.xpath(
	"//div[@class='_bGlmZ_background_HINlr']/following-sibling::div/descendant::a[contains(@aria-label,'Fire')][2]"));
	 JavascriptExecutor JS = (JavascriptExecutor) driver;
	JS.executeScript("arguments[0].click();", rolex_icon);
	 }​​​
	 private JavascriptExecutor JavascriptExecutor(WebDriver driver) {​​​
	// TODO Auto-generated method stub
	return null;
	}​​​

}
