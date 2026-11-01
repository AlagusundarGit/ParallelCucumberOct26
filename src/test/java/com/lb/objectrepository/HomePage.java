package com.lb.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lb.resources.CommonActions;

public class HomePage extends CommonActions{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='header container']//a[@id='cat10016']")
	private WebElement Clothing;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu show']//a[@id='cat10026']")
	private WebElement Tops;

	public WebElement getClothing() {
		return Clothing;
	}

	public WebElement getTops() {
		return Tops;
	}
	
	
}
