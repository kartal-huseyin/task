package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Driver.driver;
import static utils.Driver.driverWait;

public class Reusable {
    public static void click(By locator) {
        WebElement element=driver().findElement(locator);
        driverWait(5).until(ExpectedConditions.visibilityOf(element));
        scrollIntoView(element).click();
    }
    public static WebElement scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver()).executeScript("return arguments[0].scrollIntoView(false);", element);
        return element;
    }
    public static boolean isClickable(By locator) {
        try {
            click(locator);
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }
    public static void setDimension(int width, int height) {
        driver().manage().window().setPosition(new Point(10, 10));
        driver().manage().window().setSize(new Dimension(width, height));
    }



}
