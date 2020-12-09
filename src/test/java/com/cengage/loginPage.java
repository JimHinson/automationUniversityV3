package com.cengage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private static By loginPageLogo = By.cssSelector("[aria-label='Return to WebAssign']");
    private static By emailInput = By.id("email");
    private static By passwordInput = By.id("cengagePassword");
    private static By signInButton = By.name("Login");

    public static void login(WebDriver driver, String uid, String pwd) {
        driver.findElement(emailInput).sendKeys(uid);
        driver.findElement(passwordInput).sendKeys(pwd);
        driver.findElement(signInButton).click();
    }



}
