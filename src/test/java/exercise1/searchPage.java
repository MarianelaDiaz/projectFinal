package exercise1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchPage extends webDriverLogic {

	private static final String URL = "http://www.google.com";
	private WebDriverWait wait;
	protected By searchLocator = By.cssSelector("[class= \"gLFyf\"]");
	protected By boxListLocator = By.cssSelector("[class=\"G43f7e\"]");
	protected By listLocator = By.tagName("li");
	protected By imageLocator = By.cssSelector("[class='sbic vYOkbe']");
	protected WebElement search;

	public searchPage(WebDriver driver) {
		super(driver);
	}

	public void navigateTo() {
		driver.get(URL);
	}
	
	public List<WebElement> textsuggestions(String text) {
		search = driver.findElement(searchLocator);
		search.sendKeys(text);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement suggestionList = wait.until(ExpectedConditions.visibilityOfElementLocated(boxListLocator));
		List<WebElement> elementsSuggestions = suggestionList.findElements(listLocator);
		return elementsSuggestions;
	}

	public List<String> passToString(List<WebElement> list) {
		List<String> suggestionList = new ArrayList<>();

		for (WebElement suggestion : list) { 
			String suggestionText = suggestion.getText();
			suggestionList.add(suggestion.getText());
			System.out.println("Suggestion: " + suggestionText);
		}
		return suggestionList;

	}

	public void clear() {
		search.clear();
	}

	public boolean searchMatch (List<String> list1, List<String> list2) {
		boolean noMatch = true;

		for (String suggestionText1 : list1) {
			for (String suggestionText2 : list2) {
				if (suggestionText1.equals(suggestionText2)) {
					noMatch = false;
					break;
				} 
			}
			if (!noMatch) {
				break;
			}
		}
		if (noMatch) {
			System.out.println("There are no matches between the lists");
		} else {
			System.out.println("Matches were found between the lists");
		}
		return noMatch;
	}

	public boolean firstWithImage(List<WebElement> list2) {
		boolean found = false;
		WebElement first;
		for (WebElement suggestion : list2) {
			WebElement elementFound = suggestion.findElement(imageLocator);
			if (elementFound != null) {
				first = suggestion;
				first.click();
				found = true;
				break;
			}
		}
		return found;
	}
}