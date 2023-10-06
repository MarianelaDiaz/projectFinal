package exercise1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class resultsPage extends webDriverLogic {

	protected WebElement firstResult;
	protected String savedUrl, firstResultUrl;
	protected By firstResultLocator = By.cssSelector("[class = \"MjjYud\"]");

	public resultsPage(WebDriver driver) {
		super(driver);
	}

	public void checkCoincidence() {
		firstResult = driver.findElement(firstResultLocator);
		firstResultUrl = firstResult.findElement(By.tagName("a")).getAttribute("href");
		savedUrl = "https://store.steampowered.com";
		boolean coincidence = firstResultUrl.contains(savedUrl);
		if (coincidence) {
			System.out.println("La URL guardada está contenida en el primer enlace.");
			Assert.assertTrue(coincidence, "La URL guardada está contenida en el primer enlace.");
		} else {
			System.out.println("La URL guardada NO está contenida en el primer enlace.");
			Assert.fail("La URL guardada NO está contenida en el primer enlace.");
		}
	}
}