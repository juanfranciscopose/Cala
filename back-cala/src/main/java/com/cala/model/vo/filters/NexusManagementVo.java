package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.NexusManagement;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class NexusManagementVo extends GenericFilterVo{
	
	public NexusManagementVo() {}
	
	public NexusManagementVo(Filterable filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
		setCode(filter.getCode());
	}

	public NexusManagementVo(String name, boolean active, String code) {
		setName(name);
		setActive(active);
		setCode(code);
	}

	public static NexusManagementVo createVo(Filterable filter) {
		if (filter != null) {
			return new NexusManagementVo(filter);
		}
		return null;
	}
	
	public static List<GenericFilterVo> createListVo(List<NexusManagement> list){
		if (list!= null) {
			return list.stream().map(filter -> new NexusManagementVo(filter)).collect(Collectors.toList());
		}
		return null;
	}

	public static NexusManagementVo createVo(String name, boolean active, String code) {
		if (name != null) {
			return new NexusManagementVo(name, active, code);
		}
		return null;
	}

}
