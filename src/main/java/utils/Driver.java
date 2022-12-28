package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    public static WebDriver driver() {

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1440,900");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static WebDriverWait driverWait(int sec){
       return new WebDriverWait(driver(),Duration.ofSeconds(sec));
    }

    public static void quitDriver() {
        driver().quit();
    }


}
