package com.cala.dao.filters;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.TypeInstitution;
import com.cala.model.vo.filters.TypeInstitutionVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.TypeInstitutionFilterRepository;

@Repository
public class TypeInstitutionDao implements I_FilterDao<TypeInstitutionVo>{
	
	private static final Logger logger = LoggerFactory.getLogger(TypeInstitutionDao.class);
	
	@Autowired
	private TypeInstitutionFilterRepository repository;
	
	public TypeInstitutionFilterRepository getRepository() {
		return repository;
	}
	
	@Override
	public TypeInstitutionVo enable(Long id) {
		return activeAction(id, true);
	}

	@Override
	public TypeInstitutionVo disable(Long id) {
		return activeAction(id, false);
	}

	private TypeInstitutionVo activeAction(Long id, boolean active) {
		try {
			Optional<TypeInstitution> findFilter = getRepository().findById(id);
			if (findFilter.isPresent()) {
				TypeInstitution filter = findFilter.get(); 
				filter.setActive(active);
				logger.info(filter.generateLog("activeAction"));
				return TypeInstitutionVo.createVo(getRepository().save(filter));			
			}
			return null;
		} catch (Exception e) {
			logger.error("Error en metodo activeAction del filtro: Tipo Institucion");
			return null;
		}
	}
	
	@Override
	public TypeInstitutionVo store(TypeInstitutionVo filterVo) {
		try {
			TypeInstitution filter = new TypeInstitution(filterVo);
			filter = getRepository().save(filter);
			logger.info(filter.generateLog("store"));
			return TypeInstitutionVo.createVo(filter);
		} catch (Exception e) {
			logger.error("Error en metodo store del filtro: Tipo Institucion");
			return null;
		}	
	}

	@Override
	public TypeInstitutionVo rename(TypeInstitutionVo filterVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeInstitutionVo findByName(String name) {
		try {
			Optional<TypeInstitution> findFilter = getRepository().findByName(name);
			return (findFilter.isPresent() ? TypeInstitutionVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findByName del filtro: Tipo Institucion");
			return null;
		}
	}

	@Override
	public TypeInstitutionVo findById(Long id) {
		try {
			Optional<TypeInstitution> findFilter = getRepository().findById(id);
			return (findFilter.isPresent() ? TypeInstitutionVo.createVo(findFilter.get()) : null);
		} catch (Exception e) {
			logger.error("Error en metodo findById del filtro: Tipo Institucion");
			return null;
		}
	}

	@Override
	public List<TypeInstitutionVo> getAll(PaginationVo pagination) {
		// TODO Auto-generated method stub
		return null;
	}

}
