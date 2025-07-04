package com.entrata.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import nonapi.io.github.classgraph.utils.FileUtils;

public class ScreenshotUtil {
    public static String capture1(WebDriver driver, String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String dest = "reports/screenshots/" + screenshotName + ".png";
        try {
            FileUtils.copyfile(src, new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }

	public static String capture(WebDriver driver, String name) {
		return null;
	}
}

