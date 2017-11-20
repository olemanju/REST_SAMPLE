package com.ip.mircosoft;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteXLSXFile 
{
	 
    /**
     * @param args
     */
    public static void main(String[] args) {
         
        //create a new workbook
        Workbook wb = new XSSFWorkbook();
         
        //add a new sheet to the workbook
        Sheet sheet1 = wb.createSheet("Demographic1");
         
        //add 2 row to the sheet
        Row row1 = sheet1.createRow(0);
        Row row2 = sheet1.createRow(1);
         
        //create cells in the rows
        Cell row1col1 = row1.createCell(0);
        Cell row1col2 = row1.createCell(1);
        Cell row2col1 = row2.createCell(0);
        Cell row2col2 = row2.createCell(1);
         
        //add data to the cells
        row1col1.setCellValue("manjunath");
        row1col2.setCellValue("pulsar");
        row2col1.setCellValue("kishore");
        row2col2.setCellValue("bullet");
 
        //add boolean data to cell
        Row row3 = sheet1.createRow(2);
        Cell row3col1 = row3.createCell(0);
        row3col1.setCellValue(true);
         
        //add numeric data to cell
        Cell row3col2 = row3.createCell(1);
        row3col2.setCellValue(123.321);
         
        //add date data to cell
        Cell row3col3 = row3.createCell(2);
        CreationHelper ch = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(ch.createDataFormat().getFormat("m/d/yy"));
        row3col3.setCellStyle(cellStyle);
        row3col3.setCellValue(new Date());
         
        //add string data to cell
        Cell row3col4 = row3.createCell(3);
        row3col4.setCellValue("string");
         
        //write the excel to a file
        try {
        	String path2="C:\\Users\\mramasw2\\git\\REST_FINAL\\REST_API\\src\\test\\resources\\Testdata\\PersonalDetails.xlsx";
            FileOutputStream fileOut = new FileOutputStream(path2);
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
             
        System.out.println("File created!!");
 
    }
 
}