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
import com.cala.model.entities.filters.Gender;
import com.cala.model.vo.filters.GenderVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.GenderFilterRepository;

@Repository
public class GenderDao implements I_FilterDao<GenderVo>{

	private static final Logger logger = LoggerFactory.getLogger(GenderDao.class);
	

	@Autowired
	private GenderFilterRepository repository;
	
	public GenderFilterRepository getRepository() {
		return repository;
	}
	
	@Override
	public GenderVo enable(Long id) {
		return activeAction(id, true);
	}

	@Override
	public GenderVo disable(Long id) {
		return activeAction(id, false);
	}
	
	private GenderVo activeAction(Long id, boolean active) {
		try {
			Optional<Gender> findFilter = getRepository().findById(id);
			if (findFilter.isPresent()) {
				Gender filter = findFilter.get(); 
				filter.setActive(active);
				logger.info(filter.generateLog("activeAction"));
				return GenderVo.createVo(getRepository().save(filter));			
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo activeAction del filtro: Genero");
			return null;
		}
	}
	
	@Override
	public GenderVo store(GenderVo filterVo) {
		try {
			Gender filter = new Gender(filterVo);
			filter = getRepository().save(filter);
			logger.info(filter.generateLog("store"));
			return GenderVo.createVo(filter);
		} catch (Exception e) {
			logger.error("Error en metodo store del filtro: Genero");
			return null;
		}	
	}

	@Override
	public GenderVo rename(GenderVo filterVo) {
		try {
			Optional<Gender> findFilter = getRepository().findById(filterVo.getId());
			if (findFilter.isPresent()) {
				Gender filter = findFilter.get();
				filter.setName(filterVo.getName());
				logger.info(filter.generateLog("rename"));
				return GenderVo.createVo(getRepository().save(filter));
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo rename del filtro: Genero");
			return null;
		}
	}

	@Override
	public GenderVo findByName(String name) {
		try {
			Optional<Gender> findFilter = getRepository().findByName(name);
			return (findFilter.isPresent() ? GenderVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findByName del filtro: Genero");
			return null;
		}
	}

	@Override
	public GenderVo findById(Long id) {
		try {
			Optional<Gender> findFilter = getRepository().findById(id);
			return (findFilter.isPresent() ? GenderVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findById del filtro: Genero");
			return null;
		}
	}

	@Override
	public List<GenericFilterVo> getAll(PaginationVo pagination) {
		try {
			PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());	
			Page<Gender> filters = getRepository().findAll(pageRequest);
			return GenderVo.createListVo(filters.getContent());
		} catch (Exception e) {
			logger.error("Error en metodo getAll del filtro: Genero");
			return null;
		}
	}

	@Override
	public GenderVo findByCode(String code) {
		try {
			Optional<Gender> findFilter = getRepository().findByCode(code);
			return (findFilter.isPresent() ? GenderVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findByCode del filtro: Genero");
			return null;
		}
	}
	
}
