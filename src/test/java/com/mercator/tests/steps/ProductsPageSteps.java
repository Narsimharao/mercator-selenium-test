package com.mercator.tests.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.mercator.test.pages.ProductsPage;

import io.cucumber.java.en.*;

public class ProductsPageSteps extends CommonSteps {
	public ProductsPage productsPage;

	public ProductsPageSteps() {
		productsPage = new ProductsPage(driver);
	}

	@Then("I should see login is successful")
	public void i_should_see_login_is_successful() {
		assertEquals("Swag Labs", productsPage.getTitle());
	}

	@Then("I should see all products are displayed on Products page")
	public void i_should_see_all_products_are_displayed_on_products_page() {
		assertTrue("No Invetory Products displayed", productsPage.getAllProductsCount() > 0);
	}

	@When("I add the highest price product item to the card")
	public void i_add_the_highest_price_product_item_to_the_card() {
		highestPrice = productsPage.addHighestPriceProductToCart();
	}

	@Then("I should see item increased in the cart")
	public void i_should_see_item_increased_in_the_cart() {
		assertEquals(1, productsPage.getNumberOfItemsInCart());
	}

	@Then("I should see Remove button for the the highest price product item")
	public void i_should_see_remove_button_for_the_the_highest_price_product_item() {
		assertTrue(productsPage.isRemoveButtonDisplayed());
	}

	@When("I click on the cart")
	public void i_click_on_the_cart() {
		productsPage.clickCartButton();
	}
}
