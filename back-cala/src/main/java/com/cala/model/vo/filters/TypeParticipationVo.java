package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.TypeParticipation;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class TypeParticipationVo extends GenericFilterVo{
	
	public TypeParticipationVo() {}
	
	public TypeParticipationVo(GenericFilter filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
	}
	
	public static TypeParticipationVo createVo(GenericFilter filter) {
		if (filter != null) {
			return new TypeParticipationVo(filter);
		}
		return null;
	}
	
	public static List<TypeParticipationVo> createListVo(List<TypeParticipation> types){
		if (types!= null) {
			return types.stream().map(TypeParticipationVo::new).collect(Collectors.toList());
		}
		return null;
	}

}