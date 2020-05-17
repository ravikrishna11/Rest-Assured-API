package com.qa.tests;



import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.utility.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Post_call extends TestBase{
	
	@BeforeClass
	public void createUser() {
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		httpRequest = RestAssured.given();
		
		JSONObject reqParams = new JSONObject();
		reqParams.put("id", RestUtil.Id());
		reqParams.put("first_name", RestUtil.firstName());
		reqParams.put("last_name", RestUtil.lastName());
		
		//Add header
		httpRequest.header("content-type","application/json; charset=utf-8");
		
		httpRequest.body(reqParams.toJSONString());
		response = httpRequest.request(Method.POST);
	}

	@Test
	public void responseBody_post() {
		
		String responseBody = response.getBody().asString();
		System.out.println("responseBody: "+responseBody);
	}
	@Test
	public void status_code_post() {
		
		int statusCode = response.getStatusCode();
		System.out.println("statusCode: "+statusCode);
		
	}
}
