package com.example.tests.tests;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.framework.driver.DriverFactory;
import com.example.framework.pages.BaseTest;
import com.example.framework.pages.LoginPage;
import com.framework.tests.retry.RetryAnalyzer;


@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

	private static final Logger log = LogManager.getLogger(LoginTest.class);
	
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void validLoginTest() {
		LoginPage loginpage= new LoginPage(DriverFactory.getDriver());
		log.info("Username .... "+prop.getProperty("username"));
		log.info("Password ..... "+prop.getProperty("password"));
		log.info("Login started");
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String currentUrl = DriverFactory.getDriver().getCurrentUrl();
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
	}
	
}
