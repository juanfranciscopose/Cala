package com.cala.dao.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.FilterDao;
import com.cala.model.entities.filters.Interest;
import com.cala.model.vo.filters.InterestVo;

@Repository
public class InterestDao extends FilterDao<Interest, InterestVo>{

	private static final Logger logger = LoggerFactory.getLogger(InterestDao.class);
	
	@Override
	public InterestVo createVo(Interest filter) {
		return InterestVo.createVo(filter);
	}

	@Override
	public Interest create(InterestVo filterVo) {
		return new Interest(filterVo);
	}

	@Override
	public List<InterestVo> createListVo(List<Interest> list) {
		return InterestVo.createListVo(list);
	}

	@Override
	public void generateLog(Interest filter, String method) {
		logger.info(filter.generateLog(method));
	}

}
