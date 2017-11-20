package com.ip.testMongo;

import java.util.Arrays;
import java.util.List;

import org.bson.codecs.Decoder;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
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
		//getmongoDbConnection(mongoDb,Env);
		
		
	
		String detailsofdatabase = "mongodb://qsi123:1234@localhost:27017/nextgen";
		MongoClientURI uri = new MongoClientURI(detailsofdatabase);
		MongoClient mongoClient1 = new MongoClient(uri);
		DB database = mongoClient1.getDB("nextgen");
		
		/*Use MongoClient() to make a connection to a running MongoDB instance.
		You can specify the MongoClientURI connection string:*/
		
		//DB db = mongoClient.getDB(mongoDb);
		
		//http://mongodb.github.io/mongo-java-driver/3.6/driver/tutorials/authentication/
		
		DBCollection DbCollectionName_Demographics= database.getCollection("Demographics");
		
		System.out.println(DbCollectionName_Demographics.count());
		
		List mongolist= DbCollectionName_Demographics.distinct("Name");
		
		for(int i=0; i<mongolist.size(); i++)
		{
			
		String names= mongolist.get(i).toString();
		
		//System.out.println("Names are : " + names);
		
		BasicDBObject namesquery= new BasicDBObject();
		
		namesquery.append("Name", names).append("college", "UVC");
		//namesquery.append("Name", names);
		
		DBCursor findbyplace= DbCollectionName_Demographics.find(namesquery);
		
		
		while(findbyplace.hasNext())
		{
			//System.out.println("Details are " + findbyplace.next());
			DBObject doc1= findbyplace.next();
			
			String name= (String) doc1.get("Name");
			System.out.println("name is " + name);
			
			String place= (String) doc1.get("place");
			System.out.println("Place is : " + place);
			
			Long mobilenumber= (Long) doc1.get("mobile");
			System.out.println("Mobile number is " + mobilenumber);
			
			
			List<DBObject> methods= (List<DBObject>) doc1.get("methods");
			
			//System.out.println("Methods : " + methods);
			System.out.println(methods);
			//System.out.println(methods.size());
			
			if(!methods.equals("null"))
			{
				for(DBObject methodname:methods)
				{
					String nameM= (String) methodname.get("name");
					System.out.println("Method Name is " + nameM);
					
					boolean check= (Boolean) methodname.get("needEntitlementcheck");
					System.out.println("needEntitlementcheck  is " +  check);
				}
			}
			else
			{
				System.out.println("Methods is Missing");
			}
			
			
		}
			
		}

		
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
