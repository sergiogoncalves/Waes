package com.wearewaes.domainobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class PersonDO {
	
	public PersonDO() {
		
	}
	
    @Id
    @GeneratedValue
	private Long id;
	private String name;
	private String nationality;
	private Integer age;
	
	public PersonDO(Long id, String name, String nationality, Integer age) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	

}
