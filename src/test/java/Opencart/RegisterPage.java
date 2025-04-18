package Opencart;

import Utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RegisterPage {

    public static void main(String[] args){
        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.driverInit("chrome");
        browserUtil.openUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        By subscribeRadio = By.xpath("(//label[@class='radio-inline'])[1]/input");
        By subscribeRadioLeft = By.xpath("(//label[@class='radio-inline'])[2]/input");

        driver.findElement(with(By.tagName("label")).near(subscribeRadio)).click();

        String labeltext = driver.findElement(with(By.tagName("label")).toLeftOf(subscribeRadioLeft)).getText();
        System.out.println("label "+labeltext);


        By privacyPolicy = By.cssSelector(".agree");
        WebElement checkBox = driver.findElement(with(By.tagName("input")).toRightOf(privacyPolicy));
        System.out.println("checkBox Name = "+checkBox.getAttribute("name"));
        checkBox.click();

        driver.switchTo().frame("").switchTo().frame("");


    }

}
