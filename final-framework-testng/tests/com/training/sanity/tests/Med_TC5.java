package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
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

import com.training.pom.Med_TC5_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Med_TC5 {
	private WebDriver driver;
	private String adminUrl;
	private Med_TC5_POM Med_TC5_POM;
	
	

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
		Med_TC5_POM = new Med_TC5_POM(driver); 
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		
	}
	@Test (priority=1)
	public void DeleteCategoryTest() throws InterruptedException, AWTException {
		Med_TC5_POM.sendUsername("admin");
		Med_TC5_POM.sendPassword("admin@123");
		Med_TC5_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("Dashboard page validation sucess");
		//Above are steps for login//	
		
		
		Med_TC5_POM.clickCatalog();
		screenShot.captureScreenShot("2Catalog links are displayed");
		Med_TC5_POM.clickCategories();
		screenShot.captureScreenShot("2Categories contents are displayed");
		Med_TC5_POM.clickSelectedCategory();
		screenShot.captureScreenShot("2Selected category checkbox is checked");
		Med_TC5_POM.clickDeleteBtn();
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Deleted category pop -up window is displayed");
		
		//Below command is click on OK of the Pop-window opened//
		driver.switchTo().alert().accept();
				
		//Below print message is to get confirmation that category is deleted//
		System.out.println("Catalog delete status " +Med_TC5_POM.CategoryDeletesucessMsggetText());
		screenShot.captureScreenShot("Deleted category is removed from the category list");
		System.out.println("Deleted category is removed from the category list");
				
		
		String Actual = Med_TC5_POM.CategoryDeletesucessMsggetText();
		String Expected = "Success";
		assertTrue(Med_TC5_POM.CategoryDeletesucessMsggetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");
			}
		
	@AfterMethod
        public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   driver.quit();
		
	}
}

