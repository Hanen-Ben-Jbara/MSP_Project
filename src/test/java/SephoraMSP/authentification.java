package SephoraMSP;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class authentification {
public WebDriver driver;
	
	@BeforeTest
		public void setUp(){
	   driver = new ChromeDriver();
	   driver.get("https://www.sephora.fr/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));			
	   WebElement denyCookies = driver.findElement(By.id("footer_tc_privacy_button_2"));
	   denyCookies.click();
	}
		
	@Test
		public void	TestCase() throws Exception {
		String email = "hanenjbara@gmail.com";
		String password = "12345";
		
		 WebElement emailField = driver.findElement(By.id("dwfrm_crmsephoracard_email"));
	     emailField.sendKeys(email);
	     
	     driver.findElement(By.name("dwfrm_crmsephoracard_confirm")).click();
	     
	     WebElement passwordField = driver.findElement(By.id("dwfrm_login_password_d0kbayopcfgl"));
	     passwordField.sendKeys(password);
	     
	     WebElement btn_Submit = driver.findElement(By.id("loginSubmit"));
		 btn_Submit.click();	

		}	
			 
	@AfterTest
		public void TearDown(){
			driver.quit();
	}
}
