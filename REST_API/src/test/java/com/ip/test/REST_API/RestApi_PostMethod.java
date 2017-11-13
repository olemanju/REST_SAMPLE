package com.ip.test.REST_API;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

import java.util.Date;

public class RestApi_PostMethod {

	
	
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		

			//POST
String ContainerId= null;
String Method=null;

String responseBody=null;

			String strJSONFileName = "[{ \"C\": \""+ContainerId+"\",\"M\": \""+Method+"\"}]"; //createDynamicJSONforContractByCCOID_CORE("entitlementRequest", listNodes, listSubRootNodes,listValues, listSubRootValues,resultset);

			//String strXmlFileName = createDynamicXmlforUpdateUserprofile("userProfileRequest", listNodes, listSubRootNodes,listValues, listSubRootValues,resultset);

			if (strJSONFileName == null)
			{
				//logMessage("Create Dynamic JSON", "Should be able to create the dynamic JSON",	"Unable to create the dynamic JSON", "Failed");
			}

			//PRD Details 
			String token=generateToken();

			String PrdUrl=" http://eb-api.cisco.com/v0.1/access/attributes/multiple";

			responseBody=postJSONRequestWithToken(PrdUrl,"","",strJSONFileName,token);
			
		}	
			
public static String postJSONRequestWithToken(String url,String name,String password,String strFileName,String token) throws Exception 
{
String payloadBody = "", body = "";
//payloadBody = new Scanner( new File("RequestPayLoad"+System.getProperty("file.separator")+strFileName)).useDelimiter("\\A").next();

//Date strInitialTimeStamp=getTimeStamp();

Response response =
		given()
		.authentication().basic(name, password)                             //ZWZkZXYuZ2VuOmVmZGV2
		//.headers("Content-Type", "application/json; charset=utf-8", "Authorization", token)
		.headers("Content-Type", "application/json;charset=utf-8")
		.body(strFileName)
		.when()
		.post(url);

body  = response.getBody().asString();

System.out.println("---------------------------");
System.out.println("response body :"+body);
System.out.println("---------------------------");
return body;
}


//generate tokens
/**Token Req URL: https://cloudsso-test.cisco.com/as/token.oauth2?client_id=s2dw3k5hg3b7mqyvtmxt9u8t&grant_type=client_credentials&client_secret=JzGS9ZUk2823ex92SRSqCPaW 
 ** Method: POST **/
public static String generateToken() {

	String tokenRequest="", accessToken = "";
	try{
		tokenRequest = postRequest("https://cloudsso-test.cisco.com/as/token.oauth2?grant_type=client_credentials&client_id=d9466983ab40409681bf366f24c57b00&client_secret=3d8d53dced21469384F769C93C9AA86C", "", "");
		System.out.println("===TOKEN REQUEST===" + tokenRequest);

		String tokenReqSplit[] = tokenRequest.split(",");
		for(String tokenReqParts:tokenReqSplit){
			if(tokenReqParts.contains("access_token")){
				String tokenReqAttrSplit[] = tokenReqParts.split(":");
				for(String token:tokenReqAttrSplit){
					String tokenReqQuotesSplit = token.replace("\"", "");
					accessToken="Bearer "+tokenReqQuotesSplit;
				}
				System.out.println("==ACCESS TOKEN===" + accessToken);
			}
		}

	}catch(Exception e){
		e.printStackTrace();
	}

	return accessToken;
}


public static String postRequest(String url,String name,String password) throws Exception {

	String NotesToBeAdded = "", body = "";


	Response response =
			given()
			.authentication().basic(name, password)
			.header("content-type", "application/json")
			.body(NotesToBeAdded)
			.when()
			.post(url);


	body  = response.getBody().asString();

	return body;
}
	}


