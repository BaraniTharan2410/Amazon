package wrappers;

import java.awt.AWTException;
import java.io.IOException;

public interface Wrappers {

	public void invokeApp(String Browser, String URI);

	public void explicitWait(int time);

	public void sendText(String XPath, String data);

	public void click(String XPath);

	public void selectIndexByXpath(String XPath, int Index);

	public void selectValueByXpath(String XPath, String Value);

	public void selectVisibleTextXpath(String XPath, String VisibleText);

	public void mouseOver(String XPath);

	public void fileUpload(String filePath) throws AWTException, IOException;

	public long takeSnap() throws IOException;

	public void switchToFrameByName(String Name);

	public void acceptAlert();

	public void disimissAlert();

	public String getTextAlert();

	public String getData(String XPath);

	public void switchToLastWindow();

	public void switchToParentWindow();

	public void closeBrowser();

	public void closeAllBrowsers();

	public void loadObjects() throws IOException;

	public void unloadObjects();

}
