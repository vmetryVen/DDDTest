package com.vmetry.ntltaxi.initializer;

import org.openqa.selenium.support.ui.Select;

public class webdriverFunctions extends initializer{
	
	public static void selectDropDown(String xpath, String option)
	{
		
		Select S = new Select(getWebelementByxpath(xpath));
		S.selectByVisibleText(option);
		
		
	}
	
	

}
