package MavenProject1.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import MavenProject1.TestCommponents.BaseTest;
import MavenProject1.packages.CheckoutClass;
import MavenProject1.packages.ConfirmClass;
import MavenProject1.packages.EnaPageClass;
import MavenProject1.packages.LandingClass;
import MavenProject1.packages.ProductClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	
	public LandingClass landingclass;
	public ProductClass productclass;
	public EnaPageClass endPage;
	@Given("I landed on Ecommerce Page")
	public void i_landed_on_Ecommerce_page() throws IOException
	{
		
		landingclass=launchApplication();
	}
	
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) throws InterruptedException
	{
		
		 productclass=landingclass.loggingApplication(username,password);
		 
		 Thread.sleep(5000);
	}
	
	@When("^I add product (.+) to Carts $")
	public void  I_add_product_yo_cart(String productName) throws InterruptedException {
		Thread.sleep(5000);
		 List<WebElement> products =productclass.getProductList();
		 productclass.addProducttoCart(productName);
		 Thread.sleep(5000);
	}
	
	@And("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) throws InterruptedException
	{Thread.sleep(5000);
		 CheckoutClass checkoutclass = new CheckoutClass(driver);
		 Boolean Match =checkoutclass.VerifyProductDisplay(productName);
		 Assert.assertTrue(Match);
		 ConfirmClass confirmclass =checkoutclass.goToCheckout();
		 confirmclass.selectCountry("india");
		 Thread.sleep(5000);
		 EnaPageClass endpage=confirmclass.submitOrder();	
	}
	// message displayed as String 
	@Then("{string} message is displayed on ConfirmationPage")
public void message_is_displayed_on_ConfirmationPage(String string )

{
		 String confirmMessage = endPage.getConfrimationMessage();
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));	
		
}

	
//	@Then("{string} message is displayed")
//	public void message_is_displayed(String string )
//
//	{
//		Assert.assertEquals(string, landingclass.getErrorMessage());
//	}
//	
	

}
