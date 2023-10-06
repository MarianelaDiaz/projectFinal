package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

public WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");		
		driver=new ChromeDriver();
		return driver;
	}
	
	public void type(String text, By locator) {
		WebElement element = findElement(locator);
		element.sendKeys(text);
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	} 
	
	public boolean isDisplayed(By locator) {
	return (driver.findElement(locator) != null);
		
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}


	public void openUrl(String url) {
		driver.get(url);
		
	} 
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getSource() {
		return driver.getPageSource();
	}
	
	public void quit() {
		driver.quit();
	}
}

