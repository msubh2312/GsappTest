package Academy.GSAppTest;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;





public class Listeners extends base implements ITestListener{
	//ExtentTest ET;
	//ExtentReports ER=ExtentReports.ExtentReportsconfig();
	//ThreadLocal<ExtentTest> TL = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		
		//ET = ER.createTest(result.getMethod().getMethodName());
		//TL.set(ET);
	    // not implemented
	  }

	  public void onTestSuccess(ITestResult result) {
	    // not implemented
		  //TL.get().log(Status.PASS, "Test Passed");
	  }

	  public void onTestFailure(ITestResult result) {
		String s= result.getName();
		try {
			base.screenShot(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	  }

	  public void onTestSkipped(ITestResult result) {
		  
	  }
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	  }

	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
	  public void onStart(ITestContext context) {
	  }
	  public void onFinish(ITestContext context) {

	  }
	

}
