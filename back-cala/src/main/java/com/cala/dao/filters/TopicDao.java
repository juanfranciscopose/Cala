package com.cala.dao.filters;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.Topic;
import com.cala.model.vo.filters.TopicVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.TopicFilterRepository;

@Repository
public class TopicDao implements I_FilterDao<TopicVo>{

	private static final Logger logger = LoggerFactory.getLogger(TopicDao.class);

	@Autowired
	private TopicFilterRepository repository;
	
	public TopicFilterRepository getRepository() {
		return repository;
	}
	
	@Override
	public TopicVo enable(Long id) {
		return activeAction(id, true);
	}

	@Override
	public TopicVo disable(Long id) {
		return activeAction(id, false);
	}

	private TopicVo activeAction(Long id, boolean active) {
		try {
			Optional<Topic> findFilter = getRepository().findById(id);
			if (findFilter.isPresent()) {
				Topic filter = findFilter.get(); 
				filter.setActive(active);
				logger.info(filter.generateLog("activeAction"));
				return TopicVo.createVo(getRepository().save(filter));			
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo activeAction del filtro: Tematica");
			return null;
		}
	}
	
	@Override
	public TopicVo store(TopicVo filterVo) {
		try {
			Topic filter = new Topic(filterVo);
			filter = getRepository().save(filter);
			logger.info(filter.generateLog("store"));
			return TopicVo.createVo(filter);
		} catch (Exception e) {
			logger.error("Error en metodo store del filtro: Tematica");
			return null;
		}	
	}

	@Override
	public TopicVo rename(TopicVo filterVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TopicVo findByName(String name) {
		try {
			Optional<Topic> findFilter = getRepository().findByName(name);
			return (findFilter.isPresent() ? TopicVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findByName del filtro: Tematica");
			return null;
		}
	}

	@Override
	public TopicVo findById(Long id) {
		try {
			Optional<Topic> findFilter = getRepository().findById(id);
			return (findFilter.isPresent() ? TopicVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findById del filtro: Tematica");
			return null;
		}
	}

	@Override
	public List<GenericFilterVo> getAll(PaginationVo pagination) {
		try {
			PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());	
			Page<Topic> filters = getRepository().findAll(pageRequest);
			return TopicVo.createListVo(filters.getContent());
		} catch (Exception e) {
			logger.error("Error en metodo getAll del filtro: Tematica");
			return null;
		}
	}
	
}
