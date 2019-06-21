package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Admin_LoginCredentialsPOM;
//import com.training.pom.MyAccountPOM;
import com.training.pom.Shopping_PagePOM;
import com.training.pom.User_LoginCredentialsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Admin_Completing_UserOrderTest_RTTC_070 {
	// This test script verifies whether application allows the user to add product details into cart.//
	//Precondition:- User should launch the application by entering valid URL and login into application.
	private WebDriver driver;
	private String baseUrl;
	private String adminUrl;
	private User_LoginCredentialsPOM User_LoginCredentialsPOM;
	private Shopping_PagePOM Shopping_PagePOM;
	private Admin_LoginCredentialsPOM Admin_LoginCredentialsPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	  @BeforeClass public static void setUpBeforeClass() throws IOException {
	  properties = new Properties(); FileInputStream inStream = new
	  FileInputStream("./resources/others.properties"); properties.load(inStream);
	  }
	

	
	 @BeforeMethod public void setUp() throws Exception { 
		 driver = DriverFactory.getDriver(DriverNames.CHROME); 
		 User_LoginCredentialsPOM = new  User_LoginCredentialsPOM(driver); 
		 Shopping_PagePOM = new Shopping_PagePOM(driver); 
		 Admin_LoginCredentialsPOM = new Admin_LoginCredentialsPOM(driver); 
		 baseUrl = properties.getProperty("baseURL"); 
		 adminUrl = properties.getProperty("adminURL");
		 screenShot = new ScreenShot(driver); 
	
	 // open the browser 
	  driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
	  
	  }
	  
	  @Test (priority=1) public void Admin_Completing_UserOrderTest() throws
	  InterruptedException { 
		  
		  //Logging as user and creating order//
		  
	  User_LoginCredentialsPOM.sendemail("roopa.juvvala@in.ibm.com");
	  User_LoginCredentialsPOM.sendPassword("Delhi22");
	  User_LoginCredentialsPOM.clickLoginBtn(); Shopping_PagePOM.clickShop();
	  
	  
	  //As Earrings link is disabled, test case is changed to click search and add product.
	  
	  Shopping_PagePOM.clickSearchBtn();
	  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  
	  //Integer Vitae laculis Massa is out of stock so replaced it with FINGER RING in the test script.//
	  
	  Shopping_PagePOM.sendEnterSearchValue("FINGER RING");
	  Shopping_PagePOM.SearchBtn1();
	  
	  /*Shopping_PagePOM.Earrings(); 
	  Shopping_PagePOM.IntVitaelaculisMassa();
	  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS); screenShot.
	  captureScreenShot("Integer Vitae laculis Massa1 details are displayed");
	  ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(1));
	  driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);*/
	  
	  Shopping_PagePOM.FingerRing();
	  Shopping_PagePOM.clickAddToCartBtn();
	  driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
	  screenShot.captureScreenShot("Shopping Cart1 details were displayed");
	  Shopping_PagePOM.CartBag();
	  driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
	  Shopping_PagePOM.ViewCart();
	  //driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  screenShot.captureScreenShot("Complete product1 details were displayed");
	  
	  Shopping_PagePOM.clickCheckoutBtn();
	  screenShot.captureScreenShot("Billing Details should get displayed");
	  
	  Shopping_PagePOM.clickContinueBtn();
	  
	  driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);

//JavascriptExecutor js=(JavascriptExecutor)driver;

//js.executeScript("document.getElementById('button-payment-address').click()");
	  
	 
	  
	  screenShot.captureScreenShot("Delivery Details should get displayed");
	  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  Shopping_PagePOM.sendComment("This product is nice");
	  
	  Shopping_PagePOM.clickTermsCondiCheckBox();
	  
	  Shopping_PagePOM.clickContinueBtn1();
	  
	  Shopping_PagePOM.clickConfirmProductBtn();

	// After confirming the product, logging as Admin to complete the order//
	  
	driver.get(adminUrl);
	Admin_LoginCredentialsPOM.sendUsername("admin");
	Admin_LoginCredentialsPOM.sendPassword("admin@123");
	Admin_LoginCredentialsPOM.clickLoginBtn();
	screenShot.captureScreenShot("Dashboard page validation sucess");
	Shopping_PagePOM.clickMouseoverChart();Shopping_PagePOM.clickSales();
	Shopping_PagePOM.clickOrders();
	Shopping_PagePOM.clickSelectedOrder();
	Shopping_PagePOM.clickViewBtn();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	screenShot.captureScreenShot("Ordered Product details are displayed");
	System.out.println("Ordered Product details are displayed");
	Shopping_PagePOM.sendOrderStatusListBox("Complete");
	Shopping_PagePOM.clickAddHistoryBtn();
	Shopping_PagePOM.OrderCompletionSucessStatusgetText();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	System.out.println("Order completion status "+Shopping_PagePOM.OrderCompletionSucessStatusgetText());
	screenShot.captureScreenShot("Order completion status captured");

	// Logging in as User to check for the order completion.//
	
	  driver.get(baseUrl);
	  
	User_LoginCredentialsPOM.sendemail("roopa.juvvala@in.ibm.com");
	User_LoginCredentialsPOM.sendPassword("Delhi22");
	User_LoginCredentialsPOM.clickLoginBtn();
	Shopping_PagePOM.clickViewOrderHistry();
	screenShot.captureScreenShot("Completed Order details are displayed");
	System.out.println("Completed Order details are displayed");

	//Adding assertion to check order completion.//
	
	String Actual = Shopping_PagePOM.OrderCompletionSucessStatusgetText();
	String Expected = "Sucess:";
	assertTrue(Shopping_PagePOM.OrderCompletionSucessStatusgetText().contains(Expected));
	System.out.println("Test is Passed with Expected output.");
			
	}

	/*@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();

	}*/

}
