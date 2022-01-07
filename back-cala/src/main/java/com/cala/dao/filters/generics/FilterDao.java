package com.cala.dao.filters.generics;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cala.model.entities.filters.generics.GenericFilter;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.GenericFilterRepository;

public abstract class FilterDao
	<T extends GenericFilter,
	K extends GenericFilterVo>
	implements I_GenericFilterVoDao<K>{
	
	public abstract K createVo(T filter);
	public abstract T create(K filterVo);
	public abstract List<K> createListVo(List<T> list);
	public abstract void generateLog(T filter, String method);
	
	@Autowired
	private GenericFilterRepository<T> repository;
	
	public GenericFilterRepository<T> getRepository() {
		return repository;
	}
	
	@Override
	public K findById(Long id) {
		Optional<T> findFilter = getRepository().findById(id);
		return (findFilter.isPresent() ? createVo(findFilter.get()) : null);
	}
	
	@Override
	public K enable(Long id) {
		return activeAction(id, true);
	}
	
	@Override
	public K disable(Long id) {
		return activeAction(id, false);
	}

	@Override
	public K store(K filterVo) {
		T filter = create(filterVo);
		getRepository().save(filter);
		generateLog(filter, "Store");
		return createVo(filter);
	}

	@Override
	public K rename(K filterVo) {
		Optional<T> findFilter = getRepository().findById(filterVo.getId());
		if (findFilter.isPresent()) {
			T filter = findFilter.get();
			filter.setName(filterVo.getName());
			generateLog(filter, "Rename");
			return createVo(getRepository().save(filter));
		}
		return null;
	}

	@Override
	public K findByName(String name) {
		Optional<T> findFilter = getRepository().findByName(name);
		return (findFilter.isPresent() ? createVo(findFilter.get()) : null);	
	}

	@Override
	public List<K> getAll(PaginationVo pagination) {
		PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize());	
		Page<T> filters = getRepository().findAll(pageRequest);
		return createListVo(filters.getContent());
	}
	
	private K activeAction(Long id, boolean active) {
		Optional<T> findFilter = getRepository().findById(id);
		if (findFilter.isPresent()) {
			T filter = findFilter.get(); 
			filter.setActive(active);
			generateLog(filter, "ActiveAction");
			return createVo(getRepository().save(filter));			
		}
		return null;
	}
	
}
