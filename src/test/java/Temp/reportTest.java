package Temp;

import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.Destination;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class reportTest {

	
	static WebDriver wd = null;
	ExtentReports report;
	ExtentTest log;
	
	@Test(priority=1)
	public void googleTest()
	{
		
		report=new ExtentReports("E:\\SeleniumWorkspace\\DDTTest\\reportee\\sam.html");
		report.startTest("Google Test");
		wd= new FirefoxDriver();
				wd.get("http://google.com");
				log=report.startTest("googletest");
		
	}
	@Test(priority=2)
	public void bingTest()
	{
		wd= new FirefoxDriver();
				wd.get("http://bing.com");
				report.startTest("Bing Test");
				log=report.startTest("Bingtest");
	}
	
	@Test(priority=3)
	public void yahooTest()
	{
		wd= new FirefoxDriver();
		wd.get("http://yahoo.com");
		report.startTest("Yahoo Test");
		log=report.startTest("Yahootest");
			}
	@AfterMethod
	public void tearDown(ITestResult it) throws IOException
	{
		if(it.isSuccess())
		{
			
			String path = takescreenshot(it.getName());
			log.addScreenCapture(path);
			log.log(LogStatus.PASS, "Testcase Pass",path );
		}
		else
		{
			String path = takescreenshot(it.getName());
			log.addScreenCapture(path);
			log.log(LogStatus.FAIL, "Testcase Fail",path );
		}
		report.endTest(log);
		report.flush();
	}
	public static  String takescreenshot(String name) throws IOException
	{
		File src = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
			File Dest = new File("E:\\SeleniumWorkspace\\DDTTest\\Screenshot\\"+name+".jpg");	
		FileUtils.copyFile(src,Dest);
				return Dest.toString();
	}
	
	
	
}
