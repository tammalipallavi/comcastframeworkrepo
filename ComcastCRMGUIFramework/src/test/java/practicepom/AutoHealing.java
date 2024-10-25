package practicepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AutoHealing {
	@FindBy(name="user_name")
	private WebElement ele1;
	@FindBy(name="user_password")
	private WebElement ele2;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement ele3;
	
	
	@Test
	public void sampleTest() {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888/");
		SampleTestWithPOM s=PageFactory.initElements(driver, SampleTestWithPOM.class);
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		
		s.ele3.click();

}
}
