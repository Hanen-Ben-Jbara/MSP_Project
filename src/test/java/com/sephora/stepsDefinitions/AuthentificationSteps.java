package com.sephora.stepsDefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthentificationSteps {
	WebDriver driver;
	
	@Given("I launch the sephora application")
	public void i_launch_the_sephora_application() {
	    // Write code here that turns the phrase above into concrete actions
		 driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.get("https://www.sephora.fr/");
	}

	@When("I click on login-icon of nav_menu")
	public void i_click_on_login_icon_of_nav_menu() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement denyCookies = driver.findElement(By.id("footer_tc_privacy_button_2"));
	    denyCookies.click();
		WebElement sign_in = driver.findElement(By.id("customerAuthenticated"));
	     sign_in.click();
	}

	@Then("connexion page is opened")
	public void connexion_page_is_opened() {
	    // Write code here that turns the phrase above into concrete actions
	     assertTrue("The connexion is not displayed", driver.getTitle().equals("Connexion mon compte ≡ SEPHORA"));
	}

	@When("I enter the mail and passeword correct")
	public void i_enter_the_mail_and_passeword_correct() {
	    // Write code here that turns the phrase above into concrete actions
	     WebElement emailField = driver.findElement(By.id("dwfrm_crmsephoracard_email"));
	     emailField.sendKeys("hanenjbara@gmail.Com");
	     driver.findElement(By.name("dwfrm_crmsephoracard_confirm")).click();;
	     WebElement passwordField = driver.findElement(By.id("dwfrm_login_password_d0kbayopcfgl"));
	     passwordField.sendKeys("12345");
	}

	@When("I click on the connect button")
	public void i_click_on_the_connect_button() {
	    // Write code here that turns the phrase above into concrete actions
		 WebElement btn_Submit = driver.findElement(By.id("loginSubmit"));
		 btn_Submit.click();
	}

	@Then("I connect to my application account")
	public void i_connect_to_my_application_account() {
	    // Write code here that turns the phrase above into concrete actions
	     assertTrue("I can't connect to the app", driver.getCurrentUrl().contains("Mon beauty compte"));
	}



}
