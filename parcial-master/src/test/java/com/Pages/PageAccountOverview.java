package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageAccountOverview extends BasePage {

    By accountsOverviewLink = By.cssSelector("#leftPanel > ul > li:nth-child(2) > a");
    By rightPanel = By.cssSelector("#accountTable > tfoot > tr > td");
    By firstAccount = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    By title = By.cssSelector("#rightPanel > div > div:nth-child(1) > h1");
    By periodDropDownMenu = By.id("month");
    By typeDropDownMenu = By.id("transactionType");
    By goBttn = By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input");
    private WebDriver webDriver;


    public PageAccountOverview(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkAccountOverview(){
        click(accountsOverviewLink);
        waitElement(rightPanel);
        compareText(rightPanel, "*Balance includes deposits that may be subject to holds");
    }

    public void accountActivity(){
        checkAccountOverview();
        waitElement(firstAccount);
        click(firstAccount);
        waitElement(title);
        compareText(title, "Account Details");

        WebElement selectListPeriod = getElement(periodDropDownMenu);
        Select selectPeriod = new Select(selectListPeriod);
        selectPeriod.selectByIndex(0);

        WebElement selectListType = getElement(typeDropDownMenu);
        Select selectType = new Select(selectListType);
        selectType.selectByIndex(0);

        click(goBttn);
    }
}
