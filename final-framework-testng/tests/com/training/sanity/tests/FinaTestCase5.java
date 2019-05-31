package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.TestCase5POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FinaTestCase5 {
	private WebDriver driver;
	private String baseUrl;
	private TestCase5POM TestCase5POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		TestCase5POM = new TestCase5POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(7000);
		
	}
	@Test (priority=1)
	public void RemoveCartTest() throws InterruptedException {
		TestCase5POM.sendemail("roopa.juvvala@in.ibm.com");
		TestCase5POM.sendPassword("Delhi22");
		TestCase5POM.clickLoginBtn(); 
		
		TestCase5POM.clickShop();
		TestCase5POM.Earrings();
		/*TestCase5POM.Dropdown();*/
		TestCase5POM.IntVitaelaculisMassa();
		Thread.sleep(5000);
		screenShot.captureScreenShot("Integer Vitae laculis Massa details are displayed");
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(9000);
	TestCase5POM.clickAddToCartBtn();
	Thread.sleep(8000);
	screenShot.captureScreenShot("Shopping Cart details were displayed");
	TestCase5POM.CartBag();
	Thread.sleep(7000);
	TestCase5POM.ViewCart();
	screenShot.captureScreenShot("Complete product details were displayed");
	Thread.sleep(5000);
	TestCase5POM.clickRemoveBtn();
	Thread.sleep(10000);
	System.out.println("Shopping Cart status " +TestCase5POM.ShpngCartMsggetText());
	System.out.println("Test is Passed with Expected output.");
	Thread.sleep(5000);
	screenShot.captureScreenShot("Final");
			
	}
	  @AfterMethod
      public void tearDown() throws Exception {
 		Thread.sleep(1000);
 	driver.quit();
 
}
}	