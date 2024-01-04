package BAI_TAP;

import POM.LoginPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class LoginTest {
    public static void Login_Test(){

        String emailAddress = "phucnmtde170689@fpt.edu.vn";
        String password = "123456";

        StringBuffer verificationError = new StringBuffer();
        // init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            
            //Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //timing
            Thread.sleep(5000);

            //Click on my account link
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickAccount();
            Thread.sleep(1000);
            loginPage.clickLog_In();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //timing
            Thread.sleep(2000);

            //Login in application using previously created credential
            loginPage.enterEmail(emailAddress);

            //timing
            Thread.sleep(1000);

            loginPage.enterPassword(password);

            //timing
            Thread.sleep(1000);

            //Click Login
            loginPage.clickLogin();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //timing
            Thread.sleep(6000);
            loginPage.GetWelcomeText();
            loginPage.getCurrentUrl();
            Thread.sleep(2000);
            loginPage.CheckLogin();

            Thread.sleep(1000);

            //6. Screenshot capture.
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("E:\\Train_Test\\screenshots\\" + "LoginTest" + ".png");
            FileUtils.copyFile(scrFile, new File(png));

        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();


    }
}
