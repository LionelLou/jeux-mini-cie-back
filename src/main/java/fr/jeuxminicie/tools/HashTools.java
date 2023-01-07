package fr.jeuxminicie.tools;

import java.math.BigInteger;
import java.security.MessageDigest;

public class HashTools {


	public static String hashSHA512(String input) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-512");// singleton unique
		md.reset(); // reset message content

		// adding hash algorithm
		byte[] hachedArray = md.digest(input.getBytes("utf-8"));

		// conversion of hashed message 
		BigInteger bi = new BigInteger(1, hachedArray);
		return String.format("%0128x", bi);
	}

}
