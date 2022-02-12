package com.org.coforge.webapplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;


public class login3 {

	
	WebDriver driver;
	//Junit/TestNG
	//control - execution workflow
	//@Before ----- pre-condition
	//@Test ----- test case
	//@After ----- post-condition

	//Internally taken care by TestNG

	@BeforeTest
	public void setup() {
	System.out.println("launch Application on chrome browser");

	}

	@AfterTest
	public void teardown() {
	System.out.println("close application ");


	}

	@Test(priority = 0)
	public void login() throws Exception {


	System.out.println("execute login test case");



	}

	@Test(priority = 3)
	public void logout() throws Exception {


	System.out.println("execute logout test case");



	}

	@Test(priority = 1)
	public void addItemsToCart() throws Exception {


	System.out.println("execute addItemsToCart test case");



	}



	@Test(priority = 2)
	public void payment() throws Exception {


	System.out.println("execute payment test case");



	}

}
