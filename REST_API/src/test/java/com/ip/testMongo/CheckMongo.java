package com.ip.testMongo;

import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;



public class CheckMongo {

	public static void main(String[] args)
	{
		MongoClient mongoClient = null;
		String mongoDb="nextgen";
		String Env="TEST";
		getmongoDbConnection(mongoDb,Env);
		
	
	/*	String user_Role_Container_URI = "mongodb://qsi123:1234@localhost:27017/nextgen";
	MongoClientURI uri = new MongoClientURI(user_Role_Container_URI);
		MongoClient mongoClient1 = new MongoClient(uri);
		DB database = mongoClient1.getDB("nextgen");*/
		
		DB db = mongoClient.getDB(mongoDb);
		
		//http://mongodb.github.io/mongo-java-driver/3.6/driver/tutorials/authentication/
		
		DBCollection dbcoll= db.getCollection("Demographics");
		
		System.out.println(dbcoll.count());

		
	}
	
	public static MongoClient getmongoDbConnection(String mongoDb, String environment)
	{
		if(mongoDb.equalsIgnoreCase("nextgen"))
		{
			if(environment.equalsIgnoreCase("TEST"))
			{
			String MongoDbUrl= "mongodb://qsi123:1234@localhost:27017/nextgen";
			
			MongoClientURI uri= new MongoClientURI(MongoDbUrl);
			
			MongoClient mongoclient= new MongoClient(uri);
			//addede
			
			return mongoclient;
			}
			else
			{
				
			}
		}
		else
			return null;
		return null;
		
		
	}

}
