package com.cala.dao.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.FilterDao;
import com.cala.model.entities.filters.TypeJob;
import com.cala.model.vo.filters.TypeJobVo;

@Repository
public class TypeJobDao extends FilterDao<TypeJob, TypeJobVo>{

	Logger logger = LoggerFactory.getLogger(TypeJobDao.class);
	
	@Override
	public TypeJobVo createVo(TypeJob filter) {
		return TypeJobVo.createVo(filter);
	}

	@Override
	public TypeJob create(TypeJobVo filterVo) {
		return new TypeJob(filterVo);
	}

	@Override
	public List<TypeJobVo> createListVo(List<TypeJob> list) {
		return TypeJobVo.createListVo(list);
	}

	@Override
	public void generateLog(TypeJob filter, String method) {
		logger.info(filter.generateLog(method));
	}

}
