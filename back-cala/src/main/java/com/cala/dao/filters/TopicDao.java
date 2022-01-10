package com.cala.dao.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.FilterDao;
import com.cala.model.entities.filters.Topic;
import com.cala.model.vo.filters.TopicVo;

@Repository
public class TopicDao extends FilterDao<Topic, TopicVo>{

	private static final Logger logger = LoggerFactory.getLogger(TopicDao.class);
	
	@Override
	public TopicVo createVo(Topic filter) {
		return TopicVo.createVo(filter);
	}

	@Override
	public Topic create(TopicVo filterVo) {
		return new Topic(filterVo);
	}

	@Override
	public List<TopicVo> createListVo(List<Topic> list) {
		return TopicVo.createListVo(list);
	}

	@Override
	public void generateLog(Topic filter, String method) {
		logger.info(filter.generateLog(method));
	}

}
