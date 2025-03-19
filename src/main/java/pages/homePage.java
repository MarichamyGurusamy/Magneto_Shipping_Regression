package pages;

import static org.testng.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

public class homePage {

	private WebDriver driver; 
	
	public homePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	Screen screen = new Screen();

	// Guest user Header Web Elements
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	public WebElement signInLink;

	@FindBy(linkText = "Create an Account")
	public WebElement createAccountLink;

	@FindBy(xpath = "//a[@aria-label='store logo']//img")
	public WebElement Logo;

	String logoImagePath = "https://magento.softwaretestingboard.com/pub/static/version1695896754/frontend/Magento/luma/en_US/images/logo.svg";

	@FindBy(id = "ui-id-3")
	public WebElement whatsNewTopNav;

	@FindBy(id = "ui-id-4")
	public WebElement womenTopNav;

	@FindBy(id = "ui-id-5")
	public WebElement menTopNav;

	@FindBy(id = "ui-id-6")
	public WebElement gearTopNav;

	@FindBy(id = "ui-id-7")
	public WebElement gearTrainingTopNav;

	@FindBy(id = "ui-id-8")
	public WebElement saleTopNav;

	@FindBy(id = "search")
	public WebElement searchBox;

	@FindBy(xpath = "//button//span[text()='Search']")
	public WebElement searchIcon;

	@FindBy(id = "search")
	public WebElement placeholder;

	

	public String ExpectedsearchBoxPlaceholder = "Search entire store here...";

	@FindBy(css = ".action.showcart")
	public WebElement miniCart;

	@FindBy(className = "breadcrumbs")
	public WebElement breadCrumb;

	@FindBy(xpath = "//span[.='Home Page']")
	public WebElement homePageHeading;

	@FindBy(css = ".block-promo.home-main")
	public WebElement homePageMainBanner;

	@FindBy(xpath = "//span[@class='info']")
	public WebElement BanneryogaLink;

	@FindBy(xpath = "//h2[@class='title']")
	public WebElement HotSellersSectionHeading;

	@FindBy(xpath = "//p[.='Here is what`s trending on Luma right now']")
	public WebElement HotSellersSectionSubHeading;

	@FindBy(xpath = "product-items widget-product-grid")
	public WebElement hotsellerProductsWidget;

	@FindBys({ @FindBy(tagName = "li"), // Tag is 'a' (anchor tags)
			@FindBy(className = "product-item") // And class is 'category-link'
	})
	public List<WebElement> hotsellerWidgetProducts;

	@FindBy(className = "product-image-photo")
	public List<WebElement> productImages;

	@FindBy(className = "product-item-link")
	public List<WebElement> productNames;

	@FindBy(className = "price-label")
	public List<WebElement> asLowasText;

	@FindBy(className = "price")
	public List<WebElement> productPrices;

	@FindBy(className = "rating-summary")
	public List<WebElement> productStartRating;

	@FindBy(css = ".action.view")
	public List<WebElement> productReviewes;

	@FindBy(css = ".swatch-option.text")
	public List<WebElement> productSizeOptions;

	@FindBy(css = ".swatch-option.color")
	public List<WebElement> productColorOptions;

	@FindBy(xpath = "//button[@title='Add to Cart']")
	public List<WebElement> productAddToCartButton;

	@FindBy(xpath = "//a[@title='Add to Wish List']")
	public List<WebElement> productAddToWishListIcon;

	@FindBy(xpath = "//a[@title='Add to Compare']")
	public List<WebElement> productAddToCompareIcon;

	@FindBy(className = "page-footer")
	public WebElement pageFooter;

	public String homePageURL = "https://magento.softwaretestingboard.com/";
	
	public String homePageTitle = "Home Page";
	
	
	public String getHomePageURL() {
		
		   String actualURL= driver.getCurrentUrl();
		return actualURL;
	}
	
	public String gethomePageTitle() {
		
		String actualTitle = driver.getTitle();
		
		return actualTitle;
		
		
	}
	
	
	public void headerLogoVerification() {

		boolean headerLogo = Logo.isDisplayed();
		Assert.assertTrue(headerLogo);

		try {
			screen.find(logoImagePath);
		} catch (FindFailed e) {

			Assert.fail("Logo not found");
			e.printStackTrace();
		}

	}

	public void HeaderSignInLInkVerification() {

		boolean signinLinkDisplaying = signInLink.isDisplayed();

		Assert.assertTrue(signinLinkDisplaying);

	}

	public void clickSignInLinkInHeader() {
		signInLink.click();
	}

	public void HeaderCreateAnAccountlinkVerification() {

		boolean headerCreateAnAccountDisplaying = createAccountLink.isDisplayed();

		Assert.assertTrue(headerCreateAnAccountDisplaying);

	}

	public void clickCreateanAccountLink() {

		createAccountLink.click();
	}

	public String getSearchBoxPlaceHolderText() {
		
		String searchBoxPlaceHolder = placeholder.getAttribute("placeholder");
		
		return searchBoxPlaceHolder;
	}
	
//	public void headerSearchboxVerification() {
//		boolean headerSearchBoxDisplaying = searchBox.isDisplayed();
//		Assert.assertTrue(headerSearchBoxDisplaying);
//		Assert.assertEquals(searchBoxPlaceHolder, ExpectedsearchBoxPlaceholder);
//		boolean searchIconDisplaying = searchIcon.isDisplayed();
//		Assert.assertTrue(searchIconDisplaying);
//
//	}
	
	public void headerCartIconVerification() {
		
		boolean headerCartIconDisplaying = miniCart.isDisplayed();
		Assert.assertTrue(headerCartIconDisplaying);
		
	}
	
	public void topNavigationLinksVerification() {
		
		
		
	}

}
