package Practice;


import Utils.BrowserUtil;
import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.*;

public class WindowHandles {
    public static void main(String[] args) throws InterruptedException {
        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.driverInit("chrome");
        ElementUtil elementUtil = new ElementUtil(driver);
        browserUtil.openUrl("https://www.browserstack.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By socialMediaLinkBy = By.xpath("//div[@class='custom-footer-wrapper']//li/a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(socialMediaLinkBy));

        List<WebElement> socialMediaList = elementUtil.doFindElements(socialMediaLinkBy);
        String parentWindowId = driver.getWindowHandle();

        for(WebElement e : socialMediaList){
            e.click();
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> it = windows.iterator();
            while(it.hasNext()){
                System.out.println("Inside the close");
                String nextWindow = it.next();
                if(!parentWindowId.equals(nextWindow)){
                    driver.switchTo().window(nextWindow);
                    System.out.println(browserUtil.getUrl());
                    Thread.sleep(1000);
                    driver.close();
                }
            }
            driver.switchTo().window(parentWindowId);

        }
//        Set<String> windows = driver.getWindowHandles();
//        System.out.println(windows);
//        Thread.sleep(2000);
//
//        Iterator<String> it = windows.iterator();
//        while(it.hasNext()){
//            System.out.println("Inside the close");
//            String nextWindow = it.next();
//            if(!parentWindowId.equals(nextWindow)){
//                driver.switchTo().window(nextWindow);
//                System.out.println(browserUtil.getUrl());
//                Thread.sleep(1000);
//                driver.close();
//            }
//        }

        System.out.println("current URL "+driver.getCurrentUrl());

    }

}
