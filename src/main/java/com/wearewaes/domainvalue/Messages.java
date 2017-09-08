package com.wearewaes.domainvalue;

public class Messages {
	
	public static final String ENCODED_PERSON_DO_STRING = "eyJpZCI6IDEsICJuYW1lIjoiU3RldmUgSm9icyIsICJuYXRpb25hbGl0eSI6ICJBbWVyaWNhbiIsICJhZ2UiOiA1MH0=";

	public static final String DECODED_PERSON_DO_STRING = "{\"id\": 1, \"name\":\"Steve Jobs\", \"nationality\": \"American\", \"age\": 50}";
	
	public static final String DECODED_NOT_PERSON_DO_STRING = "{\"id\": 1, \"full_name\":\"Steve Jobs\", \"full_nationality\": \"American\", \"age\": 50}";
	
	public static final String DECODED_DIFFERENCE_DO_FALSE_STRING = "{\"messageFinalResult\": \"These object are differents\", \"equalObject\": false }";
	
	public static final String DECODED_DIFFERENCE_DO_TRUE_STRING = "{\"messageFinalResult\": \"These object are equals\", \"equalObject\": true }";
	
}
