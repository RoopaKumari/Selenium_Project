package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Med_TC3_POM {
private WebDriver driver; 
	
	public Med_TC3_POM(WebDriver driver) {
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
	

	@FindBy(xpath=("//a//i[@class='fa fa-tags fw']"))
	private WebElement Catalog; 

	public void clickCatalog() {
		 Actions action = new Actions(driver);
			action.moveToElement(Catalog).click().build().perform();
			 
}
	
	@FindBy(linkText=("Categories"))
    private WebElement Categories;

	public void clickCategories() {
		 Actions action = new Actions(driver);
		action.moveToElement(Categories).click().build().perform();
			 
}
	
	@FindBy(xpath=("//a//i[@class='fa fa-plus']"))
	private WebElement AddNewBtn; 

	public void clickAddNewBtn() {
		 Actions action = new Actions(driver);
			action.moveToElement(AddNewBtn).click().build().perform();
			 
}
	@FindBy(id="input-name1")
	private WebElement CategoryName;

	public void sendCategoryName(String CategoryName) {
		this.CategoryName.clear(); 
		this.CategoryName.sendKeys(CategoryName); 
	}
	
	
	@FindBy(xpath=("//div[@class='note-editable panel-body']"))
		private WebElement CategoryDescription; 
	
	public void sendCategoryDescription(String CategoryDescription) {
		this.CategoryDescription.clear(); 
		this.CategoryDescription.sendKeys(CategoryDescription); 
	}
	@FindBy(id="input-meta-title1")
	private WebElement MetaTagTitle;

	public void sendMetaTagTitle(String MetaTagTitle) {
		this.MetaTagTitle.clear(); 
		this.MetaTagTitle.sendKeys(MetaTagTitle); 
	}
	@FindBy(id="input-meta-description1")
	private WebElement MetaTagDescription;

	public void sendMetaTagDescription(String MetaTagDescription) {
		this.MetaTagDescription.clear(); 
		this.MetaTagDescription.sendKeys(MetaTagDescription); 
	}
	
	@FindBy(xpath=("//div//i[@class='fa fa-save']"))
	public WebElement SaveBtn;
	
	public void clickSaveBtn() {
		 Actions action = new Actions(driver);
			action.moveToElement(SaveBtn).click().build().perform();
}
	
	@FindBy(xpath=("//div[@class='alert alert-success']"))
	public WebElement CategoryAddsucessMsg;	
	
	public String CategoryAddsucessMsggetText() {
		  return this.CategoryAddsucessMsg.getText();
			}
		
}
