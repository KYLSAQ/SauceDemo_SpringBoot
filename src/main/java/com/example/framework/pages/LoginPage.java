package com.example.framework.pages;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.framework.driver.DriverFactory;

public class LoginPage {
	
	//WebDriver driver = DriverFactory.getDriver();//When the LoginPage object is created, DriverFactory may not have initialized the driver yet, so DriverFactory.getDriver() returns null. 
	//Then when you call: need to do below
	private static final Logger log= LogManager.getLogger(LoginPage.class);
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	public static Properties prop = new Properties(); 
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void enterUsername(String user) {
		log.info("Enter Username.. "+user);
		driver.findElement(username).sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		log.info("Enter Password.. "+pass);
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin() {
		log.info("Click on login button.. ");
		driver.findElement(loginButton).click();
	}
	
	public void login(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
	}
}
