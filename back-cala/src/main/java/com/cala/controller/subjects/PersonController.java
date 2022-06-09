package com.cala.controller.subjects;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cala.controller.abm.I_GenericAbmController;
import com.cala.exceptions.AppBussinessValidationException;
import com.cala.exceptions.AppDataTypeValidationException;
import com.cala.model.dto.global.ResponseDto;
import com.cala.model.dto.subjects.PersonDto;
import com.cala.service.subjects.I_PersonService;
import com.cala.util.messages.MessageError;

@RestController
@CrossOrigin
@RequestMapping(path="/people") 
public class PersonController implements I_GenericAbmController<PersonDto>{
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private I_PersonService personService;
	
	@PostMapping("/create")
	@Override
	public ResponseEntity<?> create(@RequestBody PersonDto person) {
		try {
			logger.info("Servicio: /people/create -> PersonDto: " + person.generateLog());
			PersonDto personDto = getPersonService().store(person);
			return new ResponseEntity<>(ResponseDto.ok(personDto), HttpStatus.CREATED);
		}catch (AppDataTypeValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (AppBussinessValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(ResponseDto.error(MessageError.ERR_CREATE_PERSON_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updatePerson")
	@Override
	public ResponseEntity<?> update(@RequestBody PersonDto person) {
		try {
			logger.info("Servicio: /people/updatePerson -> PersonDto: " + person.generateLog());
			PersonDto personDto = getPersonService().edit(person);
			return new ResponseEntity<>(ResponseDto.ok(personDto), HttpStatus.OK);
		} catch (AppDataTypeValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (AppBussinessValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(ResponseDto.error(MessageError.ERR_UPDATE_PERSON_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//no tiene sentido listar todo, es mucho. primero los highlight,
	//desp todos ordenados por apellido y nombre. Tabla inicial
	@GetMapping("/listAll") 
	public ResponseEntity<?> list(@RequestParam int size, @RequestParam int page){	
		try {
			logger.info("Servicio: /people/listAll");
			List<PersonDto> list = getPersonService().findAll(null, size, page);
			if (!list.isEmpty()) {
				return new ResponseEntity<>(ResponseDto.ok(list), HttpStatus.OK);
			}
			return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.NO_CONTENT);
		} catch (AppDataTypeValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (AppBussinessValidationException e) {
		 	return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete")
	@Override
	public ResponseEntity<?> remove(@PathVariable("id") Long id) {
		try {
			logger.info("Servicio: /people/delete -> id: " + id);
			PersonDto personDto = getPersonService().remove(id);
			return new ResponseEntity<>(ResponseDto.ok(personDto), HttpStatus.ACCEPTED);
		} catch (AppDataTypeValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (AppBussinessValidationException e) {
		 	return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(ResponseDto.error(MessageError.ERR_DELETE_PERSON_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateFilters")
	public ResponseEntity<?> updateFilters(@RequestBody PersonDto person) {
		try {
			logger.info("Servicio: /people/updateFilters -> PersonDto: " + person.generateLog());
			Optional<PersonDto> personDto = getPersonService().updateFilters(person);
			return new ResponseEntity<>(ResponseDto.ok(personDto.get()), HttpStatus.OK);
		} catch (AppDataTypeValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (AppBussinessValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(ResponseDto.error(MessageError.ERR_UPDATE_PERSON_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/findById")
	@Override
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			logger.info("Servicio: /people/find -> id: " + id);
			Optional<PersonDto> personDto = getPersonService().findById(id);
			if (personDto.isPresent()) {
				return new ResponseEntity<>(ResponseDto.ok(personDto.get()), HttpStatus.OK);
			}
			return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.NO_CONTENT);
		}catch (AppDataTypeValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (AppBussinessValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/addPersonsTest")
	public ResponseEntity<?> addPersonsTest() {
		logger.info("Servicio: /people/addPersonsTest");
		getPersonService().addPersonsTest();
		return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.OK);
	}
	
	public I_PersonService getPersonService() {
		return personService;
	}
	
}
