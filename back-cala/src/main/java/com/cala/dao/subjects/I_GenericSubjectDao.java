package com.cala.dao.subjects;

import java.util.List;

import com.cala.model.vo.pagination.PaginationVo;
import com.cala.model.vo.subjects.PersonVo;
import com.cala.model.vo.subjects.SubjectVo;

public interface I_GenericSubjectDao<T extends SubjectVo> {
	public List<T> getAllHighlight(PaginationVo pagination);
	public T store(T subject);
	public PersonVo findById(Long id);
}
