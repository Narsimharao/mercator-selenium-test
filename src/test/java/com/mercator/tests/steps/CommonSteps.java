package com.mercator.tests.steps;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.mercator.test.driver.manager.DriverManager;

public class CommonSteps {

	public static WebDriver driver;
	public static String highestPrice;

	public CommonSteps() {
		if (driver == null) {
			try {
				driver = DriverManager.getDriverDynamic();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

}