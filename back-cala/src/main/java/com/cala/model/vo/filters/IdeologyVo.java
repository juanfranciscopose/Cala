package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.Ideology;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class IdeologyVo extends GenericFilterVo {
	
	public IdeologyVo() {}
	
	public IdeologyVo(GenericFilter filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
	}
	
	public IdeologyVo(String name, boolean active) {
		setName(name);
		setActive(active);
	}

	public static IdeologyVo createVo(GenericFilter filter) {
		if (filter != null) {
			return new IdeologyVo(filter);
		}
		return null;
	}
	
	public static List<IdeologyVo> createListVo(List<Ideology> list){
		if (list!= null) {
			return list.stream().map(IdeologyVo::new).collect(Collectors.toList());
		}
		return null;
	}

	public static IdeologyVo createVo(String name, boolean active) {
		if (name != null) {
			return new IdeologyVo(name, active);
		}
		return null;
	}
	
}
