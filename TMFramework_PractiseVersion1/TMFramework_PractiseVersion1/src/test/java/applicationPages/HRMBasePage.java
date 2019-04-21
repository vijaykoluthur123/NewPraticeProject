package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import frameworkLibrary.BasePage;
import frameworkLibrary.FrameworkVariables;

public class HRMBasePage extends BasePage
{
	public WebDriver launchHRMLoginpage()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.testingmasters.com/hrm");
		return driver;
	}
	
	public  boolean exists(WebElement ele) 
	{
		boolean stepstatus;
		try 
		{
			stepstatus = ele.isDisplayed();
		} catch (Exception e) 
		{
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
}
