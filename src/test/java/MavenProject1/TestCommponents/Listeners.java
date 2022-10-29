package MavenProject1.TestCommponents;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MavenProject1.resources.ExtentReporterNG;
//public class Listeners implements ITestListener{
//
//}
public class Listeners extends BaseTest implements ITestListener{
//	public ExtentTest test;
//	ExtentReports extent = ExtentReporterNG.getReportObject();
//	@Override
//	public void onTestStart(ITestResult result)
//	{
//		test= extent.createTest(result.getMethod().getMethodName());
//	}
//	
//	@Override
//	public void onTestSuccess(ITestResult result)
//	{
//		test.log(Status.PASS, "Test Passed");
//	}
//	@Override
//	public void onTestFailure(ITestResult result)
//	{
//		test.log(Status.FAIL, "Test Failed");
//		test.fail(result.getThrowable());
//		WebDriver driver = null;
//		try {
//			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 
//		
//		String filepath = null;
//		try {
//			String filePath= getScreenShotPath(result.getMethod().getMethodName(),driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
//		
//		
//	}
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
//	{
//		
//	}
//	
//	@Override
//	public void onStart(ITestContext context)
//	{
//		
//	}
//	
//	
//	@Override
//	public void onFinish(ITestContext context)
//	{
//		extent.flush();
//	}
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//unique thread id(ErrorValidationTest)->test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());//
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		String filePath = null;
		try {
			
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
		
		//Screenshot, Attach to report
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
}