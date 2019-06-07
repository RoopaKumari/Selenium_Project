package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
import com.training.pom.LoginPOM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase1 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM2 loginPOM2;
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
		loginPOM2 = new LoginPOM2(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(7000);
		
	}
	
	
	@Test (priority=1)
	public void ValidChangePasswordTest() throws InterruptedException {
		loginPOM2.sendemail("roopa.juvvala@in.ibm.com");
		loginPOM2.sendPassword("Delhi22");
		loginPOM2.clickLoginBtn(); 
		loginPOM2.clickChangePassword();
		loginPOM2.sendpassword("Delhi23");
		loginPOM2.sendconfirm("Delhi23");
		Thread.sleep(5000);
		loginPOM2.clickContinueBtn();
		System.out.println("Password change status " +loginPOM2.PwdsucessgetText());
		screenShot.captureScreenShot("First");

		System.out.println("Test is Passed with Expected output.");
    
		
	}
		
	
    @AfterMethod
        public void tearDown() throws Exception {
   		Thread.sleep(1000);
   driver.quit();
   
 }
	
}