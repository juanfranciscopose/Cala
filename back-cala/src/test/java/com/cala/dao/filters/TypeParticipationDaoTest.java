package com.cala.dao.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.TypeParticipation;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.TypeParticipationVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.TypeParticipationFilterRepository;

class TypeParticipationDaoTest extends FilterDaoTest<TypeParticipationDao, TypeParticipationVo>{
	@Autowired
	private TypeParticipationFilterRepository repository;
	
	@Autowired
	private I_FilterDao<TypeParticipationVo> dao;
	
	@Override
	public TypeParticipation create(String name, boolean active, String code) {
		return new TypeParticipation(name, active, code); 
	}

	@Override
	public TypeParticipationVo createVo(Filterable filter) {
		return TypeParticipationVo.createVo(filter);
	}

	@Override
	public void delete(Filterable filter) {
		repository.delete((TypeParticipation) filter);
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
