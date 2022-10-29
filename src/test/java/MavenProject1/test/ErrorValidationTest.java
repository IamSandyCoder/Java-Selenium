package MavenProject1.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import MavenProject1.TestCommponents.BaseTest;
import MavenProject1.packages.CheckoutClass;
import MavenProject1.packages.ConfirmClass;
import MavenProject1.packages.EnaPageClass;
import MavenProject1.packages.LandingClass;
import MavenProject1.packages.ProductClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest {

@Test (groups= {"ErrorHandling"})
	public void submitOrder() throws IOException {
		// TODO Auto-generated method stub
String productName="ADIDAS ORIGINAL";
//		
landingclass.loggingApplication("santhoshsivan200@gmail.com", "Thalas555");
		
	Assert.assertEquals("Incorrect email or password.", landingclass.getErrorMessage());



	}
	}
