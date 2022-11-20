import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_PrintAllHeaders_GET {
	
	@Test
	void printAllHeaders() {
		
		//Specify Base URI
				RestAssured.baseURI= "https://reqres.in/api/unknown/2";
				
				//Request Object
				RequestSpecification requestObject= RestAssured.given();
				
				//Response object 
				
				Response responseObject= requestObject.request(Method.GET);
				
				//Print response in console window
				String responseBody=responseObject.getBody().asString();
				System.out.println("Response Body is:" + responseBody);
				
				//Captures all headers
				Headers allHeader = responseObject.getHeaders();
				for(Header header: allHeader) {
					System.out.println("All Headers are here :"+ header);
					
				}
				
		
	}
	
	
}
	

