package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM5 {
	private WebDriver driver; 
	
	public LoginPOM5(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

		
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath=("//*[@id=\"System_nyHsmShk\"]/div/div[2]/div/form/div/div[2]/input"))
	private WebElement loginBtn; 
	
	@FindBy(id=("button-cart"))
	private WebElement AddToCartBtn;
			
    @FindBy(xpath=("//*[@id=\"menu_all_categories_Menu_VIfWm2LT_VLHXC\"]/a/span"))
    private WebElement Shop;

    @FindBy(linkText=("Earrings"))
    private WebElement Earrings;

   

    @FindBy(xpath=("//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[1]/div/div[3]/div/div/div[1]/h4/a"))
    private WebElement IntVitaelaculisMassa;

    @FindBy(xpath=("//*[@id=\"cart\"]/ul/li/h3/a/i"))
    private WebElement CartBag;

    @FindBy(linkText=("View Cart"))
    private WebElement ViewCart;
	
   
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
	
		
		public void IntVitaelaculisMassa() {
			  Actions action = new Actions(driver);
			action.moveToElement(IntVitaelaculisMassa).click().build().perform();
			
			}
		
		public void clickAddToCartBtn() {
			this.AddToCartBtn.click(); 
		}
		
		public void CartBag() {
		  Actions action = new Actions(driver);
		action.moveToElement(CartBag).build().perform();
	

		}
		public void ViewCart() {
		  Actions action = new Actions(driver);
		action.moveToElement(ViewCart).click().build().perform();
		

}
		
}

