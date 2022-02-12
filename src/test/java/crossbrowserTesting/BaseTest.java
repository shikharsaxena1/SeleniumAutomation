package crossbrowserTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



import configExample.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {

	
	ReadConfig conf;
	WebDriver driver;

	@Parameters("coforge")
	@BeforeTest
	public void launchApp(String br) throws Exception {

	//crossBrowserTesting
	System.out.println("Execution of test case on Browser: "+ br );

	if(br.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}

	else if(br.equalsIgnoreCase("edge")) {
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();

	}



	else {

	System.out.println("choose app. browser");
	}










	driver.manage().window().maximize();
	conf = new ReadConfig();
	driver.get(conf.appURL());

	}


	@AfterTest
	public void closeApp() throws Exception {
	Thread.sleep(2000);
	driver.close();

	}
}
