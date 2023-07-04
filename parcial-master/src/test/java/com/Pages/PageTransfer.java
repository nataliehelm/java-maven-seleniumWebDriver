package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageTransfer extends BasePage {

    private WebDriver webDriver;

    By transferLink = By.cssSelector("#leftPanel > ul > li:nth-child(3) > a");
    By transferTitle = By.cssSelector("#rightPanel > div > div > h1");
    By amountInput = By.id("amount");
    By fromAccountDropDownMenu = By.id("fromAccountId");
    By toAccountDropDownMenu = By.id("toAccountId");
    By transferBttn = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input");
    By confirm =  By.className("title");

    public PageTransfer(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void transferFounds() throws InterruptedException {
        waitElement(transferLink);
        click(transferLink);
        Thread.sleep(2000);
        waitElement(transferTitle);
        compareText(transferTitle, "Transfer Funds");
        write(amountInput,"100");
        waitElement(fromAccountDropDownMenu);
        WebElement selectList = getElement(fromAccountDropDownMenu);
        Select select = new Select(selectList);
        select.selectByIndex(0);
        WebElement selectListTo = getElement(toAccountDropDownMenu);
        Select selectTo = new Select(selectListTo);
        selectTo.selectByIndex(1);
        click(transferBttn);
        Thread.sleep(2000);
        waitElement(confirm);
        compareText(confirm, "Transfer Complete!");
    }
}
