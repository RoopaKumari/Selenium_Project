package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPOM {
private WebDriver driver; 
	
	public CategoriesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
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
	@FindBy(xpath=("//tbody//tr[2]//td[1]"))
	public WebElement SelectedCategory; 
	
	public void clickSelectedCategory() {
		 Actions action = new Actions(driver);
		this.SelectedCategory.click();
			 
}
	
	@FindBy(xpath=("//a//i[@class='fa fa-pencil']"))
	private WebElement EditBtn; 

	public void clickEditBtn() {
		 Actions action = new Actions(driver);
			action.moveToElement(EditBtn).click().build().perform();
			 
}
	
	
	@FindBy(xpath=("//div[@class='alert alert-success']"))
	public WebElement CategoryModifysucessMsg;	
	
	public String CategoryModifysucessMsggetText() {
		  return this.CategoryModifysucessMsg.getText();
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

