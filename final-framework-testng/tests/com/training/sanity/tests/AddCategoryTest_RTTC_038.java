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

public class AddCategoryTest_RTTC_038 {
	//This test script verifies whether application allows admin to add category in categories page//
	
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
	public void AddCategoryTest() throws InterruptedException, AWTException {
		Admin_LoginCredentialsPOM.sendUsername("admin");
		Admin_LoginCredentialsPOM.sendPassword("admin@123");
		Admin_LoginCredentialsPOM.clickLoginBtn();
		screenShot.captureScreenShot("Dashboard page validation sucess");
		//Above are steps for login//	
		
		
		CategoriesPOM.clickCatalog();
		screenShot.captureScreenShot("Catalog links are displayed");
		CategoriesPOM.clickCategories();
		screenShot.captureScreenShot("Categories contents are displayed");
		CategoriesPOM.clickAddNewBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Add Category page is opened");
		CategoriesPOM.sendCategoryName("ORNAMENTS");
		CategoriesPOM.sendCategoryDescription("ornaments for ladies");
		CategoriesPOM.sendMetaTagTitle("ORNAMENTS");
		CategoriesPOM.sendMetaTagDescription("ornaments for ladies");
		screenShot.captureScreenShot("New Category details are displayed");
		CategoriesPOM.clickSaveBtn();
		System.out.println("Newly added Categories status " +CategoriesPOM.CategoryAddsucessMsggetText());
		screenShot.captureScreenShot("Category Newly added Message is displayed");
	
		
		String Actual = CategoriesPOM.CategoryAddsucessMsggetText();
		String Expected = "Success";
		assertTrue(CategoriesPOM.CategoryAddsucessMsggetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");
		
    		}
		
	@AfterMethod
        public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   driver.quit();
	    }
}