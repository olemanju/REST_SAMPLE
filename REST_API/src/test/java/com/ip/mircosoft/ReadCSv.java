package com.ip.mircosoft;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.opencsv.CSVReader;

public class ReadCSv {

	public static void main(String[] args) 
	{
	
		try
		{
			String path="C:\\Users\\mramasw2\\git\\REST_FINAL\\REST_API\\src\\test\\resources\\Testdata\\SampleCSVFile.csv";
			
			FileReader fr= new FileReader(path);
			CSVReader csvreader= new CSVReader(fr);
			
			//Using while loop
		/*	String[] csvcell;
			
			while((csvcell = csvreader.readNext())!=null)
			{
				String name= csvcell[0];
				System.out.println("Name is " + name);
				
				String Details= csvcell[1];
				System.out.println("Details is " + Details);
				
				String numbers= csvcell[2];
				System.out.println("numbers is " + numbers);
				
				String amount= csvcell[3];
				System.out.println("amount is " + amount);
				
				
			}*/
			
			//Using for loop
			
			List<String[]> alllines;
			
			alllines= csvreader.readAll();
	
			for(int i=0; i<alllines.size(); i++)
			{
				String[] getindex= alllines.get(i);
				
				String name= getindex[0];
				System.out.println("Names is " + name);
				
				String amount= getindex[2];
				System.out.println("amount is " + amount);
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
