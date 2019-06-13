package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Shopping_PagePOM;
import com.training.pom.User_LoginCredentialsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RemoveProduct_FromCartTest_RTTC010 {
	//This test script verifies whether application allows the user to remove added product details from cart//
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
	public void RemoveCartTest() throws InterruptedException {
		User_LoginCredentialsPOM.sendemail("roopa.juvvala@in.ibm.com");
		User_LoginCredentialsPOM.sendPassword("Delhi22");
		User_LoginCredentialsPOM.clickLoginBtn(); 
		
		Shopping_PagePOM.clickShop();
		Shopping_PagePOM.Earrings();
		/*Shopping_PagePOM.Dropdown();*/
		Shopping_PagePOM.IntVitaelaculisMassa();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Integer Vitae laculis Massa details are displayed");
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		Shopping_PagePOM.clickAddToCartBtn();
	driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
	screenShot.captureScreenShot("Shopping Cart details were displayed");
	Shopping_PagePOM.CartBag();
	driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
	Shopping_PagePOM.ViewCart();
	screenShot.captureScreenShot("Complete product details were displayed");
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	Shopping_PagePOM.clickRemoveBtn();
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
  	
	System.out.println("Shopping Cart status " +Shopping_PagePOM.ShpngCartMsggetText());
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	screenShot.captureScreenShot("Final");
	
	
	String Actual = Shopping_PagePOM.ShpngCartMsggetText();
	String Expected = "empty";
	assertTrue(Shopping_PagePOM.ShpngCartMsggetText().contains(Expected));
	System.out.println("Test is Passed with Expected output.");
	
	
	
	
			
	}
	  @AfterMethod
      public void tearDown() throws Exception {
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 	driver.quit();
 
}
}	
