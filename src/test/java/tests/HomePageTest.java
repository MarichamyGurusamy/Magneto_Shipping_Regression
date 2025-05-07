package tests;

import java.time.Duration;

import javax.print.attribute.standard.JobHoldUntil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	public void pageheaderContentsValidationforGuestuser() throws InterruptedException {

		homePage home = new homePage(driver);
		boolean logoIsDisplaying = home.Logo.isDisplayed();

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
    @Test
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

	}

}
