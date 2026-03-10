package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.example.framework.driver.DriverFactory;

public class ScreenshotUtils {
	public static String captureScreenshot(String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/reports/screenshots/" ;
        File file =new File(path);
        if (!file.exists()){
        	file.mkdir();
        }
        String remainpath=path+ testName + "_" + timestamp + ".png";

        File srcFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        File destFile = new File(path);

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
