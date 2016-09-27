package com.vmetry.ntltaxi.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class initializer {
// global variable
	
	public static FileInputStream envfis=null;
	public static Properties envprop = null;
	public static WebDriver wd=null;
	public static FileInputStream locfis=null;
	public static Properties locprop = null;
	//public static WebDriver wd=null;
	public static ExtentReports report;
	public static ExtentTest log;
	
	
	
	
	public static void initialize() throws IOException{
		
		//FileInputStream envfis= new FileInputStream(new File("E:\\SeleniumWorkspace\\DDTTest\\src\\test\\java\\com\\vmetry\\ntltaxi\\config\\env.properties"));
		//FileInputStream 
		envfis= new FileInputStream(new File("E:"+File.separator+"SeleniumWorkspace"+File.separator+"DDTTest"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"env.properties"));
		//Properties 
		envprop =new Properties();
	    envprop.load(envfis);
	    report=new ExtentReports("E:\\SeleniumWorkspace\\DDTTest\reportee\\sam.html");
	
	    locfis= new FileInputStream(new File("E:"+File.separator+"SeleniumWorkspace"+File.separator+"DDTTest"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"locator.properties"));
		//Properties 
		locprop =new Properties();
	    locprop.load(locfis);
	    
	    
	    System.out.println(envprop.getProperty("Browser"));
			       
	if(envprop.getProperty("Browser").equals("Firefox")){
		//WebDriver
		
		wd = new FirefoxDriver();
	}
	else if 
	(envprop.getProperty("Browser").equals("Chrome")){
	wd = new ChromeDriver();
	
	}
	wd.manage().window().maximize();
	wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	wd.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	
	
	
	
	}
	public static WebElement getWebelementByxpath(String xpath)
	{
		return wd.findElement(By.xpath(locprop.getProperty(xpath)));
		
		
	}

	
	
	
	
	
	}
	
		
	


// paste this command on pom.xml


//<dependencies>
//<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
//<dependency>
//    <groupId>org.seleniumhq.selenium</groupId>
//    <artifactId>selenium-java</artifactId>
//    <version>2.53.1</version>
//</dependency>
//</dependencies>



