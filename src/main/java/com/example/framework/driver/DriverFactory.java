package com.example.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static final ThreadLocal<WebDriver> driverThreadLocal= new ThreadLocal<>();
	
	public static void initDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driverThreadLocal.set(new ChromeDriver());
		}
	}
	
	public static WebDriver getDriver() {
		return driverThreadLocal.get();
	}
	
	public static void quitDriver() {
		if(getDriver()!= null) {
			getDriver().quit();
		}
	}
	

}
