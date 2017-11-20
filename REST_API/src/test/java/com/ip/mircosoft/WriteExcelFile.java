package com.ip.mircosoft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		writeExcelFile("manjunatha", 4, 0);
		writeExcelFile("devanahalli", 4, 1);
		writeExcelFile("Audi", 4, 2);
		writeExcelFile("Pulsar", 4, 3);
		writeExcelFile("5", 4, 4);

	}
	
	private static Workbook Excelworkbook;;
	private static Sheet sheetname;
	private static Row rownumber;
	private static Cell cellnumber;
	
	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	public static void setExcelfile(String path, String sheet) throws FileNotFoundException
	{
		
		Excelworkbook= new XSSFWorkbook();
		
		sheetname= Excelworkbook.getSheet(sheet);
	}
		//This method is to write in the Excel cell, Row num and Col num are the parameters
		
		public static void writeExcelFile(String result, int Rownum, int Colnum)
		{
			
			try {
				//String path1="C:\\Users\\mramasw2\\git\\REST_FINAL\\REST_API\\src\\test\\resources\\Testdata\\PersonalDetails.xlsx";
				
				//FileInputStream fis= new FileInputStream(path1);
				
				Excelworkbook= new XSSFWorkbook();
				
				sheetname= Excelworkbook.getSheet("Demographic1");
	
				rownumber= sheetname.createRow(Rownum);
				
				if(rownumber==null)
				{
					rownumber=sheetname.createRow(1);
				}
				cellnumber=rownumber.getCell(Colnum,rownumber.RETURN_BLANK_AS_NULL);
				
				if(cellnumber==null)
				{
					cellnumber=rownumber.createCell(Colnum);
					cellnumber.setCellValue(result);
					
				}
				
				else
				{
					cellnumber.setCellValue(result);
				}
				
				String path2="C:\\Users\\mramasw2\\git\\REST_FINAL\\REST_API\\src\\test\\resources\\Testdata\\PersonalDetails.xlsx";
				FileOutputStream FilePath= new FileOutputStream(path2);
				
				Excelworkbook.write(FilePath);
				FilePath.flush();
				FilePath.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		/*public static String writeExcelSheet(String result,int row, int column) throws Exception
		{
			String path1="C:\\Users\\mramasw2\\git\\REST_FINAL\\REST_API\\src\\test\\resources\\Testdata\\PersonalDetails.xlsx";
			
			//Call read excel method and mention path and sheetname
			setExcelfile(path1, "Demographic");
			
			//in return we are calling celldata it will five us cell value
			return setCellData(result,row, column);
		}*/
		
		
		
	

}
