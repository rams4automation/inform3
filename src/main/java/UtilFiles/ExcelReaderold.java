package UtilFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderold {
	
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    
    String filePath="C:\\Users\\E004373\\Desktop\\Selenium_Questions\\Estimations_Selenium.xlsx";
    String fileName="";
    String sheetName="";
    
    //String filePath,String fileName,String sheetName
    
	 public String readExcel() throws IOException {

		 //Create an object of File class to open xlsx file

		   // File file = new File(filePath);

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream finput = new FileInputStream("C:\\Users\\E004373\\Desktop\\Selenium_Questions\\Estimations_Selenium.xlsx");

		    ExcelWBook = new XSSFWorkbook(finput);
		    
		    ExcelWSheet = ExcelWBook.getSheet(sheetName);
		 
		    int rowCount = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
		   
		    //Create a loop over all the rows of excel file to read it
		    
		    for(int i=0;i<rowCount;i++){
		    	Row =ExcelWSheet.getRow(i);
		  		    
		    //Create a loop to print cell values in a row
		    
            for (int j = 0; j < Row.getLastCellNum(); j++) {
            	
            	Cell=Row.getCell(j);
            	
            	String value = Cell.getStringCellValue();
            	
                //Print excel data in console
                System.out.print(value);
                
                 return value;
                
            }
            
            System.out.println();

	     }
			
			return "row  or column does not exist  in xls";
			
	 }
		 
		 
}

	 
	 