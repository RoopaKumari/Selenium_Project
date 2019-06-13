package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MyAccountPOM;
import com.training.pom.User_LoginCredentialsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Invalid_ChangePwdTest_RTTC_007 {
	//This test script verifies whether application displays error message upon mis matching password & confirm password of Change Your Password page.//
	private WebDriver driver;
	private String baseUrl;
	private User_LoginCredentialsPOM User_LoginCredentialsPOM;
	private MyAccountPOM MyAccountPOM;
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
		MyAccountPOM = new MyAccountPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@Test (priority=1)
	public void InvalidChangePasswordTest() throws InterruptedException {
		User_LoginCredentialsPOM.sendemail("roopa.juvvala@in.ibm.com");
		User_LoginCredentialsPOM.sendPassword("Delhi22");
		User_LoginCredentialsPOM.clickLoginBtn(); 
		MyAccountPOM.clickChangePassword();
		MyAccountPOM.sendpassword("Delhi");
		MyAccountPOM.sendconfirm("Delha");
		MyAccountPOM.clickContinueBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		System.out.println("Password change status " +MyAccountPOM.PwdFailgetText());
		screenShot.captureScreenShot("First");
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		
		String Actual = MyAccountPOM.PwdFailgetText();
		String Expected = "confirmation";
		assertTrue(MyAccountPOM.PwdFailgetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");
		
			}
    	
    	@AfterMethod
        public void tearDown() throws Exception {
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   	    driver.quit();
   
 }
 }

