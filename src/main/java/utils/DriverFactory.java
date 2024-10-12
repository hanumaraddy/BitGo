package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    // Method to initialize WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            // Set the path for the ChromeDriver executable
          //  String projectPath = System.getProperty("user.dir");
         //   String driverPath = projectPath + "/Downloads/driver/chromedriver";
            
            System.setProperty("webdriver.chrome.driver", "/Users/hanumaraddym/Downloads/driver/chromedriver");

           // System.setProperty("webdriver.chrome.driver", driverPath);

            // Initialize ChromeDriver
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    // Method to quit WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}