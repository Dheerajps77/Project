package com.RoughWork;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataOfParticularTestCaseFromExcel {

	@SuppressWarnings("resource")
	public static Workbook getWorkBookInstance(String path) throws Exception {
		File file;
		FileInputStream fis;
		Workbook wb;
		try {
			file = new File(path);
			fis = new FileInputStream(file);
			if (path.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(fis);
			} else {
				wb = new HSSFWorkbook(fis);
			}
		} catch (Exception e) {
			throw e;
		}
		return wb;
	}

	public static ArrayList<String> readDataOfParticularTestCase(String path, String sheetName, String tcNameFromExcel)
			throws Exception {
		Workbook wb;
		Sheet sheet;
		Row row;
		ArrayList<String> arrayList=new ArrayList<>();
		try {
			wb = getWorkBookInstance(path);
			sheet = wb.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				row = sheet.getRow(i);
				String tcName = sheet.getRow(i).getCell(0).getStringCellValue();
				int cellCount = row.getLastCellNum();

				if (tcName.equalsIgnoreCase(tcNameFromExcel)) {
					for (int j = 0; j < cellCount-1; j++) {
						
						String value = row.getCell(j + 1).getStringCellValue();
						arrayList.add(value);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "/Test Data/TestDataExcelSheet.xlsx";
		String sheetName = "ReadData";
		String tcName = "TC_2";
		ArrayList<String> arryList;
		try {
			arryList=readDataOfParticularTestCase(path, sheetName, tcName);
			
			for(int i=0;i<arryList.size();i++)
			{
				System.out.println(arryList.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
