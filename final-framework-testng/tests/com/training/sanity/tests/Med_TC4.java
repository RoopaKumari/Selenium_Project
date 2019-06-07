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
import com.training.pom.Med_TC4_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Med_TC4 {
	private WebDriver driver;
	private String adminUrl;
	private Med_TC4_POM Med_TC4_POM;
	
	

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
		Med_TC4_POM = new Med_TC4_POM(driver); 
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		
	}
	@Test (priority=1)
	public void ModifyCategoryTest() throws InterruptedException, AWTException {
		Med_TC4_POM.sendUsername("admin");
		Med_TC4_POM.sendPassword("admin@123");
		Med_TC4_POM.clickLoginBtn(); 
		//Above are steps for login//	
		
		screenShot.captureScreenShot("Dashboard page validation sucess");
		Med_TC4_POM.clickCatalog();
		screenShot.captureScreenShot("1Catalog links are displayed");
		Med_TC4_POM.clickCategories();
		screenShot.captureScreenShot("1Categories contents are displayed");
		Med_TC4_POM.clickSelectedCategory();
		screenShot.captureScreenShot("1Selected category checkbox is checked");
		Med_TC4_POM.clickEditBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	// Below is the new value for MetaTagTitle//	
		Med_TC4_POM.sendMetaTagTitle("ORNAMENTS55555");
		Med_TC4_POM.sendMetaTagDescription("ornaments for ladies");
		screenShot.captureScreenShot("MetaTagTitle details are modified");
		Med_TC4_POM.clickSaveBtn();
			
	// Modified MegaTagTitle value is printed here//
		System.out.println("MetaTagTitle Modification Status" +Med_TC4_POM.CategoryModifysucessMsggetText());
		screenShot.captureScreenShot("Category Newly added Message is displayed");

				
		String Actual = Med_TC4_POM.CategoryModifysucessMsggetText();
		String Expected = "Success";
		assertTrue(Med_TC4_POM.CategoryModifysucessMsggetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");
    
			}
		
	@AfterMethod
        public void tearDown() throws Exception {
   		Thread.sleep(1000);
   driver.quit();
		
	}

}

