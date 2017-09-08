package com.wearewaes.domainobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "difference")
public class DifferenceDO {
	
	public DifferenceDO() {
		
	}

	@Id
	private long id;
	
	@OneToOne
	@JoinColumn(name="person_left_id")
	private PersonDO personLeft;
	
	@OneToOne
	@JoinColumn(name="person_right_id")
	private PersonDO personRight;

	public DifferenceDO(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PersonDO getPersonLeft() {
		return personLeft;
	}

	public void setPersonLeft(PersonDO personLeft) {
		this.personLeft = personLeft;
	}

	public PersonDO getPersonRight() {
		return personRight;
	}

	public void setPersonRight(PersonDO personRight) {
		this.personRight = personRight;
	}


	
	
	
}
