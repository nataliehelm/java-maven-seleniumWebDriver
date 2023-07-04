package com.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    protected static WebDriver driver;


    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chomedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public void openLink (String url) {
        driver.get(url);
    }

    public static void click (By locator) {
        driver.findElement(locator).click();
    }

    public void checkIfExist (By locator) {
        Boolean result = driver.findElement(locator).isDisplayed();
        assertTrue(result);
    }

    public WebElement getElement(By element){
        return driver.findElement(element);
    }

    public static void compareText (By locator, String message) {
        String result = driver.findElement(locator).getText();
        assertTrue(result.contains(message));
    }

    public static void compareValue (By locator, String message, String attribute) {
        String result = driver.findElement(locator).getAttribute(attribute);
        assertTrue(result.contains(message));
    }

    public void write(By locator, String imputText) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(imputText);
    }

    public WebElement waitElement(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.presenceOfElementLocated(element));
    };


}
