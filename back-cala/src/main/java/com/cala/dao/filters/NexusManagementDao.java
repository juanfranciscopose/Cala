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
import com.cala.model.entities.filters.NexusManagement;
import com.cala.model.vo.filters.NexusManagementVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.NexusManagementFilterRepository;

@Repository
public class NexusManagementDao implements I_FilterDao<NexusManagementVo>{

	private static final Logger logger = LoggerFactory.getLogger(NexusManagementDao.class);

	@Autowired
	private NexusManagementFilterRepository repository;
	
	public NexusManagementFilterRepository getRepository() {
		return repository;
	}
	
	@Override
	public NexusManagementVo enable(Long id) {
		return activeAction(id, true);
	}

	@Override
	public NexusManagementVo disable(Long id) {
		return activeAction(id, false);
	}

	private NexusManagementVo activeAction(Long id, boolean active) {
		try {
			Optional<NexusManagement> findFilter = getRepository().findById(id);
			if (findFilter.isPresent()) {
				NexusManagement filter = findFilter.get(); 
				filter.setActive(active);
				logger.info(filter.generateLog("activeAction"));
				return NexusManagementVo.createVo(getRepository().save(filter));			
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo activeAction del filtro: Nexo de Gestion");
			return null;
		}
	}
	
	@Override
	public NexusManagementVo store(NexusManagementVo filterVo) {
		try {
			NexusManagement filter = new NexusManagement(filterVo);
			filter = getRepository().save(filter);
			logger.info(filter.generateLog("store"));
			return NexusManagementVo.createVo(filter);
		} catch (Exception e) {
			logger.error("Error en metodo store del filtro: Nexo de Gestion");
			return null;
		}	
	}

	@Override
	public NexusManagementVo rename(NexusManagementVo filterVo) {
		try {
			Optional<NexusManagement> findFilter = getRepository().findById(filterVo.getId());
			if (findFilter.isPresent()) {
				NexusManagement filter = findFilter.get();
				filter.setName(filterVo.getName());
				logger.info(filter.generateLog("rename"));
				return NexusManagementVo.createVo(getRepository().save(filter));
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo findByName del filtro: Nexo de Gestion");
			return null;
		}
	}

	@Override
	public NexusManagementVo findByName(String name) {
		try {
			Optional<NexusManagement> findFilter = getRepository().findByName(name);
			return (findFilter.isPresent() ? NexusManagementVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findByName del filtro: Nexo de Gestion");
			return null;
		}
	}

	@Override
	public NexusManagementVo findById(Long id) {
		try {
			Optional<NexusManagement> findFilter = getRepository().findById(id);
			return (findFilter.isPresent() ? NexusManagementVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findById del filtro: Nexo de Gestion");
			return null;
		}
	}

	@Override
	public List<GenericFilterVo> getAll(PaginationVo pagination) {
		try {
			PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());	
			Page<NexusManagement> filters = getRepository().findAll(pageRequest);
			return NexusManagementVo.createListVo(filters.getContent());
		} catch (Exception e) {
			logger.error("Error en metodo getAll del filtro: Nexo de Gestion");
			return null;
		}
	}
	
}
