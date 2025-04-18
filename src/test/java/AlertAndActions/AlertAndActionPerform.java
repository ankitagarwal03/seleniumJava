package AlertAndActions;

import Utils.BrowserUtil;
import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlertAndActionPerform {

    public static void main(String[] args) throws InterruptedException {
        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.driverInit("chrome");
        browserUtil.openUrl("https://swisnl.github.io/jQuery-contextMenu/3.x/demo.html");
        Thread.sleep(2000);

        ElementUtil elementUtil = new ElementUtil(driver);
        By rightClickButton = By.xpath("//span[text()='right click me']");

        //click on the right click on me button
        elementUtil.doRightClick(rightClickButton);

        //get all the options and click on them oneByone
        By rightMenu = By.xpath("//ul[@class='context-menu-list context-menu-rootMenuData']//span");
        List<WebElement> rightMenuList = elementUtil.doFindElements(rightMenu);

        doClickOnTheMenu(rightMenuList, "Quit");

        String alertText =  elementUtil.switchToAlertGetTextAndAccept();
        System.out.println("alert Text = "+alertText);
    }

    public static void doClickOnTheMenu(List<WebElement> rightMenuList, String text){
        for(WebElement e : rightMenuList){
            System.out.println(e.getText());
            if(e.getText().equals(text)){
                e.click();
                break;
            }
        }
    }



}
