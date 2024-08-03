package com.mercator.test.driver.manager;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mercator.test.configutils.PropertyUtils;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	
	public static WebDriver getDriverDynamic() throws MalformedURLException {
	    String defaultBrowser = PropertyUtils.getASpecificProperty("browser");
	    WebDriver driver;
	    switch (defaultBrowser.toLowerCase()) {
	        case "firefox":
	        case "ff":
	            driver = getFirefoxDriver();
	            break;
	        case "chrome":
	            driver = getChromeDriver();
	            break;
	        case "edge":
	            driver = getEdgeDriver();
	            break;    
	        default:
	            throw new IllegalArgumentException("Unsupported browser: " + defaultBrowser);
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    driver.manage().window().maximize();
	    return driver;
	}

	public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver=new ChromeDriver(); 
        return driver;
    }
	
	public static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        RemoteWebDriver driver=new FirefoxDriver(); 
        return driver;
    }
	
	public static WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        RemoteWebDriver driver=new EdgeDriver(); 
        return driver;
    }
	
}
