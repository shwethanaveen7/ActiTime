package com.actitime.generics;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is the the generic class for data driven testing
 * @author Shwetha J
 *
 */
public class FileLib {
/**
 * Reading the data from property file
 * @param key
 * @return value 
 * @throws IOException
 */
	public String getPropertyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	/**
	 * to read the data from the excel file
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return string value
	 * @throws EncryptedDocumentException 
	 * @throws IOException
	 */
	public String getExcelValue(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	/**
	 * @throws IOException 
	 * @throws EncryptedDocumentException Write data back to excel
	 * @param value
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @throws  
	 */
	public void setExcelValue(String value, String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(row).getCell(cell);
		FileOutputStream fos=new FileOutputStream("./data/testscript.xlsx");
		wb.write(fos);
		wb.close();
	}
}
