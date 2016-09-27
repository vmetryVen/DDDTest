package com.vmetry.ntltaxi.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.ntltaxi.initializer.initializer;
import com.vmetry.ntltaxi.pages.HomePages;
import com.vmetry.ntltaxi.utils.screenshotGenerator;

public class HomePageTest extends initializer {

	@BeforeTest
	public void setup() throws IOException {
		initialize();
	}

	@Test(dataProvider = "HomePageTest")
	public void validateHomepage(String testdata, String Username, String mobnumber, String Pick, String Dest,
			String cla) throws IOException {
		// initialize(); // it will open browser
		// initializer();
		wd.get(envprop.getProperty("URL"));

		// wd.findElement(By.xpath("HOMEPAGE_USERNAME_TYPE_XPATH")).sendKeys("Vmetry");
log= report.startTest(testdata);
		HomePages.enterusername(Username);
		HomePages.entercla(cla);
		HomePages.enterMobnumber(mobnumber);
		HomePages.enterDest(Dest);
		HomePages.enterPick(Pick);
		HomePages.enterbooklater();

		// wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[2]")).sendKeys(username);
		// //wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[2]")).sendKeys(username);
		// //wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[3]")).sendKeys(mobnumber);
		// wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[3]")).sendKeys(mobnumber);
		// wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[6]")).sendKeys(Destination);
		// wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/select")).sendKeys(cla);
		// wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[7]")).click();
		// wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[3]")).sendKeys(startingpoint);
		//
		//
		//

	}

	@DataProvider(name = "HomePageTest")
	public static Object[][] getHomePageData() {
		Object[][] data = new Object[3][6];

		data[0][0] = "HomePageTest_Dataset1";

		data[0][1] = "testA";
		data[0][2] = "1234567";
		data[0][3] = "ADYAR";
		data[0][4] = "ADYAR";
		data[0][5] = "Sedan";

		data[1][0] = "HomePageTest_Dataset2";

		data[1][1] = "testB";
		data[1][2] = "1234567";
		data[1][3] = "ADYAR";
		data[1][4] = "ADYAR";
		data[1][5] = "Sedan";

		data[2][0] = "HomePageTest_Dataset3";

		data[2][1] = "testC";
		data[2][2] = "1234567";
		data[2][3] = "ADYAR";
		data[2][4] = "ADYAR";
		data[2][5] = "Sedan";

		return data;
	}

	@AfterMethod
	public void tearDown(ITestResult it) throws IOException {
		screenshotGenerator.generateScreenshot(it);
	}
}
