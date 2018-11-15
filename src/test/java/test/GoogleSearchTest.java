package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResultsPage;

import java.util.List;

public class GoogleSearchTest extends BaseTest{

    /**
     * PreConditions:
     * - Open new browser.
     * - Navigate to google.com.
     *
     * Scenario:
     * - Enter "Selenium" into search field
     * - Click on Search button
     * - Assert number of Search results is 10 on page 1
     * - Assert that each result in a list contains searchTerm
     * - Click on NextPage link to switch to next page
     * - Assert number of Search results is 10 on next page
     * - Assert that each result in a list contains searchTerm
     *
     * PostCondition:
     * - Close browser.
     */

    @Test
    public void googleSearchTest(){
        String searchTerm = "Selenium";
        int pagesToVerify = 2;

        Assert.assertTrue(googlePage.isPageLoaded(), "Google search page is not loaded.");

        SearchResultsPage searchResultsPage = googlePage.search(searchTerm);

        for (int i = 0; i < pagesToVerify; i++){

            Assert.assertTrue(searchResultsPage.isPageLoaded(i), "Search results page is not loaded.");
            Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 10, "SearchResultsCount is wrong.");
            List<String> searchResultsList = searchResultsPage.getSearchResults();
            for (String searchResult : searchResultsList){
                Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "SearchTerm "+searchTerm+ "is not found in "+searchResult);
            }
            if (i < pagesToVerify-1) {
                searchResultsPage.goToNextPage();
            }
        }
    }
}
