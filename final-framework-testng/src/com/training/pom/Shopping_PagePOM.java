package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}



