package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageRegister extends BasePage {

    private WebDriver webDriver;
    By formContainer = By.id("customerForm");

    By firstNameInput = By.id("customer.firstName");
    By lastNameInput = By.id("customer.lastName");
    By addressInput = By.id("customer.address.street");
    By cityInput = By.id("customer.address.city");
    By stateInput = By.id("customer.address.state");
    By zipCodeInput = By.id("customer.address.zipCode");
    By phoneInput = By.id("customer.phoneNumber");
    By ssnInput = By.id("customer.ssn");
    By usernameInput = By.id("customer.username");
    By passwordInput = By.id("customer.password");
    By repeatedPasswordInput = By.id("repeatedPassword");
    By registerBttn = By.cssSelector(".form2 > tbody:nth-child(1) > tr:nth-child(13) > td:nth-child(2) > input:nth-child(1)");
    By confirmation = By.id("rightPanel");

    public PageRegister(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void pageForm() {
        checkIfExist(formContainer);
    }
    public void accountRegistry(){
        write(firstNameInput,"John");
        write(lastNameInput,"Doe");
        write(addressInput,"Calle Principal 123");
        write(cityInput, "Indianapolis");
        write(stateInput, "Indiana");
        write(zipCodeInput, "46074");
        write(phoneInput, "181744022");
        write(ssnInput,"123456789987");
        write(usernameInput, "johndoe17");
        write(passwordInput, "asd123");
        write(repeatedPasswordInput, "asd123");
    }

    public void submitForm(){
        click(registerBttn);
    }
    public void registrationSuccess(){
        waitElement(confirmation);
        compareText(confirmation,"Your account was created successfully. You are now logged in.");
    }
}
