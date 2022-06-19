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
import com.cala.model.entities.filters.TypeParticipation;
import com.cala.model.vo.filters.TypeParticipationVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
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
		return activeAction(id, true);
	}

	@Override
	public TypeParticipationVo disable(Long id) {
		return activeAction(id, false);
	}

	private TypeParticipationVo activeAction(Long id, boolean active) {
		try {
			Optional<TypeParticipation> findFilter = getRepository().findById(id);
			if (findFilter.isPresent()) {
				TypeParticipation filter = findFilter.get(); 
				filter.setActive(active);
				logger.info(filter.generateLog("activeAction"));
				return TypeParticipationVo.createVo(getRepository().save(filter));			
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo activeAction del filtro: Tipo Participacion");
			return null;
		}
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
		try {
			Optional<TypeParticipation> findFilter = getRepository().findById(filterVo.getId());
			if (findFilter.isPresent()) {
				TypeParticipation filter = findFilter.get();
				filter.setName(filterVo.getName());
				logger.info(filter.generateLog("rename"));
				return TypeParticipationVo.createVo(getRepository().save(filter));
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo rename del filtro: Tipo Participacion");
			return null;
		}
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
		try {
			Optional<TypeParticipation> findFilter = getRepository().findById(id);
			return (findFilter.isPresent() ? TypeParticipationVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findById del filtro: Tipo Participacion");
			return null;
		}
	}

	@Override
	public List<GenericFilterVo> getAll(PaginationVo pagination) {
		try {
			PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());	
			Page<TypeParticipation> filters = getRepository().findAll(pageRequest);
			return TypeParticipationVo.createListVo(filters.getContent());
		} catch (Exception e) {
			logger.error("Error en metodo getAll del filtro: Tipo Participacion");
			return null;
		}
	}

	@Override
	public TypeParticipationVo findByCode(String code) {
		try {
			Optional<TypeParticipation> findFilter = getRepository().findByCode(code);
			return (findFilter.isPresent() ? TypeParticipationVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findByCode del filtro: Tipo Participacion");
			return null;
		}
	}
	
	
}
