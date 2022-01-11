package com.cala.service.filters;

import java.util.ArrayList;
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
		getHelperFilterService().validateDataTypeForCreation(filterDto);
		
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
	public List<FilterDto> findAll(String type, int size, int page) throws AppDataTypeValidationException, AppBussinessValidationException {
		// data types validations
		getHelperFilterService().validateDataTypeForFindAll(size, page);
				
		// identify type and get all filters from DB
		List<GenericFilterVo> filter = getHelperFilterService().findAllFilters(type, size, page);
						
		// create dto for response
		List<FilterDto> listDto = new ArrayList<>();
		for (GenericFilterVo f : filter) {
			listDto.add(new FilterDto(f.getId(), f.getName(), f.isActive()));
		}
		return listDto;
	}

	@Override
	public FilterDto delete(String type, Long id) throws AppBussinessValidationException, AppDataTypeValidationException {
		// data types validations
		getHelperFilterService().validateDataTypeForRemove(id);
		
		// identify type, business validations and delete filter on DB
		GenericFilterVo filter = getHelperFilterService().deleteFilter(type, id);
				
		// create dto for response
		return new FilterDto(filter.getId(), filter.getName(), filter.isActive());
	}

	@Override
	public Optional<FilterDto> findById(String type, Long id)  throws AppBussinessValidationException, AppDataTypeValidationException  {
		// data types validations
		getHelperFilterService().validateDataTypeForFindById(id);
				
		// identify type, business validations and find filter on DB
		GenericFilterVo filter = getHelperFilterService().findByIdFilter(type, id);
						
		// create dto for response
		return Optional.of(new FilterDto(filter.getId(), filter.getName(), filter.isActive()));
	}

	public HelperFilterService getHelperFilterService() {
		return helperFilterService;
	}

}
