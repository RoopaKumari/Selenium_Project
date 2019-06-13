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

public class Delete_CategoryTest_RTTC_040 {
	//This test script verifies whether application allows admin to delete multiple category from categories list//
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
		CategoriesPOM = new CategoriesPOM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		
	}
	@Test (priority=1)
	public void DeleteCategoryTest() throws InterruptedException, AWTException {
		Admin_LoginCredentialsPOM.sendUsername("admin");
		Admin_LoginCredentialsPOM.sendPassword("admin@123");
		Admin_LoginCredentialsPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Dashboard page validation sucess");
		//Above are steps for login//	
		
		
		CategoriesPOM.clickCatalog();
		screenShot.captureScreenShot("2Catalog links are displayed");
		CategoriesPOM.clickCategories();
		screenShot.captureScreenShot("2Categories contents are displayed");
		CategoriesPOM.clickSelectedCategory();
		screenShot.captureScreenShot("2Selected category checkbox is checked");
		CategoriesPOM.clickDeleteBtn();
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Deleted category pop -up window is displayed");
		
		//Below command is click on OK of the Pop-window opened//
		driver.switchTo().alert().accept();
				
		//Below print message is to get confirmation that category is deleted//
		System.out.println("Catalog delete status " +CategoriesPOM.CategoryDeletesucessMsggetText());
		screenShot.captureScreenShot("Deleted category is removed from the category list");
		System.out.println("Deleted category is removed from the category list");
				
		
		String Actual = CategoriesPOM.CategoryDeletesucessMsggetText();
		String Expected = "Success";
		assertTrue(CategoriesPOM.CategoryDeletesucessMsggetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");
			}
		
	@AfterMethod
        public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   driver.quit();
		
	}
}

