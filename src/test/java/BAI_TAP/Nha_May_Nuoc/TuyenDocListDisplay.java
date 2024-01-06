package BAI_TAP.Nha_May_Nuoc;

import POM.NMN_LoginPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;
import static org.testng.AssertJUnit.assertNotNull;

@Test
public class TuyenDocListDisplay {

    public static void Test04_TD() {
        String userName = "admin";
        String password = "12345678";

        StringBuffer verificationError = new StringBuffer();
        // init web driver session
        WebDriver driver = driverFactory.getChromeDriver();

        try{
            driver.get("https://nmn-staging.amazingtech.vn/");
            Thread.sleep(2000);
            NMN_LoginPage nmn_loginPage = new NMN_LoginPage(driver);

            //Login
            nmn_loginPage.enterUserName(userName);
            nmn_loginPage.enterPassword(password);
            Thread.sleep(2000);

            nmn_loginPage.ClickLogin();

            Thread.sleep(2000);

            //Click Tuyen Doc
            POM.CH_TuyenDoc ch_tuyenDoc = new POM.CH_TuyenDoc(driver);
            ch_tuyenDoc.ClickTD();
            Thread.sleep(2000);

            // Kiểm tra xem danh sách có tồn tại sau khi nhấn TD không
            assertNotNull("Danh sách không tồn tại sau khi nhấn DTG", ch_tuyenDoc.getListElement());
            Thread.sleep(2000);

            //Kiểm tra thông tin từng tuyến đọc có hiện ra không
            ch_tuyenDoc.ClickTD1();
            assertNotNull("Danh sách không tồn tại sau khi nhấn DT1", ch_tuyenDoc.getListElement1());
            Thread.sleep(1000);

            ch_tuyenDoc.ClickTD2();
            assertNotNull("Danh sách không tồn tại sau khi nhấn DT2", ch_tuyenDoc.getListElement2());
            Thread.sleep(1000);

            ch_tuyenDoc.ClickTD3();
            assertNotNull("Danh sách không tồn tại sau khi nhấn DT3", ch_tuyenDoc.getListElement3());
            Thread.sleep(1000);

            ch_tuyenDoc.ClickTD4();
            assertNotNull("Danh sách không tồn tại sau khi nhấn DT4", ch_tuyenDoc.getListElement4());
            Thread.sleep(1000);

            ch_tuyenDoc.ClickTD5();
            assertNotNull("Danh sách không tồn tại sau khi nhấn DT5", ch_tuyenDoc.getListElement5());
            Thread.sleep(2000);

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("E:\\Train_Test\\screenshots\\" + "TC01_CH_TuyenDoc" + ".png");
            FileUtils.copyFile(scrFile, new File(png));


        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();
        }
}
