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

	@Test(priority = 1, enabled = true, groups = "Regression")
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
