package com.cala.service.filters;

import java.util.List;
import java.util.Optional;

import com.cala.exceptions.AppBussinessValidationException;
import com.cala.exceptions.AppDataTypeValidationException;
import com.cala.model.dto.filters.FilterDto;

public interface I_FilterService {

	public FilterDto store(String type, FilterDto filter) throws AppDataTypeValidationException, AppBussinessValidationException;

	public FilterDto edit(String type, FilterDto filter) throws AppDataTypeValidationException, AppBussinessValidationException;

	public List<FilterDto> findAll(String type, int size, int page) throws AppDataTypeValidationException, AppBussinessValidationException;

	public FilterDto delete(String type, Long id) throws AppDataTypeValidationException, AppBussinessValidationException;

	public Optional<FilterDto> findById(String type, Long id) throws AppBussinessValidationException, AppDataTypeValidationException;

	public FilterDto activate(String type, Long id) throws AppDataTypeValidationException, AppBussinessValidationException;

}
