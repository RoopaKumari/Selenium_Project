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
import org.testng.annotations.Test;

import com.training.dataproviders.TC069_DataProvider;
import com.training.generics.ScreenShot;
import com.training.pom.Admin_LoginCredentialsPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.ProductsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProduct_InvalidDetailsTest_RTTC_069 {


	//Test Objective :- This test scripts verifies whether application displays error message upon entering invalid details while adding a product//
	//Preconditions :- 1. user should launch the application by entering valid URL and 2. Login as admin.//
	
	
	private WebDriver driver;
	private String adminUrl;
	private Admin_LoginCredentialsPOM Admin_LoginCredentialsPOM;
	private CategoriesPOM CategoriesPOM;
	private ProductsPOM ProductsPOM;
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
		ProductsPOM = new ProductsPOM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		
	}

 @Test(dataProvider = "excel-inputs3", dataProviderClass = TC069_DataProvider.class)
	  
	 public void AddProduct_InvalidDetailsTest_RTTC_069(String ProductName1, String MetaTagTitle1, String Model1, String Price1, String Quantity1, String Categories) {	
		
		Admin_LoginCredentialsPOM.sendUsername("admin");
		Admin_LoginCredentialsPOM.sendPassword("admin@123");
		Admin_LoginCredentialsPOM.clickLoginBtn();
		screenShot.captureScreenShot("Dashboard page validation sucess");
		CategoriesPOM.clickCatalog();
		screenShot.captureScreenShot("Catalog links are displayed");
		ProductsPOM.clickProducts();
		screenShot.captureScreenShot("Products contents are displayed");
		ProductsPOM.clickAddNewPrdtBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Add Products page is opened");
		
		ProductsPOM.sendProductName1(ProductName1);
		ProductsPOM.sendMetaTagTitle1(MetaTagTitle1);
		ProductsPOM.clickDataTab();
		ProductsPOM.sendModel1(Model1);
		ProductsPOM.sendPrice1(Price1);
		ProductsPOM.sendQuantity1(Quantity1);
		ProductsPOM.clickLinksTab();
		ProductsPOM.sendCategories(Categories);
		screenShot.captureScreenShot("2Entered values are captured");
		ProductsPOM.clickSaveBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		System.out.println("Failed add product message " +ProductsPOM.ProductAddFailMsggetText());
		screenShot.captureScreenShot("Failed add product warning message is displayed");
	
	
		String Actual = ProductsPOM.ProductAddFailMsggetText();
		String Expected = "Warning:";
		assertTrue(ProductsPOM.ProductAddFailMsggetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");
		
				
	}
	@AfterMethod
        public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   driver.quit();
	    }
}




