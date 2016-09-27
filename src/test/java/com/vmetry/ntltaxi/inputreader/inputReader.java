package com.vmetry.ntltaxi.inputreader;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class inputReader {

	public static Object [][] data;
	
	public static boolean RunModeVerification(String TestCaseName) throws Exception
	{
		XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File ("/Users/vinothkumar/Documents/SeleniumWorkspace/web/smita/DDFramework/src/main/java/com/vmetry/ntltaxi/inputreader/inputcontroller.xlsx")));
		XSSFSheet TcSheetHome=workbook.getSheet("Home");
		int TcrowHome=TcSheetHome.getLastRowNum();
		for (int k=1;k<=TcrowHome;k++)
		{
			String RunMode=TcSheetHome.getRow(k).getCell(2).getStringCellValue();
			String TCNameHome=TcSheetHome.getRow(k).getCell(0).getStringCellValue();
			if(RunMode.equals("Y") & TCNameHome.equals(TestCaseName))
			{
				return true;
			} 
		}                                                                                                                                              
		return false;
		
	}
	
	
	
	/**
	*   Runmode data search for single data or multiple data
	*
	*/
		public static Object[][] selectSingleDataOrMulitiData(String TestCaseName) throws Exception
		{
			
			XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File ("/Users/vinothkumar/Documents/SeleniumWorkspace/web/smita/DDFramework/src/main/java/com/vmetry/ntltaxi/inputreader/inputcontroller.xlsx")));
			XSSFSheet TcSheetHome=workbook.getSheet("Home");
			int TcrowHome=TcSheetHome.getLastRowNum();
			
			for (int k=1;k<=TcrowHome;k++)
			{
				String TCNameHome=TcSheetHome.getRow(k).getCell(0).getStringCellValue();
				if(TCNameHome.equals(TestCaseName))
				{	
				String RunForData=TcSheetHome.getRow(k).getCell(3).getStringCellValue();
				if(RunForData.equals("Y"))
				{
					collectMultiData(TestCaseName);
					break;
				} else  
				{
					collectSingleData(TestCaseName);
					break;
				}
				}
			}
			return data;
		}
		
		/**
		 * *searching data sing run calls your single data set
		 * @param TestCaseName
		 * @return
		 * @throws Exception
		 * 
		 */
		public static Object[][] collectSingleData(String TestCaseName) throws Exception
		{
			XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File ("/Users/vinothkumar/Documents/SeleniumWorkspace/web/smita/DDFramework/src/main/java/com/vmetry/ntltaxi/inputreader/inputcontroller.xlsx")));
			XSSFSheet TcSheet=workbook.getSheet(TestCaseName);
			int TcRow=TcSheet.getLastRowNum();
			data=new Object[1][TcRow+1];
			for (int i=0;i<=TcRow;i++)
			{
				Cell Cell=TcSheet.getRow(i).getCell(5);
				TcSheet.getRow(i).getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				data[0][i]=TcSheet.getRow(i).getCell(5).getStringCellValue();
			}
			return data;
		}
		
		/**
		 * *Searching data for multiple data set
		 * @param TestCaseName
		 * @return
		 * @throws FileNotFoundException
		 * @throws IOException
		 * 
		 */
		
		public static Object[][] collectMultiData(String TestCaseName) throws FileNotFoundException, IOException
		{
			System.err.println("i am entered run for data");
			XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File ("/Users/vinothkumar/Documents/SeleniumWorkspace/web/smita/DDFramework/src/main/java/com/vmetry/ntltaxi/inputreader/multiData.xlsx")));
			XSSFSheet TcSheet=workbook.getSheet(TestCaseName);
			int TcRow=TcSheet.getLastRowNum();
			int TcCol=TcSheet.getRow(1).getLastCellNum();
			data=new Object[TcCol][TcRow+1];
			for (int i=0;i<=TcRow;i++)
			{
				for (int j=0;j<TcCol;j++)
				{
				Cell Cell=TcSheet.getRow(i).getCell(j);
				TcSheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
				data[j][i]=TcSheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return data;
		}


}
