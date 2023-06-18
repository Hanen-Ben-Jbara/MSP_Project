package SephoraMSP;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class add_an_article {
private WebDriver driver;
	
	@BeforeTest
	public void openurl() { 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.sephora.fr/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		WebElement denyCookies = driver.findElement(By.id("footer_tc_privacy_button_2"));
		denyCookies.click();
		}
	@Test
	public void AddProducts() {
	//Click on parfum menu
	driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[3]/a")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//In the list of all parfum , click on "Ajouter au panier" 
	driver.findElement(By.xpath("//*[@id=\"search-result-items\"]/li[1]/div/div[2]/a/div/img[1]")).click();
	driver.findElement(By.id("add-to-cart")).click();
	
	//go to cart
	driver.findElement(By.xpath("//*[@id=\"dialog-container\"]/div[3]/a[2]/button")).click();
	}
@AfterTest
public void TearDown() {	
	driver.quit();
	}
}
