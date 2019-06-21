package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPOM {
private WebDriver driver; 
	
	public ProductsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
@FindBy(xpath=("//*[@id=\"menu-catalog\"]/ul/li[2]/a"))
public WebElement Products;

public void clickProducts() {
	 Actions action = new Actions(driver);
		action.moveToElement(Products).click().build().perform();
}

@FindBy(id="input-name")
private WebElement ProductName; 

public void sendProductName(String ProductName) {
		this.ProductName.sendKeys(ProductName);
}

@FindBy(id="input-price")
private WebElement Price; 

public void sendPrice(String Price) {
	this.Price.clear();
	this.Price.sendKeys(Price);
}

@FindBy(id="input-status")
private WebElement Status; 

public void sendStatus(String Status) {
	this.Status.sendKeys(Status);
}

@FindBy(id="input-model")
private WebElement Model; 

public void sendModel(String Model) {
	this.Model.clear();
	this.Model.sendKeys(Model);
}


@FindBy(id="input-quantity")
private WebElement Quantity; 

public void sendQuantity(String Quantity) {
	this.Quantity.clear();
	this.Quantity.sendKeys(Quantity);
}

@FindBy(id="input-image")
private WebElement Image; 

public void sendImage(String Image) {
	this.Image.sendKeys(Image);
}

@FindBy(id="button-filter")
private WebElement FilterBtn; 

public void clickFilterBtn() {
	Actions action = new Actions(driver);
	action.moveToElement(FilterBtn).click().build().perform();
}

@FindBy(xpath=("//a//i[@class='fa fa-plus']"))
private WebElement AddNewPrdtBtn; 

public void clickAddNewPrdtBtn() {
	 Actions action = new Actions(driver);
		action.moveToElement(AddNewPrdtBtn).click().build().perform();
		 
}
@FindBy(id="input-name1")
private WebElement ProductName1;

public void sendProductName1(String ProductName1) {
	this.ProductName1.clear(); 
	this.ProductName1.sendKeys(ProductName1); 
}


/*@FindBy(xpath=("//div[@class='note-editable panel-body']"))
	private WebElement ProductDescription; 

public void sendProductDescription(String ProductDescription) {
	this.ProductDescription.clear(); 
	this.ProductDescription.sendKeys(ProductDescription); 
}*/

@FindBy(id="input-meta-title1")
private WebElement MetaTagTitle1;

public void sendMetaTagTitle1(String MetaTagTitle1) {
	this.MetaTagTitle1.clear(); 
	this.MetaTagTitle1.sendKeys(MetaTagTitle1); 
}

@FindBy(xpath=("//*[@id=\"form-product\"]/ul/li[2]/a"))
private WebElement DataTab; 

public void clickDataTab() {
	Actions action = new Actions(driver);
	action.moveToElement(DataTab).click().build().perform();
}

@FindBy(id="input-model")
private WebElement Model1; 

public void sendModel1(String Model1) {
	this.Model1.clear();
	this.Model1.sendKeys(Model1);
}
@FindBy(id="input-price")
private WebElement Price1; 

public void sendPrice1(String Price1) {
	this.Price1.clear();
	this.Price1.sendKeys(Price1);
}
@FindBy(id="input-quantity")
private WebElement Quantity1; 

public void sendQuantity1(String Quantity1) {
	this.Quantity1.clear();
	this.Quantity1.sendKeys(Quantity1);
}

@FindBy(xpath=("//*[@id=\"form-product\"]/ul/li[3]/a"))
private WebElement LinksTab; 

public void clickLinksTab() {
	Actions action = new Actions(driver);
	action.moveToElement(LinksTab).click().build().perform();
}
@FindBy(id="input-category")
private WebElement Categories; 

public void sendCategories(String Categories) {
	this.Categories.clear();
	this.Categories.sendKeys(Categories);
}


@FindBy(xpath=("//div//i[@class='fa fa-save']"))
public WebElement SaveBtn;

public void clickSaveBtn() {
	 Actions action = new Actions(driver);
		action.moveToElement(SaveBtn).click().build().perform();
}

@FindBy(xpath=("//div[@class='alert alert-success']"))
public WebElement ProductAddsucessMsg;	

public String ProductAddsucessMsggetText() {
	  return this.ProductAddsucessMsg.getText();
		}

@FindBy(xpath=("//div[@class='alert alert-danger']"))
public WebElement ProductAddFailMsg;	

public String ProductAddFailMsggetText() {
	  return this.ProductAddFailMsg.getText();
		}

}