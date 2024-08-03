package com.mercator.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.mercator.test.configutils.PropertyUtils;

public class HomePage extends BasePage {

	@FindBy(id = "user-name")
	private WebElement userNameTextBox;

	@FindBy(id = "password")
	private WebElement passwordTextBox;

	@FindBy(id = "login-button")
	private WebElement submitButton;

	public HomePage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}

	public void gotoHomePage() {
		driver.get(PropertyUtils.getASpecificProperty("env.url"));
	}

	public void loginToApplication(String userName, String password) {
		enterText(userNameTextBox, userName);
		enterText(passwordTextBox, password);
		clickElement(submitButton);
	}
}
