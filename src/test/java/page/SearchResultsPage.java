package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath = "//div[@id='navcnt']")
    private WebElement navigationBar;

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResultsList;

    @FindBy(xpath = "//a[@id='pnnext']")
    private WebElement nextPageButton;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        waitUntilElementIsClickable(navigationBar);
        return webDriver.getCurrentUrl().contains("https://www.google.com/search")
                && webDriver.getTitle().equals("Selenium - Пошук Google");
    }

    public int getSearchResultsCount() {
        return searchResultsList.size();
    }

    public List<String> getSearchResults() {
        List<String> searchResultsStringList = new ArrayList<String>();
        for (WebElement searchResult : searchResultsList){
            String searchResultText = searchResult.getText();
            searchResultsStringList.add(searchResultText);
        }
        return searchResultsStringList;
    }

    public void goToNextPage() {
        nextPageButton.click();
    }
}