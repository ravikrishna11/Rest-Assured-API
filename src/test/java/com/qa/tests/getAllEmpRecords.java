package com.qa.tests;




import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;




public class getAllEmpRecords extends TestBase {
	
	//RequestSpecification httpRequest;
	
	//Response response;
	
	@BeforeClass
	public void getAllEmployees()  {
		
		logger.info("******GetAllEmpRecord*******");
		RestAssured.baseURI = "https://reqres.in/api/users";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET);
		System.out.println("res: "+response);
	}
	@Test
	public void checkResponseBodyAll() {
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: "+responseBody);
		
	}
	@Test
	public void checkStatusCodeAll() {
		
		int statusCode = response.getStatusCode();
		System.out.println("StatusCode: "+statusCode);
		Assert.assertEquals(statusCode, 200);
	
	}
	@Test
	public void checkStatusLineAll() {
		
		String statusLine = response.getStatusLine();
		System.out.println("statusLine: "+statusLine);
		Assert.assertEquals(statusLine,  "HTTP/1.1 200 OK");
	
	}
	@Test
	public void checkContentTypeAll() {
		String contentType = response.contentType();
		System.out.println("contentType: "+contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
	}
	@Test
	public void checkServerTypeAll() {
		
		String serverType = response.header("server");
		System.out.println("serverType: "+serverType);
		Assert.assertEquals(serverType, "cloudflare");
	}
	@AfterClass
	public void tearDown() {
		
		logger.info("***********Finish***********");
	}
}
