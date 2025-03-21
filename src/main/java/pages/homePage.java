package pages;

import static org.testng.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

public class homePage {

	private WebDriver driver;

	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	Actions action = new Actions(driver);

	public Screen screen = new Screen();

	// Guest user Header Web Elements
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	public WebElement signInLink;

	@FindBy(linkText = "Create an Account")
	public WebElement createAccountLink;

	@FindBy(xpath = "//a[@aria-label='store logo']//img")
	public WebElement Logo;

	public String logoImagePath = "https://magento.softwaretestingboard.com/pub/static/version1695896754/frontend/Magento/luma/en_US/images/logo.svg";

	@FindBy(id = "ui-id-3")
	public WebElement whatsNewTopNav;

	@FindBy(id = "ui-id-4")
	public WebElement womenTopNav;

	@FindBy(id = "ui-id-9")
	public WebElement HeaderwomenTopsSubcategoryLink;

	@FindBy(xpath = "//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")
	public WebElement HeaderwomenTops_JacketSubcategoryLink;

	@FindBy(xpath = "//a[@id='ui-id-12']//span[contains(text(),'Hoodies & Sweatshirts')]")
	public WebElement HeaderwomenTops_HoodieSubcategoryLink;

	@FindBy(xpath = "//a[@id='ui-id-13']")
	public WebElement HeaderwomenTops_TeesSubcategoryLink;

	@FindBy(xpath = "//span[normalize-space()='Bras & Tanks']")
	public WebElement HeaderwomenTops_BrasSubcategoryLink;

	@FindBy(id = "ui-id-10")
	public WebElement HeaderwomenBottomsSubcategoryLink;

	@FindBy(xpath = "//a[@id='ui-id-13']")
	public WebElement HeaderwomenBottom_PantsSubcategoryLink;

	@FindBy(xpath = "//span[normalize-space()='Bras & Tanks']")
	public WebElement HeaderwomenBottoms_ShortsSubcategoryLink;

	@FindBy(id = "ui-id-5")
	public WebElement menTopNav;

	@FindBy(id = "ui-id-17")
	public WebElement HeadermenTopsSubcategoryLink;

	@FindBy(xpath = "//a[@id='ui-id-19']//span[contains(text(),'Jackets')]")
	public WebElement HeadermenTops_JacketSubcategoryLink;

	@FindBy(xpath = "//a[@id='ui-id-20']//span[contains(text(),'Hoodies & Sweatshirts')]")
	public WebElement HeadermenTops_HoodieSubcategoryLink;

	@FindBy(xpath = "//a[@id='ui-id-21']//span[contains(text(),'Tees')]")
	public WebElement HeadermenTops_TeesSubcategoryLink;

	@FindBy(xpath = "//span[normalize-space()='Tanks']")
	public WebElement HeadermenTops_TanksSubcategoryLink;

	@FindBy(id = "ui-id-18")
	public WebElement HeadermenBottomsSubcategoryLink;

	@FindBy(xpath = "//a[@id='ui-id-23']//span[contains(text(),'Pants')]")
	public WebElement HeadermenBottom_PantsSubcategoryLink;

	@FindBy(xpath = "//a[@id='ui-id-24']//span[contains(text(),'Shorts')]")
	public WebElement HeadermenBottoms_ShortsSubcategoryLink;

	@FindBy(id = "ui-id-6")
	public WebElement gearTopNav;

	@FindBy(xpath = "//span[normalize-space()='Bags']")
	public WebElement Headergear_BagSubcategoryLink;

	@FindBy(xpath = "//span[normalize-space()='Fitness Equipment']")
	public WebElement Headergear_FitnessSubcategoryLink;

	@FindBy(xpath = "//span[normalize-space()='Watches']")
	public WebElement Headergear_WatchSubcategoryLink;

	@FindBy(xpath = "//span[normalize-space()='Video Download']")
	public WebElement TrainingVideoLink;

	@FindBy(id = "ui-id-7")
	public WebElement TrainingTopNav;

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

