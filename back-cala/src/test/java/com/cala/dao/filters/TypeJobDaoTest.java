package com.cala.dao.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.TypeJob;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.TypeJobVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.TypeJobFilterRepository;

class TypeJobDaoTest extends FilterDaoTest<TypeJobDao, TypeJobVo>{
	@Autowired
	private TypeJobFilterRepository repository;
	
	@Autowired
	private I_FilterDao<TypeJobVo> dao;
	
	@Override
	public TypeJob create(String name, boolean active) {
		return new TypeJob(name, active);
	}

	@Override
	public TypeJobVo createVo(Filterable filter) {
		return TypeJobVo.createVo(filter);
	}
	@Override
	public void delete(Filterable filter) {
		repository.delete((TypeJob) filter);
	}

	@Override
	public List<GenericFilterVo> getAll(PaginationVo pagination) {
		return dao.getAll(pagination);
	}

	@Override
	public Filterable findByName(String name) {
		return repository.findByName(name).get();
	}
	
}
