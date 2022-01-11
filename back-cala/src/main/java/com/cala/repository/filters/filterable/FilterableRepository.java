package com.cala.repository.filters.filterable;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cala.model.entities.filters.Gender;

public interface FilterableRepository {
	public Optional<Gender> findByName(String name);
	public Page<Gender> findAll(Pageable pageable);
}
