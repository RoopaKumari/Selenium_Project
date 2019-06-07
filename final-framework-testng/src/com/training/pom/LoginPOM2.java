package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM2 {
	private WebDriver driver; 
	
	public LoginPOM2(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath=("//*[@id=\"System_nyHsmShk\"]/div/div[2]/div/form/div/div[2]/input"))
	private WebElement loginBtn; 
	
	@FindBy(xpath=("//*[@id=\"System_nyHsmShk\"]/align/ul/li[2]/a"))
	private WebElement ChangePassword;
	
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	private WebElement Password;
	
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	private WebElement confirm;
	
	@FindBy(xpath=("//*[@id=\"System_U70q4RMO\"]/form/div/div[2]/input"))
	private WebElement Continue;
	

	
	@FindBy(xpath=("//div[@class='alert alert-success']"))
	public WebElement Pwdsucess; 

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickChangePassword() {
		this.ChangePassword.click(); 
	}
	
	public void sendpassword(String password) {
		this.Password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void sendconfirm(String Confirm) {
		this.confirm.clear(); 
		this.confirm.sendKeys(Confirm); 
	}
		public void clickContinueBtn() {
		this.Continue.click(); 
	}
	
		public String PwdsucessgetText() {
	  return this.Pwdsucess.getText();
		}
	
	
}
