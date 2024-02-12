package com.testRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {".//Features/"},
glue="com.stepDefinitions",plugin = { "pretty",
		"html:reports/myreport.html", "rerun:target/rerun.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false, monochrome = true)
@Test
public class testNG extends AbstractTestNGCucumberTests {

}
