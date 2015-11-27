package com.SEO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SEO.SEOgenaric;

public class SEOcommonFunction {
	private static final String FILE_PATH = "C:\\QA\\SEOChecks.xlsx";
	
	    //We are making use of a single instance to prevent multiple write access to same file.

		protected static final SEOcommonFunction INSTANCE = new SEOcommonFunction();
	    public static SEOcommonFunction getInstance() {
	        return INSTANCE;
	    }

	    protected SEOcommonFunction() {
		
	    }

/*	    public static void main(String args[]){
	   	        Map<String, String > studentList = new HashMap<String, String>();
	    	        studentList.put("Magneto","90");
	    	        studentList.put("Wolverine","60");
	    	        studentList.put("ProfX","100");
	    	        writeStudentsListToExcel( studentList);
	    	    }
	    	*/
	    public static Map<Integer, Object[]> writeListToExcel(Map<Integer, Object[]> Results){
	    	        // Using XSSF for xlsx format, for xls use HSSF
	    	        Workbook workbook = new XSSFWorkbook();
	    	        Sheet allList = workbook.createSheet("SEOCheck");
	    	    	Set<Integer> keyset = Results.keySet();
	    	        int rowIndex = 0;
	    	        for(Integer key : keyset){
	    	            Row row = allList.createRow(rowIndex++);
	    	            Object[] objArr= Results.get(key);
	    	            
	    	            int cellIndex = 0;
	    	            for (Object obj: objArr)
	    	            {
	    	                Cell cell = row.createCell(cellIndex++);
	    	                	cell.setCellValue((String)obj);
	    	               /* if(Cell instanceof String)
	    	                     cell.setCellValue((String)Cell);
	    	                	 cell = row.createCell(cellIndex++);
	    	                	 cell.setCellValue(stud);
	    	                 else if(Cell instanceof Integer)
	    	                     cell.setCellValue((Integer)Cell);
	    	                	 System.out.println("####");*/
	    	                	 
	    	            }
	    	        }
	    	        //    
	    	            //write this workbook in excel file.
	    	          try {
	    	                FileOutputStream fos = new FileOutputStream(FILE_PATH);
	    	                 workbook.write(fos);
	    	                 fos.close();
	    	                 System.out.println(FILE_PATH + " is successfully written");
	    	               } catch (FileNotFoundException e) {
	    	                        e.printStackTrace();
	    	               } catch (IOException e) {
	    	                      e.printStackTrace();
	    	               }
	    	              
					return Results;
			}
	   
    
}
