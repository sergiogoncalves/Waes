package com.wearewaes.service.person;

import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.wearewaes.util.Utils;

 

import com.wearewaes.dataaccessobject.PersonRepository;
import com.wearewaes.domainobject.PersonDO;
import com.wearewaes.exception.ConstraintsViolationException;
import com.wearewaes.exception.EntityNotFoundException;
import com.wearewaes.exception.PersonNotFoundException;

@Service
public class DefaultPersonService implements PersonService 
{
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultPersonService.class);
    
    private final PersonRepository personRepository;
    
    @Autowired
    private PersonService personService;

    public DefaultPersonService(final PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }	

	public PersonDO find(Long personId) throws EntityNotFoundException {
		return findPersonChecked(personId);
	}

	public PersonDO create(PersonDO personDO) throws ConstraintsViolationException {
		PersonDO person;
       
		try
        {
			person = personRepository.save(personDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("Some constraints are thrown due to person creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return person;
	}
	
    private PersonDO findPersonChecked(Long personId) throws EntityNotFoundException
    {
    	PersonDO personDO = personRepository.findOne(personId);
    	
        if (personDO == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + personId);
        }
        
        return personDO;
    }

	public String getDetailedDifferences(PersonDO leftPersonDO, PersonDO rightPersonDO) throws PersonNotFoundException {
		
		StringBuilder returnString = new StringBuilder("");
		
		if (leftPersonDO == null || rightPersonDO == null) {
			throw new PersonNotFoundException("Person left or Right not found!");
		}
		
		if (!leftPersonDO.getName().equals(rightPersonDO.getName())  ) {
			returnString.append("The name is different/ ");
		}
		
		if (!leftPersonDO.getNationality().equals(rightPersonDO.getNationality())  ) {
			returnString.append("The Nationality is different/ ");
		}
		
		if (!leftPersonDO.getAge().equals(rightPersonDO.getAge())  ) {
			returnString.append("The age is different ");
		}
		
		return returnString.toString();
	}

	@Override
	public String getEncodedPerson(PersonDO personDO) {
		
		JSONObject personObject = new JSONObject(); 
		
		personObject.put("id", new Long(personDO.getId())); 
		personObject.put("name", personDO.getName()); 
		personObject.put("nationality", personDO.getNationality());
		personObject.put("age",new Integer(personDO.getAge()));		
		

		return Utils.encodeString(personObject.toJSONString()); 
	}




}
