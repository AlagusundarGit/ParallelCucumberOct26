package com.lb.objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lb.resources.CommonActions;

public class PDPPage extends CommonActions {

	public PDPPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='header container']//a[@id='cat10016']")
	private WebElement clothing;

	@FindBy(xpath = "//ul[@class='dropdown-menu show']//a[@id='cat10026']")
	private WebElement tops;

	@FindBy(xpath = "//button[contains(@class,'size-height') and not(contains(@class,'unselectable'))]")
	private List<WebElement> availableSizes;

	@FindBy(xpath = "//button[starts-with(@class,'add-to-cart')]")
	private WebElement addToBag;
	
	@FindBy(xpath = "//a[contains(@class,'view-cart')]")
	private WebElement viewBag;
	
	public WebElement getClothing() {
		return clothing;
	}

	public WebElement getTops() {
		return tops;
	}
	
	public List<WebElement> getAvailableSizes() {
	    return availableSizes;
	}
	
	public WebElement getAddToBag() {
		return addToBag;
	}

	public WebElement getViewBag() {
		return viewBag;
	}
}
