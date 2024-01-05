package BAI_TAP;

import POM.ManagementWeb_LoginPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;

@Test
public class Test02 {
    public static void Test02(){
        String userID = "mngr546612";
        String password = "durebE5";

        StringBuffer verificationError = new StringBuffer();
        // init web driver session
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            driver.get("https://www.demo.guru99.com/V4/index.php");

            // timing
            Thread.sleep(3000);
            ManagementWeb_LoginPage MLogin = new ManagementWeb_LoginPage(driver);

            MLogin.enterUserID(userID);
            MLogin.enterPassword(password);

            Thread.sleep(2000);

            MLogin.ClickLogin();


            // Sleep to allow the alert to appear (adjust the time if needed)
            Thread.sleep(1000);

            // Capture screenshot


            if (MLogin.isErrorPopupDisplayed()) {
                String errorMessage = MLogin.getErrorMessageFromAlert();
                System.out.println("LOGIN FAIL. Error message: " + errorMessage);
            }
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("E:\\Train_Test\\screenshots\\" + "Test02_LoginFail" + ".png");
            FileUtils.copyFile(scrFile, new File(png));

        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();
    }
}
