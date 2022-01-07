package com.cala.dao.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cala.dao.filters.generics.FilterDao;
import com.cala.model.entities.filters.NexusManagement;
import com.cala.model.vo.filters.NexusManagementVo;

@Repository
public class NexusManagementDao extends FilterDao<NexusManagement, NexusManagementVo> {

	Logger logger = LoggerFactory.getLogger(NexusManagementDao.class);
	
	@Override
	public NexusManagementVo createVo(NexusManagement filter) {
		return NexusManagementVo.createVo(filter);
	}

	@Override
	public NexusManagement create(NexusManagementVo filterVo) {
		return new NexusManagement(filterVo);
	}

	@Override
	public List<NexusManagementVo> createListVo(List<NexusManagement> list) {
		return NexusManagementVo.createListVo(list);
	}

	@Override
	public void generateLog(NexusManagement filter, String method) {
		logger.info(filter.generateLog(method));
	}

}
