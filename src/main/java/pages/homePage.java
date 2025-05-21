package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	private WebDriver driver;
	public Actions action;

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);

	}


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

		String actualURL = driver.getCurrentUrl();
		return actualURL;
	}

	public String gethomePageTitle() {

		String actualTitle = driver.getTitle();

		return actualTitle;

	}

	


	
	
	//Sale top nav related elements
	
	public String SalePageHeading = "Sale";

	public String SalePageTitle = "Sale";

	public String SalePageURL = "https://magento.softwaretestingboard.com/sale.html";


}
