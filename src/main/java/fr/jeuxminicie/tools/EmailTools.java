package fr.jeuxminicie.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailTools {
	
	
	public static boolean checkIfEmailIsValid(String email) {
		
		Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
					
		Matcher emailMatcher = emailPattern.matcher(email);
					
		if(!emailMatcher.matches()) {
			return true;
		}else {
			return false;
		}
	}

}
