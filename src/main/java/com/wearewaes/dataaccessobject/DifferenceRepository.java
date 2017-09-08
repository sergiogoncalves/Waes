package com.wearewaes.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.wearewaes.domainobject.DifferenceDO;

/**
 * Method to CRUD Difference entity
 * @author Sergio
 *
 */
public interface DifferenceRepository  extends CrudRepository<DifferenceDO, Long>  {

}
