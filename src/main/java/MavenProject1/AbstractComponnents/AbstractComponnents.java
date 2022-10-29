package MavenProject1.AbstractComponnents;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MavenProject1.packages.CheckoutClass;

public class AbstractComponnents {

	public WebDriver driver;
	public AbstractComponnents(WebDriver driver) {
	
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//button[@routerlink='/dashboard/cart'])[1]")
	WebElement cartHeader;
	
	
	public CheckoutClass goToCartPage()
	{
		cartHeader.click();
		 CheckoutClass checkoutclass = new CheckoutClass(driver);
		 return checkoutclass;
	}
	
	
	

	public void waitForWebElementToAppear(WebElement findBY) {
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
	wait.until(ExpectedConditions.visibilityOf(findBY));
		}
	
	public void waitForElementToAppear(By findBY) {
		
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
wait.until(ExpectedConditions.visibilityOfElementLocated(findBY));
	}
	
	public void waitForElementtoDisappear(WebElement ele) throws InterruptedException {
		
		Thread.sleep(5000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
		
		
	}



}
