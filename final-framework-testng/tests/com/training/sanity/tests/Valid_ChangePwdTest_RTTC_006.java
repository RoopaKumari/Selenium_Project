package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MyAccountPOM;
import com.training.pom.User_LoginCredentialsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Valid_ChangePwdTest_RTTC_006 {
	//This test script verifies whether application allows user to change the password in Change Your Password page.//
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
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		
	}
	
	
	@Test (priority=1)
	public void ValidChangePasswordTest() throws InterruptedException {
		User_LoginCredentialsPOM.sendemail("roopa.juvvala@in.ibm.com");
		User_LoginCredentialsPOM.sendPassword("Delhi22");
		User_LoginCredentialsPOM.clickLoginBtn(); 
		MyAccountPOM.clickChangePassword();
		MyAccountPOM.sendpassword("Delhi23");
		MyAccountPOM.sendconfirm("Delhi23");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		MyAccountPOM.clickContinueBtn();
		System.out.println("Password change status " +MyAccountPOM.PwdsucessgetText());
		screenShot.captureScreenShot("First");

		String Actual = MyAccountPOM.PwdsucessgetText();
		String Expected = "Sucess";
		assertTrue(MyAccountPOM.PwdsucessgetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");
		
	}
		
	
    @AfterMethod
        public void tearDown() throws Exception {
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   driver.quit();
   
 }
	
}