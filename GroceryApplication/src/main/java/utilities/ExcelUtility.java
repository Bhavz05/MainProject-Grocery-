package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
		static FileInputStream f;
		//to get details from the file
		static XSSFWorkbook wb;
		//to get details from workbook
		static XSSFSheet sh;
		//to get details from sheet
		
		public static String getStringData(int a,int b, String sheet) throws IOException
		{
			// row a& b cell values in excel 
			
				f=new FileInputStream("C:\\Users\\user\\git\\MainProject-Grocery-\\GroceryApplication\\src\\test\\resources\\GroceryTestData.xlsx");
				wb=new XSSFWorkbook(f);
				sh=wb.getSheet(sheet);// method used to access details from excel sheet
				XSSFRow r=sh.getRow(a);//XSSFRow - in built class to access details from the row, Getrow - method to get details from the row
				XSSFCell c=r.getCell(b);//XSSFCell - in built class to access details from the cell
				return c.getStringCellValue();//method to get the string value

		}
			public static String getIntegerData(int a,int b, String sheet) throws IOException
			{
				f=new FileInputStream("C:\\Users\\user\\git\\MainProject-Grocery-\\GroceryApplication\\src\\test\\resources\\GroceryTestData.xlsx");
				wb=new  XSSFWorkbook(f);
				sh=wb.getSheet(sheet);
				XSSFRow r=sh.getRow(a);
				XSSFCell c=r.getCell(b);
				int x=(int) c.getNumericCellValue();//get the numeric cell value to get the no's
			return String.valueOf(x);//valueOf --convert any datatype to string(type conversion)
				
			}

}
