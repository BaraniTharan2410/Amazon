package wrappers;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

public class ProjectWrappers extends GenericWrappers {

	public String Author, Category, Browser;

	@BeforeSuite
	public void startReporter() {
		startReport();

	}

	@BeforeTest
	public void loadData() throws IOException {
		loadObjects();
	}

	@BeforeMethod
	public void launchApp() {

		startTestCase(TestCaseName, TestCaseDescription);
		test.assignAuthor(Author);
		test.assignCategory(Category);
		invokeApp(Browser, "https://www.amazon.co.in");
	}

	@AfterMethod
	public void closeBrowsers() {
		explicitWait(3000);
		closeAllBrowsers();
	}

	@AfterClass
	public void afterClass() {
		endTestCse();
	}

	@AfterTest
	public void AfteTest() {
		unloadObjects();
	}

	@AfterSuite
	public void afterSuite() {
		endReport();
	}

}
