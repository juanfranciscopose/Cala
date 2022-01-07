package com.cala.dao.filters;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.model.entities.filters.TypeJob;
import com.cala.model.vo.filters.TypeJobVo;

class TypeJobDaoTest extends FilterDaoTest<TypeJobDao, TypeJob, TypeJobVo>{

	@Override
	public TypeJob create(String name, boolean active) {
		return new TypeJob(name, active);
	}

	@Override
	public TypeJobVo createVo(TypeJob filter) {
		return TypeJobVo.createVo(filter);
	}

	
}
