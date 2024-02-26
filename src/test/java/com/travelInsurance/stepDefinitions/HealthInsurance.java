package com.travelInsurance.stepDefinitions;

import java.io.IOException;

import com.Insurance.PageObjects.HealthPage;
import com.Insurance.factory.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthInsurance {

	HealthPage hp;
	String mobile = BaseClass.getProperties().getProperty("phonenumber");

	@Given("user navigate to policybazaar site")
	public void user_navigate_to_policybazaar_site() {
		hp = new HealthPage(BaseClass.getDriver());
	}

	@When("user click on Health insurance navigated to health page")
	public void user_click_on_health_insurance_navigated_to_health_page() {
		hp = new HealthPage(BaseClass.getDriver());
		hp.getHealthInsurance();
	}

	@When("user should select atleast one member for health insurance from available memebers")
	public void user_should_select_atleast_one_member_for_health_insurance_from_available_memebers() {
		hp.setMember();
	}

	@When("user navigated to select age of member & proceed with continue button")
	public void user_navigated_to_select_age_of_member_proceed_with_continue_button() {
		hp.setAge();
	}

	@When("user should select the city name & proceed with continue button")
	public void user_should_select_the_city_name_proceed_with_continue_button() {
		hp.setCity();
	}

	@When("user enters name & mobileNo & proceed with continue button")
	public void user_enters_name_mobile_no_proceed_with_continue_button() {
		hp.setDetails(mobile);
	}

	@When("user should select any previous medical history")
	public void user_should_select_any_previous_medical_history() {
		hp.checkMedicalHistory();
	}

	@When("user selects health insurance is provided or not")
	public void user_selects_health_insurance_is_provided_or_not() {
		hp.getInsuranceOption();
	}

	@Then("user should capture and display different health plans")
	public void user_should_capture_and_display_different_health_plans() throws IOException {
		hp.displayHealthPlans();
	}
}
