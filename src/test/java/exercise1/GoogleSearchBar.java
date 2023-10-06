package exercise1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchBar {
	protected WebDriver driver;
	protected webDriverLogic driverLogic;
	protected searchPage searchpage;
	protected resultsPage resultsPage;
	protected List<String> list1, list2;
	protected List<WebElement> listaweb1, listaweb2;

	@BeforeTest
	public void setUp() {
		searchpage = new searchPage(driver);
		driver =searchpage.chromeDriverConnection();

	}

	@Test
	public void openPage() {
		searchpage.navigateTo();
		listaweb1 = searchpage.textsuggestions("auto");
		list1 = searchpage.passToString(listaweb1);
		searchpage.clear();

		listaweb2 = searchpage.textsuggestions("automation");
		list2 = searchpage.passToString(listaweb2);

		searchpage.searchMatch(list1, list2);

		boolean encontro = searchpage.firstWithImage(listaweb2);
		resultsPage = new resultsPage(driver);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (encontro) {

			resultsPage.checkCoincidence();
		}
	}

	@AfterTest
	public void close() {
		resultsPage.quit();
	}
}