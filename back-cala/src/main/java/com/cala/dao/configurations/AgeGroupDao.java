package com.cala.dao.configurations;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.cala.dao.configurations.generics.I_AgeGroupDao;
import com.cala.model.entities.configurations.AgeGroup;
import com.cala.model.vo.configurations.AgeGroupVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.configurations.AgeGroupRepository;

@Repository
public class AgeGroupDao implements I_AgeGroupDao{
	
	@Autowired
	private AgeGroupRepository repository;

	Logger logger = LoggerFactory.getLogger(AgeGroupDao.class);
	
	public AgeGroupRepository getRepository() {
		return repository;
	}
	
	@Override
	public AgeGroupVo setAgeGroup(AgeGroupVo c) {
		Optional<AgeGroup> config = getRepository().findById(c.getId());
		if (config.isPresent()) {
			AgeGroup configuration = config.get();
			configuration.setAgeMax(c.getAgeMax());
			configuration.setAgeMin(c.getAgeMin());
			configuration.setName(c.getName());
			configuration = getRepository().save(configuration);
			logger.info(configuration.generateLog("setAgeGroup"));
			return AgeGroupVo.createVo(configuration);
		}
		return null;
	}

	@Override
	public AgeGroupVo findByName(String name) {
		Optional<AgeGroup> config = getRepository().findByName(name);
		return (config.isPresent() ? AgeGroupVo.createVo(config.get()) : null);
	}

	@Override
	public List<AgeGroupVo> getAll(PaginationVo pagination) {
		PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());	
		Page<AgeGroup> list = getRepository().findAll(pageRequest);
		return AgeGroupVo.createListVo(list.getContent());
	}

	@Override
	public AgeGroupVo getAgeGroup(Long id) {
		Optional<AgeGroup> config = getRepository().findById(id);
		return (config.isPresent() ? AgeGroupVo.createVo(config.get()) : null);
	}

	@Override
	public AgeGroupVo store(AgeGroupVo config) {
		AgeGroup configuration = new AgeGroup(config);
		configuration = getRepository().save(configuration);
		logger.info(configuration.generateLog("Store"));
		return AgeGroupVo.createVo(configuration);
	}

	@Override
	public AgeGroupVo enable(Long id) {
		return activeAction(id, true);
	}

	@Override
	public AgeGroupVo disable(Long id) {
		return activeAction(id, false);
	}
	
	private AgeGroupVo activeAction(Long id, boolean active) {
		Optional<AgeGroup> configuration = getRepository().findById(id);
		if (configuration.isPresent()) {
			AgeGroup config = configuration.get();
			config.setActive(active);
			config = getRepository().save(config);
			logger.info(config.generateLog("ActiveAction"));
			return AgeGroupVo.createVo(config);
		}
		return null;
	}

}
