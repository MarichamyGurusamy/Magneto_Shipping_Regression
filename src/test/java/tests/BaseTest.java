package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.WebdriverManager;

public class BaseTest extends WebdriverManager{

	public WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void setupSite(String browser) throws InterruptedException {
        driver= launchBrowser(browser);	
		driver.get("https://magento.softwaretestingboard.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		WebdriverManager  manage =  new WebdriverManager();
		manage.closeBrowser();
	}

	

}
