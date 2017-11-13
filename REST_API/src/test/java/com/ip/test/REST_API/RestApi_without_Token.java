package com.ip.test.REST_API;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RestApi_without_Token 
{
	public static void main(String[] args) 
{
	
	//Passing the URL Below Methods to hit
	String url="http://services.groupkt.com/country/get/all";
	
	//getRestResponse method is called and Response is stored in the Response body.
	String responsebody= getRestResponse(url,"","");
	
	//Check the condition is Response body contains Not Authorized
	if(responsebody.contains("Not Authorized"))
			{
		System.out.println("Unable to fetch the response with response body message '"+responsebody+"");
			}
	//Check the Response body is not having null or exception then Print the Response
	//Successful Message
	else  if((responsebody!=null)&&(!responsebody.equalsIgnoreCase(""))&&(!responsebody.contains("System is experiencing issues, please try again"))&&(!responsebody.contains("Not Authorized")))
			{
		System.out.println("Able to fetch the Response '"+responsebody+"");
			}
	//Else Print Unable to print the Response
	else
	{
		System.out.println("Unable to fetch the response with response body message '"+responsebody+"");	
	}
	
	System.out.println("My Response is : " + responsebody);

	verifyJsonResponse(responsebody);
}

//Get Response with Empty UserName and Password
public static String getRestResponse(String url,String username, String password)
{
	String body= null;
	
	//This method will take username and password and Url and in return it will provide response
	
	//Response is Interface and coming from import com.jayway.restassured.response.Response;
	//Given is static method from import static com.jayway.restassured.RestAssured.given;
	Response response=given().relaxedHTTPSValidation().authentication().basic(username, password)
			.header("Content-Type", "application/json","Authorization", "Basic ZWJmYXBpZGV2LmdlbjplYmZhcGlkZXY=")
			.when()
			.get(url);
	
			//In the above Code Autorization and Basic ZWJmYXBpZGV2LmdlbjplYmZhcGlkZXY= are optional So. 
			//	.header("Content-Type", "application/json","Authorization", "Basic ZWJmYXBpZGV2LmdlbjplYmZhcGlkZXY=")
		
	
	body= response.asString();
	
	System.out.println("Response is " + body);
	
	return body;
}

public static String verifyJsonResponse(String reponsebody)
{
	
/*	JsonParser is coming from 
	<dependency>	    <groupId>com.google.code.gson</groupId>	    <artifactId>gson</artifactId>	    <version>2.8.0</version>	</dependency>
	Creating object for JsonParser class */
	
JsonParser jsonParse= new JsonParser();

//String Response in to variable
String actual_response= reponsebody;

//JsonObject is a class and we are creating object for that
//Parsing our String Response to Json object form
//If the element is of some * other type, a {@link IllegalStateException} will result.

JsonObject jsonobject= jsonParse.parse(actual_response).getAsJsonObject();
System.out.println("jsonobject will print " + jsonobject);

//A class representing an element of Json. It could either be a {@link JsonObject}, a	 * {@link JsonArray}, a {@link JsonPrimitive} or a {@link JsonNull}.
//JsonElement is Abstratc Class
//RestResponse Is the First Element  or Root tag in Response and it will print all the elements which are present in Rest Response.

JsonElement jsonElement= jsonobject.get("RestResponse");
System.out.println("Json Element will Print which are elements Present in RestResponse Tag " + jsonElement);

//In the Response Message is in Array Format we need to fetch that 
//Converting to Jsonarray to do that get the jsonobject and under that get the array and covert to array
JsonArray jsonarrayMessage=jsonobject.get("RestResponse").getAsJsonObject().get("messages").getAsJsonArray();
System.out.println("Print Json array Message " + jsonarrayMessage);

//ConvertJsonarry to String
for(int i=0; i<jsonarrayMessage.size(); i++)
{
	String arrayMessageName= jsonarrayMessage.get(i).toString();
	System.out.println("Converted array Message is " + arrayMessageName);
}

//Print the Result array

JsonArray jsonResultarry= jsonobject.get("RestResponse").getAsJsonObject().get("result").getAsJsonArray();
System.out.println("Printing Json Result array is " +jsonResultarry);
List<String> list_names= new ArrayList<String>();
List<String> list_alpha2_code= new ArrayList<String>();
List<String> list_alpha3_code= new ArrayList<String>();

for (int i = 0; i < jsonResultarry.size(); i++) 
{
	
//Since Inside array we have one more json format so we need to create object for that and get the particular value
	JsonObject jsonobject_result_l= jsonResultarry.get(i).getAsJsonObject();

	//Casting or converting jsonobject to String
String name= jsonobject_result_l.get("name").getAsString();
System.out.println("Name is " + name);

String alpha2_code=jsonobject_result_l.get("alpha2_code").getAsString();
System.out.println("alpha2_code is " + alpha2_code);


String alpha3_code=jsonobject_result_l.get("alpha3_code").getAsString();
System.out.println("alpha3_code is " + alpha3_code);

System.out.println("Name in the Result array is : " + name + "Alpha2 Code is " + alpha2_code + " alpha 3 Code is " + alpha3_code);
list_names.add(name);
list_alpha2_code.add(alpha2_code);
list_alpha3_code.add(alpha3_code);
}

System.out.println("Total Names are " + list_names);
System.out.println("Total alpha2 Code is " + list_alpha2_code);
System.out.println("Total alpha 3 Code is " + list_alpha3_code);

/*System.out.println("Converted String response to Json Response");
System.out.println("Json Response is :" + jsonobject);*/
	
	return actual_response;
}

}



