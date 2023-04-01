package com.eurowings.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver webDriver;

    @FindBy(className = "cookie-consent--cta-accept")
    private WebElement acceptCookieButton;

    protected AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void openSite(String url) {
        webDriver.navigate().to(url);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void acceptCookie() {
        acceptCookieButton.click();
    }
}
