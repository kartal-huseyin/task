package cucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;
import static utils.Config.*;
import static utils.Driver.*;
import static utils.Reusable.*;

public class Stepdefs {

    By cartButton = By.xpath("//button[contains(@class, 'Navbarstyle__ShoppingCartButton')]");
    By addToCartButton = By.xpath("//button[.='Add to Cart']");
    By closeButton = By.xpath("//button[contains(@class, 'ShoppingCartstyle__CloseButton')]");
    By clearCart = By.xpath("//button[.='Clear']");

    @Given("user on homepage")
    public void user_on_homepage() {
        driver().get(getProperty("url"));
    }

    @When("user move to product list")
    public void user_move_to_product_list() {
        WebElement container = driver().findElement(By.xpath("//div[contains(@class,\"lgoTez\")]"));
        new Actions(driver()).moveToElement(container).perform();
    }

    @Then("user verifies the number of the item in the list")
    public void userVerifiesTheNumberOfTheItemInTheList() {
        List<WebElement> productList = driver().findElements(By.xpath("//div[contains(@class,\"lgoTez\")]//img"));
        Assert.assertEquals(productList.size(), 6, "The product list should contain 6 items");
    }

    @Given("user verifies counter the badge icon")
    public void userVerifiesCounterTheBadgeIcon() {
        WebElement conterBadge = driver().findElement(By.xpath("//button/span"));
        Assert.assertFalse(conterBadge.isDisplayed(), "The Counter Badge should not be displayed when the cart is empty");
    }

    @And("user adds {int} into the cart")
    public void userAddsIntoTheCart(Integer items) {

        for (int i = 0; i < items; i++) {
            click(addToCartButton);
            click(closeButton);
            driverWait(10).until(ExpectedConditions.invisibilityOfElementLocated(closeButton));
        }
    }

    @Then("set viewport {int} {int}")
    public void setViewport(Integer width, Integer height) {
        setDimension(width, height);
    }

    @Then("user clicks on clean button")
    public void userClicksOnCleanButton() {
        click(cartButton);
        Assert.assertTrue(isClickable(clearCart),"Clear button is not reachable.");
    }

}
