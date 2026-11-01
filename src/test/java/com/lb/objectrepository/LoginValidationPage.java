package com.lb.objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lb.resources.CommonActions;

public class LoginValidationPage extends CommonActions{
	
	public LoginValidationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='esw-ship-to-us']")
	private WebElement shipToUS;
	
	@FindBy(xpath = "//a[contains(@class,'my-account')]")
	private WebElement accountIcon;
	
	@FindBy(xpath = "//input[@id='login-form-email']")
	private WebElement email;
	
	@FindBy(xpath = "//button[contains(@class,'submitPasswordlessButton otc-continue')]")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@id='login-form-password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[contains(@class,'otc-password-submit')]")
	private WebElement signInButton;
	
	@FindBy(tagName = "h1")
	private WebElement accountHeader;

	public WebElement getShipToUS() {
		return shipToUS;
	}

	public WebElement getAccountIcon() {
		return accountIcon;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public WebElement getAccountHeader() {
		return accountHeader;
	}
	
}
