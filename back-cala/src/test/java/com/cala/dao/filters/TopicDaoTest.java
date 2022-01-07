package com.cala.dao.filters;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.model.entities.filters.Topic;
import com.cala.model.vo.filters.TopicVo;

class TopicDaoTest extends FilterDaoTest<TopicDao, Topic, TopicVo>{

	@Override
	public Topic create(String name, boolean active) {
		return new Topic(name, active);
	}

	@Override
	public TopicVo createVo(Topic filter) {
		return TopicVo.createVo(filter);
	}


}
