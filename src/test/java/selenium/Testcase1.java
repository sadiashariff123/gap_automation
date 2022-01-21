package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testcase1 {

	public static void main(String[] args) throws NoAlertPresentException,InterruptedException  {									
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sadia\\eclipse-workspace\\SeleniumTryOut\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
				//Enter the URL
				driver.get("https://www.gap.com/");
				Thread.sleep(4000);
				
				driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div/div/div/div/div[3]/div/form/input"));
				Thread.sleep(1000);
				WebElement search=driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div/div/div/div/div/div[3]/div/form/input"));
				Thread.sleep(1000);
				search.sendKeys("Women dress");
				Thread.sleep(1000);
				search.sendKeys(Keys.ENTER);
				
				//scrolling down the window
				JavascriptExecutor jse=(JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,300)");
				Thread.sleep(2000);
				
				//select the dress
				driver.findElement(By.id("782233002"));
				WebElement dress=driver.findElement(By.id("782233002"));
				Thread.sleep(2000);
				dress.click();
				
				//select the size and colour
				driver.findElement(By.name("color-radio")).click();
				driver.findElement(By.id("variant-1-sizeDimension1-L")).click();
				Thread.sleep(2000);
				
				//select add to cart
				driver.findElement(By.xpath("/html/body/div[2]/div/main/div/div[1]/div[2]/div/div/div/div[1]/div/div[1]/div[1]/div[2]/div[2]/button")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div[2]/div[1]/button")).click();
				Thread.sleep(1000);
				jse.executeScript("window.scrollBy(0,-500)");
				
				//Go to the cart
				driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/div/div[3]/div[2]/a/div/div/div/span")).click();
				jse.executeScript("window.scrollBy(0,300)");
				Thread.sleep(2000);
				
				//Click on checkout
				driver.findElement(By.id("checkout-button")).click();
				Thread.sleep(2000);
				jse.executeScript("window.scrollBy(0,400)");
				Thread.sleep(5000);
				
				//continue as guest
				driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div/div[2]/div[2]/button")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div/div[2]/div[2]/form/label/input")).sendKeys("shasad@gmail.com");
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div/div[2]/div[2]/form/button")).click();
				Thread.sleep(6000);
				jse.executeScript("window.scrollBy(0,400)");
				
				//Select Priority 1 business day shipping
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div[1]/div[3]/div[1]/section[1]/div[7]/div[1]/label/div")).click();
				jse.executeScript("window.scrollBy(0,300)");
				Thread.sleep(2000);
				
				//shipping address
				driver.findElement(By.id("addressForm__fullName")).sendKeys("Shasad Ali");
				sendKeys(Keys.TAB);
				driver.findElement(By.id("addressForm__address")).sendKeys("5 cedar glenn ct ");
				sendKeys(Keys.TAB);
				driver.findElement(By.id("addressForm__apt")).sendKeys("1212");
				Thread.sleep(2000);
				sendKeys(Keys.TAB);
				driver.findElement(By.id("addressForm__town-aria")).sendKeys("Cummin");
				sendKeys(Keys.TAB);
				Thread.sleep(2000);
				driver.findElement(By.id("addressForm__state")).sendKeys("G");
				sendKeys(Keys.TAB);
				driver.findElement(By.id("addressForm__zip")).sendKeys("30040");
				sendKeys(Keys.TAB);
				driver.findElement(By.id("addressForm__phone")).sendKeys("2234452316");
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div[2]/div[1]/div[3]/div[1]/section[2]/div/div[3]/button")).click();
				driver.findElement(By.id("addressConfirm__confirm--button")).click();
				
		

	}

	private static void sendKeys(Keys tab) {
		// TODO Auto-generated method stub
		
	}

}