		String actualURL = driver.getCurrentUrl();
		return actualURL;
	}

	public String gethomePageTitle() {

		String actualTitle = driver.getTitle();

		return actualTitle;

	}

	public void clickheaderLogo() {
		Logo.click();
	}

	public int[] getLogoSize() {

		int logoHeight = Logo.getSize().getHeight();
		int logoWidth = Logo.getSize().getWidth();

		int logoSize[] = { logoHeight, logoWidth };
		return logoSize;
	}

	public void clickWhatsNewTopNav() {

		whatsNewTopNav.click();

	}

	public void clickWomenTopNav() {

		womenTopNav.click();

	}

	public void hoverWomenTopnav() {

		action.moveToElement(womenTopNav).perform();

	}

	public void clickWomensCategoryTops() {

		HeaderwomenTopsSubcategoryLink.click();

	}

	public void hoverWomensCategoryTops() {

		action.moveToElement(HeaderwomenTopsSubcategoryLink).perform();

	}
	
	public void clickWomensTops_Jacketscategory() {

		HeaderwomenTops_JacketSubcategoryLink.click();

	}

	public void hoverWomensTops_JacketsCategory() {

		action.moveToElement(HeaderwomenTops_JacketSubcategoryLink).perform();

	}
	
	public void clickWomensTops_Hoodiecategory() {

		HeaderwomenTops_HoodieSubcategoryLink.click();

	}

	public void hoverWomensTops_HoodieCategory() {

		action.moveToElement(HeaderwomenTops_HoodieSubcategoryLink).perform();

	}
	
	public void clickWomensTops_Teescategory() {

		HeaderwomenTops_TeesSubcategoryLink.click();

	}

	public void hoverWomensTops_TeesCategory() {

		action.moveToElement(HeaderwomenTops_TeesSubcategoryLink).perform();

	}
	
	public void clickWomensTops_Brascategory() {

		HeaderwomenTops_BrasSubcategoryLink.click();

	}

	public void hoverWomensTops_BrasCategory() {

		action.moveToElement(HeaderwomenTops_BrasSubcategoryLink).perform();

	}
	
	
	

	public void clickWomensCategoryBottoms() {

		HeaderwomenBottomsSubcategoryLink.click();

	}

	public void hoverWomensCategoryBottoms() {

		action.moveToElement(HeaderwomenBottomsSubcategoryLink).perform();

	}

	public void clickWomensBottom_Pantscategory() {

		HeaderwomenBottom_PantsSubcategoryLink.click();

	}

	public void hoverWomensBottom_PantsCategory() {

		action.moveToElement(HeaderwomenBottom_PantsSubcategoryLink).perform();

	}
	
	public void clickWomensBottom_Shortscategory() {

		HeaderwomenBottoms_ShortsSubcategoryLink.click();

	}

	public void hoverWomensBottom_ShortsCategory() {

		action.moveToElement(HeaderwomenBottoms_ShortsSubcategoryLink).perform();

	}
	
	public void clickmenTopNav() {

		menTopNav.click();

	}

	public void hovermenTopnav() {

		action.moveToElement(menTopNav).perform();

	}
	
	public void clickmensCategoryTops() {

		HeadermenTopsSubcategoryLink.click();

	}

	public void hovermensCategoryTops() {

		action.moveToElement(HeadermenTopsSubcategoryLink).perform();

	}
	
	public void clickmensTops_Jacketscategory() {

		HeadermenTops_JacketSubcategoryLink.click();

	}

	public void hovermensTops_JacketsCategory() {

		action.moveToElement(HeadermenTops_JacketSubcategoryLink).perform();

	}
	
	public void clickmensTops_Hoodiecategory() {

		HeadermenTops_HoodieSubcategoryLink.click();

	}

	public void hovermensTops_HoodieCategory() {

		action.moveToElement(HeadermenTops_HoodieSubcategoryLink).perform();

	}
	
	public void clickmensTops_Teescategory() {

		HeaderwomenTops_TeesSubcategoryLink.click();

	}

	public void hovermensTops_TeesCategory() {

		action.moveToElement(HeaderwomenTops_TeesSubcategoryLink).perform();

	}
	
	public void clickmensTops_Tankscategory() {

		HeaderwomenTops_BrasSubcategoryLink.click();

	}

	public void hovermensTops_TanksCategory() {

		action.moveToElement(HeadermenTops_TanksSubcategoryLink).perform();

	}
	
	
	

	public void clickmensCategoryBottoms() {

		HeadermenBottomsSubcategoryLink.click();

	}

	public void hovermensCategoryBottoms() {

		action.moveToElement(HeadermenBottomsSubcategoryLink).perform();

	}

	public void clickmensBottom_Pantscategory() {

		HeadermenBottom_PantsSubcategoryLink.click();

	}

	public void hovermensBottom_PantsCategory() {

		action.moveToElement(HeadermenBottom_PantsSubcategoryLink).perform();

	}
	
	public void clickmensBottom_Shortscategory() {

		HeadermenBottoms_ShortsSubcategoryLink.click();

	}

	public void hovermensBottom_ShortsCategory() {

		action.moveToElement(HeadermenBottoms_ShortsSubcategoryLink).perform();

	}
	
	public void clickGearTopNavcategory() {

		gearTopNav.click();

	}

	public void hoverTopNavGearCategory() {

		action.moveToElement(gearTopNav).perform();

	}
	
	public void clickGearBagsSubcategory() {

		Headergear_BagSubcategoryLink.click();

	}

	public void hoverGearBagCategory() {

		action.moveToElement(Headergear_BagSubcategoryLink).perform();

	}
	
	public void clickGearFitnessSubcategory() {

		Headergear_FitnessSubcategoryLink.click();

	}

	public void hoverGearFitnessCategory() {

		action.moveToElement(Headergear_FitnessSubcategoryLink).perform();

	}
	
	public void clickGearWatchSubcategory() {

		Headergear_WatchSubcategoryLink.click();

	}

	public void hoverGearWatchCategory() {

		action.moveToElement(Headergear_WatchSubcategoryLink).perform();

	}
	
	public void clickTrainingLink() {

		TrainingTopNav.click();

	}

	public void hoverTrainingLink() {

		action.moveToElement(TrainingTopNav).perform();

	}
	
	public void clickTrainingVideoDownloadLink() {

		TrainingVideoLink.click();

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
	
	public void getSubcategoryLinksFromWomenTopNavCategory() {
		
		
		
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
