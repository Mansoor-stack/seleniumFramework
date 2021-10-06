package edu.framework.Factory.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("C:\\Users\\MANSOOR...KHAN\\eclipse-workspace\\SeleniumFrameWork\\src\\test\\resources\\TestData\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("FormData");
		int rowcount = sheet.getPhysicalNumberOfRows();
		int colcount = sheet.getRow(0).getLastCellNum();
		String [][] data = new String[rowcount][colcount];
		for (int row = 1; row < rowcount; row++) {

			XSSFRow currentRow = sheet.getRow(row);

			for (int col = 0; col < colcount; col++) {

				String cell_Value = currentRow.getCell(col).toString();
				
//				String FirstName = currentRow.getCell(col=0).toString();
//				String LastName = currentRow.getCell(col=1).toString();
//				String Address1 = currentRow.getCell(col=2).toString();
//				String Address2 = currentRow.getCell(col=3).toString();
//				String city = currentRow.getCell(col=4).toString();
//                System.out.printf(FirstName+" "+LastName+" "+Address1+" " +Address2+" "+city);
				data[row-1][col] = cell_Value;

			}
			System.out.println();
		}
	}

}
