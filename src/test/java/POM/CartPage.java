package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends Base{
	By orderLocator = By.cssSelector("[class=\"btn btn-success\"]");
	By nameLocator = By.id("name");
	By countryLocator = By.id("country");
	By cityLocator = By.id("city");
	By cardLocator = By.id("card");
	By monthLocator = By.id("month");
	By yearLocator = By.id("year");
	By buttonLocator = By.cssSelector("[onclick=\"purchaseOrder()\"]");
	By successLocator = By.cssSelector("[class=\"sweet-alert  showSweetAlert visible\"]");
	WebDriverWait wait;

	public CartPage(WebDriver driver) {
		super(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void clickOrder() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(orderLocator));
		click(orderLocator);
	}

	public void fillTheFields() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameLocator));  
		type("maria", nameLocator);
		type("Argentina", countryLocator);
		type("Bahia", cityLocator);
		type("123", cardLocator);
		type("Octubre", monthLocator);
		type("2023", yearLocator);	
	}

	public void clickPurchase() {
		
		wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
		click(buttonLocator);
	}

	public boolean successfullyPurchase() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(successLocator));  
		return isDisplayed(successLocator);
	}
	
	public String getSuccessMessage() {
		return getText(successLocator);
	}
}
