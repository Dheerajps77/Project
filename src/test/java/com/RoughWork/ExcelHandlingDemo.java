package com.RoughWork;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.investaSolutions.base.TestBase;

public class ExcelHandlingDemo {// extends TestBase{

	static HashMap<String, String> hp = new HashMap<String, String>();
	static String pathOfExcel = System.getProperty("user.dir") + "/Test Data/TestDataExcelSheet.xlsx";
	static Workbook wb = null;

	public static Workbook getWorkBookInstance() throws Exception {
		File file = null;
		FileInputStream fis = null;
		try {
			file = new File(pathOfExcel);
			fis = new FileInputStream(file);
			if (pathOfExcel.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(fis);
			} else {
				wb = new HSSFWorkbook(fis);
			}
		} catch (Exception e) {
			throw e;
		}
		return wb;
	}

	public static void ExcelFileReaderOfTestData() throws Exception {
		Workbook workbook;
		Row row;
		try {
			workbook = getWorkBookInstance();
			Sheet sheet=workbook.getSheet("BankPortal");
			int rowCount=sheet.getPhysicalNumberOfRows();
			for(int i=1;i<rowCount;i++)
			{
				row=sheet.getRow(i);
				String tcName=row.getCell(0).getStringCellValue();
				
				if(tcName.equals("TC_1"))
				{
					int cellCount=row.getPhysicalNumberOfCells()-1;
					for(int j=0;j<cellCount;j=j+2)
					{
						String key=row.getCell(j).getStringCellValue();
						String value=row.getCell(j+1).getStringCellValue();
					}
				}
			}
		} catch (Exception e) {

			throw e;
		}
	}

	public static void testCollectionDemo() {
		try {
			/*
			 * String parentWindow=driver.getWindowHandle(); Set<String>
			 * windows=driver.getWindowHandles();
			 * 
			 * Iterator<String> iteratingWindow=windows.iterator();
			 * while(iteratingWindow.hasNext()) { String
			 * str=iteratingWindow.next(); if(!str.equals(parentWindow)) {
			 * driver.switchTo().window(str); } }
			 */

			ArrayList<String> arraylist = new ArrayList<String>();
			arraylist.add("Hello...");
			arraylist.add("Hi");
			arraylist.add("Name");

			Iterator<String> iteratingValue = arraylist.iterator();
			while (iteratingValue.hasNext()) {
				String str = iteratingValue.next();
				System.out.println(str);
			}

			HashMap<String, String> hp = new HashMap<String, String>();
			hp.put("C5000", "Session Timeout");
			hp.put("C5001", "Regiration failed");
			hp.put("C5002", "Login failed");
			hp.put("C5003", "Reset password failed");

			for (Map.Entry<String, String> hpm : hp.entrySet()) {
				String key = hpm.getKey();
				String value = hpm.getValue();
				System.out.println(key + ":" + value);

			}

		} catch (Exception e) {

			throw e;
		}
	}

	public static void main(String[] args) throws Exception {

		ExcelFileReaderOfTestData();
	}

}
