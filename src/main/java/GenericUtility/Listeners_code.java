package GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners_code extends BaseClass implements ITestListener {

	public void onFinish(ITestContext context) {
		
	}

	public void onStart(ITestContext context) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		 System.out.println("TestFaild---Screenshot capturing");
		 
		try {
			getScreenshot();
			System.out.println("TestFaild---Screenshot captured");
			
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Testing is started");
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Testcase passed");
	}

}
