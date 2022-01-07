package com.cala.dao.configurations.generics;

import java.util.List;

import com.cala.model.vo.configurations.AgeGroupVo;
import com.cala.model.vo.pagination.PaginationVo;

public interface I_AgeGroupDao {
	public AgeGroupVo enable(Long id);
	public AgeGroupVo disable(Long id);
	public AgeGroupVo setAgeGroup(AgeGroupVo config);
	public AgeGroupVo findByName(String name);
	public List<AgeGroupVo> getAll(PaginationVo pagination);
	public AgeGroupVo getAgeGroup(Long id);
	public AgeGroupVo store(AgeGroupVo config);
}
