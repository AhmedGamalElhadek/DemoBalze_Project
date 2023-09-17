package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private By addToCartButton = By.cssSelector("a.btn.btn-success.btn-lg[onclick^='addToCart']");
    private By cartButton = By.id("cartur");
    public ProductPage(WebDriver driver){
        this.driver=driver;
    }
    public void addToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
    }
    public String getaddedMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String addedMessage = alert.getText();
        alert.accept();
        return addedMessage;
    }
    public CartPage goToCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
}
