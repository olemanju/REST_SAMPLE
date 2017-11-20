package com.ip.mircosoft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws Exception 
	{
		
		String name=getExcelRowAndColumnValue(1, 0);
		System.out.println("Name is " + name);
		
		String bike=getExcelRowAndColumnValue(1, 1);
		System.out.println("Bike  is " + bike);
		
		String car=getExcelRowAndColumnValue(1, 2);
		System.out.println("car is " + car);
		
		String Total=getExcelRowAndColumnValue(1, 3);
		System.out.println("Total is " + Total);
		
	}
	
	private static XSSFWorkbook excelbook;
	private static XSSFSheet sheetName;
	
	private static XSSFRow rownumber;
	private static XSSFCell Cellnumber;
	
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	

	public static void readExcel(String filepath,  String sheet) throws InvalidFormatException
	{
		//Create an object of File class to open xlsx file
		try {
		
			//Enter the Path of the File
			FileInputStream fis= new FileInputStream(filepath);
			
			//Create Workbook instance holding reference to .xlsx file
			excelbook= new XSSFWorkbook(fis);
			
			//Get te sheet name which you are looking for
			 sheetName= excelbook.getSheet(sheet);
			 
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	
		public static String getCelldata(int RowNum, int ColNumb)
		{
		
			//Get the Cell number which you are looking for Row number and column number
			Cellnumber=sheetName.getRow(RowNum).getCell(ColNumb);
			
			//Get the particular cell data
			//String celldata= Cellnumber.getStringCellValue().toString();
			
			// Only need one of these
			DataFormatter fmt = new DataFormatter();

			// Once per cell
			String valueAsSeenInExcel = fmt.formatCellValue(Cellnumber);
			
			return valueAsSeenInExcel;
			
			
		}
		
		public static String getExcelRowAndColumnValue(int row, int column) throws Exception
		{
			String path1="C:\\Users\\mramasw2\\git\\REST_FINAL\\REST_API\\src\\test\\resources\\Testdata\\PersonalDetails.xlsx";
			
			//Call read excel method and mention path and sheetname
			readExcel(path1, "Demographic");
			
			//in return we are calling celldata it will five us cell value
			return getCelldata(row, column);
		}
		
		
	/*	public static void writeExcelFile(String result, int Rownum, int Colnum)
		{
			
			try {
				//String path1="C:\\Users\\mramasw2\\git\\REST_FINAL\\REST_API\\src\\test\\resources\\Testdata\\PersonalDetails.xlsx";
				
				//FileInputStream fis= new FileInputStream(path1);
				
				//excelbook= new XSSFWorkbook(fis);
				
				//sheetname= Excelworkbook.getSheet("Demographic");
	
				rownumber= sheetName.getRow(Rownum);
				if(rownumber==null)
				{
					rownumber=sheetName.createRow(1);
				}
				Cellnumber=rownumber.getCell(Colnum,rownumber.RETURN_BLANK_AS_NULL);
				
				if(Cellnumber==null)
				{
					Cellnumber=rownumber.createCell(Colnum);
					Cellnumber.setCellValue(result);
					
				}
				
				else
				{
					Cellnumber.setCellValue(result);
				}
				
				String path2="C:\\Users\\mramasw2\\git\\REST_FINAL\\REST_API\\src\\test\\resources\\Testdata\\PersonalDetails.xlsx";
				FileOutputStream FilePath= new FileOutputStream(path1);
				
				excelbook.write(FilePath);
				FilePath.flush();
				FilePath.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		

	}


