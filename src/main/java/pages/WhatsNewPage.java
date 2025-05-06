package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class WhatsNewPage {
	public WebDriver driver;
	public WhatsNewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
    // Guest user Header Web Elements
	@FindBy(xpath = "//h1[@class='page-title']//span")
	
	public WebElement whatsNewPageHeading;

	public String expectedPageTitle = "What's New";
	
	public String expectedwhatsNewPageHeading = "What's New";
	
	public String expectedURL =  "https://magento.softwaretestingboard.com/what-is-new.html";
	
	public String getPageHeading() {
		
		String heading = whatsNewPageHeading.getText();
		
	return heading;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
