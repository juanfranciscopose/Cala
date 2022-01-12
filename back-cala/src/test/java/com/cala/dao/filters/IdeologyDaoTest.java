package com.cala.dao.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.Ideology;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.IdeologyVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.IdeologyFilterRepository;

class IdeologyDaoTest extends FilterDaoTest<IdeologyDao, IdeologyVo>{
	@Autowired
	private IdeologyFilterRepository ideologyRepository;
	
	@Autowired
	private I_FilterDao<IdeologyVo> ideologyDao;
	
	@Override
	public Ideology create(String name, boolean active) {
		return new Ideology(name, active);
	}

	@Override
	public IdeologyVo createVo(Filterable filter) {
		return IdeologyVo.createVo(filter);
	}

	@Override
	public void delete(Filterable filter) {
		ideologyRepository.delete((Ideology) filter);
	}

	@Override
	public List<GenericFilterVo> getAll(PaginationVo pagination) {
		return ideologyDao.getAll(pagination);
	}

	@Override
	public Filterable findByName(String name) {
		return ideologyRepository.findByName(name).get();
	}
	
	
}
