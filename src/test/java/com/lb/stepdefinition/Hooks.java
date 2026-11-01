package com.lb.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.lb.resources.CommonActions;
import com.lb.resources.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonActions{
	CommonActions ca=new CommonActions();
	
	@Before
	public void beforeScenario() {
		System.out.println("Before scenario");
		System.out.println("Thread ID : " + Thread.currentThread().getId());
		ca.driverLaunch();		
	}

	@After
	public void afterScenario(Scenario scenario) {
		System.out.println("After scenario");
		if(scenario.isFailed()) {
			final byte[] screenshot =((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png","Failure Screenshot");
		} else {
			final byte[] screenshot =((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png","Success Screenshot");
		}
		DriverManager.quitDriver();
	}
}
