package com.cengage;

/**
 * Welcome to Cengage Test Automation!
 * You will spend some time refactoring and extending this code. Use this as an opportunity to hone your craft
 * on the road to becoming a Test Automation Artisan.
 *
 * “Indeed, the ratio of time spent reading versus writing is well over 10 to 1. We are constantly reading old code
 * as part of the effort to write new code. ...[Therefore,] making it easy to read makes it easier to write.”
 * Robert C. Martin, Clean Code: A Handbooks of Agile Software Craftsmanship
 */

import com.utils.PropfileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class webAssignLoginTest {
    /**
     * TODO: Move common functionality to a parent test class
     * extends BaseTest {
     */

    protected WebDriver driver;

    private By assignmentTitle = By.cssSelector("#js-assignment-header h1");

    String url = "";
    String uid = "";
    String pwd = "";


    @BeforeTest //This will run before the tests to ensure test setup
    public void testSetup() throws Exception {
    }


    @BeforeMethod // This will run before each test to remove dependency of any test from another
    public void launchHomePage() {
    }

    protected void getLoginInfo() {
        uid = (PropfileReader.getUserData("userId"));
        pwd = (PropfileReader.getUserData("password"));
        url = (PropfileReader.getUserData("url"));
    }

    protected void seleniumSetup(int implicitWait) {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
/**
 * From https://www.selenium.dev/documentation/en/webdriver/waits/
 * Warning: Do not mix implicit and explicit waits. Doing so can cause unpredictable wait times. For example, setting an
 * implicit wait of 10 seconds and an explicit wait of 15 seconds could cause a timeout to occur after 20 seconds.
 */
//        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }

    @Test
    public void UserAccessAssignmentHomePage() {
        getLoginInfo();
        int implicitWait = new Integer(PropfileReader.getSetting("implicitTimeout")).intValue();
        /**
         * TODO: use browser and browserOptions in our properties file
         */
        seleniumSetup(implicitWait);
        
        //go to our website
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(driver, uid, pwd);

        //WebAssign home page takes a bit longer to load.
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Let's leave the window open so we can see it
        mySleep(2000);

        driver.close();
        driver.quit();
    }

    @DataProvider(parallel = true, name = "data-provider")
    public Object[][] users() {
        return new Object[][] {{"jim.hinson@gmail.com", "Password1"} }; //, {"Jetson", "Password2"} };
    }
//https://www.toolsqa.com/testng/testng-dataproviders/
    @Test(dataProvider = "data-provider")
    public void multipleUserLogin(String uid, String pwd) {
//        Reporter.log("a message");
        getLoginInfo();
        seleniumSetup(2);
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(driver, uid, pwd);
    }

    public void mySleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            System.out.println("We were interrupted! Stopping");
            System.exit(1);
        }
    }

//    @Test
    public void accessClass() {
        studentHomePage shp = new studentHomePage(this.driver);
        shp.gotoCourse("CSC 230 Cengage software test automation, section 0001, Fall 2020");
        driver.findElement(By.cssSelector("[data-analytics='student-course-link-clicked']")).click();

        //Let's leave the window open so we can see it
        mySleep(15000);
        driver.close();
        driver.quit();
    }
}