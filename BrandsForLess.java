package Practice;

import Utils.BrowserUtil;
import Utils.ElementUtil;
import org.apache.poi.ss.formula.functions.WeekNum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BrandsForLess {

    public static void main(String[] args) throws InterruptedException {

        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.driverInit("chrome");

        browserUtil.openUrl("https://www.brandsforless.com/en-ae/men/shoes/");
        Thread.sleep(5000);
        ElementUtil elementUtil = new ElementUtil(driver);

        By getRRP = By.xpath("(//div[@class='container']/ul[@class='list_item_wrapper']/li)[1]/a/div[@class='item_description_wrapper']//div/div[@class='rrp_section']");
//        System.out.println("Element Text = "+elementUtil.doFindElement(getRRP).getText());

        By items = By.xpath("//div[@class='container']/ul[@class='list_item_wrapper']/li/a/div[@class='item_description_wrapper']//div/h5");
        List<WebElement> itemList = elementUtil.doFindElements(items);

        By paginationDisplay = By.cssSelector(".paginate_display > span");
        WebElement pagination = elementUtil.doFindElement(paginationDisplay);
        String[] split = pagination.getText().split("/");
        System.out.println(split[0]+" -- "+split[1]+" -- ");
        int totalPageSize = Integer.parseInt(split[1]);


        int count = 1;
        boolean flag = true;
        while(flag) {
            for (WebElement e : itemList) {
//                System.out.print("Item name = "+e.getText());
                if (e.getText().equalsIgnoreCase("nike")) {
                    e.click();
                    flag = false;
                    break;
                }
            }
            System.out.println(count<totalPageSize);
            count = ++count;
            if(count<=totalPageSize && flag == true){
                System.out.println(" Current page-------------- "+count);
                System.out.println("page = "+elementUtil.doFindElement(By.xpath("//ul[@class='pagination']/li/a[text()='"+count+"']")).getText());
                elementUtil.doFindElement(By.xpath("//ul[@class='pagination']/li/a[text()='"+count+"']")).click();
                Thread.sleep(3000);
//                List<WebElement> pageNumber = elementUtil.doFindElements(By.xpath("//ul[@class='pagination']/li/a[@aria-label]"));
//                int next = ++count;
//                String nextPage = String.valueOf(next);
//                for(WebElement e : pageNumber){
//                    System.out.println("Page Number from HTML ====== "+e.getText() + " Next Page "+nextPage);
//                    if(e.getText().trim().equalsIgnoreCase(nextPage)){
//                        System.out.print("click on the page no = "+e.getText());
//                        e.click();
//                        Thread.sleep(3000);
//                        break;
//                    }
//                }
            }
            else{
                break;
            }

        }


    }


}
