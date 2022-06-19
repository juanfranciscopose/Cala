package com.cala.service.subjects;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cala.dao.subjects.I_PersonDao;
import com.cala.exceptions.AppBussinessValidationException;
import com.cala.exceptions.AppDataTypeValidationException;
import com.cala.model.dto.subjects.PersonDto;
import com.cala.model.vo.subjects.PersonVo;
import com.cala.service.global.DataTypeValidationService;
import com.cala.util.messages.MessageError;
import com.cala.util.persons.RandomDataUtils;

@Service
public class PersonService implements I_PersonService{
	
	Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
	private HelperPersonService helper;
	
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
		PersonDto persondto = personVo.toDTO();
		return Optional.of(persondto);
	}

	@Override
	public PersonDto remove(Long id) throws AppDataTypeValidationException, AppBussinessValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonDto> findAll(PersonDto filter, int size, int page)
			throws AppDataTypeValidationException, AppBussinessValidationException {
		
		List<PersonVo> list = getPersonDao().getAll();
				
		//findAllWithFilters(null, new PaginationVo(page, size));
		return PersonVo.createListDto(list);
	}

	@Override
	public PersonDto store(PersonDto person) throws AppDataTypeValidationException, AppBussinessValidationException {
		// data types validations
		
		// business validations
		PersonVo pV = helper.personDtoToPersonVo(person);
		PersonVo personVo = getPersonDao().store(pV);
		if (pV.getGender() != null) {
			personVo = getPersonDao().setGender(personVo.getId(), pV.getGender());
		}
		// create dto for response
		return personVo.toDTO();
	}

	@Override
	public PersonDto edit(PersonDto person) throws AppDataTypeValidationException, AppBussinessValidationException {
		// data types validations
		
		// business validations
		if (findById(person.getId()).isPresent()) {
			PersonVo pV = helper.personDtoToPersonVo(person);
			PersonVo personVo = getPersonDao().update(pV);
			// create dto for response
			return personVo.toDTO();
		}
		return null;		
	}

	@Override
	public Optional<PersonDto> updateFilters(PersonDto person)
			throws AppDataTypeValidationException, AppBussinessValidationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addPersonsTest () {
		String[] names = RandomDataUtils.getRandomNames(60);
		String[] surnames = RandomDataUtils.getRandomSurnames(50);
		String[] emails = RandomDataUtils.getRandomEmails(50);
		String[] prof = RandomDataUtils.getRandomProfessions(50);
		String[] jobs = RandomDataUtils.getRandomJobs(50);
		String[] nicknames = RandomDataUtils.getRandomNicknames(50);
		String[] disab = RandomDataUtils.getRandomDisabilities(50);
				
		try {
			for (int i = 0; i < 50; i++) {
				switch (RandomDataUtils.getRandomNumbers(4)) {
				case 1:
					getPersonDao().store(new PersonVo(names[i], names[i]+surnames[i]+emails[i], new Date(), nicknames[i]+"_"+surnames[i],names[i]+" "+surnames[i] , "@"+nicknames[i]+surnames[i], nicknames[i]+"."+surnames[i], 
							String.valueOf(RandomDataUtils.getRandomNumbers(999999999)), false, surnames[i], String.valueOf(RandomDataUtils.getRandomNumbers(40999999)), "DNI", nicknames[i], prof[i], jobs[i], false, null, false, null));
					break;
				case 2:
					getPersonDao().store(new PersonVo(names[i], names[i]+surnames[i]+emails[i], new Date(), names[i]+"_"+surnames[i],names[i]+" "+surnames[i] , "@"+names[i]+surnames[i], names[i]+"."+surnames[i], 
							String.valueOf(RandomDataUtils.getRandomNumbers(999999999)), false, surnames[i], null, null, null, prof[i], jobs[i], true, names[i+1]+" "+names[i+2], true, disab[i]));
					break;
				case 3: 
					getPersonDao().store(new PersonVo(names[i], names[i]+surnames[i]+emails[i], null, names[i]+"_"+surnames[i],names[i]+" "+surnames[i] , "@"+names[i]+surnames[i], names[i]+"."+surnames[i], 
							String.valueOf(RandomDataUtils.getRandomNumbers(999999999)), false, surnames[i], null, null, null, prof[i], jobs[i], true, names[i+1], false, null));
					break;
				case 4: 
					getPersonDao().store(new PersonVo(names[i], names[i]+surnames[i]+emails[i], null, nicknames[i]+"_"+surnames[i],nicknames[i]+" "+surnames[i] , "@"+nicknames[i]+surnames[i], nicknames[i]+"."+surnames[i], 
							String.valueOf(RandomDataUtils.getRandomNumbers(999999999)), false, surnames[i], null, null, nicknames[i], prof[i], jobs[i], true, names[i+1], false, null));
					break;
				}				
			}		
		}catch(Exception e) {
			logger.error("Error en metodo addPersonsTest de PersonService");
		}
	}

	public I_PersonDao getPersonDao() {
		return personDao;
	}
	
}
