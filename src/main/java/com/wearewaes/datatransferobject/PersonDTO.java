package com.wearewaes.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class PersonDTO {
	
    @JsonIgnore
	private Long id;
    
	private String name;
	
	private String nationality;
	
	private Integer age;
	
    public PersonDTO()
    {
    }

	public PersonDTO(Long id, String name, String nationality, Integer age) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.age = age;
	}

    @JsonIgnore
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
	
	
    
    public static PersonDTOBuilder newBuilder()
    {
        return new PersonDTOBuilder();
    }
	
    public static class PersonDTOBuilder
    {
    	private Long id;
    	private String name;
    	private String nationality;
    	private Integer age;
    	
		public PersonDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		public PersonDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public PersonDTOBuilder setNationality(String nationality) {
			this.nationality = nationality;
			return this;
		}
		public PersonDTOBuilder setAge(Integer age) {
			this.age = age;
			return this;
		}
		
        public PersonDTO createPersonDTO()
        {
            return new PersonDTO(id, name, nationality, age);
        }
    }
    

}
