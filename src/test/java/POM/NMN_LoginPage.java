package POM;

import org.openqa.selenium.*;
import org.testng.Assert;

public class NMN_LoginPage {
    WebDriver driver;

    By UserName = By.cssSelector("#userName");
    By Password = By.cssSelector("#password");
    By LoginButton = By.cssSelector("button[type='submit']");
    By ErrorPopup = By.xpath("//div[@class='errorDiv']");

    public NMN_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String userName) {
        WebElement emailElement = driver.findElement(UserName);
        emailElement.clear();
        emailElement.sendKeys(userName);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(Password);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void ClickLogin() {
        driver.findElement(LoginButton).click();
    }

    public boolean isErrorPopupDisplayed() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.getText(); // This line is added to trigger the alert
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String getErrorMessageFromAlert() {
        Alert alert = driver.switchTo().alert();
        String errorMessage = alert.getText();
        alert.accept(); // Dismiss the alert
        return errorMessage;
    }
    public void verifyUrl() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.demo.guru99.com/V4/manager/Managerhomepage.php";

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("LOGIN SUCCESS");
        } else {
            System.out.println("LOGIN FAIL");
        }

        // Print current URL to console
        System.out.println("Current URL: " + actualUrl);
    }
}
