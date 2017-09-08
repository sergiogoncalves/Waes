package com.wearewaes.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wearewaes.datatransferobject.PersonDTO;
import com.wearewaes.domainvalue.Messages;
import com.wearewaes.exception.NotPersonDTOException;

public class UtilsTest {
	
	private final PersonDTO personDTO = new PersonDTO();
	
	@Test
	public void shouldReturnDecodedString() {
		assertEquals(Messages.DECODED_PERSON_DO_STRING, Utils.decodeString(Messages.ENCODED_PERSON_DO_STRING));
	}
	
	@Test
	public void shouldReturnEncodedString() {
		assertEquals(Messages.ENCODED_PERSON_DO_STRING, Utils.encodeString(Messages.DECODED_PERSON_DO_STRING));
	}
	
	@Test
	public void shouldReturnTheSameEncodedSize() {
		assertEquals(Messages.ENCODED_PERSON_DO_STRING.length(), Utils.encodeString(Messages.DECODED_PERSON_DO_STRING).length());
	}
	
	@Test
	public void shouldReturnTheSameDecodedSize() {
		assertEquals(Messages.DECODED_PERSON_DO_STRING.length(), Utils.decodeString(Messages.ENCODED_PERSON_DO_STRING).length());
	}
	
	@Test
	public void shouldObjectsOfTheSameType()  {
		assertTrue(Utils.getConvertedObject(Utils.decodeString(Messages.ENCODED_PERSON_DO_STRING), personDTO) instanceof PersonDTO);
	}
	
	@Test
	public void shouldStringIsEncoded() {
		assertTrue(Utils.isBase64Encoded(Messages.ENCODED_PERSON_DO_STRING));
	}
	
	@Test
	public void shouldStringIsNotEncoded() {
		assertFalse(Utils.isBase64Encoded(Messages.DECODED_PERSON_DO_STRING));
	}

}

