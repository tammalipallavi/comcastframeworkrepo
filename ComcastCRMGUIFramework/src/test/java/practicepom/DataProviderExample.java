package practicepom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DataProviderExample {
	@Test
	public void getProductInfoTest() {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
	
	//capture product info
		String x="//span[contains(text(),'Apple iPhone 15 (128 GB) - Black')]/../../../../div[3]/div/div[1]/div[1]/div[1]/div/a/span/span/span[2]";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	
	}
	
	
	}
