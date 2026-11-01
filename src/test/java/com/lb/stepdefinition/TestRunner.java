package com.lb.stepdefinition;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src//test/resources//Features", 
					glue = "com.lb.stepdefinition", 
					plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
					monochrome = true,
					dryRun = false,
					tags = "@Regression")

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
