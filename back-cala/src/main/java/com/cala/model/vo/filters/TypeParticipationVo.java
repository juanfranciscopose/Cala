package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class TypeParticipationVo extends GenericFilterVo{
	
	public TypeParticipationVo() {}
	
	public TypeParticipationVo(Filterable filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
	}
	
	public TypeParticipationVo(String name, boolean active) {
		setName(name);
		setActive(active);
	}

	public static TypeParticipationVo createVo(Filterable filter) {
		if (filter != null) {
			return new TypeParticipationVo(filter);
		}
		return null;
	}
	
	public static List<TypeParticipationVo> createListVo(List<Filterable> types){
		if (types!= null) {
			return types.stream().map(TypeParticipationVo::new).collect(Collectors.toList());
		}
		return null;
	}

	public static TypeParticipationVo createVo(String name, boolean active) {
		if (name != null) {
			return new TypeParticipationVo(name, active);
		}
		return null;
	}

}