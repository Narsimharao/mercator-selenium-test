package com.mercator.test.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class ProductsPage extends BasePage {

	@FindBy(css = ".inventory_item")
	private List<WebElement> allProductsList;

	@FindBy(css = "#shopping_cart_container > a > span")
	private List<WebElement> itemsInCart;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	private WebElement removeButton;

	@FindBy(css = "#shopping_cart_container > a")
	private WebElement cartButton;

	public ProductsPage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}

	public int getAllProductsCount() {
		return allProductsList.size();
	}

	public String addHighestPriceProductToCart() {
		String priceElementCss = ".inventory_item_price";
		WebElement highestPricedProduct = null;
		double highestPrice = Double.MIN_VALUE;

		for (WebElement product : allProductsList) {
			WebElement priceElement = product.findElement(By.cssSelector(priceElementCss));
			double price = Double.parseDouble(priceElement.getText().replace("$", ""));

			if (price > highestPrice) {
				highestPrice = price;
				highestPricedProduct = product;
			}
		}
		if (highestPricedProduct != null) {
			WebElement addToCartButton = highestPricedProduct
					.findElement(By.cssSelector(".inventory_item_price+button"));
			addToCartButton.click();
			return highestPricedProduct.getText().replace("$", "");
		}
		return "";
	}

	public int getNumberOfItemsInCart() {
		return itemsInCart.size();
	}

	public boolean isRemoveButtonDisplayed() {
		return removeButton.isDisplayed();
	}

	public void clickCartButton() {
		clickElement(cartButton);
	}
}
