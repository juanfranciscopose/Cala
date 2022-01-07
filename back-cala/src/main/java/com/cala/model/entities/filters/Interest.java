package com.cala.model.entities.filters;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.InterestVo;

@Entity
@DiscriminatorValue(value = "INTEREST")
public class Interest extends GenericFilter implements Auditable{
		
	public Interest() {}
	
	public Interest(String name, boolean active) {
		setName(name);
		setActive(active);
	}
	
	public Interest(InterestVo filterVo) {
		setName(filterVo.getName());
		setActive(filterVo.isActive());
	}
	
	@Override
	public String generateLog() {
		return "{id:" + getId() + ", interés:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static List<Interest> createList(List<InterestVo> list) {
		if (list!= null) {
			return list.stream().map(filter -> new Interest(filter)).collect(Collectors.toList());
		}
		return null;
	}

}
