package com.wearewaes.service.difference;

import com.wearewaes.datatransferobject.DifferenceFinalResultDTO;
import com.wearewaes.domainobject.DifferenceDO;
import com.wearewaes.domainobject.PersonDO;
import com.wearewaes.exception.ConstraintsViolationException;
import com.wearewaes.exception.EntityNotFoundException;

public interface DifferenceService {

	DifferenceDO find(Long differenceId) throws EntityNotFoundException;
	
	DifferenceDO create(DifferenceDO differenceDO) throws ConstraintsViolationException;
	
	DifferenceDO createLeftPerson(Long differenceId, PersonDO personDO);
	
	DifferenceDO createRightPerson(Long differenceId, PersonDO personDO);
	
	DifferenceFinalResultDTO analyseDifference(Long differenceId) throws EntityNotFoundException;
	
}
