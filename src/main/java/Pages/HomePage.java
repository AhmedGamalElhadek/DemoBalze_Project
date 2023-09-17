package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By signUpButton = By.id("signin2");
    private By registerUserNameButton = By.id("sign-username");
    private By registerPasswordButton = By.id("sign-password");
    private By submitSignUpButton = By.xpath("//button[@onclick='register()']");
    private By loginButton = By.id("login2");
    private By loginUserNameButton = By.id("loginusername");
    private By loginPasswordButton = By.id("loginpassword");
    private By submitLoginButton = By.xpath("//button[@onclick='logIn()']");
    private By welcomeMessage = By.id("nameofuser");
    private By categoryList = By.className("list-group");
    private By categoryItems = By.tagName("a");
    private By selectItem = By.xpath("//a[text()='Nokia lumia 1520']");


    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public void clickMethod(By clickButton){
        driver.findElement(clickButton).click();
    }
    public void sendKeysMethod(By textBox,String text){
        driver.findElement(textBox).sendKeys(text);
    }
    public void signUp(String registerUserName , String registerPassword){
        clickMethod(signUpButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(registerUserNameButton));
        sendKeysMethod(registerUserNameButton,registerUserName);
        sendKeysMethod(registerPasswordButton,registerPassword);
        clickMethod(submitSignUpButton);
        }
    public String signUpAlertMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
    public void logIn(String loginUserName , String loginPassword){
        clickMethod(loginButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(loginUserNameButton));
        sendKeysMethod(loginUserNameButton,loginUserName);
        sendKeysMethod(loginPasswordButton,loginPassword);
        clickMethod(submitLoginButton);
    }
    public String logInMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(welcomeMessage));
        return driver.findElement(welcomeMessage).getText();
    }
    public List categoryCheck(){
        WebElement listGroup = driver.findElement(categoryList);
        List<WebElement> items = listGroup.findElements(categoryItems);
        return items;
    }
    public ProductPage addItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectItem));
        driver.findElement(selectItem).click();
        return new ProductPage(driver);
    }
}
