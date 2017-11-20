package com.ip.mircosoft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) 
	{
		String name= getPropertyContents().getProperty("name");
		System.out.println("Name is " + name);
		
		String car= getPropertyContents().getProperty("car");
		System.out.println("Car brand is " + car);
		
		String bike= getPropertyContents().getProperty("bike");
		System.out.println("Bike Name is " + bike);

	}
	
	private static final Properties prop= new Properties();
	
	public static void readPropertyFile()
	{
		try {
			InputStream input = new FileInputStream("C:\\Users\\mramasw2\\git\\REST_FINAL\\REST_API\\Readme.properties");
			
			prop.load(input);
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Properties getPropertyContents()
	{
		readPropertyFile();
		return prop;
	}

}
