package com.cala.dao.filters;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.model.entities.filters.Interest;
import com.cala.model.vo.filters.InterestVo;

class InterestDaoTest extends FilterDaoTest<InterestDao, Interest, InterestVo> {

	@Override
	public Interest create(String name, boolean active) {
		return new Interest(name, active);
	}

	@Override
	public InterestVo createVo(Interest filter) {
		return InterestVo.createVo(filter);
	}
	
}
