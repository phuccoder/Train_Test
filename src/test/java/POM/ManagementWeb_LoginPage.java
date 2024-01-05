package POM;

import org.openqa.selenium.*;
import org.testng.Assert;

public class ManagementWeb_LoginPage {
    WebDriver driver;

    By UserID = By.xpath("//input[@name='uid']");
    By Password = By.cssSelector("input[name='password']");
    By LoginButton = By.cssSelector("input[value='LOGIN']");
    By ErrorPopup = By.xpath("//div[@class='errorDiv']");

    public ManagementWeb_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserID(String userID) {
        WebElement emailElement = driver.findElement(UserID);
        emailElement.clear();
        emailElement.sendKeys(userID);
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
