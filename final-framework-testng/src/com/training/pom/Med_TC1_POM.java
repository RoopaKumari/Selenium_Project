package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Med_TC1_POM {

private WebDriver driver; 

public Med_TC1_POM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}

	
@FindBy(id="input-email")
private WebElement email;

public void sendemail(String email) {
	this.email.clear();
	this.email.sendKeys(email);
}


@FindBy(name="password")
private WebElement password;

public void sendPassword(String password) {
	this.password.clear(); 
	this.password.sendKeys(password); 
}


@FindBy(xpath=("//*[@id=\"System_nyHsmShk\"]/div/div[2]/div/form/div/div[2]/input"))
private WebElement loginBtn; 

public void clickLoginBtn() {
	this.loginBtn.click(); 
}


@FindBy(xpath=("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a/span/span/i"))
public WebElement User;

public void clickUser() throws InterruptedException {
//Thread.sleep(3000);	
	Actions action = new Actions(driver);
	action.moveToElement(User).click().build().perform();
	
	}


@FindBy(xpath=("//*[@id=\"System_nyHsmShk\"]/ul/li[1]/a"))
private WebElement ViewOrderHistry;

public void clickViewOrderHistry() {
	this.ViewOrderHistry.click(); 
}


/*@FindBy(xpath=("//*[contains(text(),'MY ORDERS')]"))
public WebElement MyOrders;

public void clickMyOrders() throws InterruptedException {
	Actions action = new Actions(driver);  
	action.moveToElement(MyOrders).click().build().perform();
	Thread.sleep(3000);
	}*/

@FindBy(xpath=("//*[@id=\"System_s3bhXNDb\"]/div[1]/table/tbody/tr/td[7]/a/i"))
private WebElement ViewBtn;

public void clickViewBtn() {
	  Actions action = new Actions(driver);
	action.moveToElement(ViewBtn).click().build().perform();
	
	}

@FindBy(xpath=("//*[@id=\"System_s3bhXNDb\"]/div/div[1]/table/tbody/tr/td[6]/a[2]/i"))
private WebElement ReturnBtn;

public void clickReturnBtn() {
	  Actions action = new Actions(driver);
	action.moveToElement(ReturnBtn).click().build().perform();
	
	}

@FindBy(xpath=("//*[@id=\"return_request_form\"]/fieldset[2]/div[4]/div/div[1]/label/input"))
private WebElement ReasonRadionBtn;

public void clickReasonRadionBtn() {
	  Actions action = new Actions(driver);
	action.moveToElement(ReasonRadionBtn).click().build().perform();
	
	}


@FindBy(xpath=("//*[@id=\"return_request_form\"]/fieldset[2]/div[5]/div/label[1]/input"))
private WebElement PdtOpenedRadionBtn;

public void clickPdtOpenedRadionBtn() {
	  Actions action = new Actions(driver);
	action.moveToElement(PdtOpenedRadionBtn).click().build().perform();
	
	}



@FindBy(name="comment")
private WebElement comment;



public void sendcomment(String comment) {
	this.comment.clear();
	this.comment.sendKeys(comment);
}


@FindBy(xpath=("//*[@id=\"return_request_form\"]/div/div/input"))
private WebElement SubmitBtn; 

public void clickSubmitBtn() {
	this.SubmitBtn.click(); 
}
	
@FindBy(xpath=("//div[@class='tb_text_wrap tb_sep']"))
public WebElement FinalText; 

public String FinalTextgetText() {
	  return this.FinalText.getText();
		}
	
		
}



