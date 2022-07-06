package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.Interest;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class InterestVo extends GenericFilterVo{
	
	public InterestVo() {}
	
	public InterestVo(Filterable filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
		setCode(filter.getCode());
	}
	
	public InterestVo(String name, boolean active, String code) {
		setName(name);
		setActive(active);
		setCode(code);
	}

	public static InterestVo createVo(Filterable filter) {
		if (filter != null) {
			return new InterestVo(filter);
		}
		return null;
	}
	
	public static List<GenericFilterVo> createListVo(List<Interest> interests){
		if (interests!= null) {
			return interests.stream().map(InterestVo::new).collect(Collectors.toList());
		}
		return null;
	}
	
	public static List<InterestVo> createListInterestsVo(List<Interest> interests){
		if (interests!= null) {
			return interests.stream().map(filter -> new InterestVo(filter)).collect(Collectors.toList());
		}
		return null;
	}
	
	public static InterestVo createVo(String name, boolean active, String code) {
		if (name != null) {
			return new InterestVo(name, active, code);
		}
		return null;
	}
	
}
