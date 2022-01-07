package com.cala.model.entities.filters;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.IdeologyVo;

@Entity
@DiscriminatorValue(value = "IDEOLOGY")
public class Ideology extends GenericFilter implements Auditable{

	public Ideology() {}
	
	public Ideology(String name, boolean active) {
		setName(name);
		setActive(active);
	}

	public Ideology(IdeologyVo filterVo) {
		setName(filterVo.getName());
		setActive(filterVo.isActive());
	}
	
	@Override
	public String generateLog() {
		return "{id:" + getId() + ", ideología:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static List<Ideology> createList(List<IdeologyVo> list) {
		if (list!= null) {
			return list.stream().map(filter -> new Ideology(filter)).collect(Collectors.toList());
		}
		return null;
	}

}
