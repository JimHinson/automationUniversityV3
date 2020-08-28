package com.seleniumMonolith;

import com.Utils.PropfileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//Homework
import org.testng.Assert;
//Class2 Homework
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class webAssignLogin { //extends BaseTest {
    private By loginPageLogo = By.cssSelector("[aria-label='Return to WebAssign']");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("cengagePassword");
    private By signInButton = By.name("Login");

    protected WebDriver driver;

    private By homePageNavBar = By.cssSelector("[aria-label='WebAssign']");
    private By homePage = By.cssSelector("main h1");
    private By assignmentHomePage = By.cssSelector("[data-test='My Assignments']>ul li a");
    public static String homepageURL;

    private By assignmentTitle = By.cssSelector("#js-assignment-header h1");



    /**
     * go to assignment
     */

    /**
     * assert true
     */

    /**
     * TODO:
     * capture screenshot on failure
     */
    @BeforeTest //This will run before the tests to ensure test setup
    public void testSetup() throws Exception {

    }


    @BeforeMethod // This will run before each test to remove dependency of any test from another
    public void launchHomePage() {
    }

    @Test
    public void UserAccessAssignmentHomePage() {
        String uid= (PropfileReader.getUserData("userId"));
        String pwd = (PropfileReader.getUserData("password"));
        String url = (PropfileReader.getUserData("url"));
        int implicitWait = new Integer(PropfileReader.getSetting("implicitTimeout")).intValue();
        String browser = (PropfileReader.getSetting("browser"));
        String browserOptions = (PropfileReader.getSetting("browserOptions"));

        // Selenium setup
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

        driver.get(url);

        //log in
        driver.findElement(emailInput).sendKeys(uid);
        driver.findElement(passwordInput).sendKeys(pwd);
        driver.findElement(signInButton).click();

        //WebAssign home page takes a bit longer to load.
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);

        //wait for the class switcher to load so we we know WebAssign is loaded
        driver.findElement(By.xpath("/html/body/form/div/main/div[1]/div/div/div[1]/nav/div/button"));

        //Let's leave the window open so we can see it
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
    }

}