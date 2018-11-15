package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage{

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='lst-ib']")
    private WebElement searchField;

    /**
     * Constructor for GooglePage object
     * @param webDriver - driver instance
     */
    public GooglePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method verifies that expected page is loaded
     * @return - true if all conditions are true, else false
     */
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(searchButton);
        return webDriver.getCurrentUrl().equals("https://www.google.com/")
                && webDriver.getTitle().equals("Google");
    }

    /**
     * Method does search of searchTerm
     * @param searchTerm - String with phrase to be searched
     * @return - SearchResultsPage object
     */
    public SearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchButton.click();
        return new SearchResultsPage(webDriver);
    }
}
