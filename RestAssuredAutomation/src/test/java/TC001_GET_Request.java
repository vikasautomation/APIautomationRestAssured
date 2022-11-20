import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	public  void getWeatherReport(){
		
		//Specify Base URI
		
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		
		//Create request object
		
		RequestSpecification reqsVar = RestAssured.given();
		
		//Response object
		
		Response response = reqsVar.request(Method.GET);
		
		//Print response in console window 
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is  "+responseBody);
		
		//verify status code 
		int statusCode= response.getStatusCode();
		System.out.println("Status code is :"+ statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Verify Status Line
		String statusLine=response.getStatusLine();
		System.out.println("Status Line:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
		
	}

}
