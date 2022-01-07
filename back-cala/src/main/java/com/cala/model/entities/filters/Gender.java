package com.cala.model.entities.filters;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.GenderVo;

@Entity
@DiscriminatorValue(value = "GENDER")
public class Gender extends GenericFilter implements Auditable{
	
	public Gender() {}
	
	public Gender(GenderVo genderVo) {
		setName(genderVo.getName());
		setActive(genderVo.isActive());
	}
	
	public Gender(String gender, boolean active) {
		setName(gender);
		setActive(active);
	}

	@Override
	public String generateLog(String method) {
		return method + " ->" + " {id:" + getId() + ", género:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static Gender create(GenderVo gender) {
		if (gender != null) {
			return new Gender(gender);
		}
		return null;
	}

}
