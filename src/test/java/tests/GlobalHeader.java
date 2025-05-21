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
import pages.globalHeader;


public class GlobalHeader extends BaseTest {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	Actions actions;


	@Test(priority = 1, enabled = true, groups = "Regression")
	public void verifytheHeaderLinksByClickingAsaGuestuser() {

		globalHeader gh = new globalHeader(driver);
		WhatsNewPage WNP = new WhatsNewPage(driver);
		gh.whatsNewTopNav.click();
		wait.until(ExpectedConditions.visibilityOf(WNP.whatsNewPageHeading));
		String ActualwhatsNewPageTitle = driver.getTitle();
		String ActualwhatsNewPageURL = driver.getCurrentUrl();
		String AcutalPageHeading = WNP.getPageHeading();

		Assert.assertEquals(AcutalPageHeading, WNP.expectedwhatsNewPageHeading, "Page have correct Heading");

		Assert.assertEquals(ActualwhatsNewPageURL, WNP.expectedURL, "URL Matching Success fully");

		Assert.assertEquals(ActualwhatsNewPageTitle, WNP.expectedPageTitle, "Page tile Matching correctly");

		gh.Logo.click();

	}
	@Test(priority = 3, enabled = true , groups = "Regression" )
	
	public void pageheaderContentsValidationforGuestuser() throws InterruptedException {

		globalHeader header = new globalHeader(driver);
		boolean logoIsDisplaying = header.Logo.isDisplayed();
		
		List<WebElement> headerTopNav_Categories = driver.findElements(By.xpath(header.allHeaderTopNavCatsPath));
		
		for (int i = 0; i < headerTopNav_Categories.size(); i++) {
			
			String ActualHeaderTopNavLink = headerTopNav_Categories.get(i).getText();
			
			System.out.println(ActualHeaderTopNavLink+"=="+header.allTopNavLinks[i]);
			
			Assert.assertEquals(ActualHeaderTopNavLink, header.allTopNavLinks[i]);
			
		}

		Assert.assertTrue(logoIsDisplaying);

		try {
			wait.until(ExpectedConditions.visibilityOf(header.Logo));
			header.screen.find(header.logoImagePath);
		} catch (FindFailed e) {
			header.screen.capture().save("screenshots/", "failed_screen.png");
			Assert.fail("Logo not found");
			e.printStackTrace();
		}

		boolean isSignInLinkDisplaying = header.signInLink.isDisplayed();

		Assert.assertTrue(isSignInLinkDisplaying);

		boolean isCreateAnAccount = header.createAccountLink.isDisplayed();

		Assert.assertTrue(isCreateAnAccount);

		boolean isSearchBoxDisplaying = header.searchBox.isDisplayed();

		Assert.assertTrue(isSearchBoxDisplaying);

		String searchBoxPlaceHolder = header.getSearchBoxPlaceHolderText();

		Assert.assertEquals(searchBoxPlaceHolder, header.ExpectedsearchBoxPlaceholder);

		boolean isSearchIconisDisplaying = header.searchIcon.isDisplayed();

		Assert.assertTrue(isSearchIconisDisplaying);

		boolean isMinicartIconisDisplaying = header.miniCart.isDisplayed();

		Assert.assertTrue(isMinicartIconisDisplaying);

		boolean isWhatsNewTopNavLinkisDisplaying = header.whatsNewTopNav.isDisplayed();

		Assert.assertTrue(isWhatsNewTopNavLinkisDisplaying);

		boolean isWomenTopNavLinkisDisplaying = header.womenTopNav.isDisplayed();

		Assert.assertTrue(isWomenTopNavLinkisDisplaying);

		boolean isMenTopNavLinkisDisplaying = header.menTopNav.isDisplayed();

		Assert.assertTrue(isMenTopNavLinkisDisplaying);

		boolean isGearTopNavLinkisDisplaying = header.gearTopNav.isDisplayed();

		Assert.assertTrue(isGearTopNavLinkisDisplaying);

		boolean isTrainingTopNavLinkisDisplaying = header.TrainingTopNav.isDisplayed();

		Assert.assertTrue(isTrainingTopNavLinkisDisplaying);

		boolean isSaleTopNavLinkisDisplaying = header.saleTopNav.isDisplayed();

		Assert.assertTrue(isSaleTopNavLinkisDisplaying);

	}

