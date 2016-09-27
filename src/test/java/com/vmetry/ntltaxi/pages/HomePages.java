package com.vmetry.ntltaxi.pages;

import org.openqa.selenium.WebDriver;

import com.vmetry.ntltaxi.initializer.initializer;
import com.vmetry.ntltaxi.initializer.webdriverFunctions;

public class HomePages extends initializer {

	public static void enterusername(String Username)
	{
		getWebelementByxpath("HOMEPAGE_USERNAME_TYPE_XPATH").sendKeys(Username);
	}

	public static void enterPick(String Pick)
	{
		getWebelementByxpath("HOMEPAGE_STARTINGPOINT_XPATH").sendKeys(Pick);
	}
	public static void enterDest(String Dest)
	{
		getWebelementByxpath("HOMEPAGE_DESTINATION_XPATH").sendKeys(Dest);
	}
	
	public static void enterMobnumber(String Mobumber)
	{
		getWebelementByxpath("HOMEPAGE_MOBNUMBER_TYPE_XPATH").sendKeys(Mobumber);
	}
	
	public static void entercla(String cla)
	{
	//	getWebelementByxpath("HOMEPAGE_CLASSS_XPATH").sendKeys(cla);
		
		webdriverFunctions.selectDropDown("HOMEPAGE_CLASSS_XPATH", cla);
		
	}
	
	public static void enterbooklater()
	{
		getWebelementByxpath("HOMEPAGE_BUTTON_XPATH").click();
	}
	
	




}
