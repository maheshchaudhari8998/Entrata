package com.entrata.test;

import java.time.Duration;
import java.util.logging.LogManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import freemarker.log.Logger;

public class BaseTest {
	protected WebDriver driver;
	protected Logger log;
	protected WebDriverWait wait;
	protected ExtentReports extent;
	protected ExtentTest test;

	@BeforeClass
	public void setupExtentReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeMethod
	public void setUp() {
		ChromeDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.entrata.com");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ScreenshotUtil.capture(driver, result.getName());
			test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		driver.quit();
	}

	@AfterClass
	public void flushReport() {
		extent.flush();
	}
}
