package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Med_TC2_POM {
private WebDriver driver; 
	
	public Med_TC2_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-username")
	private WebElement Username;

	public void sendUsername(String Username) {
		this.Username.clear();
		this.Username.sendKeys(Username);
	}


	@FindBy(id="input-password")
	private WebElement password;

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}


	@FindBy(xpath=("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button"))
	private WebElement loginBtn; 

	public void clickLoginBtn() {
		this.loginBtn.click(); 
}
	
	@FindBy(xpath=("//div[@class='alert alert-danger']"))
	public WebElement ErrorMsg; 
	
		public String ErrorMsggetText() {
		  return this.ErrorMsg.getText();
			}
}
