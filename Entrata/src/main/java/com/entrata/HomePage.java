package com.entrata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By productsMenu = By.xpath("//a[text()='Products']");
    By demoButton = By.xpath("//a[text()='Get a Free Demo']");
    By banner = By.cssSelector(".hero-banner");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isBannerDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(banner)).isDisplayed();
    }

    public void clickDemoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(demoButton)).click();
    }

    public void hoverOnProducts() {
        WebElement products = wait.until(ExpectedConditions.visibilityOfElementLocated(productsMenu));
        new Actions(driver).moveToElement(products).perform();
    }
}
