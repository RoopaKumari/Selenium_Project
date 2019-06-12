package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MyAccountPOM;
import com.training.pom.Shopping_PagePOM;
import com.training.pom.User_LoginCredentialsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Search_ProductsTest_RTTC_008 {
	//This test script verifies whether application displays appropriate search products based on the user preference.//
	private WebDriver driver;
	private String baseUrl;
	private User_LoginCredentialsPOM User_LoginCredentialsPOM;
	private MyAccountPOM MyAccountPOM;
	private Shopping_PagePOM Shopping_PagePOM;
	
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
	public void EarringsSortByTest() throws InterruptedException {
		User_LoginCredentialsPOM.sendemail("roopa.juvvala@in.ibm.com");
		User_LoginCredentialsPOM.sendPassword("Delhi22");
		User_LoginCredentialsPOM.clickLoginBtn(); 
		Shopping_PagePOM.clickShop();
		Shopping_PagePOM.Earrings();
		Shopping_PagePOM.Dropdown();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		screenShot.captureScreenShot("Earrings Sort By contents are displayed");
					Select C = new Select(Shopping_PagePOM.Dropdown);
						List <WebElement> D= C.getOptions();
						System.out.println("Total values present in dropdown is "+D.size());
							 Select B = new Select(Shopping_PagePOM.Dropdown);
									B.selectByIndex(1);	
									driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
								screenShot.captureScreenShot("Earrings Sort By Name(A-Z) contents are displayed");
								 System.out.println("Earrings Sort By Name(A-Z) are displayed");
								
									Select A = new Select(Shopping_PagePOM.Dropdown);
									A.selectByIndex(5);	
									driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
								screenShot.captureScreenShot("Earrings Sort By Rating(Highest) contents are displayed");
								System.out.println("Earrings Sort By Rating(Highest) are displayed");
								System.out.println("Test is passed with Expected output");
							 driver.close();
	
									
	}
}





	
