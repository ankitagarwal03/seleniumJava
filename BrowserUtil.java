package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {
    private WebDriver driver;

    public WebDriver driverInit(String browser){
        browser = browser.toLowerCase().trim();

        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Not correct Browser");
                throw new CustomException("INVALIDBROWSER");
        }
        return driver;
    }

    public void openUrl(String url){
        if(!url.contains("http")){
            throw new CustomException("INVALIDURL");
        }
        else{
            driver.manage().window().maximize();
            driver.get(url);
        }
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }

}
