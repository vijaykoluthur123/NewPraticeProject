package frameworkLibrary;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage extends ReportLibrary
{
	/**
	 * This is used to enter value into a text field
	 * @param ele --- element reference
	 * @param StrValue --- test data
	 * @return status  --- true/false
	 */
	public boolean setText(WebElement ele, String StrValue) 
	{	
		boolean stepstatus;
		try
		{
			ele.clear();
			ele.sendKeys(StrValue);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	
	
	
	
	
	/**
	 * This is used to click a webelement
	 * @param ele --- element reference
	 * @return status  --- true/false
	 */
	public  boolean clickElement(WebElement ele) 
	{
		boolean stepstatus;
		try
		{
			ele.click();
			stepstatus = true;
		} 
		catch (Exception e)
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	
	
	/**
	 * This is used to click all webelements
	 * @param ele --- element reference
	 * @return status  --- true/false
	 */
	public  boolean clickElements(List<WebElement> allElements) 
	{
		boolean stepstatus;
		try
		{
			for(WebElement ele:allElements)
			{
				ele.click();
			}
			stepstatus = true;
		} 
		catch (Exception e)
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	
	
	/**
	 * This is used to get the link text from the webelement
	 * @param ele --- element reference
	 * @return status  --- true/false
	 */
	public  String getLinkText(WebElement ele) 
	{
		String value = "";
		try 
		{
			value=ele.getText();
		} 
		catch (Exception e) 
		{
			value = "";
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return value;
	}
	
	
	
	
	
	/**
	 * This is used to get attribute value from the webelement
	 * @param ele --- element reference
	 * @AttributeName ---- Attribute name
	 * @return status  --- true/false
	 */
	public  String getAttributeValue(WebElement ele,String AttributeName) 
	{
		String value = "";
		try 
		{
			value=ele.getAttribute(AttributeName);
		}
		catch (Exception e) 
		{
			value = "";
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return value;
	}
	
	
	
	
	
	/**
	 * This is used to get wait for complete page to load
	 * @param driver --- driver reference
	 * @return void
	 */
	public  void waitForPageToLoad(WebDriver driver) 
	{
		String pageLoadStatus;
		do 
		{
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	        pageLoadStatus = (String)js.executeScript("return document.readyState");
	    } while (!pageLoadStatus.equals("complete") );
	}
	
	
	
	
	
	/**
	 * This is used to check if element is enabled
	 * @param ele --- element reference
	 * @return status  --- true/false
	 */
	public  boolean isEnabled(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			stepstatus = ele.isEnabled();
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	
	
	
	
	
	/**
	 * This is used to check if element is selected
	 * @param ele --- element reference
	 * @return status  --- true/false
	 */
	public  boolean isSelected(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			stepstatus = ele.isSelected();
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	
	/**
	 * This is used to mousehover on a webelement
	 * @param ele --- element reference
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean mouseHover(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try 
		{
			Actions a1 = new Actions(driver);
			a1.moveToElement(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to perform right click on a webelement
	 * @param ele --- element reference
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean rightClick(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.contextClick(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to double click on a webelement
	 * @param ele --- element reference
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean doubleClick(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.doubleClick(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to perform drag and drop operation
	 * @param drag --- drag element reference
	 * @param drop --- drop element reference
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean dragAndDrop(WebElement drag, WebElement drop,WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.dragAndDrop(drag, drop);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to click on a webelement using java script executor
	 * @param ele --- element reference
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean JsclickElement(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to enter value on a webelement using java script executor
	 * @param ele --- element reference
	 * @param StrValue --- testdata
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean JssetText(WebElement ele, String StrValue,WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + StrValue + ";", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to scroll to a webelement using java script executor
	 * @param ele --- element reference
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean JsScrollToWebElement(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to accept alert 
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean acceptAlert(WebDriver driver) {
		boolean stepstatus;
		try {
			Alert a1 = driver.switchTo().alert();
			a1.accept();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	
	/**
	 * This is used to dismiss alert 
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean dismissAlert(WebDriver driver) {
		boolean stepstatus;
		try 
		{
			Alert a1 = driver.switchTo().alert();
			a1.dismiss();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to check if alert exist 
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean alertExist(WebElement ele,WebDriver driver) {
		boolean stepstatus;
		try {
			driver.switchTo().alert();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to get text from an alert 
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  String alertGetText(WebElement ele,WebDriver driver) {
		String StrValue = "";
		try {
			Alert a1 = driver.switchTo().alert();
			StrValue = a1.getText();
		} catch (Exception e) {
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return StrValue;
	}	
	
	
	
	
	/**
	 * This is used to check if window exists based on window  URL
	 * @param URL ---  URL of the target window
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean isWindowExistsByURL(String URL,WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to check if window exists based on window title
	 * @param URL ---  URL of the target window
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean isWindowExistsByTitle(String Title,WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(Title)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to switch to window based on window  URL
	 * @param URL ---  URL of the target window
	 * @param driver --- webdriver instance
	 * @return driver  --- webdriver instance
	 */
	public  WebDriver SwitchtoWindowByURL(String URL,WebDriver driver) 
	{
		try 
		{
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) 
				{
					break;
				}
			}
		} catch (Exception e) 
		{
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return driver;
	}	
	
	
	
	
	/**
	 * This is used to switch to window based on window  title
	 * @param Title ---  Title of the target window
	 * @param driver --- webdriver instance
	 * @return driver  --- webdriver instance
	 */
	public  WebDriver SwitchtoWindowByTitle(String Title,WebDriver driver) 
	{
		try 
		{
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) 
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(Title)) 
				{
					break;
				}
			}
		} catch (Exception e) 
		{
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return driver;
	}	
	
	
	
	
	/**
	 * This is used to close window based on window  URL
	 * @param Title ---  URL of the target window
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean closeWindowByURL(String URL,WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) 
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) 
				{
					driver.close();
					stepstatus = true;
					break;
				}
			}
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to close window based on window  Title
	 * @param Title ---  Title of the target window
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean closeWindowByTitle(String Title,WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) 
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(Title)) 
				{
					driver.close();
					stepstatus = true;
					break;
				}
			}
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to switch to frame based on element reference
	 * @param FrameRef ---  Frame Reference
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean SwitchtoFrameByElementReference(WebElement FrameRef,WebDriver driver )
	{
		boolean stepstatus = false;
		try 
		{
			driver.switchTo().frame(FrameRef);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to switch to frame based on frame name
	 * @param FrameName ---  Frame Name
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean SwitchtoFrameByName(String FrameName,WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			driver.switchTo().frame(FrameName);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to switch to frame based on index
	 * @param FrameIndex ---  Frame Index
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean SwitchtoFrameByIndex(int FrameIndex,WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			driver.switchTo().frame(FrameIndex);
			stepstatus = true;
		} 
		catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to switch to main document
	 * @param driver --- webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean SwitchtoMainDocument(WebDriver driver) 
	{
		boolean stepstatus = false;
		try 
		{
			driver.switchTo().defaultContent();
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	/**
	 * This is used to upload file using robot keys
	 * @param Filepath ---  File path
	 * @return status  --- true/false
	 */
	public  boolean RobotKeysFileUpload(String Filepath)
	{
		boolean stepstatus;
		try 
		{
			wait(2);
			StringSelection selection = new StringSelection(Filepath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);

			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);

			wait(2);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			wait(2);
			stepstatus = true;
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}	
	
	
	
	
	
	/**
	 * This is used to wait for specified amount of time
	 * @param timeInSec ---  Frame Index
	 * @return status  --- true/false
	 */
	public  boolean wait(int timeInSec) 
	{
		boolean stepStatus;
		try 
		{
			Thread.sleep(timeInSec * 1000);
			stepStatus = true;
		} 
		catch (Exception e)
		{
			stepStatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepStatus;
	}	
	
	
	
	
	/**
	 * This is used to wait for element to be present or till max time
	 * @param timeInSec ---  Frame Index
	 * @return status  --- true/false
	 */
	public  boolean dynamicWait(By by, int waittimeinsec,WebDriver driver) 
	{
		boolean status = false;
		int counter = 0;
		while (counter <= waittimeinsec) 
		{
			try 
			{
				driver.findElement(by);
				status = true;
				break;
			} catch (Exception e) 
			{
				wait(1);
			}
			counter = counter + 1;
		}
		if (counter > waittimeinsec) 
		{
			status = false;
		}
		return status;
	}
	
	
	
	
	
	/**
	 * This is used to quit the driver instance
	 * @param driver ---  webdriver instance
	 * @return status  --- true/false
	 */
	public  boolean quitdriver(WebDriver driver)
	{
		boolean stepstatus = false;
		try
		{
			driver.quit();
			stepstatus= true;
		}
		catch(Exception e)
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
}
