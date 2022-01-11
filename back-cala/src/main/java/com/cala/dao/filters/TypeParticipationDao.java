package com.cala.dao.filters;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.TypeParticipation;
import com.cala.model.vo.filters.TypeParticipationVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.TypeParticipationFilterRepository;

@Repository
public class TypeParticipationDao implements I_FilterDao<TypeParticipationVo>{
	
	private static final Logger logger = LoggerFactory.getLogger(TypeParticipationDao.class);
	
	@Autowired
	private TypeParticipationFilterRepository repository;
	
	public TypeParticipationFilterRepository getRepository() {
		return repository;
	}
	
	@Override
	public TypeParticipationVo enable(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeParticipationVo disable(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeParticipationVo store(TypeParticipationVo filterVo) {
		try {
			TypeParticipation filter = new TypeParticipation(filterVo);
			filter = getRepository().save(filter);
			logger.info(filter.generateLog("store"));
			return TypeParticipationVo.createVo(filter);
		} catch (Exception e) {
			logger.error("Error en metodo store del filtro: Tipo Participacion");
			return null;
		}	
	}

	@Override
	public TypeParticipationVo rename(TypeParticipationVo filterVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeParticipationVo findByName(String name) {
		try {
			Optional<TypeParticipation> findFilter = getRepository().findByName(name);
			return (findFilter.isPresent() ? TypeParticipationVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findByName del filtro: Tipo Participacion");
			return null;
		}
	}

	@Override
	public TypeParticipationVo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeParticipationVo> getAll(PaginationVo pagination) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
