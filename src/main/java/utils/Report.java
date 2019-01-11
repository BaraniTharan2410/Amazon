package utils;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Report {
	public static ExtentReports extent;
	public ExtentTest test;
	public String TestCaseName, TestCaseDescription;
	long reportNumber = System.currentTimeMillis();

	public ExtentReports startReport() {
		extent = new ExtentReports("./Reports/" + reportNumber + ".html", true);
		return extent;

	}

	public ExtentTest startTestCase(String TestCaseName, String TestCaseDescription) {
		test = extent.startTest(TestCaseName, TestCaseDescription);
		return test;
	}

	public abstract long takeSnap() throws IOException;

	public void testCaseStatus(String TestCaseStatus, String Description) throws IOException {
		long snapNumber = 1000000001;
		snapNumber = takeSnap();

		if (TestCaseStatus.toUpperCase().equals("PASS")) {
			test.log(LogStatus.PASS, Description + test.addScreenCapture("./../Images/" + snapNumber + ".jpg"));

		} else if (TestCaseStatus.toUpperCase().equals("FAIL")) {
			test.log(LogStatus.FAIL, Description + test.addScreenCapture("./../Images/" + snapNumber + ".jpg"));
		}

	}

	public void endTestCse() {
		extent.endTest(test);
	}

	public void endReport() {
		extent.flush();
	}

}
