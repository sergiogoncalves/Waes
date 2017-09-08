package com.wearewaes.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.wearewaes.domainobject.PersonDO;

/***
 * Method to CRUD Person entity
 * @author Sergio
 *
 */
public interface PersonRepository extends CrudRepository<PersonDO, Long> {

}
