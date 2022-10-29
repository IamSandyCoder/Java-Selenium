package MavenProject1.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MavenProject1.TestCommponents.BaseTest;
import MavenProject1.packages.CheckoutClass;
import MavenProject1.packages.ConfirmClass;
import MavenProject1.packages.EnaPageClass;
import MavenProject1.packages.LandingClass;
import MavenProject1.packages.ProductClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {

	 ProductClass productclass;
@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//String productName="ADIDAS ORIGINAL";
productclass  = new ProductClass(driver);
          productclass=landingclass.loggingApplication(input.get("email"), input.get("password"));
		
		 List<WebElement> products =productclass.getProductList();
		 productclass.addProducttoCart(input.get("product"));
		 productclass.goToCartPage();
		 
		 CheckoutClass checkoutclass = new CheckoutClass(driver);
		 Boolean Match =checkoutclass.VerifyProductDisplay(input.get("product"));
		 Assert.assertTrue(Match);
		 ConfirmClass confirmclass =checkoutclass.goToCheckout();
		 confirmclass.selectCountry("india");
		 Thread.sleep(4000);
		 EnaPageClass endpage=confirmclass.submitOrder();
		 String confirmMessage = endpage.getConfrimationMessage();
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
		//System.out.println(driver.getTitle());
		 
		 //List<WebElement> products=driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
//		 WebElement prod= products.stream().filter(product-> 
//		 product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
			
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		
	//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
//		//Thread.sleep(5000);
		//driver.findElement(By.xpath("(//button[@routerlink='/dashboard/cart'])[1]")).click();
		//Thread.sleep(5000);
//		List <WebElement> cartProducts =driver.findElements(By.xpath("(//div[@class='cartSection']/h3)"));
//		Thread.sleep(5000);
//		Boolean Match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
//		 Assert.assertTrue(Match);
		 
//	driver.findElement(By.cssSelector(".totalRow button")).click();
//	
//	Actions a = new Actions(driver);
//	
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//	
	

//	//Thread.sleep(3000);
//	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//	
////driver.findElement(By.xpath("//button[@type='button'][2]")).click();
//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
//
////Thread.sleep(3000);
////driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
////wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" ")));
////driver.findElement(By.cssSelector(".action__submit")).click();
//	
//String confiemMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//Assert.assertTrue(confiemMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

}
		 



 @DataProvider
	
	public Object[][] getData() throws IOException
	
	{
	 List<HashMap<String,String>> data =getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\MavenProject1\\data\\PurchaseOrderFile.json");
	 
	 return new Object[][] { {data.get(0)}, {data.get(1)} };
	 //
	 
	 
	}



	
	}
