package applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class Pg103_ContactDetailsPage extends HRMBasePage
{
	HRMBasePage basepage = new HRMBasePage();
	
	WebDriver driver;
	boolean stepstatus;
	
	public Pg103_ContactDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//define webelementss
	@FindBy(how=How.XPATH,using="//input[@value='Edit']")
	WebElement Edit;
	public void clickOnEdit()
	{
		stepstatus = basepage.clickElement(Edit);
		reportEvent(stepstatus, "Able to click On Edit", "UnAble to click On Edit", driver);
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_street1']")
	WebElement AddressStreet1;
	public void setAddressStreet1(String StrAddress1)
	{
		stepstatus = basepage.setText(AddressStreet1, StrAddress1);
		reportEvent(stepstatus, "Able to enter Address1", "UnAble to enter Address1", driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_street2']")
	WebElement AddressStreet2;
	public void setAddressStreet2(String StrAddress2)
	{
		stepstatus = basepage.setText(AddressStreet2, StrAddress2);
		reportEvent(stepstatus, "Able to enter Address2", "UnAble to enter Address2", driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_city']")
	WebElement City;
	public void setContactCity(String StrCity)
	{
		stepstatus = basepage.setText(City, StrCity);
		reportEvent(stepstatus, "Able to enter City Name", "UnAble to enter City Name", driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_province']")
	WebElement StateOrProvince;
	public void setStateOrProvince(String StrState)
	{
		stepstatus = basepage.setText(StateOrProvince, StrState);
		reportEvent(stepstatus, "Able to enter State Name", "UnAble to enter State Name", driver);
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_emp_zipcode']")
	WebElement ZipCode;
	public void setZipCode(String StrZipCode)
	{
		stepstatus = basepage.setText(ZipCode, StrZipCode);
		reportEvent(stepstatus, "Able to enter ZipCode", "UnAble to enter ZipCode", driver);
	}
	
	
	public WebElement getCountry(String StrCountryName)
	{
		return driver.findElement(By.xpath(String.format("//select[@name='contact[country]']/option[text()='%s']", StrCountryName)));
	}
	public void selectCountry(String StrCountryName)
	{
		stepstatus = basepage.clickElement(getCountry(StrCountryName));
		reportEvent(stepstatus, "Able to select country", "Unable to select country",driver);
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_emp_hm_telephone']")
	WebElement HomeTelephone;
	public void setHomeTelephone(String StrHomeTelephone)
	{
		stepstatus = basepage.setText(HomeTelephone, StrHomeTelephone);
		reportEvent(stepstatus, "Able to enter HomeTelephone", "UnAble to enter HomeTelephone", driver);
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_emp_mobile']")
	WebElement Mobile;
	public void setMobile(String StrMobile)
	{
		stepstatus = basepage.setText(Mobile, StrMobile);
		reportEvent(stepstatus, "Able to enter Mobile", "UnAble to enter Mobile", driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_emp_work_telephone']")
	WebElement WorkTelephone;
	public void setWorkTelephone(String StrWorkTelephone)
	{
		stepstatus = basepage.setText(WorkTelephone, StrWorkTelephone);
		reportEvent(stepstatus, "Able to enter WorkTelephone", "UnAble to enter WorkTelephone", driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_emp_work_email']")
	WebElement WorkEmail;
	public void setWorkEmail(String StrWorkEmail)
	{
		stepstatus = basepage.setText(WorkEmail, StrWorkEmail);
		reportEvent(stepstatus, "Able to enter WorkEmail", "UnAble to enter WorkEmail", driver);
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@id='contact_emp_oth_email']")
	WebElement OtherEmail;
	public void setOtherEmail(String StrOtherEmail)
	{
		stepstatus = basepage.setText(OtherEmail, StrOtherEmail);
		reportEvent(stepstatus, "Able to enter OtherEmail", "UnAble to enter OtherEmail", driver);
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@value='Save']")
	WebElement Save;
	public void clickOnSave()
	{
		stepstatus = basepage.clickElement(Save);
		reportEvent(stepstatus, "Able to click On Save", "UnAble to click On Save", driver);
	}
}
