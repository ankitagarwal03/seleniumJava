package GoogleSearch;

import Utils.BrowserUtil;
import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {

    public static void main(String[] args) throws InterruptedException {
        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.driverInit("chrome");

        browserUtil.openUrl("https://www.google.com/");

        ElementUtil elementUtil = new ElementUtil(driver);

        By searchBox = By.id("APjFqb");
        elementUtil.doClickAndSendKeys(searchBox, "ankit");
        Thread.sleep(3000);
        By searchRes = By.xpath("//div[@class='wM6W7d']/span");
        elementUtil.doClickTextContainsElements(searchRes,"gupta");

        System.out.println(browserUtil.getUrl());
        System.out.println(browserUtil.getTitle());

    }

}
