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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Admin_LoginCredentialsPOM;
import com.training.pom.CategoriesPOM;
import com.training.pom.ProductsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Admin_FilterProducts_ExcelTest_RTTC067 {

	//Test Objective :- This test scripts verifies whether application allows the admin to filter the product details with multiple values.//
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
  @Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void Admin_FilterProductsTest(String ProductName, String Price, String Status, String Model, String Quantity, String Image) {
  
		
		
		Admin_LoginCredentialsPOM.sendUsername("admin");
		Admin_LoginCredentialsPOM.sendPassword("admin@123");
		Admin_LoginCredentialsPOM.clickLoginBtn();
		screenShot.captureScreenShot("Dashboard page validation sucess");
		CategoriesPOM.clickCatalog();
		screenShot.captureScreenShot("Catalog links are displayed");
		ProductsPOM.clickProducts();
		screenShot.captureScreenShot("Products contents are displayed");
		ProductsPOM.sendProductName(ProductName);
		ProductsPOM.sendPrice(Price);
		ProductsPOM.sendStatus(Status);
		ProductsPOM.sendModel(Model);
		ProductsPOM.sendQuantity(Quantity);
		ProductsPOM.sendImage(Image);
		screenShot.captureScreenShot("Entered values are captured");
		ProductsPOM.clickFilterBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Products contents are displayed based on filtered criteria");
		System.out.println("Products contents are displayed based on filtered criteria");

	
		
	}
		
	@AfterMethod
        public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   driver.quit();
	    }
}

