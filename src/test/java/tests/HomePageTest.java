package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
}
