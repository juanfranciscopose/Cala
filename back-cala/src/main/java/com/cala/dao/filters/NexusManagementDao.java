package com.cala.dao.filters;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.NexusManagement;
import com.cala.model.vo.filters.NexusManagementVo;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NexusManagementVo disable(Long id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NexusManagementVo> getAll(PaginationVo pagination) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
