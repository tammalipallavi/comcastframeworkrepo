package com.comcast.crm.generic.fileutility1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/*read data from excel*/
public class ExcelUtility {
	public String getDataFromExcel(String SheetName,int rowNum,int celNum)throws Throwable{
		FileInputStream fis=new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(SheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
		
	}
	/*get row count*/
	public int getRowCount(String SheetName) throws Throwable{
		FileInputStream fis=new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount =wb.getSheet(SheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}
		
	public void setDataIntoExcel(String SheetName,int rowNum,int celNum,String data) throws IOException {
		FileInputStream fis=new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(SheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fos=new FileOutputStream("./testdata/testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
		
	}
		
	}
	
	
	


