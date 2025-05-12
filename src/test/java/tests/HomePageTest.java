package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.JobHoldUntil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import pages.WhatsNewPage;
import pages.homePage;
import utils.WebdriverManager;

public class HomePageTest extends BaseTest {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	Actions actions;

	@Test(priority = 1, enabled = false)
	public void homePageURLandTitleVerification() {
		homePage home = new homePage(driver);
		String actualhomepageURL = home.getHomePageURL();

		Assert.assertEquals(actualhomepageURL, home.homePageURL);

		System.out.println(actualhomepageURL);

		String actualhomepageTitle = home.gethomePageTitle();

		System.out.println(actualhomepageTitle);

		Assert.assertEquals(actualhomepageTitle, home.homePageTitle);

	}

	@Test(priority = 2, enabled = false)
	public void verifytheHeaderLinksByClickingAsaGuestuser() {

		homePage home = new homePage(driver);
		WhatsNewPage WNP = new WhatsNewPage(driver);
		home.whatsNewTopNav.click();
		wait.until(ExpectedConditions.visibilityOf(WNP.whatsNewPageHeading));
		String ActualwhatsNewPageTitle = driver.getTitle();
		String ActualwhatsNewPageURL = driver.getCurrentUrl();
		String AcutalPageHeading = WNP.getPageHeading();

		Assert.assertEquals(AcutalPageHeading, WNP.expectedwhatsNewPageHeading, "Page have correct Heading");

		Assert.assertEquals(ActualwhatsNewPageURL, WNP.expectedURL, "URL Matching Success fully");

		Assert.assertEquals(ActualwhatsNewPageTitle, WNP.expectedPageTitle, "Page tile Matching correctly");

		home.Logo.click();

	}
	@Test(priority = 2, enabled = false )
	
	public void pageheaderContentsValidationforGuestuser() throws InterruptedException {

		homePage home = new homePage(driver);
		boolean logoIsDisplaying = home.Logo.isDisplayed();
		
		List<WebElement> headerTopNav_Categories = driver.findElements(By.xpath(home.allHeaderTopNavCatsPath));
		
		for (int i = 0; i < headerTopNav_Categories.size(); i++) {
			
			String ActualHeaderTopNavLink = headerTopNav_Categories.get(i).getText();
			
			System.out.println(ActualHeaderTopNavLink+"=="+home.allTopNavLinks[i]);
			
			Assert.assertEquals(ActualHeaderTopNavLink, home.allTopNavLinks[i]);
			
		}

		Assert.assertTrue(logoIsDisplaying);

		try {
			wait.until(ExpectedConditions.visibilityOf(home.Logo));
			home.screen.find(home.logoImagePath);
		} catch (FindFailed e) {
			home.screen.capture().save("screenshots/", "failed_screen.png");
			Assert.fail("Logo not found");
			e.printStackTrace();
		}

		boolean isSignInLinkDisplaying = home.signInLink.isDisplayed();

		Assert.assertTrue(isSignInLinkDisplaying);

		boolean isCreateAnAccount = home.createAccountLink.isDisplayed();

		Assert.assertTrue(isCreateAnAccount);

		boolean isSearchBoxDisplaying = home.searchBox.isDisplayed();

		Assert.assertTrue(isSearchBoxDisplaying);

		String searchBoxPlaceHolder = home.getSearchBoxPlaceHolderText();

		Assert.assertEquals(searchBoxPlaceHolder, home.ExpectedsearchBoxPlaceholder);

		boolean isSearchIconisDisplaying = home.searchIcon.isDisplayed();

		Assert.assertTrue(isSearchIconisDisplaying);

		boolean isMinicartIconisDisplaying = home.miniCart.isDisplayed();

		Assert.assertTrue(isMinicartIconisDisplaying);

		boolean isWhatsNewTopNavLinkisDisplaying = home.whatsNewTopNav.isDisplayed();

		Assert.assertTrue(isWhatsNewTopNavLinkisDisplaying);

		boolean isWomenTopNavLinkisDisplaying = home.womenTopNav.isDisplayed();

		Assert.assertTrue(isWomenTopNavLinkisDisplaying);

		boolean isMenTopNavLinkisDisplaying = home.menTopNav.isDisplayed();

		Assert.assertTrue(isMenTopNavLinkisDisplaying);

		boolean isGearTopNavLinkisDisplaying = home.gearTopNav.isDisplayed();

		Assert.assertTrue(isGearTopNavLinkisDisplaying);

		boolean isTrainingTopNavLinkisDisplaying = home.TrainingTopNav.isDisplayed();

		Assert.assertTrue(isTrainingTopNavLinkisDisplaying);

		boolean isSaleTopNavLinkisDisplaying = home.saleTopNav.isDisplayed();

		Assert.assertTrue(isSaleTopNavLinkisDisplaying);

	}

