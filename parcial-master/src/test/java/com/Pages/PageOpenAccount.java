package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageOpenAccount extends BasePage {

    private WebDriver webDriver;

    By openAccountLink = By.cssSelector("#leftPanel > ul > li:nth-child(1) > a");
    By accountDropDownMenu = By.id("type");
    By accountTypeSaving = By.cssSelector("#type > option:nth-child(2)");
    By openAccountBttn = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input");
    By confirmation = By.cssSelector("#rightPanel > div > div > p:nth-child(2)");


    public PageOpenAccount(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openAccount() throws InterruptedException {
        click(openAccountLink);
        waitElement(accountDropDownMenu);

        WebElement selectList = getElement(accountDropDownMenu);
        Select select = new Select(selectList);
        select.selectByVisibleText("SAVINGS");
        Thread.sleep(2000);
        click(openAccountBttn);
        waitElement(confirmation);
        compareText(confirmation,"Congratulations, your account is now open.");
    }
}
