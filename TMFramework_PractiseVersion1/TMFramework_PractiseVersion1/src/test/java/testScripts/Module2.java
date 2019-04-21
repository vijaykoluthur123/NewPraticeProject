package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import applicationPages.Pg101_LoginPage;
import applicationPages.Pg102_HomePage;
import applicationPages.Pg104_EmergencyContacts;
import frameworkLibrary.BaseClass;

public class Module2 extends BaseClass
{
	@Test
	public void TC201()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.testingmasters.com/hrm");
		
		Pg101_LoginPage loginpage = new Pg101_LoginPage(driver);
		loginpage.setUsername("ankit3");
		loginpage.setPassword("abcd1234");
		loginpage.clickOnLogin();

		Pg102_HomePage homepage = new Pg102_HomePage(driver);
		homepage.clickOnMyInfo();
		homepage.clickOnEmergencyContacts();
		
		Pg104_EmergencyContacts emergencycontacts = new Pg104_EmergencyContacts(driver);
		emergencycontacts.clickOnAdd();
		emergencycontacts.setName("Avinash");
		emergencycontacts.setRelationship("Child");
		emergencycontacts.setHomeTelephone("9863247966");
		emergencycontacts.setMobile("9863201188");
		emergencycontacts.setWorkTelephone("040-63592368");
		emergencycontacts.clickOnSave();
	
		homepage.Logout();

		driver.quit();
	}
}
