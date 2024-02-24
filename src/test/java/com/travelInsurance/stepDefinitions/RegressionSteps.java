package com.travelInsurance.stepDefinitions;

import com.Insurance.PageObjects.CarPage;
import com.Insurance.PageObjects.HealthPage;
import com.Insurance.PageObjects.RegressionPage;
import com.Insurance.factory.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegressionSteps {

	CarPage cp;
	HealthPage hp;
	RegressionPage rp;

	@Given("user navigates to car insurance page")
	public void user_navigates_to_car_insurance_page() {
		cp = new CarPage(BaseClass.getDriver());

	}

	@Given("directly clicks view price")
	public void directly_clicks_view_price() {
		cp.getPrice();
	}

	@Then("user capture error")
	public void user_capture_error() {
		cp.getMessage();
	}

	@Given("user is on please fill your details page")
	public void user_is_on_please_fill_your_details_page() {
		cp = new CarPage(BaseClass.getDriver());
		cp.getCarInsurance();
		cp.buyCar();
		cp.getCity();
		cp.getCompanyModel();
	}

	@When("user entered the {string} name")
	public void user_entered_the_name(String string) {

		cp.setName(string);
	}

	@When("user entered the {string} email &  {string} mobilenumber")
	public void user_entered_the_email_mobilenumber(String string, String string2) {
		cp.setInfo(string, string2);
	}

	@Then("user should able to get error")
	public void user_should_able_to_get_error() {
		cp.captureMSG();
	}

	@Given("user navigates to health insurance page")
	public void user_navigates_to_health_insurance_page() {
		hp = new HealthPage(BaseClass.getDriver());
		hp.getHealthInsurance();
	}

	@Given("user selects only one child")
	public void user_selects_only_one_child() {
		hp.getChild();
	}

	@Then("user should capture error message")
	public void user_should_able_to_capture_error_message() {
		hp.captureText();
	}

	@Given("user navigates to two wheeler insurance page")
	public void user_navigates_to_two_wheeler_insurance_page() {
		rp = new RegressionPage(BaseClass.getDriver());
		rp.getTwoWheeler();
	}

	@Given("user enters invalid number")
	public void user_enters_invalid_number() {
		rp.setNumber();
	}

	@Then("user get error message & not able to proceed further")
	public void user_get_error_message_not_able_to_proceed_further() {
		rp.captureMessage();
	}

}
