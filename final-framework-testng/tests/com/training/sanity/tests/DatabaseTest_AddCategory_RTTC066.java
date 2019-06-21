package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.DbTesting_CategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DatabaseTest_AddCategory_RTTC066 {
	//This test script verifies whether application allows admin to add category in categories page//
	
		private WebDriver driver;
		private String adminUrl;
		private DbTesting_CategoryPOM DbTesting_CategoryPOM;
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
			DbTesting_CategoryPOM = new DbTesting_CategoryPOM(driver); 
			adminUrl = properties.getProperty("adminURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(adminUrl);
			driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
			
		}
		
				
		@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
		public void DatabaseTest_AddCategory_RTTC066(String UserName, String Password, String CategoryName, String CategoryDescription,  String MetaTagTitle, String MetaTagDescription) {
			DbTesting_CategoryPOM.sendUserName("admin");
			String USERNAME = DbTesting_CategoryPOM.getUserName(); //To fetch Username values from application.  

			DbTesting_CategoryPOM.sendPassword("admin@123");
			String PASSWORD = DbTesting_CategoryPOM.getPassword(); //To fetch Password values from application. 
			DbTesting_CategoryPOM.clickLoginBtn();
			screenShot.captureScreenShot("Dashboard page validation sucess");
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			DbTesting_CategoryPOM.clickCatalog();
			screenShot.captureScreenShot("Catalog links are displayed");
			DbTesting_CategoryPOM.clickCategories();
			screenShot.captureScreenShot("Categories contents are displayed");
			DbTesting_CategoryPOM.clickAddNewBtn();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			screenShot.captureScreenShot("Add Category page is opened");
			DbTesting_CategoryPOM.sendCategoryName("ORNAMENTS");
			String CATEGORYNAME = DbTesting_CategoryPOM.getCategoryName(); //To fetch Password values from application.
			DbTesting_CategoryPOM.sendCategoryDescription("ornaments for ladies");
			String CATEGORYDESCRIPTION = DbTesting_CategoryPOM.getCategoryDescription(); //To fetch Password values from application.
			DbTesting_CategoryPOM.sendMetaTagTitle("ORNAMENTS");
			String METATAGTITLE = DbTesting_CategoryPOM.getMetaTagTitle(); //To fetch Password values from application.
			DbTesting_CategoryPOM.sendMetaTagDescription("ornaments for ladies");
			String METATAGDESCRIPTION = DbTesting_CategoryPOM.getMetaTagDescription(); //To fetch Password values from application.
			screenShot.captureScreenShot("New Category details are displayed");
			DbTesting_CategoryPOM.clickSaveBtn();
			System.out.println("Newly added Categories status " +DbTesting_CategoryPOM.CategoryAddsucessMsggetText());
			screenShot.captureScreenShot("Category Newly added Message is displayed");
		
			
			Assert.assertEquals(USERNAME, UserName);
			Assert.assertEquals(PASSWORD, Password);

			Assert.assertEquals(CATEGORYNAME, CategoryName);
			Assert.assertEquals(CATEGORYDESCRIPTION, CategoryDescription);

			Assert.assertEquals(METATAGTITLE, MetaTagTitle);
			Assert.assertEquals(METATAGDESCRIPTION, MetaTagDescription);
		}
			
		@AfterMethod
	        public void tearDown() throws Exception {
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.quit();
		    }
		}
	

