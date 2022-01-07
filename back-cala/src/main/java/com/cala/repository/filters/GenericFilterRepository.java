package com.cala.repository.filters;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.filters.generics.GenericFilter;

@Repository
public interface GenericFilterRepository<T extends GenericFilter> extends JpaRepository<T, Long>{
	public Optional<T> findByName(String name);
	public Page<T> findAll(Pageable pageable);
}
