package com.cala.dao.filters;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.model.entities.filters.TypeParticipation;
import com.cala.model.vo.filters.TypeParticipationVo;

class TypeParticipationDaoTest extends FilterDaoTest<TypeParticipationDao, TypeParticipation, TypeParticipationVo>{

	@Override
	public TypeParticipation create(String name, boolean active) {
		return new TypeParticipation(name, active); 
	}

	@Override
	public TypeParticipationVo createVo(TypeParticipation filter) {
		return TypeParticipationVo.createVo(filter);
	}

}
