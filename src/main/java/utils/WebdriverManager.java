package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverManager {

    public static WebDriver driver;
    
    public WebDriver launchBrowser(String browser) {
    	
    	if (browser.equals("chrome")||browser.equals("Chrome")||browser.equals("CHROME")) {
    		
    		driver = new ChromeDriver();
    		driver.manage().window().maximize();		
    	}else if(browser.equals("edge")||browser.equals("Edge")||browser.equals("EDGE")) {
    		
    		driver =  new EdgeDriver();
    		driver.manage().window().maximize();
    	}
        else if(browser.equals("firefox")||browser.equals("Firefox")||browser.equals("ff")) {
    		
    		driver =  new FirefoxDriver();
    		driver.manage().window().maximize();
    	}
    	return driver;
    }
    
    public void closeBrowser() {
    	
    	driver.quit();
    }
    
}
