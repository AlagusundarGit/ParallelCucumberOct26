package com.lb.objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lb.resources.CommonActions;

public class CartPage extends CommonActions{

	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//p[contains(@class,'product-name')])[1]")
	private WebElement cartProductName;

	@FindBy(xpath = "//span[contains(@class,'number-of-items')]")
	private WebElement cartQuantity;

	@FindBy(xpath = "//div[contains(@class,'estimated-totals')]")
	private WebElement cartTotal;

	public WebElement getCartProductName() {
		return cartProductName;
	}

	public WebElement getCartQuantity() {
		return cartQuantity;
	}

	public WebElement getCartTotal() {
		return cartTotal;
	}
	
	
}
