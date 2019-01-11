package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP {
	@DataProvider(name = "getdata")
	public String[][] GetData() throws IOException {
		String[][] TestData;
		FileInputStream fis = new FileInputStream("./TestData/TC001.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int RowCount = sheet.getLastRowNum();
		int CellCount = sheet.getRow(0).getLastCellNum();
		TestData = new String[RowCount][CellCount];
		for (int i = 1; i <= RowCount; i++) {
			XSSFRow Row = sheet.getRow(i);
			for (int j = 0; j < CellCount; j++) {
				String CellsData = Row.getCell(j).getStringCellValue();
				TestData[i - 1][j] = CellsData;
			}
		}
		wb.close();
		return TestData;
	}

}
