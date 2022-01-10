package com.cala.service.filters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cala.exceptions.AppBussinessValidationException;
import com.cala.exceptions.AppDataTypeValidationException;
import com.cala.model.dto.filters.FilterDto;
import com.cala.model.vo.filters.generics.GenericFilterVo;

@Service
public class FilterService implements I_FilterService {
	
	@Autowired
	private HelperFilterService helperFilterService;
	
	@Override
	public FilterDto store(String type, FilterDto filterDto) throws AppDataTypeValidationException, AppBussinessValidationException {		
		// data types validations
		getHelperFilterService().validateDataType(filterDto);
		
		// identify type, business validations and generate filter on DB
		GenericFilterVo filter = getHelperFilterService().generateFilter(type, filterDto);
		
		// create dto for response
		return new FilterDto(filter.getId(), filter.getName(), filter.isActive());
	}

	@Override
	public FilterDto edit(String type, FilterDto filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<FilterDto>> findAll(String type, int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilterDto delete(String type, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FilterDto> findById(String type, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public HelperFilterService getHelperFilterService() {
		return helperFilterService;
	}

}
