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

import com.training.pom.Med_TC3_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Med_TC3 {
	private WebDriver driver;
	private String adminUrl;
	private Med_TC3_POM Med_TC3_POM;
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
		Med_TC3_POM = new Med_TC3_POM(driver); 
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		
	}
	@Test (priority=1)
	public void AddCategoryTest() throws InterruptedException, AWTException {
		Med_TC3_POM.sendUsername("admin");
		Med_TC3_POM.sendPassword("admin@123");
		Med_TC3_POM.clickLoginBtn();
		screenShot.captureScreenShot("Dashboard page validation sucess");
		//Above are steps for login//	
		
		
		Med_TC3_POM.clickCatalog();
		screenShot.captureScreenShot("Catalog links are displayed");
		Med_TC3_POM.clickCategories();
		screenShot.captureScreenShot("Categories contents are displayed");
		Med_TC3_POM.clickAddNewBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Add Category page is opened");
		Med_TC3_POM.sendCategoryName("ORNAMENTS");
		Med_TC3_POM.sendCategoryDescription("ornaments for ladies");
		Med_TC3_POM.sendMetaTagTitle("ORNAMENTS");
		Med_TC3_POM.sendMetaTagDescription("ornaments for ladies");
		screenShot.captureScreenShot("New Category details are displayed");
		Med_TC3_POM.clickSaveBtn();
		System.out.println("Newly added Categories status " +Med_TC3_POM.CategoryAddsucessMsggetText());
		screenShot.captureScreenShot("Category Newly added Message is displayed");
	
		
		String Actual = Med_TC3_POM.CategoryAddsucessMsggetText();
		String Expected = "Success";
		assertTrue(Med_TC3_POM.CategoryAddsucessMsggetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");
		
    		}
		
	@AfterMethod
        public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   driver.quit();
	    }
}