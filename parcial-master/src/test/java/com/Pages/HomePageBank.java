package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageBank extends BasePage {

    private WebDriver webDriver;

    By registerLink = By.cssSelector("#loginPanel > p:nth-child(3) > a");

    By usernameInput = By.name("username");
    By passwordInput = By.name("password");
    By loginBttn = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
//*[@id="loginPanel"]/form/div[3]/input



    public HomePageBank(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void register(){
        waitElement(registerLink);
        click(registerLink);
    }

    public void logIn(){
        write(usernameInput,"johndoe15");
        write(passwordInput, "asd123");
        click(loginBttn);
    }
}
