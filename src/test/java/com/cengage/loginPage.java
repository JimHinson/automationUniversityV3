package com.cengage;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.awt.event.WindowAdapter;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class loginPage {
    private static By loginPageLogo = By.cssSelector("[aria-label='Return to WebAssign']");
    private static By emailInput = By.id("idp-discovery-username");
    private static By nextButton = By.id("idp-discovery-submit");
    private static By passwordInput = By.id("okta-signin-password");
    private static By signInButton = By.id("okta-signin-submit");

    public loginPage(@NotNull WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void login(@NotNull WebDriver driver, String uid, String pwd) {
        driver.findElement(emailInput).sendKeys(uid);
        driver.findElement(nextButton).click();
        driver.findElement(passwordInput).sendKeys(pwd);
        driver.findElement(signInButton).click();
        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(50, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement foo = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("[data-analytics='student-course-link-clicked']"));
            }
        });
    }



}
