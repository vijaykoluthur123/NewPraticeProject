package frameworkLibrary;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ReportLibrary extends DataLibrary
{
		protected  void reportEvent(boolean stepstatus,String PassMessage, String FailMessage,WebDriver driver) 
		{
			if (stepstatus == true) 
			{
				System.out.println("		<<PASS>> " + PassMessage);
				FrameworkVariables.getInstance().getExtentCurrentTest().log(LogStatus.PASS, PassMessage);
			} 
			else 
			{
				System.out.println("		<<FAIL>> " + FailMessage);
				System.out.println("");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Exception description  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				FrameworkVariables.getInstance().getExceptionDescription().printStackTrace();
				FrameworkVariables.getInstance().getExtentCurrentTest().log(LogStatus.FAIL, FailMessage + FrameworkVariables.getInstance().getExtentCurrentTest().addScreenCapture(getScreenshot(driver)));
			}
			//Hard assertion
			Assert.assertEquals(stepstatus, true);
			
			//soft assertion
//			SoftAssert sassert= new SoftAssert();
//			sassert.assertEquals(stepstatus, true);
			
		}
//		
//		protected  void reportEvent(boolean stepstatus,String PassMessage, String FailMessage,WebDriver driver,boolean takescrrenshot) 
//		{
//			if (stepstatus == true) 
//			{
//				System.out.println("		<<PASS>> " + PassMessage);
//				if (takescrrenshot==true) 
//				{
//					FrameworkVariables.getInstance().getExtentCurrentTest().log(LogStatus.PASS, PassMessage + FrameworkVariables.getInstance().getExtentCurrentTest().addScreenCapture(getScreenshot(driver)));
//				} 
//				else 
//				{
//					FrameworkVariables.getInstance().getExtentCurrentTest().log(LogStatus.PASS, PassMessage);
//				}
//			} 
//			else 
//			{
//				System.out.println("		<<FAIL>> " + FailMessage);
//				System.out.println("");
//				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Exception description  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//				FrameworkVariables.getInstance().getExceptionDescription().printStackTrace();
//				if (takescrrenshot==true) 
//				{
//					FrameworkVariables.getInstance().getExtentCurrentTest().log(LogStatus.FAIL, FailMessage + FrameworkVariables.getInstance().getExtentCurrentTest().addScreenCapture(getScreenshot(driver)));
//				} 
//				else 
//				{
//					FrameworkVariables.getInstance().getExtentCurrentTest().log(LogStatus.FAIL, FailMessage);
//				}
//			}
////			Hard assertion
//			Assert.assertEquals(stepstatus, true);
//			
//			//soft assertion
////			SoftAssert sassert= new SoftAssert();
////			sassert.assertEquals(stepstatus, true);
//		}
			public  void CreateNewExtentReportInResultsFolderWithDateAndTimeStamp()
			{
				// get current folder path
				FrameworkVariables.getInstance().setCurrentFolderPath(System.getProperty("user.dir"));

				// create folder with date and time stamp
				DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
				String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
				DateTimeStamp = DateTimeStamp.replace(",", "");
				DateTimeStamp = DateTimeStamp.replace(" ", "_");
				DateTimeStamp = DateTimeStamp.replace(":", "-");
				FrameworkVariables.getInstance().setCurrentResultPath(FrameworkVariables.getInstance().getCurrentFolderPath() + "\\Results\\" + DateTimeStamp);
				File dir = new File(FrameworkVariables.getInstance().getCurrentResultPath());
				dir.mkdir();
				
				//create folder with name as Scrrenshots
				File dir1 = new File(FrameworkVariables.getInstance().getCurrentResultPath() + "\\Screenshots");
				dir1.mkdir();

				// create extent report
				FrameworkVariables.getInstance().setExtentReports(new ExtentReports(FrameworkVariables.getInstance().getCurrentResultPath() + "\\Summary.html", true));
			}
			
			public void CreateNewExtentTestForClass()
			{
				FrameworkVariables.getInstance().setExtentClassTest(FrameworkVariables.getInstance().getExtentReports().startTest(FrameworkVariables.getInstance().getCurrentModuleName()));
				System.out.println("<<ClassStart>>" + FrameworkVariables.getInstance().getCurrentModuleName());
			}
			public void EndExtentTestForClass()
			{
				FrameworkVariables.getInstance().getExtentReports().endTest(FrameworkVariables.getInstance().getExtentClassTest());
				System.out.println("<<ClassEnd>>" + FrameworkVariables.getInstance().getCurrentModuleName());
			}
			
			public void CreateExtentTestForBeforeClass()
			{
				FrameworkVariables.getInstance().setExtentBeforeClassTest(FrameworkVariables.getInstance().getExtentReports().startTest("BeforeClass"));
			}
			public void EndExtentTestForBeforeClass()
			{
				FrameworkVariables.getInstance().getExtentReports().endTest(FrameworkVariables.getInstance().getExtentBeforeClassTest());
				FrameworkVariables.getInstance().getExtentClassTest().appendChild(FrameworkVariables.getInstance().getExtentBeforeClassTest());
			}
			
			public void CreateExtentTestForAfterClass()
			{
				FrameworkVariables.getInstance().setExtentAfterClassTest(FrameworkVariables.getInstance().getExtentReports().startTest("AfterClass"));
			}
			public void EndExtentTestForAfterClass()
			{
				FrameworkVariables.getInstance().getExtentReports().endTest(FrameworkVariables.getInstance().getExtentAfterClassTest());
				FrameworkVariables.getInstance().getExtentClassTest().appendChild(FrameworkVariables.getInstance().getExtentAfterClassTest());
			}
			
			public  void startExtentTestForCurrentTestCase()
			{
				FrameworkVariables.getInstance().setExtentTest(FrameworkVariables.getInstance().getExtentReports().startTest(FrameworkVariables.getInstance().getCurrentTestCaseName()));
				System.out.println("	<<TestStart>>" + FrameworkVariables.getInstance().getCurrentTestCaseName());
			}
			
			public  void endExtentTestForCurrentTestCase()
			{
				FrameworkVariables.getInstance().getExtentReports().endTest(FrameworkVariables.getInstance().getExtentTest());
				System.out.println("	<<TestCompleted>>" + FrameworkVariables.getInstance().getCurrentTestCaseName());
				FrameworkVariables.getInstance().getExtentClassTest().appendChild(FrameworkVariables.getInstance().getExtentTest());
				
			}
			
			public  void closeExtentReport()
			{
				FrameworkVariables.getInstance().getExtentReports().close();
			}
			
			public  void launchResult()
			{
				WebDriver driver = new ChromeDriver();
				driver.get(FrameworkVariables.getInstance().getCurrentResultPath()+ "//Summary.html");
			}

			public  String  getScreenshot(WebDriver driver)
			{
				String Dest = FrameworkVariables.getInstance().getCurrentResultPath() + "\\Screenshots\\";
				try 
				{
					DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
					String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
					DateTimeStamp = DateTimeStamp.replace(",", "");
					DateTimeStamp = DateTimeStamp.replace(" ", "_");
					DateTimeStamp = DateTimeStamp.replace(":", "-");

					Dest = Dest + FrameworkVariables.getInstance().getCurrentTestCaseName() + DateTimeStamp + ".png";

					TakesScreenshot ts = (TakesScreenshot) driver;
					File source = ts.getScreenshotAs(OutputType.FILE);
					File destinationfile = new File(Dest);
					FileUtils.copyFile(source, destinationfile);

					// Get entire page screenshot
					File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					ImageIO.write(ImageIO.read(screenshot), "png", screenshot);

					// Copy the element screenshot to disk
					FileUtils.copyFile(screenshot, new File(Dest));
				} 
				catch (Exception e) 
				{
					System.out.println("Exception occured while taking Scrrenshot");
				}
				return Dest;
			}
			
}
