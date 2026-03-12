package com.example.framework.pages;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.example.framework.driver.DriverFactory;


public class BaseTest {
	
	DriverFactory driverFactory =new DriverFactory();
	public static Properties prop;
	private static final Logger log = LogManager.getLogger(BaseTest.class);
	
	@BeforeMethod
	public void setUp() {
		 try {
			 	
	            prop = new Properties();

	            FileInputStream ip = new FileInputStream(
	                    System.getProperty("user.dir") + "/src/test/resources/application.properties");

	            prop.load(ip);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		log.info("Browser initialization started....");
		DriverFactory.initDriver(prop.getProperty("browser"));
		DriverFactory.getDriver().manage().window().maximize();
		log.info("Broser got maximized....");
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
		log.info("Navigated to application URL....");
	}
	
	@AfterMethod
	public void tearDown() {
		log.info("Browser closing....");
		driverFactory.quitDriver();
	}
	

}
