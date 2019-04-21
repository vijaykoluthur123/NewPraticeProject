package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg101_LoginPage extends HRMBasePage
{
	HRMBasePage basepage = new HRMBasePage();
	
	//Initilization
	WebDriver driver;
	boolean stepstatus;
	public Pg101_LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//define webelementss
	@FindBy(how=How.XPATH,using="//input[@name='txtUsername']")
	WebElement Username;
	public void setUsername(String Strusername)
	{
		stepstatus = basepage.setText(Username, Strusername);
		reportEvent(stepstatus, "Able to enter username", "Unable to enter username",driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='txtPassword']")
	WebElement Password;
	public void setPassword(String Strpassword)
	{
		stepstatus = basepage.setText(Password, Strpassword);
		reportEvent(stepstatus, "Able to enter password", "Unable to enter password",driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='Submit']")
	WebElement Singin;
	public void clickOnLogin()
	{
		stepstatus = basepage.clickElement(Singin);
		reportEvent(stepstatus, "Able to click on Sign-In BUtton", "Unable to click on Sign-In Button",driver);
	}
}
