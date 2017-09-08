package com.wearewaes.service.person;

import com.wearewaes.domainobject.PersonDO;
import com.wearewaes.exception.ConstraintsViolationException;
import com.wearewaes.exception.EntityNotFoundException;
import com.wearewaes.exception.PersonNotFoundException;

public interface PersonService {
	
	PersonDO find(Long personId) throws EntityNotFoundException;
	
	PersonDO create(PersonDO personDO) throws ConstraintsViolationException;
	
	String getDetailedDifferences(PersonDO leftPersonDO, PersonDO rightPersonDO) throws PersonNotFoundException;
	
	String getEncodedPerson(PersonDO personDO);

}
