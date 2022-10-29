package MavenProject1.packages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenProject1.AbstractComponnents.AbstractComponnents;

public class LandingClass extends AbstractComponnents{

	public WebDriver driver;
		
		public LandingClass(WebDriver driver){
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		
		}
		
		@FindBy(id="userEmail")
		WebElement userEmail;
			
		  
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(id="login")
		WebElement submit;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
			
			public ProductClass loggingApplication(String email, String password) {
				userEmail.sendKeys(email);
				passwordEle.sendKeys(password);
				submit.click();
				ProductClass productclass = new ProductClass(driver);
				return productclass  ;
				}
			public String getErrorMessage()
			{
				waitForWebElementToAppear(errorMessage);
				return errorMessage.getText();
				
				
			}
			
			public void goTo() 
			{
				 driver.get("https://rahulshettyacademy.com/client");
				 driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}
			
}



