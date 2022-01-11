package com.cala.dao.filters;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.TypeJob;
import com.cala.model.vo.filters.TypeJobVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.TypeJobFilterRepository;

@Repository
public class TypeJobDao implements I_FilterDao<TypeJobVo>{
	private static final Logger logger = LoggerFactory.getLogger(TypeJobDao.class);
	
	@Autowired
	private TypeJobFilterRepository repository;
	
	public TypeJobFilterRepository getRepository() {
		return repository;
	}
	
	@Override
	public TypeJobVo enable(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeJobVo disable(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeJobVo store(TypeJobVo filterVo) {
		try {
			TypeJob filter = new TypeJob(filterVo);
			filter = getRepository().save(filter);
			logger.info(filter.generateLog("store"));
			return TypeJobVo.createVo(filter);
		} catch (Exception e) {
			logger.error("Error en metodo store del filtro: Tipo Trabajo");
			return null;
		}	
	}

	@Override
	public TypeJobVo rename(TypeJobVo filterVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeJobVo findByName(String name) {
		try {
			Optional<TypeJob> findFilter = getRepository().findByName(name);
			return (findFilter.isPresent() ? TypeJobVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findByName del filtro: Tipo Trabajo");
			return null;
		}
	}

	@Override
	public TypeJobVo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeJobVo> getAll(PaginationVo pagination) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
