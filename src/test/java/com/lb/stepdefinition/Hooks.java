package com.lb.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.lb.resources.CommonActions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonActions{
	CommonActions ca=new CommonActions();
	
	@Before
	public void beforeScenario() {
		System.out.println("Before scenario");
		ca.driverLaunch();		
	}

	@After
	public void afterScenario(Scenario scenario) {
		System.out.println("After scenario");
		if(scenario.isFailed()) {
			final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png","Failure Screenshot");
		} else {
			final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png","Success Screenshot");
		}
		ca.driver.quit();
	}
}
