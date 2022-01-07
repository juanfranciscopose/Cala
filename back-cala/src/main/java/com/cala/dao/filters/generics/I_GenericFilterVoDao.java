package com.cala.dao.filters.generics;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;

@Repository
public interface I_GenericFilterVoDao<T extends GenericFilterVo> {
	public T enable(Long id);
	public T disable(Long id);
	public T store(T filterVo);
	public T rename(T filterVo);
	public T findByName(String name);
	public T findById(Long id);
	public List<T> getAll(PaginationVo pagination);
}
