package com.cala.dao.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.FilterDao;
import com.cala.model.entities.filters.TypeParticipation;
import com.cala.model.vo.filters.TypeParticipationVo;

@Repository
public class TypeParticipationDao extends FilterDao<TypeParticipation, TypeParticipationVo>{
	
	Logger logger = LoggerFactory.getLogger(TypeParticipationDao.class);
	
	@Override
	public TypeParticipationVo createVo(TypeParticipation filter) {
		return TypeParticipationVo.createVo(filter);
	}

	@Override
	public TypeParticipation create(TypeParticipationVo filterVo) {
		return new TypeParticipation(filterVo);
	}

	@Override
	public List<TypeParticipationVo> createListVo(List<TypeParticipation> list) {
		return TypeParticipationVo.createListVo(list);
	}

	@Override
	public void generateLog(TypeParticipation filter, String method) {
		logger.info(filter.generateLog(method));
	}

}
