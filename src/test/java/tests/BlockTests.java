package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BlockPage;
import utils.DriverFactory;

import java.util.List;

public class BlockTests {

    WebDriver driver;
    BlockPage blockPage;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = DriverFactory.getDriver();

        // Navigate to the block page
        driver.get("https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");

        // Initialize BlockPage
        blockPage = new BlockPage(driver);
    }

    @Test(priority = 1)
    public void testValidateTransactionText() {
        // Validate the text "25 of 2875 Transactions"
        String transactionText = blockPage.getTransactionText();
        Assert.assertTrue(transactionText.contains("25 of 2875 Transactions"), "Transaction text validation failed!");
        System.out.println("Test Case 1 Passed: Correct transaction text is displayed.");
    }

    @Test(priority = 2)
    public void testValidateTransactionsWithOneInputTwoOutputs() {
        // Fetch transaction elements and validate those with 1 input and 2 outputs
        List<WebElement> transactions = blockPage.getTransactionElements();

        for (WebElement transaction : transactions) {
            // Locate inputs and outputs for each transaction
           List<WebElement> inputs = transaction.findElements(By.xpath("//a[contains(text(),'734f4b76781fa3ef6f8783148407c3b1983e4b395eb8b331ee')]"));  // Adjust selectors if needed
           List<WebElement> outputs = transaction.findElements(By.xpath("//a[normalize-space()='bc1qt3eqtd73mzu8053n2pnyflzpu8hzq2zlcghdar']")); // Adjust selectors if needed

            // Check if the transaction has exactly 1 input and 2 outputs
           if (inputs.size() == 1 && outputs.size() == 2) {
                // Extract the transaction hash
                WebElement transactionHash = transaction.findElement(By.cssSelector(".transaction-hash"));
                System.out.println("Transaction Hash with 1 input and 2 outputs: " + transactionHash.getText());
            }
        }
    }

    @AfterClass
    public void tearDown() {
        // Close WebDriver
        DriverFactory.quitDriver();
    }
}