package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class WhatsNewPage {
	

    // Guest user Header Web Elements
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	public WebElement signInLink;
	
	@FindBy(linkText = "Create an Account")
	public WebElement createAccountLink;
	
	@FindBy(xpath = "//a[@aria-label='store logo']//img")
	public WebElement Logo;
	
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
	
	public String searchBoxPlaceHolder =  placeholder.getAttribute("placeholder");
	
	@FindBy(className = "action showcart")
	public WebElement miniCart;
	
	@FindBy(className =  "breadcrumbs")
	public WebElement breadCrumb;
	
	@FindBy(id =  "page-title-heading")
	public WebElement homePageHeading;
	
	@FindBy(className =  "categories-menu")
	public WebElement categoryLeftMenu;
	
	@FindBy(xpath =  "//span[text()=\"New in women's\"]")
	public WebElement womenCategoryHeading;
	
	@FindBy(xpath =  "//span[text()=\"New in men's\"]")
	public WebElement menCategoryHeading;
	
	@FindBy(xpath =  "//main[@id='maincontent']//ul[1]//li[1]//a[1]")
	public WebElement womensHoodiesCategory;
	
	@FindBy(xpath =  "//main[@id='maincontent']//ul[1]//li[2]//a[1]")
	public WebElement womensJacketCategory;
	
	@FindBy(xpath =  "//main[@id='maincontent']//ul[1]//li[3]//a[1]")
	public WebElement womensTeesCategory;
	
	@FindBy(xpath =  "//a[contains(text(),'Bras & Tanks')]")
	public WebElement brasTanksCategory;
	
	@FindBy(xpath =  "//main[@id='maincontent']//ul[1]//li[5]//a[1]")
	public WebElement womensPantCategory;
	
	@FindBy(xpath =  "//main[@id='maincontent']//ul[1]//li[6]//a[1]")
	public WebElement womensShortsCategory;
	
	@FindBy(xpath =  "//ul[2]//li[1]//a[1]")
	public WebElement mensHoodiesCategory;
	
	@FindBy(xpath =  "//ul[2]//li[2]//a[1]")
	public WebElement mensJacketCategory;
	
	@FindBy(xpath =  "//ul[2]//li[3]//a[1]")
	public WebElement mensTeesCategory;
	
	@FindBy(xpath =  "//li[@class='item']//a[normalize-space()='Tanks']")
	public WebElement mensTanksCategory;
	
	@FindBy(xpath =  "//ul[2]//li[5]//a[1]")
	public WebElement mensPantCategory;
	
	@FindBy(xpath =  "//ul[2]//li[6]//a[1]")
	public WebElement mensShortsCategory;
	
	@FindBy(id = "block-compare-heading")
	public WebElement compareSectionHeading;
	
	@FindBy(xpath = "//div[normalize-space()='You have no items to compare.']")
	public WebElement compareSectionNoProductMessage;
	
	@FindBy(xpath = "//strong[normalize-space()='My Wish List']")
	public WebElement myWishListSectionHeading;
	
	@FindBy(xpath = "//div[normalize-space()='You have no items in your wish list.']")
	public WebElement noWishListMessage;
	
	@FindBy(className = "block-promo new-main")
	public WebElement homePageMainBanner;
	
	@FindBy(xpath = "//strong[contains(text(),'The very latest yoga styles')]")
	public WebElement BanneryogaLink;
	
	@FindBy(className = "block-promo new-performance")
	public WebElement performancepromBanner;
	
	@FindBy(xpath = "//strong[normalize-space()='Whatever day brings']")
	public WebElement performancepromBannerLink;
	
	@FindBy(className = "block-promo new-eco")
	public WebElement ecopromBanner;
	
	@FindBy(xpath = "//span[normalize-space()='Enjoy comfort of body and mind with Luma eco-friendly choices']")
	public WebElement ecopromBannerLink;
	
	@FindBy(xpath = "//h2[@class='title']")
	public WebElement latestSectionHeading;
	
	@FindBy(xpath = "//p[@class='info']")
	public WebElement latestSectionSubHeading;
	
	@FindBy(className = "product-items widget-product-grid")
	public WebElement LatestProductsWidget;
	
	@FindBys({
        @FindBy(tagName = "li"),  // Tag is 'a' (anchor tags)
        @FindBy(className = "product-item")  // And class is 'category-link'
    })
	public List<WebElement> latestWidgetProducts;
	
	@FindBy(className = "product-image-photo")
	public List<WebElement> productImages;
	
	@FindBy(className = "product-item-link")
	public List<WebElement> productNames;
	
	@FindBy(className = "price")
	public List<WebElement> productPrices;
	
	@FindBy(className = "rating-summary")
	public List<WebElement> productStartRating;
	
	@FindBy(className = "action view")
	public List<WebElement> productReviewes;
	
	@FindBy(className = "swatch-option text")
	public List<WebElement> productSizeOptions;
	
	@FindBy(className = "swatch-option color")
	public List<WebElement> productColorOptions;
	
	@FindBy(xpath = "//button[@title='Add to Cart']")
	public List<WebElement> productAddToCartButton;
	
	@FindBy(xpath = "//a[@title='Add to Wish List']")
	public List<WebElement> productAddToWishListIcon;
	
	@FindBy(xpath = "//a[@title='Add to Compare']")
	public List<WebElement> productAddToCompareIcon;
	
	@FindBy(className = "page-footer")
	public WebElement pageFooter;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
