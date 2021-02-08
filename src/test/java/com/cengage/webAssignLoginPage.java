package com.cengage;

import org.openqa.selenium.By;

public class webAssignLoginPage {
    private static By loginPageLogo = By.cssSelector("[aria-label='Return to WebAssign']");
    private static By emailInput = By.id("idp-discovery-username");
    private static By passwordInput = By.id("okta-signin-password");
    private static By signInButton = By.id("idp-discovery-submit");
    private static By oktaSignInButton = By.id("okta-signin-submit");


}
