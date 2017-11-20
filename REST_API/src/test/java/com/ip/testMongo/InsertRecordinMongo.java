package com.ip.testMongo;


import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertRecordinMongo {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String detailsofdatabase = "mongodb://qsi123:1234@localhost:27017/nextgen";
		MongoClientURI mongourli= new MongoClientURI(detailsofdatabase);
		
		MongoClient mongoclient= new MongoClient(mongourli);
		
		MongoDatabase dbname= mongoclient.getDatabase("nextgen");
		
		DB myreaddb= mongoclient.getDB("nextgen");
		
		Document doc= new Document("Name","Deepa")
				.append("age", 28)
				.append("college", "CMR")
				.append("car", "Toyoto")
				.append("place", "Chennai")
				.append("Company", "nextgen")
				.append("mobile", 212111232);
		
		
		
		MongoCollection<Document> collectionname= dbname.getCollection("Demographics");
		
		collectionname.insertOne(doc);
		
		//DBCollection DbCollectionName_Demographics= (DBCollection) dbname.getCollection("Demographics");
		DBCollection Demographicscollection= myreaddb.getCollection("Demographics");
		System.out.println(collectionname.count());
		
		List mongolist= Demographicscollection.distinct("Name");
		
		for(int i=0; i<mongolist.size(); i++)
		{
			
		String names= mongolist.get(i).toString();
		
		//System.out.println("Names are : " + names);
		
		BasicDBObject namesquery= new BasicDBObject();
		
		namesquery.append("Name", names).append("college", "CMR");
		//namesquery.append("Name", names);
		
		DBCursor findbyplace= Demographicscollection.find(namesquery);
		
		
		while(findbyplace.hasNext())
		{
			//System.out.println("Details are " + findbyplace.next());
			DBObject doc1= findbyplace.next();
			
			String name= (String) doc1.get("Name");
			System.out.println("name is " + name);
			
			String place= (String) doc1.get("place");
			System.out.println("Place is : " + place);
			
			Integer mobilenumber= (Integer) doc1.get("mobile");
			System.out.println("Mobile number is " + mobilenumber);
			
		}
		}
		
		
		

	}
	
	public static void connectTomongoDb()
	{
		String detailsofdatabase = "mongodb://qsi123:1234@localhost:27017/nextgen";
		MongoClientURI mongourli= new MongoClientURI(detailsofdatabase);
		
		MongoClient mongoclient= new MongoClient(mongourli);
		
		DB dbname= mongoclient.getDB("nextgen");
	}
	
	

}
