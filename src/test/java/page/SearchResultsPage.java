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

    @FindBy(xpath = "//td[@class='cur']")
    private WebElement currentPageIndicator;

    /**
     * Constructor for SearchResultsPage object
     * @param webDriver - driver instance
     */
    SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method verifies that expected search results page is loaded
     * @param i - Integer index of results page
     * @return - true if all conditions are true, else false
     */
    public boolean isPageLoaded(int i) {
        waitUntilElementIsClickable(navigationBar);
        return webDriver.getCurrentUrl().contains("https://www.google.com/search")
                && currentPageIndicator.getText().equals(String.valueOf(i+1))
                && webDriver.getTitle().contains("Google");
    }

    /**
     * Method counts number of searchResultsList entries
     * @return - int number
     */
    public int getSearchResultsCount() {
        return searchResultsList.size();
    }

    /**
     * Method compiles strings of each search result into a list
     * @return - searchResultsStringList object
     */
    public List<String> getSearchResults() {
        List<String> searchResultsStringList = new ArrayList<>();
        for (WebElement searchResult : searchResultsList){
            String searchResultText = searchResult.getText();
            searchResultsStringList.add(searchResultText);
        }
        return searchResultsStringList;
    }

    /**
     * Method performs transition to next page
     */
    public void goToNextPage() {
        nextPageButton.click();
    }
}
