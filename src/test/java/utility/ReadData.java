package utility;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	public static void main(String[] args) throws Exception {

		//FileInputStream inputStream = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\NewSetup\\com.test.coforge.CRM\\testData\\RegisterUser.xls");

		FileInputStream inputStream = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\NewSetup\\com.test.coforge.CRM\\testData\\RegistrationData.xlsx");
		// creating workbook instance that refers to .xls file
		//HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		// creating a Sheet object
		//HSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFSheet sheet = workbook.getSheet("Student");
		
		System.out.println("No. of Rows in Sheet for processing : "+ sheet.getLastRowNum());
	
		//System.out.println("No. of columns in Sheet for processing : "+ sheet.getFirstRowNum());
		String cellData = sheet.getRow(1).getCell(2).toString();
		System.out.println("Data in cell " + cellData);

	}

}
