import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_Post_Request {
	@Test
	public void addData() {
		//Specify Base URI
		
		RestAssured.baseURI ="https://reqres.in/api";
		
		//Request object
		RequestSpecification request= RestAssured.given();
		
		//Request payload sending along with Post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Vijay");
		requestParams.put("job", "QA");
		
		request.header("Content-Type","application/json");
		request.body(requestParams.toJSONString());//attach above data to the request
		//Response object
		Response  response =request.request(Method.POST,"/users");
		
		//Print response in console window
		String responseBody= response.getBody().asString();
		System.out.println("RespnseBody is : "+responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is :"+statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//Success code Validation
		String successCode=response.jsonPath().get("createdAt");
		Assert.assertEquals(successCode, "2022-11-19");
	}

}
