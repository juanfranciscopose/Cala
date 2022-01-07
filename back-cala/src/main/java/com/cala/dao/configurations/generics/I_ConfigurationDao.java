package com.cala.dao.configurations.generics;

import java.util.List;

import com.cala.model.vo.configurations.ConfigurationVo;
import com.cala.model.vo.pagination.PaginationVo;

public interface I_ConfigurationDao {
	public ConfigurationVo setValue(String name, String value);
	public ConfigurationVo findByName(String name);
	public List<ConfigurationVo> getAll(PaginationVo pagination);
	public ConfigurationVo getConfiguration(Long id);
}
