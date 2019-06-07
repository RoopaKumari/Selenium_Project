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
import com.training.pom.Med_TC2_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Med_TC2 {
	private WebDriver driver; 
	private String adminUrl; 
	private Med_TC2_POM Med_TC2_POM;
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
		Med_TC2_POM = new Med_TC2_POM(driver); 
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
	}
	
	
	
	
	@Test(dataProvider="inputs")
	public void Admin_InvalidCredentials_Test(String userName, String password) throws InterruptedException {
		Med_TC2_POM.sendUsername(userName);
		Med_TC2_POM.sendPassword(password);
		Med_TC2_POM.clickLoginBtn(); 
		
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		System.out.println("Incorrect password error message is " +Med_TC2_POM.ErrorMsggetText());
		screenShot.captureScreenShot("First");
				
		String Actual = Med_TC2_POM.ErrorMsggetText();
		String Expected = "No match";
		assertTrue(Med_TC2_POM.ErrorMsggetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");	
	}
    	
    	@AfterMethod
        public void tearDown() throws Exception {
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   	driver.quit();	
		
		
	}
	
}
