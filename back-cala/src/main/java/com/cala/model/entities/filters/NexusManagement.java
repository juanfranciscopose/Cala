package com.cala.model.entities.filters;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.NexusManagementVo;

@Entity
@DiscriminatorValue(value = "NEXUS_MANAGEMENT")
public class NexusManagement extends GenericFilter  implements Auditable{
	
	public NexusManagement() {}
	
	public NexusManagement(String name, boolean active) {
		setName(name);
		setActive(active);
	}
	
	public NexusManagement(NexusManagementVo filterVo) {
		setName(filterVo.getName());
		setActive(filterVo.isActive());
	}
	
	@Override
	public String generateLog(String method) {
		return method + " ->" + " {id:" + getId() + ", nexo de gestión:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static List<NexusManagement> createList(List<NexusManagementVo> list) {
		if(list != null) {
			return list.stream().map(filter -> new NexusManagement(filter)).collect(Collectors.toList());
		}
		return null;
	}
	
}
