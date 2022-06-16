package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.Ideology;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class IdeologyVo extends GenericFilterVo {
	
	public IdeologyVo() {}
	
	public IdeologyVo(Filterable filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
		setCode(filter.getCode());
	}
	
	public IdeologyVo(String name, boolean active, String code) {
		setName(name);
		setActive(active);
		setCode(code);
	}

	public static IdeologyVo createVo(Filterable filter) {
		if (filter != null) {
			return new IdeologyVo(filter);
		}
		return null;
	}
	
	public static List<GenericFilterVo> createListVo(List<Ideology> list){
		if (list!= null) {
			return list.stream().map(IdeologyVo::new).collect(Collectors.toList());
		}
		return null;
	}

	public static IdeologyVo createVo(String name, boolean active, String code) {
		if (name != null) {
			return new IdeologyVo(name, active, code);
		}
		return null;
	}
	
}
