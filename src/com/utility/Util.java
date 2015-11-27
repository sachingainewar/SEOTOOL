package com.utility;

import com.utility.Xls_Reader;

public class Util  {

	// return the test data from a test in a 2 dim array
			 public static  Object [][] getData(Xls_Reader xls, String testCaseName)
			 {
			// if sheet is present or not 
				 if (!xls.isSheetExist(testCaseName))
				 {
					 xls = null;
					 return new Object[1][0];
				 }

				 int rows= xls.getRowCount(testCaseName);
				 int cols = xls.getColumnCount(testCaseName);
				 //System.out.println(rows  +"**"+cols);
				
				 
				 Object[][] data= new Object[rows-1][cols];
				 for (int rowNum=2;rowNum<=rows; rowNum++ )
				 {
					 for(int colNum =0;colNum<cols;colNum++)
					 {
						// System.out.print(xls.getCellData(testCaseName,colNum , rowNum));
						 data[rowNum-2][colNum]=xls.getCellData(testCaseName,colNum , rowNum);
					 }
					 System.out.println();
				 }
				 
				 return data;
			 }
			 
			// Update the result for a perticular dataSet
				public static void reportDataSetResult(Xls_Reader xls, String testCaseName, int rowNum, String result)
				{
					xls.setCellData(testCaseName, "Results", rowNum, result);
				}

	}


