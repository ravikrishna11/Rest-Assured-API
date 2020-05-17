package com.qa.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {
	
	public static String Id() {
		
		String generatedString = RandomStringUtils.randomNumeric(3);
		return(generatedString);
		
	}
	public static String firstName() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return ("ravi"+generatedString);
	}
	public static String lastName() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return ("krishna"+generatedString);
	}

}
