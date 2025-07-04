package com.entrata.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.entrata.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {
        test = extent.createTest("Verify Home Page Title");
        String expectedTitle = "Entrata | Property Management Software";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void verifyBannerDisplayed() {
        test = extent.createTest("Verify Dynamic Banner");
        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.isBannerDisplayed());
    }

    @Test
    public void testHoverOnProducts() {
        test = extent.createTest("Hover on Products");
        HomePage home = new HomePage(driver, wait);
        home.hoverOnProducts();
        Assert.assertTrue(true); // You can add specific submenu checks
    }

    @Test
    public void testClickDemoForm() {
        test = extent.createTest("Click Get Demo and Fill Form");
        HomePage home = new HomePage(driver, wait);
        home.clickDemoButton();
        // You can assert on form fields or URL
        Assert.assertTrue(driver.getCurrentUrl().contains("request-demo"));
    }
}

