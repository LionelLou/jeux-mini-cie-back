package fr.jeuxminicie.tools;

import java.util.regex.Pattern;

public class EmailTools {
	
	
	public static boolean checkIfEmailIsValid(String email) {
		
//		boolean result = false;
//		
//		String pattern = "@";
//		
//		Pattern emailPattern = Pattern.compile(pattern);
//					
//		Matcher emailMatcher = emailPattern.matcher(email);
//		
//		System.out.println(emailMatcher.matches());
//					
//		if(emailMatcher.matches()) {
//			result = true;
//		}
//		
//		return result;
		
		return Pattern.matches(".+@.+", email); 
	}

}
