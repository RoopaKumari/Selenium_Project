package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM2;
import com.training.pom.LoginPOM3;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase2 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM3 loginPOM3;
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
		loginPOM3 = new LoginPOM3(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@Test (priority=1)
	public void InvalidChangePasswordTest() throws InterruptedException {
		loginPOM3.sendemail("roopa.juvvala@in.ibm.com");
		loginPOM3.sendPassword("Delhi22");
		loginPOM3.clickLoginBtn(); 
		loginPOM3.clickChangePassword();
		loginPOM3.sendpassword("Delhi");
		loginPOM3.sendconfirm("Delha");
		loginPOM3.clickContinueBtn();
		Thread.sleep(5000);
		System.out.println("Password change status " +loginPOM3.PwdFailgetText());
		screenShot.captureScreenShot("First");
    	Thread.sleep(7000);
    	System.out.println("Test is Passed with Expected output.");
	}
    	
    	@AfterMethod
        public void tearDown() throws Exception {
   		Thread.sleep(1000);
   	driver.quit();
   
 }
 }

