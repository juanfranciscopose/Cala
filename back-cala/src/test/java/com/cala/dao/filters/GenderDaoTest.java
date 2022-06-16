package com.cala.dao.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.Gender;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.GenderVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.GenderFilterRepository;

class GenderDaoTest extends FilterDaoTest<GenderDao, GenderVo> {
	@Autowired
	private GenderFilterRepository genderRepository;
	
	@Autowired
	private I_FilterDao<GenderVo> genderDao;
	
	@Override
	public Gender create(String name, boolean active, String code) {
		return new Gender(name, active, code);
	}

	@Override
	public GenderVo createVo(Filterable filter) {
		return GenderVo.createVo(filter);
	}

	@Override
	public void delete(Filterable filter) {
		genderRepository.delete((Gender) filter);		
	}

	@Override
	public List<GenericFilterVo> getAll(PaginationVo pagination) {
		return genderDao.getAll(pagination);
	}


	@Override
	public Filterable findByName(String name) {
		return genderRepository.findByName(name).get();
	}
	
}
