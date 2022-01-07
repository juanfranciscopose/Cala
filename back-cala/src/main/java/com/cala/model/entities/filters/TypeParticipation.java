package com.cala.model.entities.filters;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.TypeParticipationVo;

@Entity
@DiscriminatorValue(value = "TYPE_PARTICIPATION")
public class TypeParticipation extends GenericFilter implements Auditable{

	public TypeParticipation () {}
	
	public TypeParticipation(String name, boolean active) {
		setName(name);
		setActive(active);
	}
	
	public TypeParticipation(TypeParticipationVo filterVo) {
		setName(filterVo.getName());
		setActive(filterVo.isActive());
	}
	
	@Override
	public String generateLog() {
		return "{id:" + getId() + ", tipo de participación:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static List<TypeParticipation> createList(List<TypeParticipationVo> list) {
		if (list!= null) {
			return list.stream().map(filter -> new TypeParticipation(filter)).collect(Collectors.toList());
		}
		return null;
	}
		
}
