import Utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class WebTable {

    public static void main(String[] args){
        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.driverInit("chrome");
        browserUtil.openUrl("https://www.w3schools.com/html/html_tables.asp");
        List<WebElement> companyList = driver.findElements(By.xpath("//table[@id='customers']//tr/td[1]"));

        for(WebElement e : companyList){
            System.out.println(e.getText());
        }

        driver.findElement(with(By.tagName("p")).toLeftOf(By.xpath(""))).getText();

    }


}
