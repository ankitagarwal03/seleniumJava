package DropDown;

import Utils.BrowserUtil;
import Utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class DropDownTest {

    static ElementUtil elementUtil;
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        BrowserUtil browserUtil = new BrowserUtil();
        driver = browserUtil.driverInit("chrome");

        browserUtil.openUrl("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        elementUtil = new ElementUtil(driver);

        By dropDown = By.id("justAnInputBox");
        elementUtil.doClick(dropDown);

        By dropDownLocator = By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//ul/li/span");

//        String[] option = {"choice 1","choice 6 2 1","choice 7","choice 6"};
        String[] option = {"choice 1","choice 2"};
        boolean isSelected = elementUtil.doSelectMultipleChoiceInDropDown(option, dropDownLocator);
        if(isSelected == false){
            System.out.println("invalid option");
        }
        By dropDownPath = By.xpath("(//div[@class='comboTreeInputWrapper'])[1]");


        List<WebElement> checkboxes = driver.findElements(By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                WebElement label = checkbox.findElement(By.xpath("parent::span"));
                System.out.println("Selected option: " + label.getText());
            }
        }

//        String aboveText = driver.findElement(with(By.tagName("input")).below(dropDownPath)).getAttribute("class");
//        String aboveText3 = driver.findElement(with(By.tagName("input")).below(dropDownPath)).getText();
//        String aboveText2 = driver.findElement(with(By.tagName("input")).near(dropDownPath)).getAttribute("id");
//        System.out.println("Above = "+aboveText + "  "+aboveText2 +" text = "+aboveText3 );
//
//        String aboveText1 = driver.findElement(with(By.tagName("span")).below(dropDownLocator)).getText();
//        System.out.println("Below = "+aboveText1);

        By dropDownSelectVal = By.id("justAnInputBox");
        Thread.sleep(2000);
        System.out.println("000 ---- "+driver.findElement(dropDownSelectVal).getText());
        Thread.sleep(10000);
        System.out.println("0001 ---- "+driver.findElement(By.xpath("(//div[@class='comboTreeInputWrapper']/input)[1]")).getText()+" Test");
        Thread.sleep(2000);
        System.out.println("0002 ---- "+driver.findElement(By.xpath("(//div[@class='comboTreeInputWrapper']/input)[1]")).getAttribute("class"));
        Thread.sleep(2000);
        System.out.println("0003 ---- "+driver.findElement(By.xpath("(//div[@class='comboTreeInputWrapper']/input)[1]")).getAttribute("placeholder"));

        By selectedValue = By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//ul/li/span[@data-id]");
//        By selectedValue = By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//ul/li/span");

//        getSelectedValuesOfDropDown(selectedValue);
    }

    public static void getSelectedValuesOfDropDown(By locator){
        List<String> selectedList = elementUtil.isValuesSelected(locator);
        System.out.println(selectedList);
    }



}
