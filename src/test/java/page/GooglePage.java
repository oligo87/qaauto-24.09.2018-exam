package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class GooglePage extends BasePage{

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='lst-ib']")
    private WebElement searchField;

    public GooglePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        waitUntilElementIsClickable(searchButton);
        return webDriver.getCurrentUrl().equals("https://www.google.com/")
                && webDriver.getTitle().equals("Google");
    }

    public SearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchButton.click();
        return new SearchResultsPage(webDriver);
    }
}
