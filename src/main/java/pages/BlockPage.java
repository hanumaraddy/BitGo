package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BlockPage {
    WebDriver driver;

    // Constructor to initialize the WebDriver
    public BlockPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the transaction text
    By transactionText = By.xpath("//*[contains(text(), '25 of 2875 Transactions')]");

    // Locator for transaction elements (adjust selector if necessary)
    By transactionElements = By.cssSelector(".transaction");

    // Method to get the transaction text
    public String getTransactionText() {
        WebElement transactionElement = driver.findElement(transactionText);
        return transactionElement.getText();
    }

    // Method to get the list of transaction elements
    public List<WebElement> getTransactionElements() {
        return driver.findElements(transactionElements);
    }
}