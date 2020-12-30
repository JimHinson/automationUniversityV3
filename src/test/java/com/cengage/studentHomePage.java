package com.cengage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class studentHomePage {
    private WebDriver driver;

    @FindBy(id="courseSelect")
    Select courseSelector;
    @FindBy(css="[data-analytics='student-course-link-clicked']")
    WebElement goButton;

    public studentHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void gotoCourse(String courseName) {
        courseSelector = new Select(driver.findElement(By.id("courseSelect")));
        courseSelector.selectByVisibleText(courseName);
        goButton.click();
        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(50, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement foo = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("myAssignmentsTitle"));
            }
        });
    }
}
