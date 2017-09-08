package com.wearewaes.controller.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wearewaes.datatransferobject.PersonDTO;
import com.wearewaes.domainvalue.Messages;
import com.wearewaes.exception.NotPersonDTOException;

public class PersonMapperTest {

	@Test
	public void shouldReturnAPersonDTOObjectByEncodedString() throws NotPersonDTOException {

		assertTrue(PersonMapper.makePersonDTODecoded(Messages.ENCODED_PERSON_DO_STRING) instanceof PersonDTO);

	}
	
	@Test(expected = NotPersonDTOException.class)
	public void shouldNotReturnAPersonDTOObjectByEncodedString() throws NotPersonDTOException {

		assertFalse(PersonMapper.makePersonDTODecoded(Messages.DECODED_NOT_PERSON_DO_STRING) instanceof PersonDTO);

	}

}
