package practiceFramework.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyTestListener implements ITestListener {
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest,extentTest2;
	 

	@Override
	public void onFinish(ITestContext Context) {

		System.out.println("Test Finish");

		extentReports.flush();

	}

	@Override
	public void onStart(ITestContext Context) {

		extentSparkReporter = new ExtentSparkReporter(
				"C:\\\\Users\\\\MANSOOR...KHAN\\\\eclipse-workspace\\\\SeleniumFrameWork\\\\src\\\\test\\\\resources\\\\ExtentReport\\\\ExtentReportResults.html");
		extentSparkReporter.config().setDocumentTitle("Document Title of report");
		extentSparkReporter.config().setReportName("Name of Report");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		System.out.println("Test Started");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("onTestFailedButWithinSuccessPercentage");
//		extentTest.log(Status.INFO, "onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
//		extentTest = extentReports.createTest(methodName);
		extentTest.fail("Test failed"+" "+methodName);
//		extentTest2.log(Status.FAIL, methodName);
		extentTest.addScreenCaptureFromBase64String("Failedscreenshot.png");

		System.out.println("Test Failed" + " " + methodName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
//		extentTest = extentReports.createTest(methodName);
		extentTest.skip("Test Skipped"+""+methodName);
//		extentTest2.log(Status.SKIP, methodName);
		System.out.println("Test Skipped" + "" + methodName);

	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		extentTest = extentReports.createTest(methodName);
//		extentTest2.log(Status.INFO, methodName);

		System.out.println("Test Started" + " " + methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		extentTest.pass("Test Passed"+" "+methodName);
//		extentTest = extentReports.createTest(methodName);
//		extentTest2.log(Status.PASS, methodName);

		System.out.println("Test successed" + " " + methodName);
	}

}