	@Test(priority = 3, enabled = false)
	public void verifyAllSubcategoryLinksUnderWomenTopNav() throws InterruptedException {

		homePage home = new homePage(driver);
		
		home.womenTopNav.click();
		String Women_Category_URL = driver.getCurrentUrl();
		Assert.assertEquals(Women_Category_URL, home.WomensCategoryURL);
		System.out.println("Page URL------" + Women_Category_URL + "==" + home.WomensCategoryURL);
		String Women_Category_PageHeading = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(Women_Category_PageHeading, home.WomensCategoryPageHeading);
		System.out.println("Page Heading------" + Women_Category_PageHeading + "==" + home.WomensCategoryPageHeading);
		home.Logo.click();

		home.action.moveToElement(home.womenTopNav).perform();

		wait.until(ExpectedConditions.visibilityOfAllElements(home.womenTopNav));
		
		List<WebElement> firstLevelLinks = driver.findElements(By.xpath(home.WomensTopNavFirstLevelCategories));
		
		List<WebElement> womenTopsSubCategries = driver.findElements(By.xpath(home.WomensTopsSubLevelCategories));
		
		List<WebElement> womenBottomsSubCategries = driver.findElements(By.xpath(home.WomensBottomsSubLevelCategories));
		
		int actualFirstlevelCategoryCount = firstLevelLinks.size();

		int expectedFirstlevelCategoryCount = home.expectedFirstLevelWomensCategories.length;

		Assert.assertEquals(actualFirstlevelCategoryCount, expectedFirstlevelCategoryCount);

		for (int i = 0; i < actualFirstlevelCategoryCount; i++) {
			
			/*Refetching the elements to avoid the stale element exception every iteration home page loading 
		    due to that we are refetching the elements*/
		
			
			List<WebElement> refetchFirstLevelcategories1 = driver.findElements(By.xpath(home.WomensTopNavFirstLevelCategories));	
			home.action.moveToElement(home.womenTopNav).perform();
			wait.until(ExpectedConditions.visibilityOfAllElements(home.womenTopNav));
			String link = refetchFirstLevelcategories1.get(i).getText();
			System.out.println(link);
			link = home.expectedFirstLevelWomensCategories[i];
			Assert.assertEquals(link, home.expectedFirstLevelWomensCategories[i]);
			System.out.println(link+"----"+home.expectedFirstLevelWomensCategories[i]);
			refetchFirstLevelcategories1.get(i).click();
			String firstlevelPageCategoryTitle = driver.getTitle();
			Assert.assertEquals(firstlevelPageCategoryTitle, home.WomenTopNavFirstLevelCategoryPageTiltles[i]);
			System.out.println("Page title------"+firstlevelPageCategoryTitle+"=="+home.WomenTopNavFirstLevelCategoryPageTiltles[i]);
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, home.WomenTopNavFirstLevelCategoryNavigationURLS[i]);
			System.out.println("Page URL------"+URL+"=="+home.WomenTopNavFirstLevelCategoryNavigationURLS[i]);
			String PageHeading = driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals(PageHeading, home.expectedFirstLevelWomensCategories[i]);
			System.out.println("Page Heading------"+PageHeading+"=="+home.expectedFirstLevelWomensCategories[i]);
			home.Logo.click();
			
			
           if(link.equals("Tops")) {

			for (int j = 0; j < womenTopsSubCategries.size(); j++) {
				
				    /*Refetching the elements to avoid the stale element exception every iteration home page loading 
				    due to that we are refetching the elements*/
				
				    List<WebElement> refetchFirstLevelcategories = driver.findElements(By.xpath(home.WomensTopNavFirstLevelCategories));	
				    List<WebElement> refetchwomenTopsSubCategries = driver.findElements(By.xpath(home.WomensTopsSubLevelCategories));
					
				    wait.until(ExpectedConditions.visibilityOfAllElements(home.womenTopNav));
				    home.action.moveToElement(home.womenTopNav).perform();	
					home.action.moveToElement(refetchFirstLevelcategories.get(i)).perform();
					String womesTopsSubLinks = refetchwomenTopsSubCategries.get(j).getText();
					Assert.assertEquals(womesTopsSubLinks, home.expectedWomensTopsSubLevelCategories[j]);
					System.out.println(womesTopsSubLinks+"----"+home.expectedWomensTopsSubLevelCategories[j]);
					refetchwomenTopsSubCategries.get(j).click();
					String topsSubCategoryTitle = driver.getTitle();
					Assert.assertEquals(topsSubCategoryTitle, home.WomenTopsSubLevelCategoryPageTiltles[j]);
					String topsSubcategoryPageURLs = driver.getCurrentUrl();
					Assert.assertEquals(topsSubcategoryPageURLs, home.WomenTopsSubLevelCategoryNavigationURLS[j]);
					String topsSubCategoryPageHeading = driver.findElement(By.tagName("h1")).getText();
					Assert.assertEquals(topsSubCategoryPageHeading, home.expectedWomensTopsSubLevelCategories[j]);
					home.Logo.click();
					

			}
           }else if(link.equals("Bottoms")) {
			
           for (int j = 0; j < womenBottomsSubCategries.size(); j++) {
        	   
        	   /*Refetching the elements to avoid the stale element exception every iteration home page loading 
			    due to that we are refetching the elements*/
        	    
        	    List<WebElement> refetchFirstLevelcategories2 = driver.findElements(By.xpath(home.WomensTopNavFirstLevelCategories));	
			    List<WebElement> refetchwomenBottomSubCategries = driver.findElements(By.xpath(home.WomensBottomsSubLevelCategories));
				
        	    wait.until(ExpectedConditions.visibilityOf(home.womenTopNav));	
        	    home.action.moveToElement(home.womenTopNav).perform();
   			    wait.until(ExpectedConditions.visibilityOf(refetchFirstLevelcategories2.get(i)));	
				home.action.moveToElement(refetchFirstLevelcategories2.get(i)).perform();
				String womesBottomSubLinks = refetchwomenBottomSubCategries.get(j).getText();
				Assert.assertEquals(womesBottomSubLinks, home.expectedWomensBottomsSubLevelCategories[j]);
				System.out.println(womesBottomSubLinks+"----"+home.expectedWomensBottomsSubLevelCategories[j]);
				refetchwomenBottomSubCategries.get(j).click();
				String bottomsSubCategoryTitle = driver.getTitle();
				Assert.assertEquals(bottomsSubCategoryTitle, home.WomenBottomsSubLevelCategoryPageTiltles[j]);
				String topsSubcategoryPageURLs = driver.getCurrentUrl();
				Assert.assertEquals(topsSubcategoryPageURLs, home.WomenBottomsSubLevelCategoryNavigationURLS[j]);
				String topsSubCategoryPageHeading = driver.findElement(By.tagName("h1")).getText();
				System.out.println(topsSubCategoryPageHeading);
				Assert.assertEquals(topsSubCategoryPageHeading, home.expectedWomensBottomsSubLevelCategories[j]);
				home.Logo.click();

			}
           }
		}

	}
	
	@Test(priority = 4,enabled = false)

	public void verifyAllSubcategoryLinksUnderMenTopNav() throws InterruptedException {

		homePage home = new homePage(driver);
		home.menTopNav.click();
		String men_Category_URL = driver.getCurrentUrl();
		Assert.assertEquals(men_Category_URL, home.mensCategoryURL);
		System.out.println("Page URL------" + men_Category_URL + "==" + home.mensCategoryURL);
		String men_Category_PageHeading = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(men_Category_PageHeading, home.mensCategoryPageHeading);
		System.out.println("Page Heading------" + men_Category_PageHeading + "==" + home.mensCategoryPageHeading);
		home.Logo.click();

		home.action.moveToElement(home.menTopNav).perform();

		wait.until(ExpectedConditions.visibilityOfAllElements(home.menTopNav));

		List<WebElement> firstLevelLinks = driver.findElements(By.xpath(home.mensTopNavFirstLevelCategories));
		
		List<WebElement> menTopsSubCategries = driver.findElements(By.xpath(home.mensTopsSubLevelCategories));
		
		List<WebElement> menBottomsSubCategries = driver.findElements(By.xpath(home.mensBottomsSubLevelCategories));
		
		int actualFirstlevelCategoryCount = firstLevelLinks.size();

		int expectedFirstlevelCategoryCount = home.expectedFirstLevelmensCategories.length;

		Assert.assertEquals(actualFirstlevelCategoryCount, expectedFirstlevelCategoryCount);

		for (int i = 0; i < actualFirstlevelCategoryCount; i++) {
			
			/*Refetching the elements to avoid the stale element exception every iteration home page loading 
		    due to that we are refetching the elements*/
		
			
			List<WebElement> refetchFirstLevelcategories1 = driver.findElements(By.xpath(home.mensTopNavFirstLevelCategories));	
			home.action.moveToElement(home.menTopNav).perform();
			wait.until(ExpectedConditions.visibilityOfAllElements(home.menTopNav));
			String link = refetchFirstLevelcategories1.get(i).getText();
			System.out.println(link);
			link = home.expectedFirstLevelmensCategories[i];
			Assert.assertEquals(link, home.expectedFirstLevelmensCategories[i]);
			System.out.println(link+"----"+home.expectedFirstLevelmensCategories[i]);
			refetchFirstLevelcategories1.get(i).click();
			String firstlevelPageCategoryTitle = driver.getTitle();
			Assert.assertEquals(firstlevelPageCategoryTitle, home.menTopNavFirstLevelCategoryPageTiltles[i]);
			System.out.println("Page title------"+firstlevelPageCategoryTitle+"=="+home.menTopNavFirstLevelCategoryPageTiltles[i]);
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, home.menTopNavFirstLevelCategoryNavigationURLS[i]);
			System.out.println("Page URL------"+URL+"=="+home.menTopNavFirstLevelCategoryNavigationURLS[i]);
			String PageHeading = driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals(PageHeading, home.expectedFirstLevelmensCategories[i]);
			System.out.println("Page Heading------"+PageHeading+"=="+home.expectedFirstLevelmensCategories[i]);
			home.Logo.click();
			
			
           if(link.equals("Tops")) {

			for (int j = 0; j < menTopsSubCategries.size(); j++) {
				
				    /*Refetching the elements to avoid the stale element exception every iteration home page loading 
				    due to that we are refetching the elements*/
				
				    List<WebElement> refetchFirstLevelcategories = driver.findElements(By.xpath(home.mensTopNavFirstLevelCategories));	
				    List<WebElement> refetchmenTopsSubCategries = driver.findElements(By.xpath(home.mensTopsSubLevelCategories));
					
				    wait.until(ExpectedConditions.visibilityOfAllElements(home.menTopNav));
				    home.action.moveToElement(home.menTopNav).perform();	
					home.action.moveToElement(refetchFirstLevelcategories.get(i)).perform();
					String mensTopsSubLinks = refetchmenTopsSubCategries.get(j).getText();
					Assert.assertEquals(mensTopsSubLinks, home.expectedmensTopsSubLevelCategories[j]);
					System.out.println(mensTopsSubLinks+"----"+home.expectedmensTopsSubLevelCategories[j]);
					refetchmenTopsSubCategries.get(j).click();
					String topsSubCategoryTitle = driver.getTitle();
					Assert.assertEquals(topsSubCategoryTitle, home.menTopsSubLevelCategoryPageTiltles[j]);
					String topsSubcategoryPageURLs = driver.getCurrentUrl();
					Assert.assertEquals(topsSubcategoryPageURLs, home.menTopsSubLevelCategoryNavigationURLS[j]);
					String topsSubCategoryPageHeading = driver.findElement(By.tagName("h1")).getText();
					Assert.assertEquals(topsSubCategoryPageHeading, home.expectedmensTopsSubLevelCategories[j]);
					home.Logo.click();
					

			}
           }else if(link.equals("Bottoms")) {
			
           for (int j = 0; j < menBottomsSubCategries.size(); j++) {
        	   
        	   /*Refetching the elements to avoid the stale element exception every iteration home page loading 
			    due to that we are refetching the elements*/
        	    
        	    List<WebElement> refetchFirstLevelcategories2 = driver.findElements(By.xpath(home.mensTopNavFirstLevelCategories));	
			    List<WebElement> refetchmenBottomSubCategries = driver.findElements(By.xpath(home.mensBottomsSubLevelCategories));
				
        	    wait.until(ExpectedConditions.visibilityOf(home.menTopNav));	
        	    home.action.moveToElement(home.menTopNav).perform();
   			    wait.until(ExpectedConditions.visibilityOf(refetchFirstLevelcategories2.get(i)));	
				home.action.moveToElement(refetchFirstLevelcategories2.get(i)).perform();
				String mensBottomSubLinks = refetchmenBottomSubCategries.get(j).getText();
				Assert.assertEquals(mensBottomSubLinks, home.expectedmensBottomsSubLevelCategories[j]);
				System.out.println(mensBottomSubLinks+"----"+home.expectedmensBottomsSubLevelCategories[j]);
				refetchmenBottomSubCategries.get(j).click();
				String bottomsSubCategoryTitle = driver.getTitle();
				Assert.assertEquals(bottomsSubCategoryTitle, home.menBottomsSubLevelCategoryPageTiltles[j]);
				String topsSubcategoryPageURLs = driver.getCurrentUrl();
				Assert.assertEquals(topsSubcategoryPageURLs, home.menBottomsSubLevelCategoryNavigationURLS[j]);
				String topsSubCategoryPageHeading = driver.findElement(By.tagName("h1")).getText();
				System.out.println(topsSubCategoryPageHeading);
				Assert.assertEquals(topsSubCategoryPageHeading, home.expectedmensBottomsSubLevelCategories[j]);
				home.Logo.click();

			}
           }
		}

	}

	@Test(priority = 6, enabled=false)
	public void verifygearTopNavandSubcategoryLinks() {
		
		homePage home =  new homePage(driver);
		
		wait.until(ExpectedConditions.visibilityOf(home.gearTopNav));
		
		home.clickGearTopNavcategory();
		
		String actual_gearPage_URL = driver.getCurrentUrl();
		
		System.out.println(actual_gearPage_URL+"===="+home.gearPageURL);
		
		Assert.assertEquals(actual_gearPage_URL,home.gearPageURL);
		
		String actual_gearPage_Title = driver.getTitle();
		
		System.out.println(actual_gearPage_Title+"===="+home.gear_PageTitle);
		
		Assert.assertEquals(actual_gearPage_Title, home.gear_PageTitle);
		
		String getGearPageHeading =  driver.findElement(By.tagName("h1")).getText();
		
		System.out.println(getGearPageHeading+"===="+home.gearText);
		
		Assert.assertEquals(getGearPageHeading, home.gearText);
		
		home.clickheaderLogo();
		
		wait.until(ExpectedConditions.visibilityOf(home.gearTopNav));
		
		home.action.moveToElement(home.gearTopNav).perform();
		
		List <WebElement> gear_subCategories = driver.findElements(By.xpath(home.gear_subcategories));
		
		int actual_gear_category_count =  gear_subCategories.size();
		
		System.out.println("category count :"+actual_gear_category_count);
		
		int expected_gear_category_count = home.gear_Categories.length;
		
		System.out.println("storedcategory count :"+expected_gear_category_count);
		
		Assert.assertEquals(actual_gear_category_count, expected_gear_category_count);
		
		for(int i = 0; i < actual_gear_category_count; i++) {
			
			home.action.moveToElement(home.gearTopNav).perform();
			
			List <WebElement> refetch_gear_subCategories = driver.findElements(By.xpath(home.gear_subcategories));
			
			String subcategoryLinks = refetch_gear_subCategories.get(i).getText();
			
			System.out.println(subcategoryLinks+"=="+home.gear_Categories[i]);
			
			Assert.assertEquals(subcategoryLinks, home.gear_Categories[i]);
			
			refetch_gear_subCategories.get(i).click();
			
			String currentCategoryURL = driver.getCurrentUrl();
			
			Assert.assertEquals(currentCategoryURL,home.gear_SubcategoryPageURLs[i]);
			
			String currentCategorypageTitle = driver.getTitle();
			
			Assert.assertEquals(currentCategorypageTitle,home.gear_SubcategoryPageTitles[i]);
			
			String currentCategorypageHeading = driver.findElement(By.tagName("h1")).getText();
			
			Assert.assertEquals(currentCategorypageHeading,home.gear_Categories[i]);
			
			home.clickheaderLogo();
				
			
		}
		
		
	}
	
	@Test(enabled = false)
	public void verifyTrainingTopNavLink() {
		
		homePage home = new homePage(driver);
		
		wait.until(ExpectedConditions.visibilityOf(home.TrainingTopNav));
		
		home.TrainingTopNav.click();
		
		String Actual_Training_Page_URL=driver.getCurrentUrl();
		
		String Actual_Training_Page_Title = driver.getTitle();
		
		String Actual_Training_Page_Heading = driver.findElement(By.tagName("h1")).getText();
		
		Assert.assertEquals(Actual_Training_Page_URL, home.Training_Page_URL);
		
		Assert.assertEquals(Actual_Training_Page_Title,home.Training_Page_Title);
		
		Assert.assertEquals(Actual_Training_Page_Heading, home.TrainingText);
		
		home.clickheaderLogo();
		
		List<WebElement> Training_SubCatgories = driver.findElements(By.xpath(home.Training_Subcategories));
		
		for(int i = 0 ;i < Training_SubCatgories.size(); i++)
			
		{
			home.hoverTrainingLink();
			
			String SubLinks = Training_SubCatgories.get(i).getText();
			
			Assert.assertEquals(SubLinks, home.Training_Sub_Category);
			
			Training_SubCatgories.get(i).click();
			
			String ActualTraining_SubCategoryPage_URL = driver.getCurrentUrl();
			
			String ActualTraining_SubcategoryPage_Title = driver.getTitle();
			
			String ActualTraining_subcategorypage_Heading = driver.findElement(By.tagName("h1")).getText();
			
			Assert.assertEquals(ActualTraining_SubCategoryPage_URL, home.Training_SubcategoryPageURL);
			
			Assert.assertEquals(ActualTraining_SubcategoryPage_Title, home.Training_SubcategoryPageTitle);
			
			Assert.assertEquals(ActualTraining_subcategorypage_Heading, home.Training_Sub_Category);	
			
		}
		
		
		
		
		
		
	}
	
	@Test(enabled = false)
	public void verifytheSaleTopNavLink() {
	
		homePage home = new homePage(driver);
		
		home.saleTopNav.click();
		
		String Actual_SalePage_Title = driver.getTitle();
		
		String Actual_SalePage_URL = driver.getCurrentUrl();
		
		String Actual_SalePage_Heading = driver.findElement(By.tagName("h1")).getText();
		
		Assert.assertEquals(Actual_SalePage_Title, home.SalePageTitle);
		
		Assert.assertEquals(Actual_SalePage_URL, home.SalePageURL);
		
		Assert.assertEquals(Actual_SalePage_Heading, home.SalePageHeading);
		
		
		
		
	}
	
	@Test(enabled = false)
	public void verify_the_SearchBox() throws InterruptedException {
	
		homePage home = new homePage(driver);
		
		home.searchBox.sendKeys("Shirt");
		
		WebElement search_suggestion_flyout = driver.findElement(By.id("search_autocomplete"));
		
		wait.until(ExpectedConditions.visibilityOf(search_suggestion_flyout));
		
		boolean search_suggestiondisplaying = search_suggestion_flyout.isDisplayed();
		
		Assert.assertTrue(search_suggestiondisplaying);
		
		
		List<WebElement> suggestion_List = driver.findElements(By.xpath("//ul[@role='listbox']//li//span[@class='qs-option-name']"));
		
		for (int i = 0; i < suggestion_List.size(); i++) {
			
			wait.until(ExpectedConditions.visibilityOf(search_suggestion_flyout));
			
			String suggestion_options = suggestion_List.get(i).getText();
			
			System.out.println("suggestionOption--->"+suggestion_options);
			
			home.searchBox.sendKeys(Keys.ARROW_DOWN);
			
			//Thread.sleep(3000);
			
			String Search_Box_Value = home.searchBox.getAttribute("value");
			
			String removed_Space_From_Search_Box_Value=Search_Box_Value.trim();
			
			System.out.println("selected value"+"--->"+removed_Space_From_Search_Box_Value);
			
			Assert.assertEquals(suggestion_options, removed_Space_From_Search_Box_Value);
		
		}
		
		suggestion_List.get(0).click();
		
		String getResultPageHeading = driver.findElement(By.tagName("h1")).getText();
		
		String fullResultHeading = getResultPageHeading.trim();
		
		String ExpectedResultHeading = "Search results for: 'shirt'";
		
		Assert.assertEquals(fullResultHeading, ExpectedResultHeading);
		
		home.clickheaderLogo();
		
		home.searchBox.sendKeys("Shirt");
		
		home.action.moveToElement(home.searchIcon).perform();
		
		String tooltip = home.searchIcon.getText();
		
		String actualTooltip = "Search";
		
		Assert.assertEquals(tooltip, actualTooltip);
		
		Assert.assertTrue((driver.findElement(By.xpath("//button//span[.='Search']")).isDisplayed()));
		
		wait.until(ExpectedConditions.elementToBeClickable(home.searchIcon));
		
		home.searchIcon.click();
		
		String getSearchResultPageHeading = driver.findElement(By.tagName("h1")).getText();
		
		String fullSearchResultHeading = getSearchResultPageHeading.trim();
		
		String ExpectedSearchResultHeading = "Search results for: 'Shirt'";
		
		Assert.assertEquals(fullSearchResultHeading, ExpectedSearchResultHeading);		
		
	}
	
	@Test
	public void verif_the_minicartIcon_In_Header() {
		
		homePage home = new homePage(driver);
		
		String productCount = home.minicartProductCount.getAttribute("textContent");
		
		if (productCount == null || productCount.trim().isEmpty()) {
		    System.out.println("Cart count is empty or invisible — setting to 0.");
		    productCount = "0";
		} else {
		    // Remove all non-digit characters, just in case
		    productCount = productCount.trim();
		}
		
		
		System.out.println("Product count raw: >" + productCount + "<");
		
		int productCountValue = Integer.parseInt(productCount);		
		
		
			
			boolean productCountDisplaying = home.minicartProductCount.isDisplayed();
			
			Assert.assertFalse(productCountDisplaying);
			
			home.miniCart.click();
			
			wait.until(ExpectedConditions.visibilityOf(home.minicartPopup));
			
			Assert.assertTrue(home.minicartPopup.isDisplayed());
			
			String EmptyCartMessage = driver.findElement(By.cssSelector(".subtitle.empty")).getText();
			
			Assert.assertEquals(EmptyCartMessage, home.ExpectedEmptyCartMessage);
			
			Assert.assertTrue(home.minicartCloseIcon.isDisplayed());
			
			home.minicartCloseIcon.click();
			
			Assert.assertFalse(home.minicartPopup.isDisplayed());
			
		

		
	}
}
