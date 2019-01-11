package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.DP;
import wrappers.ProjectWrappers;

public class AmazonBalance extends ProjectWrappers {

	@BeforeClass
	public void beforClass() {
		TestCaseName = "TC001";
		TestCaseDescription = "IRCTC SingnUp";
		Author = "Thiru";
		Category = "Functional";
		Browser = "chrome";
		// DataSheet = "TC001";
	}

	@Test(dataProvider = "getdata", dataProviderClass = DP.class)
	public void AmazonBalanceCheck(String UserName, String Password) throws IOException {
		new HomePage(driver, test).AmazonHP().enterUserName(UserName).clickOnContinueU().enterPassword(Password)
				.clickOnContinueP().clickOnAmazonPayBalance().getAmazonPayBalance();
	}

}
