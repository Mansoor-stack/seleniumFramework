package practiceFramework.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentReports extentreports;
	public static ExtentSparkReporter sparkReporter;

	public static ExtentReports getReport() {
		sparkReporter = new ExtentSparkReporter(
				"C:\\Users\\MANSOOR...KHAN\\eclipse-workspace\\SeleniumFrameWork\\src\\test\\resources\\ExtentReport\\ExtentReportResults.html");
		sparkReporter.config().setDocumentTitle("Document Title of report");
		sparkReporter.config().setReportName("Name of report ");

		extentreports = new ExtentReports();
		extentreports.attachReporter(sparkReporter);

		return extentreports;
	}

	public static void printResults() {
		extentreports.flush();
	}

}
