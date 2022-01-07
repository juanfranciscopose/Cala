package com.cala.dao.filters;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.model.entities.filters.TypeInstitution;
import com.cala.model.vo.filters.TypeInstitutionVo;

class TypeInstitutionDaoTest extends FilterDaoTest<TypeInstitutionDao, TypeInstitution, TypeInstitutionVo>{

	@Override
	public TypeInstitution create(String name, boolean active) {
		return new TypeInstitution(name, active);
	}

	@Override
	public TypeInstitutionVo createVo(TypeInstitution filter) {
		return TypeInstitutionVo.createVo(filter);
	}


}
