package com.sephora.stepsDefinitions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {
	WebDriver driver;

@Given("I am on the shopping website homepage")
public void i_am_on_the_shopping_website_homepage() {
    // Write code here that turns the phrase above into concrete actions
	driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.sephora.fr/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    WebElement denyCookies = driver.findElement(By.id("footer_tc_privacy_button_2"));
		denyCookies.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
}

	@When("I search for {string}")
	public void i_search_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@id='wrapper']/header/div[6]/div/div[3]/div/span")).click();
		driver.findElement(By.id("autocomplete-0-input")).sendKeys("Eau de parfum");
		driver.findElement(By.id("autocomplete-0-input")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}

	@When("I select a {string} product from the search results")
	public void i_select_a_product_from_the_search_results(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"algolia-searchbox-placeholder\"]/div/div/ol/li[1]/div/div[2]/a/div[1]/img[1]")).click();
	}

	@When("I click on the {string} button")
	public void i_click_on_the_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("add-to-cart")).click(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Then("the item {string} should be added to my shopping cart")
	public void the_item_should_be_added_to_my_shopping_cart(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"dialog-container\"]/div[3]/a[2]/button")).click();
	}

	@Then("the cart total should be updated accordingly")
	public void the_cart_total_should_be_updated_accordingly() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement quantityInput= driver.findElement(By.xpath("//*[@id=\"cart-items-form\"]/fieldset/div[1]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/select"));
		Select quantity = new Select(quantityInput);
		quantity.selectByIndex(2);
	}

}
