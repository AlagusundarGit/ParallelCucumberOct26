package com.lb.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lb.resources.CommonActions;

public class PLPPage extends CommonActions {
	
	public PLPPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='pdp-link product-name'])[1]")
	private WebElement PLP_Product1;
	
	public WebElement getPLP_Product1() {
		return PLP_Product1;
	}
	
	
}
