package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class NexusManagementVo extends GenericFilterVo{
	
	public NexusManagementVo() {}
	
	public NexusManagementVo(Filterable filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
	}

	public NexusManagementVo(String name, boolean active) {
		setName(name);
		setActive(active);
	}

	public static NexusManagementVo createVo(Filterable filter) {
		if (filter != null) {
			return new NexusManagementVo(filter);
		}
		return null;
	}
	
	public static List<NexusManagementVo> createListVo(List<Filterable> list){
		if (list!= null) {
			return list.stream().map(filter -> new NexusManagementVo(filter)).collect(Collectors.toList());
		}
		return null;
	}

	public static NexusManagementVo createVo(String name, boolean active) {
		if (name != null) {
			return new NexusManagementVo(name, active);
		}
		return null;
	}

}
