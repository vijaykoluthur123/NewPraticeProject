package frameworkLibrary;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import applicationPages.HRMBasePage;

public class BaseClass extends HRMBasePage
{
	@BeforeSuite
	public void beforesuite()
	{
		CreateNewExtentReportInResultsFolderWithDateAndTimeStamp();
	}
	
	@BeforeClass
	public void BeforeClass()
	{
		String ClassName = this.getClass().getSimpleName();
		FrameworkVariables.getInstance().setCurrentModuleName(ClassName);
		CreateNewExtentTestForClass();
		FrameworkVariables.getInstance().setCurrentTestData();
		loadDataFromExceltoHashMapBeforeClass();
	}
	
	@BeforeMethod
	public void beforemethod(Method currentmethod)
	{
		FrameworkVariables.getInstance().setCurrentTestCaseName(currentmethod.getName());
		
		FrameworkVariables.getInstance().setDataFilesPath(FrameworkVariables.getInstance().getCurrentFolderPath() + "\\DataFiles");
		
		FrameworkVariables.getInstance().setCurrentTestData();
		loadDataFromExceltoHashMap();
		
		startExtentTestForCurrentTestCase();
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result)
	{
		endExtentTestForCurrentTestCase();
		loadDataFromHashMaptoExcel();
	}
	
	@AfterClass
	public void AfterClass()
	{
		EndExtentTestForClass();
	}
	
	
	@AfterSuite
	public void aftersuite()
	{
		closeExtentReport();
		launchResult();
	}
}
