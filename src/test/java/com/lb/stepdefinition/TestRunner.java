package com.lb.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test/resources//Features", 
					glue = "com.lb.stepdefinition", 
					plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
					monochrome = true,
					dryRun = false,
					tags = "@Regression")

public class TestRunner {

}
