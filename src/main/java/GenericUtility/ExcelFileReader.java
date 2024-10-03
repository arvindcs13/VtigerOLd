package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileReader {

	/*
	 * Program to read data from Excel file
	 * public static void String ExcelDataRead(String sheet, int row, int col)
	 */
	 public  String ExcelDataRead(String sheet, int row, int col) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Vijay\\naya-workspace\\vtigercrm\\src\\main\\resources\\exceldata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(sh.getRow(row).getCell(col));
		return data;
	}  
}
