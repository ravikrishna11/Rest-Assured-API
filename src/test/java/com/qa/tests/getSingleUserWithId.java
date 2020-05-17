package com.qa.tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class getSingleUserWithId extends TestBase {
	
	
	
	@BeforeClass
	public void getSingleUser() {
		
		logger.info("******GetSINGLEEmpRecord*******");
		 RestAssured.baseURI = "https://reqres.in/api";
		 httpRequest = RestAssured.given();
		 response = httpRequest.request(Method.GET,"/users/"+id);
	}
	@Test
	public void checkResponseBody() {
		
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(id), true);
	}
	@Test
	public void checkStatusCode() {
		
		int statusCode = response.getStatusCode();
		System.out.println("StatusCode: "+statusCode);
		Assert.assertEquals(statusCode, 200);
	
	}
	@Test
	public void checkStatusLine() {
		
		String statusLine = response.getStatusLine();
		System.out.println("statusLine: "+statusLine);
		Assert.assertEquals(statusLine,  "HTTP/1.1 200 OK");
	
	}
	@Test
	public void checkContentType() {
		String contentType = response.contentType();
		System.out.println("contentType: "+contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
	}
	@Test
	public void checkServerType() {
		
		String serverType = response.header("server");
		System.out.println("serverType: "+serverType);
		Assert.assertEquals(serverType, "cloudflare");
	}
	@AfterClass
	public void tearDown() {
		
		logger.info("***********Finish***********");
	}
}

	


