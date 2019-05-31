package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.LoginPOM4;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase3 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM4 loginPOM4;
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
		loginPOM4 = new LoginPOM4(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(7000);
		
	}
	@Test (priority=1)
	public void EarringsSortByTest() throws InterruptedException {
		loginPOM4.sendemail("roopa.juvvala@in.ibm.com");
		loginPOM4.sendPassword("Delhi22");
		loginPOM4.clickLoginBtn(); 
		loginPOM4.clickShop();
		loginPOM4.Earrings();
		loginPOM4.Dropdown();
		Thread.sleep(5000);
		screenShot.captureScreenShot("Earrings Sort By contents are displayed");
					Select C = new Select(LoginPOM4.Dropdown);
						List <WebElement> D= C.getOptions();
						System.out.println("Total values present in dropdown is "+D.size());
							 Select B = new Select(LoginPOM4.Dropdown);
									B.selectByIndex(1);	
								Thread.sleep(5000);
								screenShot.captureScreenShot("Earrings Sort By Name(A-Z) contents are displayed");
								 System.out.println("Earrings Sort By Name(A-Z) are displayed");
								
									Select A = new Select(LoginPOM4.Dropdown);
									A.selectByIndex(5);	
								Thread.sleep(5000);
								screenShot.captureScreenShot("Earrings Sort By Rating(Highest) contents are displayed");
								System.out.println("Earrings Sort By Rating(Highest) are displayed");
								System.out.println("Test is passed with Expected output");
							 driver.close();
	
									
	}
}





	
