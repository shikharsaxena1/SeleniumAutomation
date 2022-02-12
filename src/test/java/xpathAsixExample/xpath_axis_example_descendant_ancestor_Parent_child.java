package xpathAsixExample;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class xpath_axis_example_descendant_ancestor_Parent_child {
	@Test
	public void XPATHAsix() throws Exception {​​​
	 System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	 driver.get("https://accounts.lambdatest.com/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 // Finding the remember me grandchildren of the login form with field value as
	// remember me.
	driver.findElement(By.xpath("//div[@class='form-group'][3]//descendant::samp")).click();
	 Thread.sleep(2000);
	 //Finding the parent div using the password field of the login page.
	WebElement parentDiv=driver.findElement(By.xpath("//input[@name='password']//ancestor::div[1]"));
	System.out.println(parentDiv.getAttribute("class"));
	WebElement parentForm=driver.findElement(By.xpath("//input[@name='password']//ancestor::form"));
	System.out.println(parentForm.getAttribute("action"));

	driver.close();
	 }​​​
}
