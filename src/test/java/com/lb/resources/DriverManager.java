package com.lb.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setWait(WebDriverWait webDriverWait) {
        wait.set(webDriverWait);
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }
    
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
