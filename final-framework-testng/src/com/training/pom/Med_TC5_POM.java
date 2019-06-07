package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Med_TC5_POM {
private WebDriver driver; 
	
	public Med_TC5_POM(WebDriver driver) {
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
	@FindBy(xpath=("//tbody//tr[3]//td[1]"))
	public WebElement SelectedCategory; 
	
	public void clickSelectedCategory() {
		 Actions action = new Actions(driver);
		this.SelectedCategory.click();
			 
}
	
	@FindBy(xpath=("//div//i[@class='fa fa-trash-o']"))
	public WebElement DeleteBtn;
	
	public void clickDeleteBtn() {
		 Actions action = new Actions(driver);
			action.moveToElement(DeleteBtn).click().build().perform();
}
	
	@FindBy(xpath=("//div[@class='alert alert-success']"))
	public WebElement CategoryDeletesucessMsg;	
	
	public String CategoryDeletesucessMsggetText() {
		  return this.CategoryDeletesucessMsg.getText();

}
}
	
	
	
	
	
	
	
	
	
	
	

