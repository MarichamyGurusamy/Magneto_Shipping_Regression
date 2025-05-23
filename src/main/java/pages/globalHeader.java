package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Screen;
import org.testng.Assert;

public class globalHeader {

	private WebDriver driver;
	public Actions action;

	public globalHeader(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);

	}

	public Screen screen = new Screen();

	/* xpaths and Expected subcatagory links for validating the womens top nav */
	
	
	public String allTopNavLinks[] = {"What's New", "Women", "Men", "Gear", "Training", "Sale"}; 
	
	public String allHeaderTopNavCatsPath = "//nav[@class='navigation']//ul[@class='ui-menu ui-widget ui-widget-content ui-corner-all']//li//a[@class='level-top ui-corner-all']";
	
	public String WomensCategoryPageHeading = "Women";

	public String WomensCategoryTitle = "Women";

	public String WomensCategoryURL = "https://magento.softwaretestingboard.com/women.html";

	public String WomensTopNavFirstLevelCategories = "//a[span[text()='Women']]/following-sibling::ul/li/a";
	public String WomensTopsSubLevelCategories = "//li[@class='level1 nav-2-1 category-item first parent ui-menu-item']//ul//li";

	public String WomensBottomsSubLevelCategories = "//li[@class='level1 nav-2-2 category-item last parent ui-menu-item']//ul//li";

	public String expectedFirstLevelWomensCategories[] = { "Tops", "Bottoms" };
	
	public String expectedWomensTopsSubLevelCategories[] = { "Jackets", "Hoodies & Sweatshirts", "Tees", "Bras & Tanks" };
	
	public String expectedWomensBottomsSubLevelCategories[] = { "Pants", "Shorts"};
	
	public String WomenTopNavFirstLevelCategoryNavigationURLS[] =  {
			
			"https://magento.softwaretestingboard.com/women/tops-women.html",
			"https://magento.softwaretestingboard.com/women/bottoms-women.html"
			                                                    
	};
	
	public String WomenTopNavFirstLevelCategoryPageTiltles[] =  {"Tops - Women","Bottoms - Women"};
	
	public String WomenTopsSubLevelCategoryNavigationURLS[] =  {
			
			"https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html",
			"https://magento.softwaretestingboard.com/women/tops-women/hoodies-and-sweatshirts-women.html",
			"https://magento.softwaretestingboard.com/women/tops-women/tees-women.html",
			"https://magento.softwaretestingboard.com/women/tops-women/tanks-women.html"
			                                                    
	};
	
	public String WomenTopsSubLevelCategoryPageTiltles[] =  {"Jackets - Tops - Women","Hoodies & Sweatshirts - Tops - Women", "Tees - Tops - Women", "Bras & Tanks - Tops - Women"};
	
	public String WomenBottomsSubLevelCategoryNavigationURLS[] =  {
			
			"https://magento.softwaretestingboard.com/women/bottoms-women/pants-women.html",
			"https://magento.softwaretestingboard.com/women/bottoms-women/shorts-women.html",
			
			                                                    
	};
	
	public String WomenBottomsSubLevelCategoryPageTiltles[] =  {"Pants - Bottoms - Women","Shorts - Bottoms - Women"};
	
	
