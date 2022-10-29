package MavenProject1.packages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MavenProject1.AbstractComponnents.AbstractComponnents;


public class EnaPageClass extends AbstractComponnents  {
	
	WebDriver driver;
	public EnaPageClass(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css =".hero-primary")
	WebElement confrimationMessage;
	
	
	public String getConfrimationMessage()
	{
		return confrimationMessage.getText();
	}
}
