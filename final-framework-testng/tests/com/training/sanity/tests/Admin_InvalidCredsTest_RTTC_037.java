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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Admin_LoginCredentialsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Admin_InvalidCredsTest_RTTC_037 {
	//This test script verifies whether application denies admin getting logged in upon entering invalid credentials in required fields//
	private WebDriver driver; 
	private String adminUrl; 
	private Admin_LoginCredentialsPOM Admin_LoginCredentialsPOM;
	private static Properties properties; 
	private ScreenShot screenShot; 


	@DataProvider(name="inputs")
	public Object[][] getData() {
		return new Object[][] {
			{"admin", "123456"},
			{"admin", "admin"},
			{"manzoor", "admin@123"},
			{"admin@123", "admin@123"},
		};
	}

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Admin_LoginCredentialsPOM = new Admin_LoginCredentialsPOM(driver); 
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
	}
	
	
	
	
	@Test(dataProvider="inputs")
	public void Admin_InvalidCredentials_Test(String userName, String password) throws InterruptedException {
		Admin_LoginCredentialsPOM.sendUsername(userName);
		Admin_LoginCredentialsPOM.sendPassword(password);
		Admin_LoginCredentialsPOM.clickLoginBtn(); 
		
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		System.out.println("Incorrect password error message is " +Admin_LoginCredentialsPOM.ErrorMsggetText());
		screenShot.captureScreenShot("First");
				
		String Actual = Admin_LoginCredentialsPOM.ErrorMsggetText();
		String Expected = "No match";
		assertTrue(Admin_LoginCredentialsPOM.ErrorMsggetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");	
	}
    	
    	@AfterMethod
        public void tearDown() throws Exception {
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   	driver.quit();	
		
		
	}
	
}