/* xpaths and Expected subcatagory links for validating the mens top nav */
	
	public String mensCategoryPageHeading = "Men";

	public String mensCategoryTitle = "Men";

	public String mensCategoryURL = "https://magento.softwaretestingboard.com/men.html";
	
	public String mensTopNavFirstLevelCategories = "//a[span[text()='Men']]/following-sibling::ul/li/a";

	public String mensTopsSubLevelCategories = "//li[@class='level1 nav-3-1 category-item first parent ui-menu-item']//ul//li";

	public String mensBottomsSubLevelCategories = "//li[@class='level1 nav-3-2 category-item has-active last parent ui-menu-item']//ul//li";

	public String expectedFirstLevelmensCategories[] = { "Tops", "Bottoms" };
	
	public String expectedmensTopsSubLevelCategories[] = { "Jackets", "Hoodies & Sweatshirts", "Tees", "Tanks" };
	
	public String expectedmensBottomsSubLevelCategories[] = { "Pants", "Shorts"};
	
	public String menTopNavFirstLevelCategoryNavigationURLS[] =  {
			
			"https://magento.softwaretestingboard.com/men/tops-men.html",
			"https://magento.softwaretestingboard.com/men/bottoms-men.html"
			                                                    
	};
	
	public String menTopNavFirstLevelCategoryPageTiltles[] =  {"Tops - Men","Bottoms - Men"};
	
	public String menTopsSubLevelCategoryNavigationURLS[] =  {
			
			"https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html",
			"https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html",
			"https://magento.softwaretestingboard.com/men/tops-men/tees-men.html",
			"https://magento.softwaretestingboard.com/men/tops-men/tanks-men.html"
			                                                    
	};
	
	public String menTopsSubLevelCategoryPageTiltles[] =  {"Jackets - Tops - Men","Hoodies & Sweatshirts - Tops - Men", "Tees - Tops - Men", "Tanks - Tops - Men"};
	
	public String menBottomsSubLevelCategoryNavigationURLS[] =  {
			
			"https://magento.softwaretestingboard.com/men/bottoms-men/pants-men.html",
			"https://magento.softwaretestingboard.com/men/bottoms-men/shorts-men.html",
			
			                                                    
	};
	
	public String menBottomsSubLevelCategoryPageTiltles[] =  {"Pants - Bottoms - Men","Shorts - Bottoms - Men"};
	
	
	//Gear top nav and its subcategory links elements
	
	public String gearText = "Gear";
	
    public String gearPageURL = "https://magento.softwaretestingboard.com/gear.html";
	
    public String gear_PageTitle = "Gear";
	
    public String gear_Categories[] = {"Bags", "Fitness Equipment", "Watches"}; 
	
    public String gear_SubcategoryPageURLs[] = { 
    		
    		"https://magento.softwaretestingboard.com/gear/bags.html",
    		"https://magento.softwaretestingboard.com/gear/fitness-equipment.html",
    		"https://magento.softwaretestingboard.com/gear/watches.html"
    		   		
    };
    
    public String gear_SubcategoryPageTitles[] = {"Bags - Gear", "Fitness Equipment - Gear", "Watches - Gear"};
	
    public String gear_subcategories = "//span[text()='Gear']/ancestor::a/following-sibling::ul/li/a";
    
    
  //Training top nav and its subcategory links elements
	
  	public String TrainingText = "Training";
  	
      public String Training_Page_URL = "https://magento.softwaretestingboard.com/training.html";
  	
      public String Training_Page_Title = "Training";
  	
      public String Training_Sub_Category= "Video Download"; 
  	
      public String Training_SubcategoryPageURL ="https://magento.softwaretestingboard.com/training/training-video.html";
      
      public String Training_SubcategoryPageTitle = "Video Download - Training";
  	
      public String Training_Subcategories = "//span[text()='Training']/ancestor::a/following-sibling::ul/li/a";
	

	// Guest user Header Web Elements
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	public WebElement signInLink;

	@FindBy(linkText = "Create an Account")
	public WebElement createAccountLink;

	@FindBy(xpath = "//a[@aria-label='store logo']//img")
	public WebElement Logo;

	public String logoImagePath = "D:\\JavaRevise\\Magneto_Shipping_Regression\\images\\logo.png";

	@FindBy(id = "ui-id-3")
	public WebElement whatsNewTopNav;

	@FindBy(xpath = "//span[.='Women']")
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

	@FindBy(xpath = "//span[.='Men']")
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

	@FindBy(xpath = "//button[@title='Search']")
	public WebElement searchIcon;

	@FindBy(id = "search")
	public WebElement placeholder;

	public String ExpectedsearchBoxPlaceholder = "Search entire store here...";

	@FindBy(css = ".action.showcart")
	public WebElement miniCart;

	@FindBy(xpath ="//span[@class='counter-number']")
	public WebElement minicartProductCount;
	
	@FindBy(css = "div[data-role=dropdownDialog]")
	public WebElement minicartPopup;
	
	public String ExpectedEmptyCartMessage = "You have no items in your shopping cart.";
	
	@FindBy(id = "btn-minicart-close")
	public WebElement minicartCloseIcon;
	

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



	public void headerCartIconVerification() {

		boolean headerCartIconDisplaying = miniCart.isDisplayed();
		Assert.assertTrue(headerCartIconDisplaying);

	}

	
	
	//Sale top nav related elements
	
	public String SalePageHeading = "Sale";

	public String SalePageTitle = "Sale";

	public String SalePageURL = "https://magento.softwaretestingboard.com/sale.html";


}
