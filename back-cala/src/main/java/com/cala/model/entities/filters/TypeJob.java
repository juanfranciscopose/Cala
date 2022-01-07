package com.cala.model.entities.filters;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.TypeJobVo;

@Entity
@DiscriminatorValue(value = "TYPE_JOB")
public class TypeJob extends GenericFilter implements Auditable {
	
	public TypeJob() {}
	
	public TypeJob(String name, boolean active) {
		setName(name);
		setActive(active);
	}
	
	public TypeJob(TypeJobVo filterVo) {
		setName(filterVo.getName());
		setActive(filterVo.isActive());
	}
	
	@Override
	public String generateLog(String method) {
		return method + " ->" + " {id:" + getId() + ", tipo de empleo:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static TypeJob create(TypeJobVo typeJobVo) {
		if (typeJobVo != null) {
			return new TypeJob(typeJobVo);
		}
		return null;
	}

}
