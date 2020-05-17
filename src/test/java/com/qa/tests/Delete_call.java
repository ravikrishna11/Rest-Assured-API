package com.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class Delete_call extends TestBase {
	
	
	@BeforeClass
	public void Delete_TestCase() {
		
		RestAssured.baseURI = "https://reqres.in/api";
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET,"/users");
		
		//first get json path object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		//capture Id
		String  id = jsonPathEvaluator.get("[0].id");
		response = httpRequest.request(Method.DELETE,"/users/"+id);
		
		
	}
     @Test
     public void check_delete_statusCode() {
    	 
    	  int statusCode = response.getStatusCode();
    	  System.out.println("statusCode: "+statusCode);
     }
}
