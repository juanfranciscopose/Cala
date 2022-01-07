package com.cala.dao.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.FilterDao;
import com.cala.model.entities.filters.Gender;
import com.cala.model.vo.filters.GenderVo;

@Repository
public class GenderDao extends FilterDao<Gender, GenderVo> {

	Logger logger = LoggerFactory.getLogger(GenderDao.class);
	
	@Override
	public GenderVo createVo(Gender filter) {
		return GenderVo.createVo(filter);
	}

	@Override
	public Gender create(GenderVo filterVo) {
		return  new Gender(filterVo);
	}

	@Override
	public List<GenderVo> createListVo(List<Gender> list) {
		return GenderVo.createListVo(list);
	}

	@Override
	public void generateLog(Gender filter, String method) {
		logger.info(filter.generateLog(method));
	}
	
}
