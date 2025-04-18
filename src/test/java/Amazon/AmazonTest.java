package Amazon;

import Utils.BrowserUtil;
import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AmazonTest {


    static WebDriver driver;
    public static void main(String[] args){
        BrowserUtil browserUtil = new BrowserUtil();
        driver = browserUtil.driverInit("chrome");
        ElementUtil elementUtil = new ElementUtil(driver);

        browserUtil.openUrl("https://www.amazon.in/");

        By email = By.id("twotabsearchtextbox");
        elementUtil.doClickAndSendKeys(email, "Ankit");

        By footer = By.xpath("//div[@id='navFooter']/div//a");
        List<String> footerList = elementUtil.doGetElementText(footer);
        for (String str : footerList){
            System.out.println(str);
        }
        //quit the browser
//        browserUtil.quitBrowser();



    }

}
