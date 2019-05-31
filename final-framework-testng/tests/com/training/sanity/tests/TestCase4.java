package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM5;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase4 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM5 LoginPOM5;
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
		LoginPOM5 = new LoginPOM5(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(7000);
		
	}
	@Test (priority=1)
	public void ViewCartTest() throws InterruptedException {
		LoginPOM5.sendemail("roopa.juvvala@in.ibm.com");
		LoginPOM5.sendPassword("Delhi22");
		LoginPOM5.clickLoginBtn(); 
		LoginPOM5.clickShop();
		LoginPOM5.Earrings();
		LoginPOM5.IntVitaelaculisMassa();
		Thread.sleep(5000);
		screenShot.captureScreenShot("Integer Vitae laculis Massa1 details are displayed");
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(7000);
		
		LoginPOM5.clickAddToCartBtn();
	Thread.sleep(7000);
	screenShot.captureScreenShot("Shopping Cart1 details were displayed");
	LoginPOM5.CartBag();
	Thread.sleep(7000);
	LoginPOM5.ViewCart();
	Thread.sleep(5000);
	screenShot.captureScreenShot("Complete product1 details were displayed");
	System.out.println("View Cart details were displayed corrected, Hence the Test is passed");
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
		
		
}