package com.RoughWork;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenWithApachePOI {

	static Workbook wb;
	static Sheet sheet;
	static Cell cell;
	static int rowCount;
	static int cellCount;
	static Row row;
	public static Workbook getWorkBook() throws Exception {
		Workbook wb;

		try {
			String filePath = System.getProperty("user.dir") + "/Test Data/TestData.xlsx";
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			if (filePath.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(fis);
			} else {
				wb = new HSSFWorkbook(fis);
			}

		} catch (Exception e) {
			throw e;
		}
		return wb;
	}

	public static void readDataOnlyWithoutColumn(String sheetName) throws Exception {
		try {			
			wb = getWorkBook();
			sheet = wb.getSheet(sheetName);
			rowCount = sheet.getLastRowNum();

			for (int i = 1; i < rowCount; i++) {
				row = sheet.getRow(i);
				cellCount = row.getLastCellNum();

				for (int j = 0; j <= cellCount - 1; j++) {
					cell = row.getCell(j);
					CellType type = cell.getCellTypeEnum();
					if (type == CellType.BLANK) {
						System.out.println("[" + cell.getRowIndex() + " " + cell.getColumnIndex() + "]=BLANK CELL");
					} else if (type == CellType.STRING) {
						System.out.println("[" + cell.getRowIndex() + " " + cell.getColumnIndex()
								+ "]=STRING; Value is : " + cell.getRichStringCellValue().toString());
					} else if (type == CellType.NUMERIC) {
						double d = cell.getNumericCellValue();
						String value = String.valueOf(d);
						String newValue = value.replace(".", "");
						System.out.println("[" + cell.getRowIndex() + " " + cell.getColumnIndex()
								+ "]=NUMBERIC; Value is :" + newValue);
					} else if (type == CellType.BOOLEAN) {
						System.out.println("[" + cell.getRowIndex() + " " + cell.getColumnIndex()
								+ "]=BOOLEAN; Value is :" + cell.getBooleanCellValue());
					}

				}
			}

		} catch (Exception e) {
			throw e;
		}
		/***
		 * Below are the OutPut:
		 * [1 0]=STRING; Value is : Dheeraj
		   [1 1]=STRING; Value is : Singh
		   [1 2]=STRING; Value is : New Delhi
		   [1 3]=NUMBERIC; Value is :23434343E7
		   [1 4]=STRING; Value is : kjdkasd@gmail.com
	       [1 5]=BOOLEAN; Value is :false
           [2 0]=STRING; Value is : Rahul 
           [2 1]=STRING; Value is : Singh
           [2 2]=STRING; Value is : New Delhi
           [2 3]=NUMBERIC; Value is :989893284E8
           [2 4]=STRING; Value is : nmcnckdjf@gmail.com
           [2 5]=BOOLEAN; Value is :true
           [3 0]=STRING; Value is : Mukesh
           [3 1]=STRING; Value is : Yadav
           [3 2]=STRING; Value is : Mumbai
           [3 3]=NUMBERIC; Value is :16287819E7
           [3 4]=STRING; Value is : jsdhasjds@gmail.com
           [3 5]=BOOLEAN; Value is :false
		 */
	}

	public static void readDataOnlyWithColumn(String sheetName) throws Exception {		
		try {
			Row row;
			wb = getWorkBook();
			sheet = wb.getSheet(sheetName);
			rowCount = sheet.getLastRowNum();

			for (int i = 0; i < rowCount; i++) {
				row = sheet.getRow(i);
				cellCount = row.getLastCellNum();

				for (int j = 0; j <= cellCount - 1; j++) {
					cell = row.getCell(j);
					CellType type = cell.getCellTypeEnum();
					if (type == CellType.BLANK) {
						System.out.println("=BLANK CELL");
					} else if (type == CellType.STRING) {
						System.out.print(cell.getRichStringCellValue().toString() + " | ");
					} else if (type == CellType.NUMERIC) {
						double d = cell.getNumericCellValue();
						String value = String.valueOf(d);
						String newValue = value.replace(".", "");
						System.out.print(newValue + " | ");
					} else if (type == CellType.BOOLEAN) {
						System.out.print(cell.getBooleanCellValue());
					}
				}
				System.out.println();
			}

		} catch (Exception e) {
			throw e;
		}

		/***
		 * Below are the Output FirstName | LastName | Address | Contact Number
		 * | Email Id | Leaving Status | Dheeraj | Singh | New Delhi |
		 * 23434343E7 | kjdkasd@gmail.com | false Rahul | Singh | New Delhi |
		 * 989893284E8 | nmcnckdjf@gmail.com | true Mukesh | Yadav | Mumbai |
		 * 16287819E7 | jsdhasjds@gmail.com | false
		 * 
		 */
	}
	
	public static Map<String, String> getExcelValuesAndStoreInMap(String sheetName) throws Exception
	{
		String key;
		String value;
		wb = getWorkBook();
		sheet = wb.getSheet(sheetName);
		rowCount = sheet.getLastRowNum();		
		Map<String, String> map;
		try {
			map=new HashMap<String, String>();
			
			for(int i=0;i<=rowCount;i++)
			{
				row=sheet.getRow(i);
				Cell keyCell=row.getCell(0);
				Cell keyValue=row.getCell(1);
				key=keyCell.getStringCellValue();
					value=keyValue.getStringCellValue();
					map.put(key, value);
					System.out.println(key + " " +value);
				
			}
		} catch (Exception e) {
			throw e;
		}
		return map;
	}
	

	public static void main(String[] args) throws Exception {

		//DataDrivenWithApachePOI.readDataOnlyWithoutColumn("Sheet1");
		DataDrivenWithApachePOI.getExcelValuesAndStoreInMap("Sheet2");
	}

}
