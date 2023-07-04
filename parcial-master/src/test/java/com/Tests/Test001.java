package com.Tests;

import com.Pages.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.reports;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test001 {

    private WebDriver webDriver;
    public ExtentReports report;
    public ExtentTest test;

    HomePageBank homePageBank;
    PageRegister pageRegister;
    PageOpenAccount openAccount;
    PageAccountOverview accountOverview;
    PageTransfer transfer;

    @BeforeEach
    public void setUp() {
        homePageBank = new HomePageBank(webDriver);
        pageRegister = new PageRegister(webDriver);
        openAccount = new PageOpenAccount(webDriver);
        accountOverview = new PageAccountOverview(webDriver);
        transfer = new PageTransfer(webDriver);
        webDriver =homePageBank.chromeDriverConnection();
        homePageBank.openLink("https://parabank.parasoft.com/parabank/index.htm");
        report = reports.getInstance();
    }
    @AfterEach
    public void tearDown() throws Exception {
        Thread.sleep(1500);
        report.endTest(test);
        report.flush();
        webDriver.quit();
    }

    @Test
    @Tag("regresion")
    @Order(0)
    void register() throws InterruptedException {
        test = report.startTest("Proceso de registro");
        test.log(LogStatus.INFO,"Se inicia registro de un usuario");
        homePageBank.register();
        pageRegister.pageForm();
        pageRegister.accountRegistry();
        pageRegister.submitForm();
        pageRegister.registrationSuccess();
        Thread.sleep(1500);

        openAccount.openAccount();
        Thread.sleep(1500);

        accountOverview.checkAccountOverview();
        Thread.sleep(1500);

        transfer.transferFounds();
        Thread.sleep(1500);

        accountOverview.accountActivity();
        Thread.sleep(1500);

    }
    @Test
    @Tag("regresion")
    @Order(1)
    void openAccount() throws InterruptedException {
        test = report.startTest("Apertura de una nueva cuenta");
        test.log(LogStatus.INFO,"Se abre una nueva cuenta del tipo SAVINGS");
        homePageBank.logIn();
        openAccount.openAccount();
    }

    @Test
    @Tag("regresion")
    @Order(2)
    void checkAccounts() throws InterruptedException {
        test = report.startTest("Visión general de la cuenta");
        test.log(LogStatus.INFO,"Se comprueba la existencia de las cuentas");
        homePageBank.logIn();
        accountOverview.checkAccountOverview();
        Thread.sleep(1500);

    }

    @Test
    @Tag("regresion")
    @Order(3)
    void transferMoney() throws InterruptedException {
        test = report.startTest("Transferencia de fondos");
        test.log(LogStatus.INFO,"Se comprueba la transferencia entre cuentas");
        homePageBank.logIn();
        transfer.transferFounds();
        Thread.sleep(1500);

    }

    @Test
    @Tag("regresion")
    @Order(4)
    void checkAccountActivity() throws InterruptedException {
        test = report.startTest("Actividad de la cuenta");
        test.log(LogStatus.INFO,"Se comprueba la actividad de las cuentas");
        homePageBank.logIn();
        accountOverview.accountActivity();
        Thread.sleep(1500);

    }

}
