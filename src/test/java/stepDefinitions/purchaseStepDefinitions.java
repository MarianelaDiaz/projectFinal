package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import POM.CartPage;
import POM.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class purchaseStepDefinitions {
	
	protected final static String webURL = "https://www.demoblaze.com/";
	protected WebDriver driver;
	protected HomePage homePage;
	protected CartPage cartPage;
	protected WebElement bottonLogout;
	
	@Given("I am on the home page and I have two o more products")
	public void openPage() {
		homePage= new HomePage(driver);
		driver = homePage.chromeDriverConnection();
		driver.get(webURL);
		homePage.addProducts();
	}
	
	@And("I click on cart page")
	public void clickCart() {
		homePage.goTo();
	}
	 
	@And("I click on button place order")
	public void clickButtonOrder() {
		cartPage = new CartPage(driver);
		cartPage.clickOrder();
	}
	
	@And("I fill the fields with user information")
	public void fillUserInformationFields() {
		cartPage.fillTheFields();		
	}
	
	@When("I click on button purchase")
	public void clickButtonPurchase() {
		cartPage.clickPurchase();
	}
	
	@Then("I made the purchase successful")
	public void successfullyPurchase() {
		Assert.assertTrue(cartPage.successfullyPurchase());
		Assert.assertTrue(cartPage.getSuccessMessage().contains("Thank you for your purchase!"));
		cartPage.quit();
	}
}

