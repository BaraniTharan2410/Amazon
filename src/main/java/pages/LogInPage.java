package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LogInPage extends GenericWrappers {

	public LogInPage(RemoteWebDriver driver ,  ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public LogInPage enterUserName(String UserName) {
		sendText(prop.getProperty("LogInPage.enterUserName"), UserName);
		return this;
	}

	public LogInPage clickOnContinueU() {
		click(prop.getProperty("LogInPage.clickOnContinueU"));
		return this;
	}

	public LogInPage enterPassword(String Password) {
		sendText(prop.getProperty("LogInPage.enterPassword"), Password);
		return this;
	}

	public LogInPage clickOnContinueP() {
		click(prop.getProperty("LogInPage.clickOnContinueP"));
		return this;
	}

	public LogInPage clickOnAmazonPayBalance() {
		click(prop.getProperty("LogInPage.clickOnAmazonPayBalance"));
		return this;
	}

	public LogInPage getAmazonPayBalance() {
		String Text = getData(prop.getProperty("LogInPage.getAmazonPayBalanceText"));
		String Amount = getData(prop.getProperty("LogInPage.getAmazonPayBalanceValue"));
		System.out.println(Text + " : " + Amount);
		return this;
	}

}
