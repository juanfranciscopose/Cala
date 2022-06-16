package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.Gender;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class GenderVo extends GenericFilterVo{
	
	public GenderVo() {}
	
	public GenderVo(Filterable filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
		setCode(filter.getCode());
	}

	public GenderVo(String gender, boolean active, String code) {
		setName(gender);
		setActive(active);
		setCode(code);
	}
	
	public static List<GenericFilterVo> createListVo(List<Gender> list) {
		if (list!= null) {
			return list.stream().map(filter -> new GenderVo(filter)).collect(Collectors.toList());
		}
		return null;
	}

	public static GenderVo createVo(Filterable filter) {
		if (filter != null) {
			return new GenderVo(filter);
		}
		return null;
	}
	
	public static GenderVo createVo(String name, boolean active, String code) {
		if (name != null) {
			return new GenderVo(name, active, code);
		}
		return null;
	}
	
}
