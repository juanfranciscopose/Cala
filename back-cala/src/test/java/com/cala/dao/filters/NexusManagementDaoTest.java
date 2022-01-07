package com.cala.dao.filters;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.model.entities.filters.NexusManagement;
import com.cala.model.vo.filters.NexusManagementVo;

class NexusManagementDaoTest extends FilterDaoTest<NexusManagementDao, NexusManagement, NexusManagementVo>{

	@Override
	public NexusManagement create(String name, boolean active) {
		return new NexusManagement(name, active);
	}

	@Override
	public NexusManagementVo createVo(NexusManagement filter) {
		return NexusManagementVo.createVo(filter);
	}

}
