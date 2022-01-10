package com.cala.dao.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.FilterDao;
import com.cala.model.entities.filters.Ideology;
import com.cala.model.vo.filters.IdeologyVo;

@Repository
public class IdeologyDao extends FilterDao<Ideology, IdeologyVo> {

	private static final Logger logger = LoggerFactory.getLogger(IdeologyDao.class);
	
	@Override
	public IdeologyVo createVo(Ideology filter) {
		return IdeologyVo.createVo(filter);
	}

	@Override
	public Ideology create(IdeologyVo filterVo) {
		return new Ideology(filterVo);
	}

	@Override
	public List<IdeologyVo> createListVo(List<Ideology> list) {
		return IdeologyVo.createListVo(list);
	}

	@Override
	public void generateLog(Ideology filter, String method) {
		logger.info(filter.generateLog(method));
	}

	
}
