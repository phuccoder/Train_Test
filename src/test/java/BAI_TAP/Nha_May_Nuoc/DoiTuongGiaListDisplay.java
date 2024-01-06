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
public class DoiTuongGiaListDisplay {
    public static void Test04_DTG(){
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

            //Click Doi tuong gia
            POM.CH_DoiTuongGia ch_doiTuongGia = new POM.CH_DoiTuongGia(driver);
            ch_doiTuongGia.ClickDTG();

            Thread.sleep(2000);
            // Kiểm tra xem danh sách có tồn tại sau khi nhấn DTG không
            assertNotNull("Danh sách không tồn tại sau khi nhấn DTG", ch_doiTuongGia.getListElement());
            Thread.sleep(2000);

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(FILE);
            String png = ("E:\\Train_Test\\screenshots\\" + "TC01_CH_DoiTuongGia" + ".png");
            FileUtils.copyFile(scrFile, new File(png));


        }catch (Exception e){
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();
    }
}
