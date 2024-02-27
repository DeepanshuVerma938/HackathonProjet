package com.travelInsurance.stepDefinitions;

import com.Insurance.PageObjects.CarPage;
import com.Insurance.PageObjects.HealthPage;
import com.Insurance.PageObjects.SmokePage;
import com.Insurance.PageObjects.TravelPage;
import com.Insurance.PageObjects.loginPage;
import com.Insurance.factory.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SmokeSteps {

	TravelPage tp;
	loginPage lp = new loginPage(BaseClass.getDriver());
	HealthPage hp = new HealthPage(BaseClass.getDriver());
	CarPage cp = new CarPage(BaseClass.getDriver());
	SmokePage sp = new SmokePage(BaseClass.getDriver());

	String actualheading = "Login to my account";

	@Given("user navigates to policybazaar site")
	public void user_navigates_to_policybazaar_site() {
		tp = new TravelPage(BaseClass.getDriver());
	}

	@When("user clicked on travel icon")
	public void user_clicked_on_travel_icon() {
		tp.clickTravelIcon();
	}

	@Then("user should navigate to travelpolicybazaar webpage")
	public void user_should_navigate_to_travel_policybazaar_webpage() {
		tp.checkpage();
	}

	@When("user clicked on heart logo icon")
	public void user_clicked_on_heart_logo_icon() {
		hp.clickheartlogo();
	}

	@Then("user  navigate to healthInsurance webpage")
	public void user_navigate_to_health_insurance_webpage() {
		hp.checkhealthpage();
	}

	@When("user clicked on CarImage present on homepage")
	public void user_clicked_on_car_image_present_on_homepage() {
		cp.getcarlogo();
	}

	@Then("user  navigates to carInsurance webpage")
	public void user_navigates_to_car_insurance_webpage() {
		cp.validatepage();
	}

	@When("user clicked on HouseImage available on homepage")
	public void user_clicked_on_house_image_available_on_homepage() {
		sp.homelogo();
	}

	@Then("user should navigate to houseInsurance webpage")
	public void user_should_navigate_to_house_insurance_webpage() {
		sp.validateHomePage();
	}

	@When("user clicked on UmbrellaImage available on homepage")
	public void user_clicked_on_umbrella_image_available_on_homepage() {
		sp.UmbrellaLogo();
	}

	@Then("user should navigate to TermLifeInsurance webpage")
	public void user_should_navigate_to_term_life_insurance_webpage() {
		sp.validateTermPage();
	}

	@When("user clicked on RetirementPlans present on homepage")
	public void user_clicked_on_retirement_plans_present_on_homepage() {
		sp.clickRetire();
	}

	@Then("user should navigate to RetirementPlans webpage")
	public void user_should_navigate_to_retirement_plans_webpage() {
		sp.getRetirementPage();
	}

	@When("user clicked on ChildImage available on homepage")
	public void user_clicked_on_child_image_available_on_homepage() {
		sp.clickChild();
	}

	@Then("user should navigate to child savings plan webpage")
	public void user_should_navigate_to_child_savings_plan_webpage() {
		sp.CheckChildPage();
	}

	@When("user clicked on FamilyImage present on homepage")
	public void user_clicked_on_family_image_present_on_homepage() {
		sp.clickFamily();
	}

	@Then("user should navigate to FamilyHealthInsurance webpage")
	public void user_should_navigate_to_family_health_insurance_webpage() {
		sp.CheckFamilyPage();
	}

	@When("user scroll to bottom of webpage")
	public void user_scroll_to_bottom_of_webpage() {
		lp.scroll();
	}

	@When("click on contact us link")
	public void click_on_contact_us_link() {
		lp.getContactus();

	}

	@Then("contact us link should be clickable and navigated to my accoount")
	public void contact_us_link_should_be_clickable_and_navigated_to_my_accoount() {
		lp.checkPage();
	}

	@Given("user navigate to contact us page of policy bazaar")
	public void user_navigate_to_contact_us_page_of_policy_bazaar() {
		tp = new TravelPage(BaseClass.getDriver());
		lp.scroll();
		lp.getContactus();
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		lp.clickLogin();

	}

	@When("enter {string} phone number")
	public void enter_phone_number(String string) {
		lp.setPhoneNumber(string);
	}

	@When("click on log in button")
	public void click_on_log_in_button() {
		lp.clickLoginBtn();
	}

	@Then("capture error message if entered mobile number is invalid otherwise user should login")
	public void capture_error_message_if_entered_mobile_number_is_invalid_otherwise_user_should_login() {
		lp.getMessage();
	}

}
