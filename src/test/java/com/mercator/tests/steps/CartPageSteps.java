package com.mercator.tests.steps;

import static org.junit.Assert.assertTrue;

import com.mercator.test.pages.CartPage;

import io.cucumber.java.en.*;

public class CartPageSteps extends CommonSteps {
	public CartPage cartPage;

	public CartPageSteps() {
		cartPage = new CartPage(driver);
	}

	@Then("I should see added item is displayed in the cart")
	public void i_should_see_added_item_is_displayed_in_the_cart() {
		assertTrue(highestPrice.contains(cartPage.getItemPriceFromCart()));
	}
}
