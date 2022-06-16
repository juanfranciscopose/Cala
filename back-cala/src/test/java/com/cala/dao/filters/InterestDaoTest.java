package com.cala.dao.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.Interest;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.InterestVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.InterestFilterRepository;

class InterestDaoTest extends FilterDaoTest<InterestDao, InterestVo> {
	@Autowired
	private I_FilterDao<InterestVo> interestDao;
	
	@Autowired
	private InterestFilterRepository interestRepository;
	
	@Override
	public Interest create(String name, boolean active, String code) {
		return new Interest(name, active, code);
	}

	@Override
	public InterestVo createVo(Filterable filter) {
		return InterestVo.createVo(filter);
	}

	@Override
	public void delete(Filterable filter) {
		interestRepository.delete((Interest) filter);
	}

	@Override
	public List<GenericFilterVo> getAll(PaginationVo pagination) {
		return interestDao.getAll(pagination);
	}

	@Override
	public Filterable findByName(String name) {
		return interestRepository.findByName(name).get();
	}
	
}
