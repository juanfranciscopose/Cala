package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.TypeJob;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class TypeJobVo extends GenericFilterVo {
	
	public TypeJobVo() {}
	
	public TypeJobVo(Filterable filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
	}
	
	public TypeJobVo(String name, boolean active) {
		setName(name);
		setActive(active);
	}

	public static TypeJobVo createVo(Filterable filter) {
		if (filter != null) {
			return new TypeJobVo(filter);
		}
		return null;
	}
	
	public static List<GenericFilterVo> createListVo(List<TypeJob> types){
		return types.stream().map(TypeJobVo::new).collect(Collectors.toList());
	}

	public static TypeJobVo createVo(String name, boolean active) {
		if (name != null) {
			return new TypeJobVo(name, active);
		}
		return null;
	}

}

