package com.cala.model.entities.filters;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.cala.model.entities.audit.Auditable;
import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.TypeInstitutionVo;

@Entity
@DiscriminatorValue(value = "TYPE_INSTITUTION")
public class TypeInstitution extends GenericFilter implements Auditable{
	
	public TypeInstitution () {}
	
	public TypeInstitution(String name, boolean active) {
		setName(name);
		setActive(active);
	}

	public TypeInstitution(TypeInstitutionVo filterVo) {
		setName(filterVo.getName());
		setActive(filterVo.isActive());
	}
	
	@Override
	public String generateLog(String method) {
		return method + " ->" + " {id:" + getId() + ", tipo de institución:" + getName() + ", activo: " + activeToString() + "}";
	}
	
	public static List<TypeInstitution> createList(List<TypeInstitutionVo> list) {
		return list.stream().map(filter -> new TypeInstitution(filter)).collect(Collectors.toList());
	}
	
}
