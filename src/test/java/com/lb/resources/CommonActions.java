package com.lb.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.lb.objectrepository.LoginValidationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class CommonActions {
	
	//Read config properties
	public String getProperty(String key) {
	    Properties prop = new Properties();
	    try {
	        FileInputStream fis =new FileInputStream("src/test/resources/config.properties");
	        prop.load(fis);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return prop.getProperty(key);
	}

	// driver launch
	public void driverLaunch() {

		try {
			//FileUtils.deleteDirectory(new File("allure-results"));
		} catch (Exception e) {
		}

		ChromeOptions options = new ChromeOptions();
		
		if (getProperty("headless").equalsIgnoreCase("true")) {
		    options.addArguments("--headless=new");
		    options.addArguments("--window-size=1920,1080");
		    DriverManager.setDriver(new ChromeDriver(options));
		} else {
		    DriverManager.setDriver(new ChromeDriver(options));
		    DriverManager.getDriver().manage().window().maximize();
		}
		
		int timeout=Integer.parseInt(getProperty("explicitWait"));
		DriverManager.setWait(new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout)));
		DriverManager.getDriver().get(getProperty("url"));
	}

	public void clickCookies(WebElement element) {
	    try {
	        if (element.isDisplayed()) {
	            highlightElement(element);
	            element.click();
	        }
	    } catch (Exception e) {
	        System.out.println("Cookie popup not displayed");
	    }
	}
	
	public void waitForVisible(WebElement element) {
	    DriverManager.getWait().until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForClickable(WebElement element) {
	    DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void printValue(WebElement element) {
		waitForVisible(element);
		String value = element.getText();
		System.out.println(value);
		Allure.step("Verified value: " + value);
	}

	// sendkeys
	public void insertText(WebElement element, String input) {
		waitForVisible(element);
		highlightElement(element);
		element.sendKeys(input);
	}

	// sendkeys and enter
	public void insertTextEnter(WebElement element, String input) {
		waitForVisible(element);
		highlightElement(element);
		element.sendKeys(input, Keys.ENTER);
	}

	// click
	public void button(WebElement element) {
		waitForClickable(element);
		highlightElement(element);
		element.click();
	}

	// get Text
	public void getText(WebElement element) {
		waitForVisible(element);
		highlightElement(element);
		System.out.println(element.getText());
	}

	// scroll to element
	public void scrollToElement(WebElement element) {
		waitForVisible(element);
		highlightElement(element);
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// hover
	public void hover(WebElement element) {
		Actions action = new Actions(DriverManager.getDriver());
		highlightElement(element);
		action.moveToElement(element).pause(Duration.ofSeconds(2)).perform();
	}

	// size click
	public void selectFirstAvailableSize(List<WebElement> elements) {

		for (WebElement size : elements) {
			System.out.println("Size: " + size.getText());

			if (size.isDisplayed() && size.isEnabled()) {
				scrollToElement(size);
				waitForClickable(size);
				highlightElement(size);
				size.click();
				break;
			}
		}
	}

	// window handle
	public void windowHandle() throws InterruptedException {
		String parentURL = DriverManager.getDriver().getWindowHandle();
		Set<String> childURL = DriverManager.getDriver().getWindowHandles();
		for (String child : childURL) {
			if (!parentURL.equals(child)) {
				DriverManager.getDriver().switchTo().window(child);
			}
		}
		Thread.sleep(2000);
	}

	// highlighter
	public void highlightElement(WebElement element) {
		waitForVisible(element);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].style.backgroundColor='yellow';" + "arguments[0].style.border='3px solid red';",
				element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Actions
	public void moveToElemant(WebElement element) {
		Actions a = new Actions(DriverManager.getDriver());
		waitForVisible(element);
		highlightElement(element);
		a.moveToElement(element).perform();
		;
	}

	// Actions build() inside in perform() in Selenium 4
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(DriverManager.getDriver());
		a.dragAndDrop(source, target).build().perform();
	}

	// Excel read and write
	public static void excel(WebElement element) throws IOException {
		// Write in Excel
		File file = new File(".//Excel//Account.xlsx");
		FileOutputStream f = new FileOutputStream(file);

		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet sheet = w.createSheet("Account Details");

		List<WebElement> accountDetails = DriverManager.getWait().until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='column-secondary']//li")));
		for (int i = 0; i < accountDetails.size(); i++) {
			WebElement detail = accountDetails.get(i);
			String name = detail.getText();

			XSSFRow row = sheet.createRow(i);
			XSSFCell cell = row.createCell(0);

			cell.setCellValue(name);
		}
		w.write(f);
		f.close();
		w.close();

		FileInputStream fi = new FileInputStream(file);
		XSSFWorkbook wr = new XSSFWorkbook(fi);
		XSSFSheet sheeti = wr.getSheet("Account Details");
		XSSFCell celli = sheeti.getRow(2).getCell(0);

		String accountEmail = celli.getStringCellValue();
		System.out.println(accountEmail + " Excel write read done");
		fi.close();
		wr.close();
	}
}
