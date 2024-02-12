package com.stepDefinitions;

import com.pageObjects.Locators;
import com.pageObjects.featuredNewsPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.factory.BaseClass;
import com.pageObjects.loginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class featuredNewsSteps {
	
	String userEmail= BaseClass.getProperties().getProperty("username");
	String userPassword= BaseClass.getProperties().getProperty("password");
	loginPage lp;
	
	//Locators loc=new Locators(BaseClass.getDriver());
	featuredNewsPage ns=new featuredNewsPage(BaseClass.getDriver());
	
	@Given("User navigate to be.cognizant page")
	public void User_navigate_to_be_cognizant_portal() {
	    
		lp = new loginPage(BaseClass.getDriver());
		
	}
	@Given("Featured news section should be displayed on Be.cognizant homepage")
	public void featured_news_section_should_be_displayed_on_be_cognizant_homepage() {
			ns.checkNewsBlock();
			
	}

	@When("Print count of total number of featured news displayed on Be.cognizant homepage")
	public void print_count_of_total_number_of_featured_news_displayed_on_be_cognizant_homepage() {
		//int newsCount = ns.displayCount();
		//d System.out.println("\nNumber of featured news displayed on Be.cognizant homepage: "+newsCount);
		ns.displayCount();
	}

	@When("Print the news title of all featured news displayed on Be.cognizant homepage")
	public void print_the_news_title_of_all_featured_news_displayed_on_be_cognizant_homepage() {
		ns.displayNewsHeading();
	}

	@Then("Verify tooltip with respective news title for each featured news of be.cognizant homepage.")
	public void verify_tooltip_with_respective_news_title_for_each_featured_news_of_be_cognizant_homepage() {
		ns.verifyTooltip();
	}
	
	
	@When("Print the information inside each News")
	public void print_the_information_inside_each_news() throws IOException, InterruptedException {
		ns.getNewsInformation();
	}


	
	
	@Then("Verify the apps under Apps and Tools are displayed on Be.cognizant homepage.")
	public void verify_the_apps_under_apps_and_tools_are_displayed_on_be_cognizant_homepage() {
		boolean appsDisplay = ns.checkApps();
		try {
		    Assert.assertEquals(appsDisplay,true);
		    System.out.println("Apps and Tools displayed");
			}
			catch(Exception e) {
				System.out.println("Apps and Tools not displayed");
			}
			System.out.println("\n");
	}

	@When("print all Apps under Apps and Tools Header of Homepage")
	public void print_all_apps_under_apps_and_tools_header_of_homepage() throws IOException {
		ns.displayAllApps();
	}

}
