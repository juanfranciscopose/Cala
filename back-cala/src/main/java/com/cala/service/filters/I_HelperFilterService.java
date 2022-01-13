package com.cala.service.filters;

import java.util.List;

import com.cala.exceptions.AppBussinessValidationException;
import com.cala.exceptions.AppDataTypeValidationException;
import com.cala.model.dto.filters.FilterDto;
import com.cala.model.vo.filters.generics.GenericFilterVo;


public interface I_HelperFilterService {

	public GenericFilterVo activateFilter(String type, Long id) throws AppBussinessValidationException;
	
	public void validateDataTypeForEdition(FilterDto filter) throws AppDataTypeValidationException;
	
	public GenericFilterVo updateFilter(String type, FilterDto filter) throws AppBussinessValidationException;
	
	public void validateDataTypeForFindAll(int size, int page) throws AppDataTypeValidationException;
	
	public List<GenericFilterVo> findAllFilters(String type, int size, int page) throws AppBussinessValidationException;
	
	public void validateDataTypeId(Long id) throws AppDataTypeValidationException;
	
	public GenericFilterVo findByIdFilter(String type, Long id) throws AppBussinessValidationException;

	public GenericFilterVo deleteFilter(String type, Long id) throws AppBussinessValidationException;

	public void validateDataTypeForCreation(FilterDto filter) throws AppDataTypeValidationException;

	public GenericFilterVo generateFilter(String type, FilterDto filterDto) throws AppBussinessValidationException;

}
