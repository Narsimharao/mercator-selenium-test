package com.mercator.tests.steps;

import com.mercator.test.configutils.PropertyUtils;
import com.mercator.test.pages.HomePage;

import io.cucumber.java.en.*;

public class HomePageSteps extends CommonSteps {
	public HomePage homePage;

	public HomePageSteps() {
		homePage = new HomePage(driver);
	}

	@Given("^I am navigated to sauce demo home page$")
	public void i_am_on_job_seekers_homepage() throws Throwable {
		homePage.gotoHomePage();
	}

	@When("I login to the application")
	public void i_login_to_the_application() {
		homePage.loginToApplication(PropertyUtils.getASpecificProperty("userid"),
				PropertyUtils.getASpecificProperty("password"));
	}

}
