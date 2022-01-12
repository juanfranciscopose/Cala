package com.cala.dao.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.Topic;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.TopicVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.TopicFilterRepository;

class TopicDaoTest extends FilterDaoTest<TopicDao, TopicVo>{
	@Autowired
	private I_FilterDao<TopicVo> dao;
	
	@Autowired
	private TopicFilterRepository repository;
	
	@Override
	public Topic create(String name, boolean active) {
		return new Topic(name, active);
	}

	@Override
	public TopicVo createVo(Filterable filter) {
		return TopicVo.createVo(filter);
	}

	@Override
	public void delete(Filterable filter) {
		repository.delete((Topic) filter);
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
