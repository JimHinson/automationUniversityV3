package com.cengage;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class LoginPage {
    private static final By loginPageLogo = By.cssSelector("[aria-label='Return to WebAssign']");
    /**
     * from https://www.selenium.dev/documentation/en/getting_started_with_webdriver/locating_elements/
     * Locator types, from most to least desirable:
     * id, CSS, Xpath, linkText and partialLinkText, tag name
     * "The recommendation is to keep your locators as compact and readable as possible.
     * Asking WebDriver to traverse the DOM structure is an expensive operation, and the more you can narrow the scope of your search, the better."
     */
    @FindBy(id = "idp-discovery-username") private WebElement emailInput;
    @FindBy(id = "idp-discovery-submit") private WebElement nextButton;
    @FindBy(id = "okta-signin-password") private WebElement passwordInput;
    @FindBy(id = "okta-signin-submit") private WebElement signinButton;
    private final WebDriver driver;

    public LoginPage(@NotNull WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

   }

    public void login(@NotNull WebDriver driver, String uid, String pwd) {
        /**
         * Notice that I don't need to call 'driver.findElement()' because PageFactory.initElements() initialized the element
         */
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        emailInput.sendKeys(uid);
        nextButton.click();
        //Explicit Wait (https://www.selenium.dev/documentation/en/webdriver/waits/)
        new WebDriverWait(driver, (long) 35.4)
                .until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(pwd);
        //Explicit Wait (https://www.selenium.dev/documentation/en/webdriver/waits/)
        new WebDriverWait(driver, (long) 35.4)
                .until(ExpectedConditions.elementToBeClickable(signinButton));
        signinButton.click();

        //Fluent Wait (https://www.selenium.dev/documentation/en/webdriver/waits/)
        //First define your 'wait':
        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(50, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        //Then use it
        WebElement foo = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector("[data-analytics='student-course-link-clicked']"));
            }
        });

    }
}
