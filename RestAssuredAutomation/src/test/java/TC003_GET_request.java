import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_request {
	@Test
	 void googleMapTest() {
		
		//Specify Base URI
		RestAssured.baseURI= "https://reqres.in/api/unknown/2";
		
		//Request Object
		RequestSpecification requestObject= RestAssured.given();
		
		//Response object 
		
		Response responseObject= requestObject.request(Method.GET);
		
		//Print response in console window
		String responseBody=responseObject.getBody().asString();
		System.out.println("Response Body is:" + responseBody);
		
		//Validating Headers
		String contentType=responseObject.header("content-type");
		System.out.println("Content type Is :"+ contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		String contentEncoding=responseObject.header("content-Encoding");
		System.out.println("Content encoding Is :"+ contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
		String server=responseObject.header("server");
		System.out.println("server Is :"+ server);
		Assert.assertEquals(server, "cloudflare");
		
		
		
	}

}
