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
public class Test01 {
    public static void Test01(){
        String userID = "mngr546611";
        String password = "durebEn";

        StringBuffer verificationError = new StringBuffer();
        // init web driver session
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            //Go to http://live.techpanda.org/
            driver.get("https://www.demo.guru99.com/V4/index.php");

            //timing
            Thread.sleep(5000);
            ManagementWeb_LoginPage MLogin = new ManagementWeb_LoginPage(driver);

            MLogin.enterUserID(userID);
            MLogin.enterPassword(password);

            Thread.sleep(2000);

            MLogin.ClickLogin();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            //timing
            Thread.sleep(2000);

            MLogin.verifyUrl();
            Thread.sleep(2000);
            //6. Screenshot capture.
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("E:\\Train_Test\\screenshots\\" + "Test01_LoginSuccess" + ".png");
            FileUtils.copyFile(scrFile, new File(png));

        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();
    }
}
