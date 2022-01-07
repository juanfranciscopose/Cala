package com.cala.dao.filters;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.model.entities.filters.Ideology;
import com.cala.model.vo.filters.IdeologyVo;

class IdeologyDaoTest extends FilterDaoTest<IdeologyDao, Ideology, IdeologyVo>{

	@Override
	public Ideology create(String name, boolean active) {
		return new Ideology(name, active);
	}

	@Override
	public IdeologyVo createVo(Ideology filter) {
		return IdeologyVo.createVo(filter);
	}
	
	
}
