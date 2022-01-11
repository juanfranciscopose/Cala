package com.cala.model.vo.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.filters.TypeInstitution;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.generics.GenericFilterVo;

public class TypeInstitutionVo extends GenericFilterVo {

	public TypeInstitutionVo() {}
	
	public TypeInstitutionVo(Filterable filter) {
		setId(filter.getId());
		setName(filter.getName());
		setActive(filter.isActive());
	}

	public TypeInstitutionVo(String name, boolean active) {
		setName(name);
		setActive(active);
	}

	public static TypeInstitutionVo createVo(Filterable filter) {
		if (filter != null) {
			return new TypeInstitutionVo(filter);
		}
		return null;
	}
	
	public static List<GenericFilterVo> createListVo(List<TypeInstitution> types){
		return types.stream().map(filter -> new TypeInstitutionVo(filter)).collect(Collectors.toList());
	}

	public static TypeInstitutionVo createVo(String name, boolean active) {
		if (name != null) {
			return new TypeInstitutionVo(name, active);
		}
		return null;
	}
	
}