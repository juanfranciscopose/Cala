package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.Interest;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class InterestVo extends GenericFilterVo{
	
	public InterestVo() {}
	
	public InterestVo(GenericFilter filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
	}
	
	public InterestVo(String name, boolean active) {
		setName(name);
		setActive(active);
	}

	public static InterestVo createVo(GenericFilter filter) {
		if (filter != null) {
			return new InterestVo(filter);
		}
		return null;
	}
	
	public static List<InterestVo> createListVo(List<Interest> interests){
		if (interests!= null) {
			return interests.stream().map(InterestVo::new).collect(Collectors.toList());
		}
		return null;
	}

	public static InterestVo createVo(String name, boolean active) {
		if (name != null) {
			return new InterestVo(name, active);
		}
		return null;
	}
	
}