	@Test(priority = 4, enabled = true, groups = "Regression")
	public void verifyAllSubcategoryLinksUnderWomenTopNav() throws InterruptedException {

		globalHeader header = new globalHeader(driver);
		
		header.womenTopNav.click();
		String Women_Category_URL = driver.getCurrentUrl();
		Assert.assertEquals(Women_Category_URL, header.WomensCategoryURL);
		System.out.println("Page URL------" + Women_Category_URL + "==" + header.WomensCategoryURL);
		String Women_Category_PageHeading = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(Women_Category_PageHeading, header.WomensCategoryPageHeading);
		System.out.println("Page Heading------" + Women_Category_PageHeading + "==" + header.WomensCategoryPageHeading);
		header.Logo.click();

		header.action.moveToElement(header.womenTopNav).perform();

		wait.until(ExpectedConditions.visibilityOfAllElements(header.womenTopNav));
		
		List<WebElement> firstLevelLinks = driver.findElements(By.xpath(header.WomensTopNavFirstLevelCategories));
		
		List<WebElement> womenTopsSubCategries = driver.findElements(By.xpath(header.WomensTopsSubLevelCategories));
		
		List<WebElement> womenBottomsSubCategries = driver.findElements(By.xpath(header.WomensBottomsSubLevelCategories));
		
		int actualFirstlevelCategoryCount = firstLevelLinks.size();

		int expectedFirstlevelCategoryCount = header.expectedFirstLevelWomensCategories.length;

		Assert.assertEquals(actualFirstlevelCategoryCount, expectedFirstlevelCategoryCount);

		for (int i = 0; i < actualFirstlevelCategoryCount; i++) {
			
			/*Refetching the elements to avoid the stale element exception every iteration header page loading 
		    due to that we are refetching the elements*/
		
			
			List<WebElement> refetchFirstLevelcategories1 = driver.findElements(By.xpath(header.WomensTopNavFirstLevelCategories));	
			header.action.moveToElement(header.womenTopNav).perform();
			wait.until(ExpectedConditions.visibilityOfAllElements(header.womenTopNav));
			String link = refetchFirstLevelcategories1.get(i).getText();
			System.out.println(link);
			link = header.expectedFirstLevelWomensCategories[i];
			Assert.assertEquals(link, header.expectedFirstLevelWomensCategories[i]);
			System.out.println(link+"----"+header.expectedFirstLevelWomensCategories[i]);
			refetchFirstLevelcategories1.get(i).click();
			String firstlevelPageCategoryTitle = driver.getTitle();
			Assert.assertEquals(firstlevelPageCategoryTitle, header.WomenTopNavFirstLevelCategoryPageTiltles[i]);
			System.out.println("Page title------"+firstlevelPageCategoryTitle+"=="+header.WomenTopNavFirstLevelCategoryPageTiltles[i]);
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, header.WomenTopNavFirstLevelCategoryNavigationURLS[i]);
			System.out.println("Page URL------"+URL+"=="+header.WomenTopNavFirstLevelCategoryNavigationURLS[i]);
			String PageHeading = driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals(PageHeading, header.expectedFirstLevelWomensCategories[i]);
			System.out.println("Page Heading------"+PageHeading+"=="+header.expectedFirstLevelWomensCategories[i]);
			header.Logo.click();
			
			
           if(link.equals("Tops")) {

			for (int j = 0; j < womenTopsSubCategries.size(); j++) {
				
				    /*Refetching the elements to avoid the stale element exception every iteration header page loading 
				    due to that we are refetching the elements*/
				
				    List<WebElement> refetchFirstLevelcategories = driver.findElements(By.xpath(header.WomensTopNavFirstLevelCategories));	
				    List<WebElement> refetchwomenTopsSubCategries = driver.findElements(By.xpath(header.WomensTopsSubLevelCategories));
					
				    wait.until(ExpectedConditions.visibilityOfAllElements(header.womenTopNav));
				    header.action.moveToElement(header.womenTopNav).perform();	
				    header.action.moveToElement(refetchFirstLevelcategories.get(i)).perform();
					String womesTopsSubLinks = refetchwomenTopsSubCategries.get(j).getText();
					Assert.assertEquals(womesTopsSubLinks, header.expectedWomensTopsSubLevelCategories[j]);
					System.out.println(womesTopsSubLinks+"----"+header.expectedWomensTopsSubLevelCategories[j]);
					refetchwomenTopsSubCategries.get(j).click();
					String topsSubCategoryTitle = driver.getTitle();
					Assert.assertEquals(topsSubCategoryTitle, header.WomenTopsSubLevelCategoryPageTiltles[j]);
					String topsSubcategoryPageURLs = driver.getCurrentUrl();
					Assert.assertEquals(topsSubcategoryPageURLs, header.WomenTopsSubLevelCategoryNavigationURLS[j]);
					String topsSubCategoryPageHeading = driver.findElement(By.tagName("h1")).getText();
					Assert.assertEquals(topsSubCategoryPageHeading, header.expectedWomensTopsSubLevelCategories[j]);
					header.Logo.click();
					

			}
           }else if(link.equals("Bottoms")) {
			
           for (int j = 0; j < womenBottomsSubCategries.size(); j++) {
        	   
        	   /*Refetching the elements to avoid the stale element exception every iteration header page loading 
			    due to that we are refetching the elements*/
        	    
        	    List<WebElement> refetchFirstLevelcategories2 = driver.findElements(By.xpath(header.WomensTopNavFirstLevelCategories));	
			    List<WebElement> refetchwomenBottomSubCategries = driver.findElements(By.xpath(header.WomensBottomsSubLevelCategories));
				
        	    wait.until(ExpectedConditions.visibilityOf(header.womenTopNav));	
        	    header.action.moveToElement(header.womenTopNav).perform();
   			    wait.until(ExpectedConditions.visibilityOf(refetchFirstLevelcategories2.get(i)));	
   			    header.action.moveToElement(refetchFirstLevelcategories2.get(i)).perform();
				String womesBottomSubLinks = refetchwomenBottomSubCategries.get(j).getText();
				Assert.assertEquals(womesBottomSubLinks, header.expectedWomensBottomsSubLevelCategories[j]);
				System.out.println(womesBottomSubLinks+"----"+header.expectedWomensBottomsSubLevelCategories[j]);
				refetchwomenBottomSubCategries.get(j).click();
				String bottomsSubCategoryTitle = driver.getTitle();
				Assert.assertEquals(bottomsSubCategoryTitle, header.WomenBottomsSubLevelCategoryPageTiltles[j]);
				String topsSubcategoryPageURLs = driver.getCurrentUrl();
				Assert.assertEquals(topsSubcategoryPageURLs, header.WomenBottomsSubLevelCategoryNavigationURLS[j]);
				String topsSubCategoryPageHeading = driver.findElement(By.tagName("h1")).getText();
				System.out.println(topsSubCategoryPageHeading);
				Assert.assertEquals(topsSubCategoryPageHeading, header.expectedWomensBottomsSubLevelCategories[j]);
				header.Logo.click();

			}
           }
		}

	}
	
	@Test(priority = 5,enabled = true, groups = "Regression")

	public void verifyAllSubcategoryLinksUnderMenTopNav() throws InterruptedException {

		globalHeader header = new globalHeader(driver);
		header.menTopNav.click();
		String men_Category_URL = driver.getCurrentUrl();
		Assert.assertEquals(men_Category_URL, header.mensCategoryURL);
		System.out.println("Page URL------" + men_Category_URL + "==" + header.mensCategoryURL);
		String men_Category_PageHeading = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(men_Category_PageHeading, header.mensCategoryPageHeading);
		System.out.println("Page Heading------" + men_Category_PageHeading + "==" + header.mensCategoryPageHeading);
		header.Logo.click();

		header.action.moveToElement(header.menTopNav).perform();

		wait.until(ExpectedConditions.visibilityOfAllElements(header.menTopNav));

		List<WebElement> firstLevelLinks = driver.findElements(By.xpath(header.mensTopNavFirstLevelCategories));
		
		List<WebElement> menTopsSubCategries = driver.findElements(By.xpath(header.mensTopsSubLevelCategories));
		
		List<WebElement> menBottomsSubCategries = driver.findElements(By.xpath(header.mensBottomsSubLevelCategories));
		
		int actualFirstlevelCategoryCount = firstLevelLinks.size();

		int expectedFirstlevelCategoryCount = header.expectedFirstLevelmensCategories.length;

		Assert.assertEquals(actualFirstlevelCategoryCount, expectedFirstlevelCategoryCount);

		for (int i = 0; i < actualFirstlevelCategoryCount; i++) {
			
			/*Refetching the elements to avoid the stale element exception every iteration header page loading 
		    due to that we are refetching the elements*/
		
			
			List<WebElement> refetchFirstLevelcategories1 = driver.findElements(By.xpath(header.mensTopNavFirstLevelCategories));	
			header.action.moveToElement(header.menTopNav).perform();
			wait.until(ExpectedConditions.visibilityOfAllElements(header.menTopNav));
			String link = refetchFirstLevelcategories1.get(i).getText();
			System.out.println(link);
			link = header.expectedFirstLevelmensCategories[i];
			Assert.assertEquals(link, header.expectedFirstLevelmensCategories[i]);
			System.out.println(link+"----"+header.expectedFirstLevelmensCategories[i]);
			refetchFirstLevelcategories1.get(i).click();
			String firstlevelPageCategoryTitle = driver.getTitle();
			Assert.assertEquals(firstlevelPageCategoryTitle, header.menTopNavFirstLevelCategoryPageTiltles[i]);
			System.out.println("Page title------"+firstlevelPageCategoryTitle+"=="+header.menTopNavFirstLevelCategoryPageTiltles[i]);
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, header.menTopNavFirstLevelCategoryNavigationURLS[i]);
			System.out.println("Page URL------"+URL+"=="+header.menTopNavFirstLevelCategoryNavigationURLS[i]);
			String PageHeading = driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals(PageHeading, header.expectedFirstLevelmensCategories[i]);
			System.out.println("Page Heading------"+PageHeading+"=="+header.expectedFirstLevelmensCategories[i]);
			header.Logo.click();
			
			
           if(link.equals("Tops")) {

			for (int j = 0; j < menTopsSubCategries.size(); j++) {
				
				    /*Refetching the elements to avoid the stale element exception every iteration header page loading 
				    due to that we are refetching the elements*/
				
				    List<WebElement> refetchFirstLevelcategories = driver.findElements(By.xpath(header.mensTopNavFirstLevelCategories));	
				    List<WebElement> refetchmenTopsSubCategries = driver.findElements(By.xpath(header.mensTopsSubLevelCategories));
					
				    wait.until(ExpectedConditions.visibilityOfAllElements(header.menTopNav));
				    header.action.moveToElement(header.menTopNav).perform();	
					header.action.moveToElement(refetchFirstLevelcategories.get(i)).perform();
					String mensTopsSubLinks = refetchmenTopsSubCategries.get(j).getText();
					Assert.assertEquals(mensTopsSubLinks, header.expectedmensTopsSubLevelCategories[j]);
					System.out.println(mensTopsSubLinks+"----"+header.expectedmensTopsSubLevelCategories[j]);
					refetchmenTopsSubCategries.get(j).click();
					String topsSubCategoryTitle = driver.getTitle();
					Assert.assertEquals(topsSubCategoryTitle, header.menTopsSubLevelCategoryPageTiltles[j]);
					String topsSubcategoryPageURLs = driver.getCurrentUrl();
					Assert.assertEquals(topsSubcategoryPageURLs, header.menTopsSubLevelCategoryNavigationURLS[j]);
					String topsSubCategoryPageHeading = driver.findElement(By.tagName("h1")).getText();
					Assert.assertEquals(topsSubCategoryPageHeading, header.expectedmensTopsSubLevelCategories[j]);
					header.Logo.click();
					

			}
           }else if(link.equals("Bottoms")) {
			
           for (int j = 0; j < menBottomsSubCategries.size(); j++) {
        	   
        	   /*Refetching the elements to avoid the stale element exception every iteration header page loading 
			    due to that we are refetching the elements*/
        	    
        	    List<WebElement> refetchFirstLevelcategories2 = driver.findElements(By.xpath(header.mensTopNavFirstLevelCategories));	
			    List<WebElement> refetchmenBottomSubCategries = driver.findElements(By.xpath(header.mensBottomsSubLevelCategories));
				
        	    wait.until(ExpectedConditions.visibilityOf(header.menTopNav));	
        	    header.action.moveToElement(header.menTopNav).perform();
   			    wait.until(ExpectedConditions.visibilityOf(refetchFirstLevelcategories2.get(i)));	
				header.action.moveToElement(refetchFirstLevelcategories2.get(i)).perform();
				String mensBottomSubLinks = refetchmenBottomSubCategries.get(j).getText();
				Assert.assertEquals(mensBottomSubLinks, header.expectedmensBottomsSubLevelCategories[j]);
				System.out.println(mensBottomSubLinks+"----"+header.expectedmensBottomsSubLevelCategories[j]);
				refetchmenBottomSubCategries.get(j).click();
				String bottomsSubCategoryTitle = driver.getTitle();
				Assert.assertEquals(bottomsSubCategoryTitle, header.menBottomsSubLevelCategoryPageTiltles[j]);
				String topsSubcategoryPageURLs = driver.getCurrentUrl();
				Assert.assertEquals(topsSubcategoryPageURLs, header.menBottomsSubLevelCategoryNavigationURLS[j]);
				String topsSubCategoryPageHeading = driver.findElement(By.tagName("h1")).getText();
				System.out.println(topsSubCategoryPageHeading);
				Assert.assertEquals(topsSubCategoryPageHeading, header.expectedmensBottomsSubLevelCategories[j]);
				header.Logo.click();

			}
           }
		}

	}

	@Test(priority = 6, enabled=true, groups = "Regression")
	public void verifygearTopNavandSubcategoryLinks() {
		
		globalHeader header = new globalHeader(driver);
		
		wait.until(ExpectedConditions.visibilityOf(header.gearTopNav));
		
		header.clickGearTopNavcategory();
		
		String actual_gearPage_URL = driver.getCurrentUrl();
		
		System.out.println(actual_gearPage_URL+"===="+header.gearPageURL);
		
		Assert.assertEquals(actual_gearPage_URL,header.gearPageURL);
		
		String actual_gearPage_Title = driver.getTitle();
		
		System.out.println(actual_gearPage_Title+"===="+header.gear_PageTitle);
		
		Assert.assertEquals(actual_gearPage_Title, header.gear_PageTitle);
		
		String getGearPageHeading =  driver.findElement(By.tagName("h1")).getText();
		
		System.out.println(getGearPageHeading+"===="+header.gearText);
		
		Assert.assertEquals(getGearPageHeading, header.gearText);
		
		header.clickheaderLogo();
		
		wait.until(ExpectedConditions.visibilityOf(header.gearTopNav));
		
		header.action.moveToElement(header.gearTopNav).perform();
		
		List <WebElement> gear_subCategories = driver.findElements(By.xpath(header.gear_subcategories));
		
		int actual_gear_category_count =  gear_subCategories.size();
		
		System.out.println("category count :"+actual_gear_category_count);
		
		int expected_gear_category_count = header.gear_Categories.length;
		
		System.out.println("storedcategory count :"+expected_gear_category_count);
		
		Assert.assertEquals(actual_gear_category_count, expected_gear_category_count);
		
		for(int i = 0; i < actual_gear_category_count; i++) {
			
			header.action.moveToElement(header.gearTopNav).perform();
			
			List <WebElement> refetch_gear_subCategories = driver.findElements(By.xpath(header.gear_subcategories));
			
			String subcategoryLinks = refetch_gear_subCategories.get(i).getText();
			
			System.out.println(subcategoryLinks+"=="+header.gear_Categories[i]);
			
			Assert.assertEquals(subcategoryLinks, header.gear_Categories[i]);
			
			refetch_gear_subCategories.get(i).click();
			
			String currentCategoryURL = driver.getCurrentUrl();
			
			Assert.assertEquals(currentCategoryURL,header.gear_SubcategoryPageURLs[i]);
			
			String currentCategorypageTitle = driver.getTitle();
			
			Assert.assertEquals(currentCategorypageTitle,header.gear_SubcategoryPageTitles[i]);
			
			String currentCategorypageHeading = driver.findElement(By.tagName("h1")).getText();
			
			Assert.assertEquals(currentCategorypageHeading,header.gear_Categories[i]);
			
			header.clickheaderLogo();
				
			
		}
		
		
	}
	
	@Test(priority = 7, enabled = true, groups = "Regression")
	public void verifyTrainingTopNavLink() {
		
		globalHeader header = new globalHeader(driver);
		
		wait.until(ExpectedConditions.visibilityOf(header.TrainingTopNav));
		
		header.TrainingTopNav.click();
		
		String Actual_Training_Page_URL=driver.getCurrentUrl();
		
		String Actual_Training_Page_Title = driver.getTitle();
		
		String Actual_Training_Page_Heading = driver.findElement(By.tagName("h1")).getText();
		
		Assert.assertEquals(Actual_Training_Page_URL, header.Training_Page_URL);
		
		Assert.assertEquals(Actual_Training_Page_Title,header.Training_Page_Title);
		
		Assert.assertEquals(Actual_Training_Page_Heading, header.TrainingText);
		
		header.clickheaderLogo();
		
		List<WebElement> Training_SubCatgories = driver.findElements(By.xpath(header.Training_Subcategories));
		
		for(int i = 0 ;i < Training_SubCatgories.size(); i++)
			
		{
			header.hoverTrainingLink();
			
			String SubLinks = Training_SubCatgories.get(i).getText();
			
			Assert.assertEquals(SubLinks, header.Training_Sub_Category);
			
			Training_SubCatgories.get(i).click();
			
			String ActualTraining_SubCategoryPage_URL = driver.getCurrentUrl();
			
			String ActualTraining_SubcategoryPage_Title = driver.getTitle();
			
			String ActualTraining_subcategorypage_Heading = driver.findElement(By.tagName("h1")).getText();
			
			Assert.assertEquals(ActualTraining_SubCategoryPage_URL, header.Training_SubcategoryPageURL);
			
			Assert.assertEquals(ActualTraining_SubcategoryPage_Title, header.Training_SubcategoryPageTitle);
			
			Assert.assertEquals(ActualTraining_subcategorypage_Heading, header.Training_Sub_Category);	
			
		}
		
		
		
		
		
		
	}
	
	@Test(priority=8, enabled = true, groups = "Regression")
	public void verifytheSaleTopNavLink() {
	
		globalHeader header = new globalHeader(driver);
		
		header.saleTopNav.click();
		
		String Actual_SalePage_Title = driver.getTitle();
		
		String Actual_SalePage_URL = driver.getCurrentUrl();
		
		String Actual_SalePage_Heading = driver.findElement(By.tagName("h1")).getText();
		
		Assert.assertEquals(Actual_SalePage_Title, header.SalePageTitle);
		
		Assert.assertEquals(Actual_SalePage_URL, header.SalePageURL);
		
		Assert.assertEquals(Actual_SalePage_Heading, header.SalePageHeading);
		
		
		
		
	}
	
	@Test(priority=9,enabled = true, groups = "Regression")
	public void verify_the_SearchBox() throws InterruptedException {
	
		globalHeader header = new globalHeader(driver);
		
		header.searchBox.sendKeys("Shirt");
		
		WebElement search_suggestion_flyout = driver.findElement(By.id("search_autocomplete"));
		
		wait.until(ExpectedConditions.visibilityOf(search_suggestion_flyout));
		
		boolean search_suggestiondisplaying = search_suggestion_flyout.isDisplayed();
		
		Assert.assertTrue(search_suggestiondisplaying);
		
		
		List<WebElement> suggestion_List = driver.findElements(By.xpath("//ul[@role='listbox']//li//span[@class='qs-option-name']"));
		
		for (int i = 0; i < suggestion_List.size(); i++) {
			
			wait.until(ExpectedConditions.visibilityOf(search_suggestion_flyout));
			
			String suggestion_options = suggestion_List.get(i).getText();
			
			System.out.println("suggestionOption--->"+suggestion_options);
			
			header.searchBox.sendKeys(Keys.ARROW_DOWN);
			
			//Thread.sleep(3000);
			
			String Search_Box_Value = header.searchBox.getAttribute("value");
			
			String removed_Space_From_Search_Box_Value=Search_Box_Value.trim();
			
			System.out.println("selected value"+"--->"+removed_Space_From_Search_Box_Value);
			
			Assert.assertEquals(suggestion_options, removed_Space_From_Search_Box_Value);
		
		}
		
		suggestion_List.get(0).click();
		
		String getResultPageHeading = driver.findElement(By.tagName("h1")).getText();
		
		String fullResultHeading = getResultPageHeading.trim();
		
		String ExpectedResultHeading = "Search results for: 'shirt'";
		
		Assert.assertEquals(fullResultHeading, ExpectedResultHeading);
		
		header.clickheaderLogo();
		
		header.searchBox.sendKeys("Shirt");
		
		header.action.moveToElement(header.searchIcon).perform();
		
		String tooltip = header.searchIcon.getText();
		
		String actualTooltip = "Search";
		
		Assert.assertEquals(tooltip, actualTooltip);
		
		Assert.assertTrue((driver.findElement(By.xpath("//button//span[.='Search']")).isDisplayed()));
		
		wait.until(ExpectedConditions.elementToBeClickable(header.searchIcon));
		
		header.searchIcon.click();
		
		String getSearchResultPageHeading = driver.findElement(By.tagName("h1")).getText();
		
		String fullSearchResultHeading = getSearchResultPageHeading.trim();
		
		String ExpectedSearchResultHeading = "Search results for: 'Shirt'";
		
		Assert.assertEquals(fullSearchResultHeading, ExpectedSearchResultHeading);		
		
	}
	
	@Test(priority=10,enabled = true, groups = "Regression")
	public void verif_the_minicartIcon_In_Header() {
		
		globalHeader header = new globalHeader(driver);
		
		String productCount = header.minicartProductCount.getAttribute("textContent");
		
		if (productCount == null || productCount.trim().isEmpty()) {
		    System.out.println("Cart count is empty or invisible — setting to 0.");
		    productCount = "0";
		} else {
		    // Remove all non-digit characters, just in case
		    productCount = productCount.trim();
		}
		
		
		System.out.println("Product count raw: >" + productCount + "<");
		
		int productCountValue = Integer.parseInt(productCount);		
		
		
			
			boolean productCountDisplaying = header.minicartProductCount.isDisplayed();
			
			Assert.assertFalse(productCountDisplaying);
			
			header.miniCart.click();
			
			wait.until(ExpectedConditions.visibilityOf(header.minicartPopup));
			
			Assert.assertTrue(header.minicartPopup.isDisplayed());
			
			String EmptyCartMessage = driver.findElement(By.cssSelector(".subtitle.empty")).getText();
			
			Assert.assertEquals(EmptyCartMessage, header.ExpectedEmptyCartMessage);
			
			Assert.assertTrue(header.minicartCloseIcon.isDisplayed());
			
			header.minicartCloseIcon.click();
			
			Assert.assertFalse(header.minicartPopup.isDisplayed());
			
		

		
	}
}
