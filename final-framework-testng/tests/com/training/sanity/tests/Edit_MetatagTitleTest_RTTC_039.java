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
import com.training.pom.Admin_LoginCredentialsPOM;
import com.training.pom.CategoriesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Edit_MetatagTitleTest_RTTC_039 {
	//This test script verifies whether application allows admin to Edit Meta tag Title in categories page//
	private WebDriver driver;
	private String adminUrl;
	private Admin_LoginCredentialsPOM Admin_LoginCredentialsPOM;
	private CategoriesPOM CategoriesPOM;

	

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
		Admin_LoginCredentialsPOM = new Admin_LoginCredentialsPOM(driver); 
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		
	}
	@Test (priority=1)
	public void ModifyCategoryTest() throws InterruptedException, AWTException {
		Admin_LoginCredentialsPOM.sendUsername("admin");
		Admin_LoginCredentialsPOM.sendPassword("admin@123");
		Admin_LoginCredentialsPOM.clickLoginBtn(); 
		//Above are steps for login//	
		
		screenShot.captureScreenShot("Dashboard page validation sucess");
		CategoriesPOM.clickCatalog();
		screenShot.captureScreenShot("1Catalog links are displayed");
		CategoriesPOM.clickCategories();
		screenShot.captureScreenShot("1Categories contents are displayed");
		CategoriesPOM.clickSelectedCategory();
		screenShot.captureScreenShot("1Selected category checkbox is checked");
		CategoriesPOM.clickEditBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	// Below is the new value for MetaTagTitle//	
		CategoriesPOM.sendMetaTagTitle("ORNAMENTS55555");
		CategoriesPOM.sendMetaTagDescription("ornaments for ladies");
		screenShot.captureScreenShot("MetaTagTitle details are modified");
		CategoriesPOM.clickSaveBtn();
			
	// Modified MegaTagTitle value is printed here//
		System.out.println("MetaTagTitle Modification Status" +CategoriesPOM.CategoryModifysucessMsggetText());
		screenShot.captureScreenShot("Category Newly added Message is displayed");

				
		String Actual = CategoriesPOM.CategoryModifysucessMsggetText();
		String Expected = "Success";
		assertTrue(CategoriesPOM.CategoryModifysucessMsggetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");
    
			}
		
	@AfterMethod
        public void tearDown() throws Exception {
   		Thread.sleep(1000);
   driver.quit();
		
	}

}

