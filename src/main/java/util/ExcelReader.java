package util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
//	​Global Variables
	public String path;
	public FileInputStream fis = null;	//the fileReader
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	//use XSSF if excel version is >2010
	//use HSSF if excel version is <2007
	
	// Constructor to initialize variables
	public ExcelReader(String path) {
		this.path = path;	//set the path in this class = the path being passed through
		try {
			fis = new FileInputStream(path);	//create a connection b/w the fis and file
												//read the file at this path
			workbook = new XSSFWorkbook(fis);	//create a connection b/w the workbook and fis
												//basically means the workbook of the file
			sheet = workbook.getSheetAt(0);		//the indexed sheet of this workbook
												//initialize the sheet variable I think
			fis.close();						//closes the fis just like any other fileReader like scanner
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to call the value
	public String getCellData(String sheetName, String colName, int rowNum) {
		//return as a String so any numerical values passed in the actual Excel sheet
		//will be considered an integer when read by fis. To get by this, make the value
		//a string by putting a letter at the beginning of it like "a"
		// For Sheet
		int index = workbook.getSheetIndex(sheetName);	//return the index of the given sheetName
		int col_Num = 0;								//initialize the col_Num variable
		sheet = workbook.getSheetAt(index);				//set sheet = the given sheetName

		// For Row
		row = sheet.getRow(0);							
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				col_Num = i;
			}	//iterate through the top row of cells and if that cell value = the given
				//colName then set the col_Num = to that indexed row#
				//this basically tells you which column# the specified colName is
		}

		// For Column
		row = sheet.getRow(rowNum - 1);		//set row = the specified rowNum - 1 for index
		cell = row.getCell(col_Num);		//set cell = at this row#
											//get the cell at this col_Num from above
		return cell.getStringCellValue();	//return the value of the given cell
	}
}
