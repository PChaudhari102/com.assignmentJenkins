package assignmentJenkins;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListner implements ITestListener{
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****Test case is started****");
		test=reports.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****Test case is success****");
		test.log(LogStatus.PASS, "Great this testcase is passed");
		reports.endTest(test);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****Test case is failed****");
		test.log(LogStatus.FAIL, result.getThrowable() );
		reports.endTest(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("****Test Suit is started****");
		reports=new ExtentReports
				("C:\\Users\\Princy\\eclipse-workspace\\com.assignmentJenkins"+"\\reports\\"+"extentsreports.html");
        reports.loadConfig(new File("C:\\Users\\Princy\\eclipse-workspace\\com.assignmentJenkins\\config-report.xml"));
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("****Test Suit is finish****");
		reports.flush();
	}

}
