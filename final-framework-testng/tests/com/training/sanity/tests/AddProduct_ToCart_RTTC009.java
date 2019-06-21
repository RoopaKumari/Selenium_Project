package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import com.training.pom.MyAccountPOM;
import com.training.pom.Shopping_PagePOM;
import com.training.pom.User_LoginCredentialsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProduct_ToCart_RTTC009 {
	//This test script verifies whether application allows the user to add product details into cart.//
	private WebDriver driver;
	private String baseUrl;
	private User_LoginCredentialsPOM User_LoginCredentialsPOM;
	private Shopping_PagePOM Shopping_PagePOM;
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
		User_LoginCredentialsPOM = new User_LoginCredentialsPOM(driver); 
		Shopping_PagePOM = new Shopping_PagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		
	}
	@Test (priority=1)
	public void AddProduct_ToCart() throws InterruptedException {
		User_LoginCredentialsPOM.sendemail("roopa.juvvala@in.ibm.com");
		User_LoginCredentialsPOM.sendPassword("Delhi22");
		User_LoginCredentialsPOM.clickLoginBtn(); 
		Shopping_PagePOM.clickShop();
		Shopping_PagePOM.Earrings();
		Shopping_PagePOM.IntVitaelaculisMassa();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Integer Vitae laculis Massa1 details are displayed");
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		
		Shopping_PagePOM.clickAddToCartBtn();
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
	screenShot.captureScreenShot("Shopping Cart1 details were displayed");
	Shopping_PagePOM.CartBag();
	driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
	Shopping_PagePOM.ViewCart();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	screenShot.captureScreenShot("Complete product1 details were displayed");
	System.out.println("View Cart details were displayed corrected, Hence the Test is passed");
	}
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.quit();
	}
		
		
}