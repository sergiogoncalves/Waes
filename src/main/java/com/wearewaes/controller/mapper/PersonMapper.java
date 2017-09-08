package com.wearewaes.controller.mapper;

import com.wearewaes.datatransferobject.PersonDTO;
import com.wearewaes.domainobject.PersonDO;
import com.wearewaes.exception.NotPersonDTOException;
import com.wearewaes.util.Utils;

public class PersonMapper {

	/**
	 * Method used to transform PersonDTO to PersonDO
	 * 
	 * @param personDTO
	 * @return PersonDO
	 */
	public static PersonDO makePersonDO(PersonDTO personDTO) {
		return new PersonDO(personDTO.getId(), personDTO.getName(), personDTO.getNationality(), personDTO.getAge());
	}

	/**
	 * Method used to decode an encoded PersonDTO
	 * 
	 * @param encodedString
	 * @return PersonDTO
	 * @throws NotPersonDTOException
	 */
	public static PersonDTO makePersonDTODecoded(String encodedString) throws NotPersonDTOException {

		PersonDTO personDTO = new PersonDTO();
		try {
			
			String jsonFile = Utils.decodeString(encodedString);
			personDTO = (PersonDTO) Utils.getConvertedObject(jsonFile, personDTO);

		} catch (Exception e) {
			throw new NotPersonDTOException("The encoded string is not a PersonDTO class.");
		}

		return personDTO;
	}

}
