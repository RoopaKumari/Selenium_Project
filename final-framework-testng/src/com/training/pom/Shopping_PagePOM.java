package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Shopping_PagePOM {

private WebDriver driver; 
	
	public Shopping_PagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//*[@id=\"menu_all_categories_Menu_VIfWm2LT_VLHXC\"]/a/span"))
    private WebElement Shop;

public void clickShop() {
		  Actions action = new Actions(driver);
		action.moveToElement(Shop).click().build().perform();
		
		}


    @FindBy(linkText=("Earrings"))
    private WebElement Earrings;

public void Earrings() {
		  Actions action = new Actions(driver);
		action.moveToElement(Earrings).click().build().perform();
	}



    @FindBy(xpath="//*[@id=\"ProductsSystem_QQI8r357\"]/nav/div/div[3]/select")
	public static WebElement Dropdown;

public void Dropdown() {
		  Actions action = new Actions(driver);
		action.moveToElement(Dropdown).click().build().perform();
		this.Dropdown.click();
}
@FindBy(xpath=("//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[1]/div/div[3]/div/div/div[1]/h4/a"))
private WebElement IntVitaelaculisMassa;

public void IntVitaelaculisMassa() {
		  Actions action = new Actions(driver);
		action.moveToElement(IntVitaelaculisMassa).click().build().perform();
		
		}


@FindBy(xpath=("//*[@id=\"cart\"]/ul/li/h3/a/i"))
private WebElement CartBag;

public void CartBag() {
	  Actions action = new Actions(driver);
	action.moveToElement(CartBag).build().perform();


	}


@FindBy(linkText=("View Cart"))
private WebElement ViewCart;

public void ViewCart() {
	  Actions action = new Actions(driver);
	action.moveToElement(ViewCart).click().build().perform();
	

}

@FindBy(id=("button-cart"))
private WebElement AddToCartBtn;

public void clickAddToCartBtn() {
		this.AddToCartBtn.click(); 
	}

@FindBy(xpath=("//button[@title='Remove' and @class='btn btn-default btn-sm tb_no_text']"))
	private WebElement RemoveBtn;

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



@FindBy(xpath=("//*[@id=\"System_V2Exp1o9\"]/div[1]"))
public WebElement ShpngCartMsg;

public String ShpngCartMsggetText() {
  return this.ShpngCartMsg.getText();
	}

//*****************************added on 14th June ********************************************//



@FindBy(id=("filter_keyword"))
private WebElement SearchBtn;

public void clickSearchBtn() {
	 Actions action = new Actions(driver);
		action.moveToElement(SearchBtn).build().perform();
	 
}

@FindBy(id=("filter_keyword"))
private WebElement EnterSearchValue;

public void sendEnterSearchValue(String EnterSearchValue) {
	this.EnterSearchValue.clear();
	this.EnterSearchValue.sendKeys(EnterSearchValue);
}

@FindBy(id=("search_button"))
private WebElement SearchBtn1;

public void SearchBtn1() {
	  Actions action = new Actions(driver);
	action.moveToElement(SearchBtn1).click().build().perform();
}



@FindBy(xpath=("//*[@id=\"ProductsSystem_YD9pMDOx\"]/div[1]/div[1]/div/div[2]/div[1]/a/span/span/img"))
private WebElement FingerRing;

public void FingerRing() {
		  Actions action = new Actions(driver);
		action.moveToElement(FingerRing).click().build().perform();
		
		}


@FindBy(xpath=("//*[@id=\"System_V2Exp1o9\"]/div[3]/div[2]/a")) 
private WebElement CheckoutBtn;  

public void clickCheckoutBtn() {
		this.CheckoutBtn.click(); 
	}





@FindBy(xpath=("//*[@id='button-payment-address' and @value='Continue']"))

//@FindBy(xpath=("//*[@id='button-account' and contains(text(),'Continue')]"))

private WebElement ContinueBtn; 

public void clickContinueBtn() {
Actions action = new Actions(driver);
action.moveToElement(ContinueBtn).click().build().perform();
}

@FindBy(xpath=("//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea"))   
private WebElement Comment;


public void sendComment(String Comment) {
	this.Comment.clear();
	this.Comment.sendKeys(Comment);
}

//@FindBy(xpath=("//div[@class='checkbox']"))
@FindBy(xpath=("//*[@name='agree' and @value='1']"))

public WebElement TermsCondiCheckBox; 

public void clickTermsCondiCheckBox() {
	 Actions action = new Actions(driver);
	this.TermsCondiCheckBox.click();
		 
}

//@FindBy(id=("button-shipping-method"))
@FindBy(xpath=("//*[@id='button-payment-method' and @value='Continue']"))
private WebElement ContinueBtn1;

public void clickContinueBtn1() {
	this.ContinueBtn1.click(); 
}


@FindBy(id=("button-confirm"))
private WebElement ConfirmProductBtn;

public void clickConfirmProductBtn() {
	this.ConfirmProductBtn.click(); 
}



@FindBy(xpath=("//a//i[@class='fa fa-bar-chart-o fw']"))   
private WebElement MouseoverChart; 

public void clickMouseoverChart() {
	 Actions action = new Actions(driver);
		action.moveToElement(MouseoverChart).click().build().perform();
		 
}


@FindBy(linkText=("Sales"))
private WebElement Sales;

public void clickSales() {
	 Actions action = new Actions(driver);
	action.moveToElement(Sales).click().build().perform();
		 
}

@FindBy(linkText=("Orders"))
public WebElement Orders;

public void clickOrders() {
	 Actions action = new Actions(driver);
		action.moveToElement(Orders).click().build().perform();
}


@FindBy(xpath= ("//tbody/tr[10]td[1]"))
public WebElement SelectedOrder;

public void clickSelectedOrder() {
	 Actions action = new Actions(driver);
		action.moveToElement(SelectedOrder).click().build().perform();
}


@FindBy(xpath=("//a//i[@class='fa fa-eye']"))   
private WebElement ViewBtn;

public void clickViewBtn() {
	  Actions action = new Actions(driver);
	action.moveToElement(ViewBtn).click().build().perform();
	
	}
@FindBy(id="input-order-status")
	public WebElement OrderStatusListBox;


public void sendOrderStatusListBox(String OrderStatusListBox) {
	this.OrderStatusListBox.sendKeys(OrderStatusListBox);
}

/*public void OrderStatusListBox() {
		  Actions action = new Actions(driver);
		action.moveToElement(OrderStatusListBox).click().build().perform();
		this.OrderStatusListBox.click();*/

/*Select B = new Select(Shopping_PagePOM.OrderStatusListBox);
B.selectByIndex(1);	
driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
screenShot.captureScreenShot("Earrings Sort By Name(A-Z) contents are displayed");*/


@FindBy(id="button-history")
private WebElement AddHistoryBtn; 

public void clickAddHistoryBtn() {
	this.AddHistoryBtn.click(); 

}
@FindBy(xpath=("//div[@class='alert alert-success']"))
public WebElement OrderCompletionSucessStatus; 

public String OrderCompletionSucessStatusgetText() {
  return this.OrderCompletionSucessStatus.getText();
	}
@FindBy(xpath=("//*[@id=\"System_nyHsmShk\"]/ul/li[1]/a"))
private WebElement ViewOrderHistry;

public void clickViewOrderHistry() {
	this.ViewOrderHistry.click(); 
}

}
