package com.travelInsurance.stepDefinitions;

import com.Insurance.PageObjects.CarPage;
import com.Insurance.factory.BaseClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarInsurance {

	CarPage cp;

	@When("user click on policybazaar logo")
	public void user_click_on_policybazaar_logo() {
		cp = new CarPage(BaseClass.getDriver());
	}

	@When("user click on car insurance and redirected to cipolicybazaar webpage")
	public void user_click_on_car_insurance_and_redirected_to_cipolicybazaar_webpage() throws InterruptedException {
		cp.getCarInsurance();
		cp.buyCar();
	}

	@When("user selects  car issued city & RTO")
	public void user_selects_car_issued_city_rto() {
		cp.getCity();
	}

	@When("user enters car company & car model")
	public void user_enters_car_company_car_model() {
		cp.getCompanyModel();
	}

	@When("user entered the invalid email & mobile number")
	public void user_entered_the_invalid_email_mobile_number() {
		cp.setDetails();
	}

	@Then("capture & display the error message")
	public void capture_display_the_error_message() {
		cp.captureMSG();
	}

}
