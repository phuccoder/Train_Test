package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    By myAccountLink = By.linkText("MY ACCOUNT");
    By emailInputLocator = By.id("email");
    By passwordInputLocator = By.id("pass");
    By loginButton = By.id("send2");

    By welcomeText= By.xpath("(//p[@class='welcome-msg'])[1]");

    By accountButton = By.xpath("(//a[@class='skip-link skip-account'])[1]");

    By loginEnter = By.cssSelector("a[title='Log In']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }
    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailInputLocator);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInputLocator);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickAccount(){driver.findElement(By.xpath("(//a[@class='skip-link skip-account'])[1]")).click();}

    public void clickLog_In(){driver.findElement(By.cssSelector("a[title='Log In']")).click();}

    public String GetWelcomeText(){
        WebElement successLogin = driver.findElement(welcomeText);
        return successLogin.getText();
    }

    public String getCurrentUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }
    public boolean CheckLogin(){
        String login = GetWelcomeText();
        String actualUrl = getCurrentUrl();
        if (login != null){
            System.out.println("LOGIN SUCCESS");
            System.out.println(login);
            System.out.println(actualUrl);
            return true;
        }else {
            System.out.println("LOGIN FAIL");
            return false;
        }
    }
}
