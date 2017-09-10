package com.wearewaes.service.difference;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wearewaes.dataaccessobject.DifferenceRepository;
import com.wearewaes.datatransferobject.DifferenceFinalResultDTO;
import com.wearewaes.domainobject.DifferenceDO;
import com.wearewaes.domainobject.PersonDO;
import com.wearewaes.exception.ConstraintsViolationException;
import com.wearewaes.exception.EntityNotFoundException;
import com.wearewaes.service.person.PersonService;

@Service
public class DefaultDifferenceService implements DifferenceService{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultDifferenceService.class);
    
    @Autowired
    private DifferenceRepository differenceRepository;
    
    @Autowired
    private PersonService personService;

    public DefaultDifferenceService(final DifferenceRepository differenceRepository)
    {
        this.differenceRepository = differenceRepository;
    }	

    public DifferenceDO find(Long differenceId) throws EntityNotFoundException {

		return findDifferenceChecked(differenceId);
	}

    @Transactional
	public DifferenceDO create(DifferenceDO differenceDO) throws ConstraintsViolationException {

		return null;
	}
	
    private DifferenceDO findDifferenceChecked(Long differenceId) throws EntityNotFoundException
    {
    	DifferenceDO differenceDO = differenceRepository.findOne(differenceId);
    	
        if (differenceDO == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + differenceId);
        }
        
        return differenceDO;
    }
    
    private DifferenceDO findDifference(Long differenceId) 
    {
    	DifferenceDO differenceDO = differenceRepository.findOne(differenceId);
    	
        if (differenceDO == null)
        {
            return new DifferenceDO(differenceId);
        }
        
        return differenceDO;
    }

    @Transactional
	public DifferenceDO createLeftPerson(Long differenceId, PersonDO personDO) 
	{
		DifferenceDO differenceDO = findDifference(differenceId);
		
		if (differenceDO.getPersonLeft() == null) {
			differenceDO.setPersonLeft(personDO);
		}
		return differenceRepository.save(differenceDO);
	}

    @Transactional
	public DifferenceDO createRightPerson(Long differenceId, PersonDO personDO) {
		
		DifferenceDO differenceDO = findDifference(differenceId);
		
		if (differenceDO.getPersonRight() == null) {
			differenceDO.setPersonRight(personDO);
		}
		return differenceRepository.save(differenceDO);
	}

	public DifferenceFinalResultDTO analyseDifference(Long differenceId) throws EntityNotFoundException {

		DifferenceDO differenceDO = findDifferenceChecked(differenceId);
		DifferenceFinalResultDTO differenceFinalResultDTO = new DifferenceFinalResultDTO();
		
		String personLeft = personService.getEncodedPerson(differenceDO.getPersonLeft());
		String personRight = personService.getEncodedPerson(differenceDO.getPersonRight());
		
		if (personLeft.length() != personRight.length()) 
		{
			differenceFinalResultDTO.setEqualObject(false);
			differenceFinalResultDTO.setMessageFinalResult("These object are differents");
		}
		else 
		{
			if (personLeft.equals(personRight)) {
				differenceFinalResultDTO.setEqualObject(false);
				differenceFinalResultDTO.setMessageFinalResult("These object have the same length but different content");
			}
			else {
				differenceFinalResultDTO.setEqualObject(true);
				differenceFinalResultDTO.setMessageFinalResult("These object are equals");
			}
			
		}
		
		return differenceFinalResultDTO;
	}

}
