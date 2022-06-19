package com.cala.service.subjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cala.dao.filters.GenderDao;
import com.cala.model.dto.subjects.PersonDto;

import com.cala.model.vo.filters.GenderVo;
import com.cala.model.vo.subjects.PersonVo;

@Service
public class HelperPersonService {
	
	@Autowired
	private GenderDao filterDao;
	
	public PersonVo personDtoToPersonVo(PersonDto person) {
		PersonVo respPerson = new PersonVo();
		respPerson.setId(person.getId());
		respPerson.setHighlight(person.isHighlight());
		respPerson.setSurname(person.getSurname());
		respPerson.setDocument(person.getDocument());
		respPerson.setTypeDocument(person.getTypeDocument());
		respPerson.setNickname(person.getNickname());
		respPerson.setJob(person.getJob());
		respPerson.setProfession(person.getProfession());
		respPerson.setKids(person.isKids());
		respPerson.setKidsNames(person.getKidsNames());
		respPerson.setDisability(person.isDisability());
		respPerson.setDisabilityName(person.getDisabilityName());
		respPerson.setName(person.getName());
		respPerson.setEmail(person.getEmail());
		respPerson.setBirthday(person.getBirthday());
		respPerson.setDiscord(person.getDiscord());
		respPerson.setFacebook(person.getFacebook());
		respPerson.setInstagram(person.getInstagram());
		respPerson.setTwitter(person.getTwitter());
		respPerson.setPhone(person.getPhone());
		respPerson.setGender(getGenderDto(person.getGender()));
		return respPerson;
	}

	private GenderVo getGenderDto(String gender) {
		GenderVo gVo = filterDao.findByCode(gender);
		System.out.println(gVo);
		return gVo;
	}


	
}
