package com.wearewaes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wearewaes.controller.mapper.PersonMapper;
import com.wearewaes.datatransferobject.DifferenceFinalResultDTO;
import com.wearewaes.datatransferobject.PersonDTO;
import com.wearewaes.domainobject.PersonDO;
import com.wearewaes.exception.ConstraintsViolationException;
import com.wearewaes.exception.EntityNotFoundException;
import com.wearewaes.exception.NoBase64EncodedException;
import com.wearewaes.exception.NotPersonDTOException;
import com.wearewaes.service.difference.DifferenceService;
import com.wearewaes.service.person.PersonService;
import com.wearewaes.util.Utils;

@RestController
@RequestMapping("/v1")
public class DifferenceController {
	
	private DifferenceService differenceService;
	
	@Autowired
	public DifferenceController(final DifferenceService differenceService) {
		
		this.differenceService = differenceService;
		
	}
	
    @PostMapping(value = "/{id}/left")
    @ResponseStatus(HttpStatus.CREATED)
    public void receiveLeft(@Valid @PathVariable long id, @Valid @RequestBody String personDTO) throws ConstraintsViolationException, NoBase64EncodedException, NotPersonDTOException 
    {
    	if (!Utils.isBase64Encoded(personDTO)) {
			throw new NoBase64EncodedException("The sent string is not Base64 encoded.");
		}
    	
        PersonDO personDO = PersonMapper.makePersonDO(PersonMapper.makePersonDTODecoded(personDTO));
		
        differenceService.createLeftPerson(id, personDO);
    }
    
    @PostMapping(value = "/{id}/right")
    @ResponseStatus(HttpStatus.CREATED)
    public void receiveRight(@Valid @PathVariable long id, @Valid @RequestBody String personDTO) throws ConstraintsViolationException, NoBase64EncodedException, NotPersonDTOException 
    {
    	if (!Utils.isBase64Encoded(personDTO)) {
			throw new NoBase64EncodedException("The sent string is not Base64 encoded.");
		}
    	
        PersonDO personDO = PersonMapper.makePersonDO(PersonMapper.makePersonDTODecoded(personDTO));
		
        differenceService.createRightPerson(id, personDO);
    }
    
    @GetMapping("/diff/{id}")
    public DifferenceFinalResultDTO getDiff(@Valid @PathVariable long id) throws EntityNotFoundException 
    {
      return differenceService.analyseDifference(id);
    }

}
