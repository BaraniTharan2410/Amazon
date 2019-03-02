package wrappers;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Report;

public class GenericWrappers extends Report implements Wrappers {
	public RemoteWebDriver driver;
	public static Properties prop;

	public void invokeApp(String Browser, String URI) {
		try {
			if (Browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/chromedriver.exe");
				driver = new FirefoxDriver();
			} else if (Browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.IE.driver", "./drivers/IEServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(URI);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			testCaseStatus("Pass", "Browser opened successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void explicitWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

		}

	}

	public void sendText(String XPath, String data) {
		try {
			driver.findElementByXPath(XPath).sendKeys(data);
			testCaseStatus("Pass", "Data entered successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void click(String XPath) {
		try {
			driver.findElementByXPath(XPath).click();
			testCaseStatus("Pass", "Clicked on element successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectIndexByXpath(String XPath, int Index) {
		try {
			WebElement DropDown = driver.findElementByXPath(XPath);
			Select select = new Select(DropDown);
			select.selectByIndex(Index);
			testCaseStatus("Pass", "Selected successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectValueByXpath(String XPath, String Value) {
		try {
			WebElement DropDown = driver.findElementByXPath(XPath);
			Select select = new Select(DropDown);
			select.selectByValue(Value);
			testCaseStatus("Pass", "Drop down selected successfully");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void selectVisibleTextXpath(String XPath, String VisibleText) {
		try {
			WebElement DropDown = driver.findElementByXPath(XPath);
			Select select = new Select(DropDown);
			select.selectByVisibleText(VisibleText);
			testCaseStatus("Pass", "Drop down selected successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mouseOver(String XPath) {
		try {
			WebElement Target = driver.findElementByXPath(XPath);
			Actions action = new Actions(driver);
			action.moveToElement(Target).perform();
			testCaseStatus("Pass", "Mouse Overed successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fileUpload(String filePath) throws AWTException, IOException {
		try {
			StringSelection filepath = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			testCaseStatus("Pass", "Uploaded successfully");
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public long takeSnap() throws IOException {
		long number = 1000000l;
		try {
			number = (long) (Math.floor(Math.random() * 10000000) + 100000);
			File Sourse = driver.getScreenshotAs(OutputType.FILE);
			String Destination = ("./Images/" + number + ".jpg");
			File Dest = new File(Destination);
			FileUtils.copyFile(Sourse, Dest);

		} catch (WebDriverException e) {

			e.printStackTrace();
		}
		return number;
	}

	public void switchToFrameByName(String Name) {
		try {
			driver.switchTo().frame(Name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void disimissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public String getTextAlert() { try { String text =
	 * driver.switchTo().alert().getText();
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } return text;
	 * 
	 * }
	 */

	/*
	 * public String getData(String XPath) { String data; try { data =
	 * driver.findElementByXPath(XPath).getText(); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return data;
	 * 
	 * }
	 */

	public void switchToLastWindow() {
		Set<String> Allwinds = driver.getWindowHandles();
		for (String laswind : Allwinds) {
			driver.switchTo().window(laswind);
		}

	}

	public void switchToParentWindow() {
		Set<String> Allwinds = driver.getWindowHandles();
		for (String laswind : Allwinds) {
			driver.switchTo().window(laswind);
			break;
		}

	}

	public void closeBrowser() {
		driver.close();

	}

	public void closeAllBrowsers() {
		driver.quit();

	}

	public void loadObjects() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream("./src/test/java/object.properties");
		prop.load(file);

	}

	public void unloadObjects() {
		prop = null;

	}

	public String getTextAlert() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getData(String XPath) {
		// TODO Auto-generated method stub
		return null;
	}

}
