package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
/*import org.testng.annotations.AfterMethod;*/
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.MyAccountPOM;
import com.training.pom.User_LoginCredentialsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Return_Ordered_ProductTest_RTTC_036 {
	
	//This test script verifies whether application allows the user to return ordered product//
	
	private WebDriver driver;
	private String baseUrl;
	private MyAccountPOM MyAccountPOM;
	private User_LoginCredentialsPOM User_LoginCredentialsPOM;
	
	

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
		User_LoginCredentialsPOM = new User_LoginCredentialsPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		}
	
	@Test (priority=1)
	public void ReturnOrderTest() throws InterruptedException, AWTException {
		User_LoginCredentialsPOM.sendemail("roopa.juvvala@in.ibm.com");
		User_LoginCredentialsPOM.sendPassword("Delhi22");
		User_LoginCredentialsPOM.clickLoginBtn(); 
	//Above are steps for login//	
		
		
		MyAccountPOM.clickUser();
		screenShot.captureScreenShot("MyAccount_MyOrders_Logout are displayed");
		System.out.println("MyAccount,MyOrders and Logout are displayed");
		
		

    /*Actions action = new Actions(this.driver);
     action.moveToElement(MyAccountPOM.User).click().build().perform();
     action.sendKeys("MY ORDER", Keys.ARROW_DOWN);
     action.sendKeys("MY ORDER").click().build().perform();*/
	/*Med_TC1_POM.clickMyOrders();*/
	
	// **********Added clickViewOrderHistory method as a workaround as MyOrders click have object identification problem***************//
	
		MyAccountPOM.clickViewOrderHistry();
		screenShot.captureScreenShot("Order id_Customer_No of Products_ Status_Total_Date Added are displayed are displayed");
		System.out.println("Order id, Customer, No of Products, Status, Total and Date Added are displayed are displayed");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		MyAccountPOM.clickViewBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Ordered Product details are displayed");
		System.out.println("Ordered Product details are displayed");
		
	//Below steps are to return an order//
		
		MyAccountPOM.clickReturnBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Ordered information and Product Information details are displayed");
		System.out.println("Ordered information and Product Information details are displayed");
		
		MyAccountPOM.clickReasonRadionBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Dead on arrival Radio button is set");
		System.out.println("Dead on arrival Radio button is set");
		
		MyAccountPOM.clickPdtOpenedRadionBtn();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Yes of Product is opened category is selected");
		System.out.println("Yes of Product is opened category is selected");
		
		MyAccountPOM.sendcomment("Product is faulty");
		MyAccountPOM.clickSubmitBtn(); 
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	//Below loc is to get the final text after successful return order//
		
		MyAccountPOM.FinalTextgetText(); 
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		System.out.println("Order return status " +MyAccountPOM.FinalTextgetText());
		screenShot.captureScreenShot("Order return status captured");
		
		String PdReturnStatus = MyAccountPOM.FinalTextgetText();
		String Expected = "Thanking";
    	assertTrue(MyAccountPOM.FinalTextgetText().contains(Expected));
		System.out.println("Test is Passed with Expected output.");
	}
    	
    	@AfterMethod
        public void tearDown() throws Exception {
    		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   		
   	driver.quit();
   	
    	}
}
		
	

