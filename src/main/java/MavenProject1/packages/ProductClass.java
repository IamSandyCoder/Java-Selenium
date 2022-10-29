package MavenProject1.packages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenProject1.AbstractComponnents.AbstractComponnents;

public class ProductClass extends AbstractComponnents {

	WebDriver driver;
		
		public ProductClass(WebDriver driver){
			
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		
		}
		
		@FindBy(css=".mb-3")
		List<WebElement> products;
		@FindBy(css=".ng-animating")
		WebElement spinner;
		By productBy = By.cssSelector(".mb-3");
		By addtoCart = By.cssSelector(".card-body button:last-of-type");
		By tostMessage= By.cssSelector("#toast-container");
		
		public List<WebElement> getProductList()
		{
			waitForElementToAppear(productBy);
			return products;
		}
		
		
		
		public WebElement getProductByName(String productName)
		{
			WebElement prod= products.stream().filter(product-> 
			 product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			return prod;
			
		}
			
		public void addProducttoCart(String productName) throws InterruptedException
		{
			WebElement prod= getProductByName(productName);
			prod.findElement(addtoCart).click();
			waitForElementToAppear(tostMessage);
			waitForElementtoDisappear(spinner);
		}
		
}
		



