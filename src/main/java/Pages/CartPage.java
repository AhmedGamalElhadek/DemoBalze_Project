package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private By deleteButton = By.cssSelector("a[onclick*='deleteItem']");
    private By placeOrderButton = By.cssSelector("button.btn.btn-success[data-toggle='modal'][data-target='#orderModal']");
    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By cardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseButton = By.xpath("//*[@onclick='purchaseOrder()']");
    private By purchaseMessage = By.cssSelector("div.sweet-alert.showSweetAlert.visible h2");
    private By confirmButton = By.cssSelector("button.confirm.btn.btn-lg.btn-primary[tabindex='1']");
    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickMethod(By clickButton){driver.findElement(clickButton).click();
    }
    public void sendKeysMethod(By textBox,String text){
        driver.findElement(textBox).sendKeys(text);
    }
    public void deleteItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        clickMethod(deleteButton);}

    public void checkOut(String name , String country , String city , String creditCard , String month , String year){
        clickMethod(placeOrderButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nameField));
        sendKeysMethod(nameField,name);
        sendKeysMethod(countryField,country);
        sendKeysMethod(cityField,city);
        sendKeysMethod(cardField,creditCard);
        sendKeysMethod(monthField,month);
        sendKeysMethod(yearField,year);
        clickMethod(purchaseButton);
    }
    public void confirmPurchase(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        clickMethod(confirmButton);
        }
}
