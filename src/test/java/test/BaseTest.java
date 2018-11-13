package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.GooglePage;

public class BaseTest {
    private WebDriver webDriver;
    GooglePage googlePage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.google.com/");
        googlePage = new GooglePage(webDriver);
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }
}