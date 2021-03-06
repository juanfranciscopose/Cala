package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.NexusManagement;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class NexusManagementVo extends GenericFilterVo{
	
	public NexusManagementVo() {}
	
	public NexusManagementVo(GenericFilter filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
	}

	public static NexusManagementVo createVo(GenericFilter filter) {
		if (filter != null) {
			return new NexusManagementVo(filter);
		}
		return null;
	}
	
	public static List<NexusManagementVo> createListVo(List<NexusManagement> list){
		if (list!= null) {
			return list.stream().map(filter -> new NexusManagementVo(filter)).collect(Collectors.toList());
		}
		return null;
	}

}
