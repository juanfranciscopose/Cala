package com.cala.service.subjects;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cala.dao.subjects.I_PersonDao;
import com.cala.exceptions.AppBussinessValidationException;
import com.cala.exceptions.AppDataTypeValidationException;
import com.cala.model.dto.subjects.PersonDto;
import com.cala.model.vo.subjects.PersonVo;
import com.cala.service.global.DataTypeValidationService;
import com.cala.util.messages.MessageError;
@Service
public class PersonService implements I_PersonService{
	
	@Autowired
	private I_PersonDao personDao;

	@Override
	public Optional<PersonDto> findById(Long id)
			throws AppDataTypeValidationException, AppBussinessValidationException {
		// data types validations
		DataTypeValidationService.checkLong(id, MessageError.ERR_ID);
		// business validations
		PersonVo personVo = (PersonVo) getPersonDao().findById(id);
		if (personVo == null) {
			throw new AppBussinessValidationException(MessageError.ERR_PERSON_NOT_EXIST);
		}
		// create dto for response
		
		return Optional.of(null);
	}

	@Override
	public PersonDto remove(Long id) throws AppDataTypeValidationException, AppBussinessValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonDto> findAll(PersonDto filter, int size, int page)
			throws AppDataTypeValidationException, AppBussinessValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDto store(PersonDto person) throws AppDataTypeValidationException, AppBussinessValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDto edit(PersonDto person) throws AppDataTypeValidationException, AppBussinessValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<PersonDto> updateFilters(PersonDto person)
			throws AppDataTypeValidationException, AppBussinessValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	public I_PersonDao getPersonDao() {
		return personDao;
	}
	
}
