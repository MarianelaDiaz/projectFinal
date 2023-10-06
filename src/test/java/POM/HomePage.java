package POM;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Base{
	By laptopId = By.cssSelector("[onclick=\"byCat('notebook')\"]");
	WebDriverWait wait;
	By categoryLocator = By.cssSelector("[onclick=\"byCat('notebook')\"]");
	By productLocator1 = By.cssSelector("[href=\"prod.html?idp_=15\"]");
	By productLocator2 = By.cssSelector("[href=\"prod.html?idp_=8\"]");
	By buttonLocator1 = By.cssSelector("[onclick=\"addToCart(15)\"]");
	By buttonLocator2 = By.cssSelector("[onclick=\"addToCart(8)\"]");
	By homeLocator = By.cssSelector("[href=\"index.html\"]");
	By locatorGoButton = By.id("cartur");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void addProducts() {
	    goToCategoryAndAddProduct(categoryLocator, productLocator1, buttonLocator1);
	    goToCategoryAndAddProduct(categoryLocator, productLocator2, buttonLocator2);
	}
	
	private void goToCategoryAndAddProduct(By categoryLocator, By productLocator, By buttonLocator) {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    
	    WebElement category = driver.findElement(categoryLocator);
	    wait.until(ExpectedConditions.elementToBeClickable(category));
	    click(categoryLocator);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
	    click(productLocator);

	    wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
	    click(buttonLocator);

	    wait.until(ExpectedConditions.elementToBeClickable(homeLocator));
	    click(homeLocator);

	    }

	public void goTo() {
		wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        wait.until(ExpectedConditions.elementToBeClickable(locatorGoButton));
		click(locatorGoButton);	
	}	
}
