package Utils;

import org.aspectj.bridge.ISourceLocation;
import org.aspectj.weaver.ISourceContext;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.crypto.spec.PSource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ElementUtil {

    private WebDriver driver;
    private int DEFAULT_TIME_OUT = 5;

    public ElementUtil(WebDriver driver){
        this.driver = driver;

    }

    public void doClick(By locator){
        doFindElement(locator).click();
    }

    public void doClick(By locator, int timeout){
        checkElementClickable(locator, timeout).click();
    }

    public void doClickAndSendKeys(By locator, String value){
        if(value == null){
            throw new CustomException("VALUECANNOTBENULL");
        }
        WebElement element = doFindElement(locator);

        element.click();
        element.sendKeys(value);
    }

    public WebElement doFindElement(By locator, int timeout) {
        return visibilityOfElement(locator, timeout);
    }

    public WebElement doFindElement(By locator) {
        WebElement element = null;

        try{
            element = driver.findElement(locator);
        }catch (NoSuchElementException e){
            System.out.println("Element is not present "+locator);
            element = visibilityOfElement(locator, DEFAULT_TIME_OUT);
        }

        return element;
    }

    public String doGetAttribute(By locator, String attribute){
        return doFindElement(locator).getAttribute(attribute);
    }

    public String doGetText(By locator){
        return doFindElement(locator).getText();
    }

    public List<WebElement> doFindElements(By locator){
        return driver.findElements(locator);
    }

    public List<String> doGetElementAttributeValue(By locator, String attribute){
        List<WebElement> webElementList = doFindElements(locator);
        List<String> eleAttribute = new ArrayList<>();
        for(WebElement element: webElementList){
            eleAttribute.add(element.getAttribute(attribute));
        }
        return eleAttribute;
    }

    public List<String> doGetElementText(By locator){
        List<WebElement> webElementList = doFindElements(locator);
        List<String> eleAttribute = new ArrayList<>();
        for(WebElement element: webElementList){
            eleAttribute.add(element.getText());
        }
        return eleAttribute;
    }

    public int getElementCount(By locator){
        return doFindElements(locator).size();
    }

    public void doClickElementFromPage(By locator, String elementText){
        List<WebElement> elementList = doFindElements(locator);
        for(WebElement element : elementList){
            if(element.getText().equals(elementText)){
                element.click();
                break;
            }
        }
    }

    public void doClickTextContainsElements(By locator, String elementText){
        List<WebElement> elementList = doFindElements(locator);
        for(WebElement element : elementList){
            if(element.getText().toLowerCase().contains(elementText.toLowerCase())){
                element.click();
                break;
            }
            else{
                System.out.println("No Search Result found");
            }

        }
    }

    /*
        ***** DROPDOWN utils ***

     */

    public void doSelectDropDownByIndex(By locator, int index){
        Select select = new Select(doFindElement(locator));
        select.selectByIndex(index);
    }

    public void doSelectDropDownByValue(By locator, String value){
        Select select = new Select(doFindElement(locator));
        select.selectByValue(value);
    }

    public void doSelectDropDownByVisibleText(By locator, String text){
        Select select = new Select(doFindElement(locator));
        select.selectByVisibleText(text);
    }

    public void doSelectDropDownValue(By locator, String dropDownText){
        Select select = new Select(doFindElement(locator));
        List<WebElement> dropDownList = select.getOptions();
        for(WebElement e : dropDownList){
            if(e.getText().equals(dropDownText)){
                e.click();
                break;
            }
        }
    }

    public List<String> doGetDropDownValues(By locator){
        Select select = new Select(doFindElement(locator));
        List<WebElement> dropDownList = select.getOptions();
        List<String> dropDownValueList = new ArrayList<>();
        for(WebElement e : dropDownList){
            dropDownValueList.add(e.getText());
        }

        return dropDownValueList;
    }

    public boolean doSelectDropDownWithOutSelect(By locator, String text){
        boolean flag = false;
        List<WebElement> dropDownList = doFindElements(locator);
        for(WebElement e : dropDownList){
            if(e.getText().equals(text)) {
                flag = true;
                e.click();
                break;
            }
        }
        if(flag == false){
            System.out.println("Not found thr drop down Text "+text);
        }
        return flag;
    }

    public boolean isValueSelected(By locator){
        return driver.findElement(locator).isSelected();
    }

    public List<String> isValuesSelected(By locator){
        List<WebElement> li = driver.findElements(locator);

        List<String> selectedOptionsList = new ArrayList<>();
        List<WebElement> innerElement = driver.findElements(By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//ul/li/span/input"));

        for(int i=0; i<li.size(); i++){
            WebElement e =  li.get(i);
            WebElement inputEle =  innerElement.get(i);
            if(inputEle.isSelected()){
                System.out.println(e.getText());
                System.out.println("yess--- ");
                selectedOptionsList.add(e.getText());
            }
        }

//            for(WebElement cc : innerElement) {
//                if (cc.isSelected()) {
//                    System.out.println("class = " + cc.getAttribute("class"));
//                    System.out.println("Text = " + e.getText());
//                    System.out.println("isSelected = " + cc.isSelected());
//                    System.out.println("TagName = " + cc.getTagName());
//                    selectedOptionsList.add(cc.getText());
//                    break;
//                }
//            }

//        }
        return selectedOptionsList;
    }

    public List<String> doGetAllSelectedDropDownValues(Select select){
        List<WebElement> selectList =  select.getAllSelectedOptions();
        List<String> selectTextList = new ArrayList<>();
        for(WebElement e : selectList){
            selectTextList.add(e.getText());
        }
        return selectTextList;
    }

    public boolean doSelectMultipleChoiceInDropDown(String[] options, By locator){
        List<WebElement> dropDownList = doFindElements(locator);
        boolean flag = false;

        String option = options[0];
        if(!option.equalsIgnoreCase("all")){
            for (WebElement e : dropDownList) {
                for(String str : options){
                    if(e.getText().equalsIgnoreCase(str)){
                        flag = true;
                        e.click();
                        break;
                    }
                }
            }
        }
        else{
            for(WebElement e : dropDownList){
                if(!e.getText().equals("−")) {
                    flag = true;
                    e.click();
                }
            }
        }

        if(flag == false){
            System.out.println("Not found the any option in drop down ");
        }
        return flag;
    }

    /*
        Switch to Frame
     */

    public void switchToFrameViaNameOrID(String name){
        driver.switchTo().frame(name);
    }

    public void switchToFrameViaIndex(int index){
        driver.switchTo().frame(index);
    }

    public void switchToFrameViaWebElement(By locator){
        driver.switchTo().frame(doFindElement(locator));
    }

    /*
        Switch to alert
     */

    public String switchToAlertAndGetText(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String switchToAlertAndGetText(int timeout){
        Alert alert = waitForAlert(timeout);
        return alert.getText();
    }

    public String switchToAlertGetTextAndDismiss(){
        Alert alert = driver.switchTo().alert();
        return getTextAndDismissAlert(alert);
    }

    public String switchToAlertGetTextAndDismiss(int timeout){
        Alert alert = waitForAlert(timeout);
        return getTextAndDismissAlert(alert);
    }

    public String getTextAndDismissAlert(Alert alert){
        String text = alert.getText();
        alert.dismiss();
        return text;
    }

    public String switchToAlertGetTextAndAccept(){
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public void switchToAlertSendKeysAndAccept(String text){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public void switchToAlertSendKeysAndDismiss(String text){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.dismiss();
    }


    /*
        Actions class
     */
    public void doRightClick(By locator){
        Actions actions = new Actions(driver);
        actions.contextClick(doFindElement(locator)).build().perform();
    }

    public void doMoveToElement(By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(doFindElement(locator)).build().perform();
    }

    public void doActionsSendKeys(By locator, String input) {
        Actions actions = new Actions(driver);
        actions.sendKeys(doFindElement(locator), input).build().perform();
    }

    public void doActionsClick(By locator) {
        Actions actions = new Actions(driver);
        actions.click(doFindElement(locator)).build().perform();
    }

    public void doActionsClick(By locator, int timeout) {
        Actions actions = new Actions(driver);
        actions.click(checkElementClickable(locator, timeout)).build().perform();
    }

    public void doActionsSendKeyWithKeys(By locator, Keys keys) {
        Actions actions = new Actions(driver);
        actions.sendKeys(doFindElement(locator), keys).build().perform();
    }

    /**
     * Wait Util
     */

    public WebElement visibilityOfElement(By locator, int timeDuration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //An expectation for checking that all elements present on the web page that match the locator are visible.
    public List<WebElement> visibilityOfAllElement(By locator, int timeDuration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement checkElementClickable(By locator, int timeDuration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickElementWhenReady(By locator, int timeDuration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public Alert waitForAlert(int timeDuration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
        return wait.until(ExpectedConditions.alertIsPresent());
    }


    /*
        get window handles and getWindowHandle
    */

    //Get the current window id
    public String getWindowHandle(){
        return driver.getWindowHandle();
    }

    //Get the all window id
    public Set<String> getWindowHandles(){
         return driver.getWindowHandles();
    }

    public boolean waitForWindowHandles(int timeOut, int noOfWindows){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows));
    }

}
