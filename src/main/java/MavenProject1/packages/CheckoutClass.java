package MavenProject1.packages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenProject1.AbstractComponnents.AbstractComponnents;

public class CheckoutClass extends AbstractComponnents {

	public WebDriver driver;
		
		public CheckoutClass(WebDriver driver){
			
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
	
		}
		
		@FindBy(xpath="(//div[@class='cartSection']/h3)")
		private List<WebElement> cartProducts ;
		
		@FindBy(css=".totalRow button")
		WebElement checkoutEle;
		
		
		
		public Boolean VerifyProductDisplay(String productName)
		{
			Boolean Match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
			return Match;
		}
			
		public ConfirmClass  goToCheckout() {
			
			checkoutEle.click();
			return new ConfirmClass(driver);
			
			
		}
}
		



