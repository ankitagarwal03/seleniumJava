package Practice;

import Utils.BrowserUtil;
import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SpiceActions {

    public static void main(String[] args){
        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.driverInit("chrome");
        browserUtil.openUrl("https://www.spicejet.com/");

        ElementUtil elementUtil = new ElementUtil(driver);

        By book = By.xpath("//div[text()='Add-ons']");
        elementUtil.doMoveToElement(book);

        By flight = By.linkText("You1st");
        elementUtil.doClick(flight);

        elementUtil.doActionsSendKeyWithKeys(flight, Keys.F5);

    }

}
