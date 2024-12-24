package stepDefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class UserLoginStepDef {
	WebDriver driver;
	@Given("User is on login page")
	public void user_is_on_login_page() {
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	   driver.get("http://the-internet.herokuapp.com/login");
	}
	@When("User enters credentials")
	public void user_enters_credentials() {
	   driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
	   driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
	   driver.findElement(By.cssSelector("button.radius")).click();
	   
		
	}
	@Then("Should display home page")
	public void should_display_home_page() {
	   boolean isValidUser =driver.findElement(By.cssSelector("div.success")).isDisplayed();
	   Assert.assertTrue(isValidUser);
	}

}
