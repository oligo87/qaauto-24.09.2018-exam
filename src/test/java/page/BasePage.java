package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    WebDriver webDriver;

    /**
     * Method that waits until specific webElement become clickable
     * Max wait time is timeOutInSeconds
     * @param webElement - expected WebElement for waiting
     */
    void waitUntilElementIsClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
