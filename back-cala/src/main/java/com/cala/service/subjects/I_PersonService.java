package com.cala.service.subjects;

import java.util.List;
import java.util.Optional;

import com.cala.exceptions.AppBussinessValidationException;
import com.cala.exceptions.AppDataTypeValidationException;
import com.cala.model.dto.subjects.PersonDto;


public interface I_PersonService {
	public Optional<PersonDto> findById(Long id)throws AppDataTypeValidationException, AppBussinessValidationException;
	
	public PersonDto remove(Long id) throws AppDataTypeValidationException, AppBussinessValidationException;

	public List<PersonDto> findAll(PersonDto filter, int size, int page) throws AppDataTypeValidationException, AppBussinessValidationException;
		
	public PersonDto store(PersonDto person) throws AppDataTypeValidationException, AppBussinessValidationException;

	public PersonDto edit(PersonDto person) throws AppDataTypeValidationException, AppBussinessValidationException;
	
	public Optional<PersonDto> updateFilters(PersonDto person) throws AppDataTypeValidationException, AppBussinessValidationException;

	public void addPersonsTest();

}
