package UtilFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Utility to read Excel files. This file makes use of apache poi for reading excel files.
 * It supports both "xls" and "xlsx" file extension.
 *
 */
public class ExcelReaderNew  {
	private static Cell openCell;
	private static Row openRow;
	private static Sheet openSheet;
	private static Workbook openWorkbook;
	private static Map<String, List<String>> storedData = new LinkedHashMap<String, List<String>>();
	public static ResultSet resultset;
	protected static String TestDataPath=System.getProperty("user.dir").replace("\\", "/")+"/testdata/TestData.xlsx";
	protected static String testDriver=System.getProperty("user.dir").replace("\\", "/")+"/testdata/Test_Driver.xlsx";
	public static String TestDataSheetName="Data";
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;

	/******** :::::::: Code for Keyword Driven Framework:: Start ::::::: ******/
	public String filename = testDriver;
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;

	/******** :::::::: Code for Keyword Driven Framework:: end ::::::: ******/

	/**
	 * Creates a ExcelReader object based on filePath
	 * @param filePath File path of the file to be opened
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	// returns the data from a cell
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			if(rowNum <=0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if(index==-1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(colNum);
			if(cell==null)
				return "";

				return cell.getStringCellValue();
		}
		catch(Exception e){

			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}


}