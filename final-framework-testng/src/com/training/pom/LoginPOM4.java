package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM4 {
	private WebDriver driver; 
	
	public LoginPOM4(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath=("//*[@id=\"System_nyHsmShk\"]/div/div[2]/div/form/div/div[2]/input"))
	private WebElement loginBtn; 
	
	@FindBy(xpath=("//*[@id=\"menu_all_categories_Menu_VIfWm2LT_VLHXC\"]/a/span"))
    private WebElement Shop;

    @FindBy(linkText=("Earrings"))
    private WebElement Earrings;

    @FindBy(xpath="//*[@id=\"ProductsSystem_QQI8r357\"]/nav/div/div[3]/select")
	public static WebElement Dropdown;

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
	public void Earrings() {
		  Actions action = new Actions(driver);
		action.moveToElement(Earrings).click().build().perform();
	}
		public void clickShop() {
		  Actions action = new Actions(driver);
		action.moveToElement(Shop).click().build().perform();
		
		}
	public void Dropdown() {
		  Actions action = new Actions(driver);
		action.moveToElement(Dropdown).click().build().perform();
		this.Dropdown.click();
}
}
