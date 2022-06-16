package com.cala.dao.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.NexusManagement;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.NexusManagementVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.NexusManagementFilterRepository;

class NexusManagementDaoTest extends FilterDaoTest<NexusManagementDao, NexusManagementVo>{
	@Autowired
	private NexusManagementFilterRepository repository;
	
	@Autowired
	private I_FilterDao<NexusManagementVo> dao;
	
	@Override
	public NexusManagement create(String name, boolean active, String code) {
		return new NexusManagement(name, active, code);
	}

	@Override
	public NexusManagementVo createVo(Filterable filter) {
		return NexusManagementVo.createVo(filter);
	}

	@Override
	public void delete(Filterable filter) {
		repository.delete((NexusManagement) filter);
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
