package com.wearewaes.util;

import java.nio.charset.StandardCharsets;
//import java.util.Base64;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.wearewaes.exception.NotPersonDTOException;

public class Utils {
	/**
	 * Method used to decode a JSON file
	 * @param encodedString
	 * @return String
	 * @throws NotPersonDTOException 
	 */
	public static String decodeString(String encodedString) {


			byte[] decoded = Base64.decodeBase64(encodedString);
			
			return new String(decoded, StandardCharsets.UTF_8);
			

	}

	/***
	 * Method used to encode a JSON File
	 * @param encodedString
	 * @return
	 */
	public static String encodeString(String encodedString) {

		return Base64.encodeBase64String(encodedString.getBytes());

	}

	/**
	 * Method used to transform a JSON file in a Object
	 * @param jsonFile
	 * @param object
	 * @return
	 */
	public static Object getConvertedObject(String jsonFile, Object object) {
		Gson gson = new Gson();
		return gson.fromJson(jsonFile, object.getClass());
	}
	
	public static boolean isBase64Encoded(String encodedString) {
		
		if (Base64.isBase64(encodedString)) {
			return true;
		}
		
		return false;
	}
}
