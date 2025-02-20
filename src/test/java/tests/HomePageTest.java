package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.WebdriverManager;

public class HomePageTest extends BaseTest{
	
	@Test
	public void test1() {
		
		System.out.println("Hii");
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
	}
}
