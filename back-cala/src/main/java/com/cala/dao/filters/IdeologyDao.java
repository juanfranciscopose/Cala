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
import com.cala.model.entities.filters.Ideology;
import com.cala.model.vo.filters.IdeologyVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.IdeologyFilterRepository;

@Repository
public class IdeologyDao implements I_FilterDao<IdeologyVo>{

	private static final Logger logger = LoggerFactory.getLogger(IdeologyDao.class);

	@Autowired
	private IdeologyFilterRepository repository;
	
	public IdeologyFilterRepository getRepository() {
		return repository;
	}
	
	@Override
	public IdeologyVo enable(Long id) {
		return activeAction(id, true);
	}

	@Override
	public IdeologyVo disable(Long id) {
		return activeAction(id, false);
	}

	private IdeologyVo activeAction(Long id, boolean active) {
		try {
			Optional<Ideology> findFilter = getRepository().findById(id);
			if (findFilter.isPresent()) {
				Ideology filter = findFilter.get(); 
				filter.setActive(active);
				logger.info(filter.generateLog("activeAction"));
				return IdeologyVo.createVo(getRepository().save(filter));			
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo activeAction del filtro: Ideologia");
			return null;
		}
	}
	
	@Override
	public IdeologyVo store(IdeologyVo filterVo) {
		try {
			Ideology filter = new Ideology(filterVo);
			filter = getRepository().save(filter);
			logger.info(filter.generateLog("store"));
			return IdeologyVo.createVo(filter);
		} catch (Exception e) {
			logger.error("Error en metodo store del filtro: Ideologia");
			return null;
		}	
	}

	@Override
	public IdeologyVo rename(IdeologyVo filterVo) {
		try {
			Optional<Ideology> findFilter = getRepository().findById(filterVo.getId());
			if (findFilter.isPresent()) {
				Ideology filter = findFilter.get();
				filter.setName(filterVo.getName());
				logger.info(filter.generateLog("rename"));
				return IdeologyVo.createVo(getRepository().save(filter));
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo rename del filtro: Ideologia");
			return null;
		}
	}

	@Override
	public IdeologyVo findByName(String name) {
		try {
			Optional<Ideology> findFilter = getRepository().findByName(name);
			return (findFilter.isPresent() ? IdeologyVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findByName del filtro: Ideologia");
			return null;
		}
	}

	@Override
	public IdeologyVo findById(Long id) {
		try {
			Optional<Ideology> findFilter = getRepository().findById(id);
			return (findFilter.isPresent() ? IdeologyVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findById del filtro: Ideologia");
			return null;
		}
	}

	@Override
	public List<GenericFilterVo> getAll(PaginationVo pagination) {
		try {
			PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());	
			Page<Ideology> filters = getRepository().findAll(pageRequest);
			return IdeologyVo.createListVo(filters.getContent());
		} catch (Exception e) {
			logger.error("Error en metodo getAll del filtro: Ideologia");
			return null;
		}
	}
	
}
