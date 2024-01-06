package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CH_TuyenDoc {
    WebDriver driver;

    By TD = By.xpath("//span[contains(text(),'CH Tuyến đọc')]");
    By listElement= By.cssSelector(".ant-spin-container");

    By listElementTD1 = By.xpath("//body[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/div[1]/div[1]");

    By listElementTD2 = By.cssSelector("body > div:nth-child(2) > section:nth-child(1) > section:nth-child(3) > main:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)");
    By listElementTD3 = By.xpath("//body[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/td[1]/div[1]/div[1]/div[1]");

    By listElementTD4 = By.xpath("//body[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[9]/td[1]/div[1]/div[1]/div[1]");

    By listElementTD5 = By.xpath("//body[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[11]/td[1]/div[1]/div[1]/div[1]");
    By TD1 = By.xpath("//button[@aria-label='Expand row']");
    By TD2 = By.xpath("//body[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[1]/button[1]");

    By TD3 = By.xpath("//body[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[6]/td[1]/button[1]");

    By TD4 =By.xpath("//body[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[8]/td[1]/button[1]");

    By TD5 = By.xpath("//body[1]/div[1]/section[1]/section[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[10]/td[1]/button[1]");
    public CH_TuyenDoc(WebDriver driver){
        this.driver = driver;
    }

    public void ClickTD(){
        driver.findElement(TD).click();
    }

    public List<WebElement> getListElement() {
        return driver.findElements(listElement);
    }

    public List<WebElement> getListElement1() {
        return driver.findElements(listElementTD1);
    }

    public List<WebElement> getListElement2() {
        return driver.findElements(listElementTD2);
    }

    public List<WebElement> getListElement3() {
        return driver.findElements(listElementTD3);
    }

    public List<WebElement> getListElement4() {
        return driver.findElements(listElementTD4);
    }

    public List<WebElement> getListElement5() {
        return driver.findElements(listElementTD5);
    }

    public void ClickTD1(){
        driver.findElement(TD1).click();
    }

    public void ClickTD2(){
        driver.findElement(TD2).click();
    }

    public void ClickTD3(){
        driver.findElement(TD3).click();
    }

    public void ClickTD4(){
        driver.findElement(TD4).click();
    }

    public void ClickTD5(){
        driver.findElement(TD5).click();
    }
}
