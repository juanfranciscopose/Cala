package com.cala.controller.filters;

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

import com.cala.exceptions.AppBussinessValidationException;
import com.cala.exceptions.AppDataTypeValidationException;
import com.cala.model.dto.filters.FilterDto;
import com.cala.model.dto.global.ResponseDto;
import com.cala.service.filters.I_FilterService;
import com.cala.util.messages.MessageError;

@RestController
@CrossOrigin
@RequestMapping(path="/filters") 
public class FilterController {
	
	private static final Logger logger = LoggerFactory.getLogger(FilterController.class);
	
	@Autowired
	private I_FilterService filterService;
	
	@PostMapping("/{type}/create")
	public ResponseEntity<?> create(@PathVariable("type") String type, @RequestBody FilterDto filter){
		try {
			logger.info("Servicio: /filter/"+type+"/create -> FilterDto: " + filter.generateLog(type));
			FilterDto filterDto = getFilterService().store(type, filter);
			return new ResponseEntity<>(ResponseDto.ok(filterDto), HttpStatus.CREATED);
		}catch (AppDataTypeValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (AppBussinessValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(ResponseDto.error(MessageError.msgErrorCreateGenericFilter(type)), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PutMapping("/{type}/update")
	public ResponseEntity<?> update(@PathVariable("type") String type, @RequestBody FilterDto filter) {
		logger.info("Servicio: /filter/"+type+"/update -> FilterDto: " + filter.generateLog(type));
		FilterDto filterDto = getFilterService().edit(type, filter);
		return new ResponseEntity<>(ResponseDto.ok(filterDto), HttpStatus.OK);
	}

	@GetMapping("/{type}/list") 
	public ResponseEntity<?> list(@PathVariable("type") String type, @RequestParam int size, @RequestParam int page) {
		logger.info("Servicio: /filter/"+type+"/list");
		Optional<List<FilterDto>> list = getFilterService().findAll(type, size, page);
		if (!list.isEmpty()) {
			return new ResponseEntity<>(ResponseDto.ok(list.get()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{type}/delete/{id}")
	public ResponseEntity<?> remove(@PathVariable("type") String type, @PathVariable("id") Long id) {
		try {
			logger.info("Servicio: /filter/"+type+"/delete -> id: " + id);
			FilterDto filterDto = getFilterService().delete(type, id);
			return new ResponseEntity<>(ResponseDto.ok(filterDto), HttpStatus.OK);
		} catch (AppDataTypeValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (AppBussinessValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(ResponseDto.error(MessageError.msgErrorDeleteGenericFilter(type)), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{type}/find/{id}")
	public ResponseEntity<?> findById(@PathVariable("type") String type, @PathVariable("id") Long id) {
		try {
			logger.info("Servicio: /filter/"+type+"/find -> id: " + id);
			Optional<FilterDto> filterDto = getFilterService().findById(type, id);
			if (filterDto.isPresent()) {
				return new ResponseEntity<>(ResponseDto.ok(filterDto.get()), HttpStatus.OK);
			}
			return new ResponseEntity<>(ResponseDto.ok(), HttpStatus.NO_CONTENT);
		}catch (AppDataTypeValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (AppBussinessValidationException e) {
			return new ResponseEntity<>(ResponseDto.error(e.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public I_FilterService getFilterService() {
		return filterService;
	}

}
