package com.cala.dao.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.FilterDao;
import com.cala.model.entities.filters.TypeInstitution;
import com.cala.model.vo.filters.TypeInstitutionVo;

@Repository
public class TypeInstitutionDao extends FilterDao<TypeInstitution, TypeInstitutionVo>{
	
	private static final Logger logger = LoggerFactory.getLogger(TypeInstitutionDao.class);
	
	@Override
	public TypeInstitutionVo createVo(TypeInstitution filter) {
		return TypeInstitutionVo.createVo(filter);
	}

	@Override
	public TypeInstitution create(TypeInstitutionVo filterVo) {
		return new TypeInstitution(filterVo);
	}

	@Override
	public List<TypeInstitutionVo> createListVo(List<TypeInstitution> list) {
		return TypeInstitutionVo.createListVo(list);
	}

	@Override
	public void generateLog(TypeInstitution filter, String method) {
		logger.info(filter.generateLog(method));
	}

}
