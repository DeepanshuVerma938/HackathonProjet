package com.travelInsurance.stepDefinitions;

import java.io.IOException;

import com.Insurance.PageObjects.TravelPage;
import com.Insurance.factory.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TravelInsurance {

	TravelPage tp;
	String countryname = BaseClass.getProperties().getProperty("country");

	@Given("user navigate to the policybazaar site")
	public void user_navigate_to_the_policybazaar_site() {
		tp = new TravelPage(BaseClass.getDriver());
	}

	@When("user click on travel insurance icon")
	public void user_click_on_travel_insurance_icon() {
		tp = new TravelPage(BaseClass.getDriver());
		tp.clickTravelIcon();
	}

	@When("user navigate to travelpolicybazaar webpage")
	public void user_navigate_to_travel_policybazaar_webpage() {
		tp.checkpage();
	}

//	@When("user entered the noneuropean country name")
//	public void user_entered_the_noneuropean_country_name() {
//		tp.selectcountry();
//	}

	@When("user entered the noneuropean {string} name")
	public void user_entered_the_noneuropean_name(String string) {
		tp.selectcountry(string);
	}

	@Then("next button should be enabled")
	public void next_button_should_be_enabled() {

		tp.clickNextButton();
	}

	@When("user select the start and end date of travelling")
	public void user_select_the_start_and_end_date_of_travelling() {
		tp.setDate();
	}

	@When("user selects the number of people along with their age and clicks on next button")
	public void user_selects_the_number_of_people_along_with_their_age_and_clicks_on_next_button() {
		tp.setAge();
	}

	@When("user required to enter medical history and clicks on next button")
	public void user_required_to_enter_medical_history_and_clicks_on_next_button() {
		tp.setOption();
	}

//	@When("user redirected to contact details page and required to enter mobile number")
//	public void user_redirected_to_contact_details_page_and_required_to_enter_mobile_number(String mo) {
//		tp.setmobileNumber(mo);
//	}

	@When("user redirected to contact details page and required to enter {string} mobilenumber")
	public void user_redirected_to_contact_details_page_and_required_to_enter_mobilenumber(String string) {
		tp.setmobileNumber(string);
	}

	@When("user applies the filter to select student plan and select plan Type to fetch available policies")
	public void user_applies_the_filter_to_select_student_plan_and_select_plan_type() {
		tp.applyFilter();
	}

	@Then("lowest three travel insurance for students is captured.")
	public void lowest_three_travel_insurance_for_students_is_captured() throws IOException {
		tp.displayPolicies();
	}

}
