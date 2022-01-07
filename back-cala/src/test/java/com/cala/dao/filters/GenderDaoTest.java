package com.cala.dao.filters;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.model.entities.filters.Gender;
import com.cala.model.vo.filters.GenderVo;

class GenderDaoTest extends FilterDaoTest<GenderDao, Gender, GenderVo> {

	@Override
	public Gender create(String name, boolean active) {
		return new Gender(name, active);
	}

	@Override
	public GenderVo createVo(Gender filter) {
		return GenderVo.createVo(filter);
	}
	
}
