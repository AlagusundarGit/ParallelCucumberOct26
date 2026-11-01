package com.lb.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lb.resources.CommonActions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.lb.objectrepository.LoginValidationPage;



public class LoginValidationSteps extends CommonActions {
	
	CommonActions ca=new CommonActions();
	LoginValidationPage l;
	public static String usernameCred;
	public static String passwordCred;

	@Given("Launch the application")
	public void launch_the_application() {
		l=new LoginValidationPage();
	}

	@Given("User clicks on Accept Cookies")
	public void user_clicks_on_accept_cookies() {
		// WebElement
		// shipToUs=driver.findElement(By.xpath("//button[@id='esw-ship-to-us']"));
		wait.until(ExpectedConditions.elementToBeClickable(l.getShipToUS()));
		ca.highlightElement(l.getShipToUS());
		ca.button(l.getShipToUS());
	}

	@Given("User clicks on account")
	public void user_clicks_on_account() {
		// WebElement
		// account=driver.findElement(By.xpath("//a[contains(@class,'my-account')]"));
		wait.until(ExpectedConditions.elementToBeClickable(l.getAccountIcon()));
		ca.highlightElement(l.getAccountIcon());
		ca.button(l.getAccountIcon());
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		wait.until(ExpectedConditions.visibilityOf(l.getEmail()));
		ca.highlightElement(l.getEmail());
		ca.insertText(l.getEmail(), ca.getProperty("username"));
		wait.until(ExpectedConditions.elementToBeClickable(l.getContinueButton()));
		ca.highlightElement(l.getContinueButton());
		ca.button(l.getContinueButton());
		wait.until(ExpectedConditions.visibilityOf(l.getPassword()));
		ca.highlightElement(l.getPassword());
		ca.insertText(l.getPassword(), ca.getProperty("password"));
	}

	@When("User clicks Login")
	public void user_clicks_login() {
		
		wait.until(ExpectedConditions.elementToBeClickable(l.getSignInButton()));
		ca.highlightElement(l.getSignInButton());
		ca.button(l.getSignInButton());
	}

	@Then("User should be redirected to the home page")
	public void user_should_be_redirected_to_the_home_page() throws IOException {
		// WebElement myAccount=driver.findElement(By.tagName("h1"));
		wait.until(ExpectedConditions.visibilityOf(l.getAccountHeader()));
		ca.highlightElement(l.getAccountHeader());
		String header = l.getAccountHeader().getText();
		System.out.println(header + " User navigated to my account page");

		ca.excel(l.getAccountHeader());

		// driver.quit();
	}

	@When("User enters valid username and password by one dim list")
	public void user_enters_valid_username_and_password_by_one_dim_list(DataTable datas) {
		List<String> creds = datas.asList();
		usernameCred = creds.get(0);
		passwordCred = creds.get(1);
		wait.until(ExpectedConditions.visibilityOf(l.getEmail()));
		ca.highlightElement(l.getEmail());
		ca.insertText(l.getEmail(), usernameCred);
		wait.until(ExpectedConditions.elementToBeClickable(l.getContinueButton()));
		ca.highlightElement(l.getContinueButton());
		ca.button(l.getContinueButton());
		wait.until(ExpectedConditions.visibilityOf(l.getPassword()));
		ca.highlightElement(l.getPassword());
		ca.insertText(l.getPassword(), passwordCred);
	}

	@When("User enters valid username and password by one dim map")
	public void user_enters_valid_username_and_password_by_one_dim_map(DataTable datas) {
		Map<String, String> credMap = datas.asMap(String.class, String.class);
		usernameCred = credMap.get("usernames");
		passwordCred = credMap.get("passwords");
		wait.until(ExpectedConditions.visibilityOf(l.getEmail()));
		ca.highlightElement(l.getEmail());
		ca.insertText(l.getEmail(), usernameCred);
		wait.until(ExpectedConditions.elementToBeClickable(l.getContinueButton()));
		ca.highlightElement(l.getContinueButton());
		ca.button(l.getContinueButton());
		wait.until(ExpectedConditions.visibilityOf(l.getPassword()));
		ca.highlightElement(l.getPassword());
		ca.insertText(l.getPassword(), passwordCred);
	}

	@When("User enters valid username and password {string} {string}")
	public void user_enters_valid_username_and_password(String usernames, String passwords) {
		usernameCred = usernames;
		passwordCred = passwords;
		wait.until(ExpectedConditions.visibilityOf(l.getEmail()));
		ca.highlightElement(l.getEmail());
		ca.insertText(l.getEmail(), usernameCred);
		wait.until(ExpectedConditions.elementToBeClickable(l.getContinueButton()));
		ca.highlightElement(l.getContinueButton());
		ca.button(l.getContinueButton());
		wait.until(ExpectedConditions.visibilityOf(l.getPassword()));
		ca.highlightElement(l.getPassword());
		ca.insertText(l.getPassword(), passwordCred);
	}
}
