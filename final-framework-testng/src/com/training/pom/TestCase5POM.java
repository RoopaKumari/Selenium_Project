


package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase5POM {
private WebDriver driver; 
	
	public TestCase5POM(WebDriver driver) {
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
	
    @FindBy(xpath=("//button[@title='Remove' and @class='btn btn-default btn-sm tb_no_text']"))
  	private WebElement RemoveBtn;
    
    @FindBy(xpath=("//*[@id=\"System_V2Exp1o9\"]/div[1]"))
	public WebElement ShpngCartMsg;
    
  /* @FindBy(xpath=("//div[@class='fa fa-times-circle']"))
	public WebElement RemoveBtn;*/
    
  /*@FindBy(xpath=("//i[@class='fa fa-refresh']"))
 	public WebElement RefreshBtn;*/
  
	 /* @FindBy(xpath=("//div[@class='btn btn-danger tb_no_text']")
	public WebElement RemoveBtn;*/
          
   /* @FindBy(xpath=("//i[@class='fa fa-times']"))
 	public WebElement RemoveBtn;*/
    
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
		public void clickRemoveBtn() {
			Actions action = new Actions(driver);
			action.moveToElement(RemoveBtn).click().build().perform();
			driver.findElement(By.xpath("//i[@class='fa fa-refresh']")).click();
			//this.RemoveBtn.click();
			
		}
		/*public void clickRefreshBtn() {
			Actions action = new Actions(driver);
			action.moveToElement(RefreshBtn).build().perform();
			action.moveToElement(RefreshBtn).click().build().perform();
						
		}*/
		
		
		public String ShpngCartMsggetText() {
		  return this.ShpngCartMsg.getText();
			}
}

