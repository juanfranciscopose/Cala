package com.cala.dao.filters;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.Interest;
import com.cala.model.vo.filters.InterestVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.InterestFilterRepository;

@Repository
public class InterestDao implements I_FilterDao<InterestVo>{

	private static final Logger logger = LoggerFactory.getLogger(InterestDao.class);

	@Autowired
	private InterestFilterRepository repository;
	
	public InterestFilterRepository getRepository() {
		return repository;
	}
	
	@Override
	public InterestVo enable(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterestVo disable(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterestVo store(InterestVo filterVo) {
		try {
			Interest filter = new Interest(filterVo);
			filter = getRepository().save(filter);
			logger.info(filter.generateLog("store"));
			return InterestVo.createVo(filter);
		} catch (Exception e) {
			logger.error("Error en metodo store del filtro: Interes");
			return null;
		}	
	}

	@Override
	public InterestVo rename(InterestVo filterVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InterestVo findByName(String name) {
		try {
			Optional<Interest> findFilter = getRepository().findByName(name);
			return (findFilter.isPresent() ? InterestVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findByName del filtro: Interes");
			return null;
		}
	}

	@Override
	public InterestVo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InterestVo> getAll(PaginationVo pagination) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
