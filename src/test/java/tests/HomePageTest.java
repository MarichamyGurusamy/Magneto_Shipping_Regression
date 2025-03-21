package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import pages.homePage;
import utils.WebdriverManager;

public class HomePageTest extends BaseTest {

	@Test
	public void homePageURLandTitleVerification() {
		homePage home = new homePage(driver);

		String actualhomepageURL = home.getHomePageURL();

		Assert.assertEquals(actualhomepageURL, home.homePageURL);

		System.out.println(actualhomepageURL);

		String actualhomepageTitle = home.gethomePageTitle();

		System.out.println(actualhomepageTitle);

		Assert.assertEquals(actualhomepageTitle, home.homePageTitle);

	}

	@Test
	public void pageheaderContentsValidationforGuestuser() {

		homePage home = new homePage(driver);

		boolean logoIsDisplaying = home.Logo.isDisplayed();

		Assert.assertTrue(logoIsDisplaying);

		try {
			home.screen.find(home.logoImagePath);
		} catch (FindFailed e) {

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
}
