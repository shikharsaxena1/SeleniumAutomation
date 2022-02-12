package com.org.coforge.webapplication;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
public class login2 {

	//Execution workflow
	//Unit testing framework- JUnit------> TestNG (**additional)
	//@Before - pre condition
	//@After - post condition
	//@Test - actual test case

	WebDriver driver;

	@AfterTest
	public void closeApp() {

	System.out.println("closeApp");
	driver.close();
	}




	@Test
	public void TC_01() throws Exception {

	System.out.println("TestCase 1");
	driver.findElement(By.xpath("//input[contains(@id,'Email')]")).clear();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[contains(@id,'Email')]")).sendKeys("admin@yourstore.com");
	driver.findElement(By.xpath("//input[contains(@id,'Pass')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'Pass')]")).sendKeys("admin");
	driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

	String text = driver.findElement(By.xpath("//h1[contains(text(),'D')]")).getText();
	System.out.println("**************" + text);


	//Click on Logout
	driver.findElement(By.xpath("//a[contains(text(),'Log')]")).click();
	}

	@BeforeTest
	public void launchApp() {

	System.out.println("launchApp");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

	}

}
