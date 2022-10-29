package MavenProject1.TestCommponents;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import MavenProject1.packages.LandingClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public  WebDriver driver;
	public LandingClass landingclass;

	public  WebDriver initializeDriver() throws IOException 
	{
// properties class
		
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\MavenProject1\\resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
		ChromeOptions options = new ChromeOptions();
	    WebDriverManager.chromedriver().setup();
	    if(browserName.contains("headless"))
	    {
		options.addArguments("headless");
	       }
	    driver =new ChromeDriver(options);
	    // driver.manage().window().setSize(new Dimension (1440,900));
	    
		}
		
		
//		if(browserName.equalsIgnoreCase("chrome"))
//		{
//		ChromeOptions options = new ChromeOptions();
//	    WebDriverManager.chromedriver().setup();
//		options.addArguments("headless");
//	    driver =new ChromeDriver(options);
//		
//		
//		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
//			WebDriverManager.chromedriver().setup();
//			 WebDriver driver =new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("Edge"))
		{
//			WebDriverManager.chromedriver().setup();
//			 WebDriver driver =new ChromeDriver();
		}
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 	
		return driver;
	}
		
	

		public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
			
			// read json to string 
		String jsonContent	=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		// string to hashMap   Jackson Datbind dependency convert string to hashmap
		
		
		ObjectMapper mapper =new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
			
		});
	 	return data;
		
		
		}
	
			
		public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";	
		}
		
		public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
		{
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
			//String png= System.currentTimeMillis()+ ".png";
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
			FileUtils.copyFile(source,new File(destinationFile));
			
			return destinationFile;
		}
	
	@BeforeTest(alwaysRun=true)
	public LandingClass launchApplication() throws IOException 
	{
		driver=initializeDriver();
	
		 landingclass= new LandingClass(driver);
		 landingclass.goTo();
		
		return landingclass;
		
	}
	@AfterTest(alwaysRun=true)

	 public void tearDown() {
		
		
		driver.quit();
	}
}

