package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CH_DoiTuongGia {
    WebDriver driver;

    By DTG = By.xpath("//span[contains(text(),'CH Đối tượng giá')]");
    By listElement= By.xpath("//tbody");

    public CH_DoiTuongGia(WebDriver driver){
        this.driver = driver;
    }

    public void ClickDTG(){
        driver.findElement(DTG).click();
    }

    public List<WebElement> getListElement() {
        return driver.findElements(listElement);
    }
}
