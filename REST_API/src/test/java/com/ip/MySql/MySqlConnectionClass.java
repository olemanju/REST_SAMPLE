package com.ip.MySql;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnectionClass {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		getConnection();
	}
	
	public static Connection getConnection() throws Exception
	{
		//Connection import from Java.sql
		
		try 
		{
			System.out.println("Connected");
			String driver="com.mysql.jdbc.Driver";
			//Url is where the database located and table name
			String url="jdbc:mysql://localhost:3306/City";
			String username="olemanju";
			String password="olemanju";
			
			
			Class.forName(driver);
			
			Connection con= DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return con;
		} catch (Exception e) 
		{
			// TODO: handle exception
		}
		return null;
	}

}
