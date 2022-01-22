package Project1.Gap;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.gap.helpers.FileReaderManager;
import com.gap.pojo.Customer;

import org.apache.log4j.Logger;

public class DefOutlineGap {
	
	static Logger log  = Logger.getLogger(DefOutlineGap.class.getName());
	
	WebDriver driver = null;

	
	@Given("User is on Home Page")
	public void user_is_on_home_page() throws Throwable {
		log.debug("Entered User home page");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sadia\\eclipse-workspace\\SeleniumTryOut\\chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(4000);
				driver.get("https://www.gap.com/");
				driver.manage().window().maximize();
				Thread.sleep(4000);
		log.debug("Successfully completed home page method");
	}

	@When("User search for {string}")
	public void user_search_for(String string) throws Throwable {
		driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div/div/div/div/div[3]/div/form/input"));
		Thread.sleep(1000);
		WebElement search=driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div/div/div/div/div[3]/div/form/input"));
		Thread.sleep(1000);
		search.sendKeys("Women dress");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
	
	}

	@When("Choose to buy the second item")
	public void choose_to_buy_the_second_item() throws InterruptedException {
		//driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/section/div/div[3]/div/div[1]/a/img"));
		//driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/section/div/div[3]/div/div[1]/a/img")).click();

		Thread.sleep(2000);
		
		//driver.findElement(By.cssSelector(".css-11ltxe6 div.css-e213ev:nth-of-type(1)")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/section/div/div[3]/div/div[1]/a/img")).click();
	}

	@When("Selects the colour and size")
	public void selects_the_colour_and_size() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.name("color-radio")).click();
		driver.findElement(By.id("variant-1-sizeDimension1-L")).click();
		Thread.sleep(2000);
	}

	@When("Adds item to the cart")
	public void adds_item_to_the_cart() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div/main/div/div[1]/div[2]/div/div/div/div[1]/div/div[1]/div[1]/div[2]/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div[2]/div[1]/button")).click();
		Thread.sleep(1000);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-600)");
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[3]/div[2]/a/div/div/div/span")).click();
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
	}

	@When("clicks guest checkout")
	public void clicks_guest_checkout() throws InterruptedException {
		driver.findElement(By.id("checkout-button")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");
		Thread.sleep(5000);
	}

	@When("enters the email address continues as guest")
	public void enters_the_email_address_continues_as_guest() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div/div[2]/div[2]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div/div[2]/div[2]/form/label/input")).sendKeys("shasad@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div/div[2]/div[2]/form/button")).click();
		Thread.sleep(6000);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)");
	}

	@When("select Priority {int} business day shipping")
	public void select_priority_business_day_shipping(Integer int1) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div[1]/div[3]/div[1]/section[1]/div[7]/div[1]/label/div")).click();
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
	}

	@Then("enter personal details and shipping address on checkout page")
	public void enter_personal_details_and_shipping_address_on_checkout_page() {
		driver.findElement(By.id("addressForm__fullName")).sendKeys(FileReaderManager.getInstance().getJsonReader().getCustomerFullName());
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		//sendKeys(Keys.TAB);
		driver.findElement(By.id("addressForm__address")).sendKeys(FileReaderManager.getInstance().getJsonReader().getCustomerAddress());
		act.sendKeys(Keys.TAB).build().perform();
		//sendKeys(Keys.TAB);
		driver.findElement(By.id("addressForm__apt")).sendKeys("5");
		act.sendKeys(Keys.TAB).build().perform();
		//sendKeys(Keys.TAB);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div[1]/div[3]/div[1]/section[2]/div/div[1]/div/div/div/form/div/div[2]/span/div[2]/label/input")).sendKeys(FileReaderManager.getInstance().getJsonReader().getCustomercity());
		act.sendKeys(Keys.TAB).build().perform();
		//sendKeys(Keys.TAB);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div[1]/div[3]/div[1]/section[2]/div/div[1]/div/div/div/form/div/div[2]/span/div[3]/div/label/select")).sendKeys(FileReaderManager.getInstance().getJsonReader().getCustomerstate());
		act.sendKeys(Keys.TAB).build().perform();
		//sendKeys(Keys.TAB);
		driver.findElement(By.id("addressForm__zip")).sendKeys(FileReaderManager.getInstance().getJsonReader().getCustomerpostCode());
		act.sendKeys(Keys.TAB).build().perform();
		//sendKeys(Keys.TAB);
		driver.findElement(By.id("addressForm__phone")).sendKeys(FileReaderManager.getInstance().getJsonReader().getCustomergetMob());
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div[1]/div[3]/div[1]/section[2]/div/div[3]/button")).click();
		//driver.findElement(By.id("addressConfirm__confirm--button")).click();
		
		
	}

//	@Then("select payment method and review order")
//	public void select_payment_method_and_review_order() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}


}
