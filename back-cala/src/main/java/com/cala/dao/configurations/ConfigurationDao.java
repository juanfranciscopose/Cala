package com.cala.dao.configurations;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.cala.dao.configurations.generics.I_ConfigurationDao;
import com.cala.model.entities.configurations.Configuration;
import com.cala.model.vo.configurations.ConfigurationVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.configurations.ConfigurationRepository;

@Repository
public class ConfigurationDao implements I_ConfigurationDao{
	@Autowired
	private ConfigurationRepository repository;

	Logger logger = LoggerFactory.getLogger(ConfigurationDao.class);
	
	public ConfigurationRepository getRepository() {
		return repository;
	}

	@Override
	public ConfigurationVo setValue(String name, String value) {
		Optional<Configuration> configuration = getRepository().findByName(name);
		if (configuration.isPresent()) {
			Configuration config = configuration.get();
			config.setValue(value);
			config = getRepository().save(config);
			return ConfigurationVo.createVo(config);
		}
		return null;
	}

	@Override
	public ConfigurationVo findByName(String name) {
		Optional<Configuration> config = getRepository().findByName(name);
		return (config.isPresent() ? ConfigurationVo.createVo(config.get()) : null);
	}

	@Override
	public List<ConfigurationVo> getAll(PaginationVo pagination) {
		PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());	
		Page<Configuration> list = getRepository().findAll(pageRequest);
		return ConfigurationVo.createListVo(list.getContent());
	}

	@Override
	public ConfigurationVo getConfiguration(Long id) {
		Optional<Configuration> config = getRepository().findById(id);
		return (config.isPresent() ? ConfigurationVo.createVo(config.get()) : null);
	}
	
}
