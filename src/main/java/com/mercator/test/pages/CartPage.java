package com.mercator.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class CartPage extends BasePage {

	@FindBy(css = ".inventory_item_price")
	private WebElement itemPriceLabel;

	public CartPage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}

	public String getItemPriceFromCart() {
		return getText(itemPriceLabel).replace("$", "").trim();
	}

}
