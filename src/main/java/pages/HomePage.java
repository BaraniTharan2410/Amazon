package pages;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {

	public HomePage(RemoteWebDriver driver , ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public LogInPage AmazonHP() throws IOException {
		mouseOver(prop.getProperty("HomePage.mouseOver"));
		explicitWait(3000);
		click(prop.getProperty("HomePage.click"));
		takeSnap();
		return new LogInPage(driver , test);
	}
}
