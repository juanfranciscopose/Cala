package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.Gender;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class GenderVo extends GenericFilterVo{
	
	public GenderVo() {}
	
	public GenderVo(GenericFilter filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
	}

	public GenderVo(String gender, boolean active) {
		setName(gender);
		setActive(active);
	}
	
	public static List<GenderVo> createListVo(List<Gender> list) {
		if (list!= null) {
			return list.stream().map(filter -> new GenderVo(filter)).collect(Collectors.toList());
		}
		return null;
	}

	public static GenderVo createVo(GenericFilter filter) {
		if (filter != null) {
			return new GenderVo((Gender) filter);
		}
		return null;
	}
	
}
