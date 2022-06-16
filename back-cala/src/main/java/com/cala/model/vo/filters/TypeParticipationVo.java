package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.TypeParticipation;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class TypeParticipationVo extends GenericFilterVo{
	
	public TypeParticipationVo() {}
	
	public TypeParticipationVo(Filterable filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
		setCode(filter.getCode());
	}
	
	public TypeParticipationVo(String name, boolean active, String code) {
		setName(name);
		setActive(active);
		setCode(code);
	}

	public static TypeParticipationVo createVo(Filterable filter) {
		if (filter != null) {
			return new TypeParticipationVo(filter);
		}
		return null;
	}
	
	public static List<GenericFilterVo> createListVo(List<TypeParticipation> types){
		if (types!= null) {
			return types.stream().map(TypeParticipationVo::new).collect(Collectors.toList());
		}
		return null;
	}

	public static TypeParticipationVo createVo(String name, boolean active, String code) {
		if (name != null) {
			return new TypeParticipationVo(name, active, code);
		}
		return null;
	}

}