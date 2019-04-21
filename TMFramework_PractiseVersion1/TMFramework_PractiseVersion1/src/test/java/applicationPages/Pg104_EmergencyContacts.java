package applicationPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Pg104_EmergencyContacts extends HRMBasePage
{
	HRMBasePage basepage = new HRMBasePage();
	
	WebDriver driver;
	boolean stepstatus;
	
	public Pg104_EmergencyContacts(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(how=How.XPATH,using="//input[@value='Add']")
	WebElement Add;
	public void clickOnAdd()
	{
		stepstatus = basepage.clickElement(Add);
		reportEvent(stepstatus, "Able to click on Add", "Unable to click on Add",driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='emgcontacts_name']")
	WebElement Name;
	public void setName(String strName)
	{
		stepstatus = basepage.setText(Name,strName);
		reportEvent(stepstatus, "Able to set Name", "Unable to set Name",driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='emgcontacts_relationship']")
	WebElement Relationship;
	public void setRelationship(String strRelationship)
	{
		stepstatus = basepage.setText(Relationship,strRelationship);
		reportEvent(stepstatus, "Able to set Relationship", "Unable to set Relationship",driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='emgcontacts_homePhone']")
	WebElement HomeTelephone;
	public void setHomeTelephone(String strHomeTelephone)
	{
		stepstatus = basepage.setText(HomeTelephone,strHomeTelephone);
		reportEvent(stepstatus, "Able to set HomeTelephone", "Unable to set HomeTelephone",driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='emgcontacts_mobilePhone']")
	WebElement Mobile;
	public void setMobile(String strMobile)
	{
		stepstatus = basepage.setText(Mobile,strMobile);
		reportEvent(stepstatus, "Able to set Mobile", "Unable to set Mobile",driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='emgcontacts_workPhone']")
	WebElement WorkTelephone;
	public void setWorkTelephone(String strWorkTelephone)
	{
		stepstatus = basepage.setText(WorkTelephone,strWorkTelephone);
		reportEvent(stepstatus, "Able to set WorkTelephone", "Unable to set WorkTelephone",driver);
	}
	
	
	
	public WebElement getCheckboxeBasedOnName(String StrName)
	{
		return driver.findElement(By.xpath(String.format("//a[text()='%s']/../preceding-sibling::td[1]/input[@type='checkbox']", StrName)));
	}
	public void SelectCheckboxBasedOnName(String StrName)
	{
		stepstatus = basepage.clickElement(getCheckboxeBasedOnName(StrName));
		reportEvent(stepstatus, "Able to select checkbox based on name", "Unable to select checkbox based on name",driver);
	}
	
	
	public List<WebElement> getCheckboxeBasedOnRelationship(String StrRelationship)
	{
		return driver.findElements(By.xpath(String.format("//td[text()='%s']/preceding-sibling::td[2]/input[@type='checkbox']", StrRelationship)));
	}
	public void SelectCheckboxBasedOnRelationship(String StrRelationship)
	{
		stepstatus = basepage.clickElements(getCheckboxeBasedOnRelationship(StrRelationship));
		reportEvent(stepstatus, "Able to select checkbox based on name", "Unable to select checkbox based on name",driver);
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@value='Save']")
	WebElement Save;
	public void clickOnSave()
	{
		stepstatus = basepage.clickElement(Save);
		reportEvent(stepstatus, "Able to click on Save", "Unable to click on Save",driver);
	}
	
	@FindBy(how=How.XPATH,using="//input[@value='Delete']")
	WebElement Delete;
	public void clickOnDelete()
	{
		stepstatus = basepage.clickElement(Delete);
		reportEvent(stepstatus, "Able to click on Delete", "Unable to click on Delete",driver);
	}
}
