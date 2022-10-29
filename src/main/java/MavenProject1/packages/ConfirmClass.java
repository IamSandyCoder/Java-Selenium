package MavenProject1.packages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MavenProject1.AbstractComponnents.AbstractComponnents;

public class ConfirmClass extends AbstractComponnents {
WebDriver driver;
	public ConfirmClass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css ="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css =".action__submit")
	WebElement submit;
	@FindBy(css =".ta-item:nth-of-type(2)")
	WebElement selectCountry; 
	
	By results =By.cssSelector(".ta-results");
//
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		
		a.sendKeys(country, countryName).build().perform();
		
		

		//Thread.sleep(3000);
		waitForElementToAppear(results);
		selectCountry.click();
		
	//driver.findElement(By.xpath("//button[@type='button'][2]")).click();
	//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
	}
	
	
	public EnaPageClass submitOrder()
	{		
		//submit.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", submit);
		js.executeScript("arguments[0].click();", submit);
		return new EnaPageClass(driver);	
	}
	
	
}
