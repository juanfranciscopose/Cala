package com.cala.repository.filters;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.filters.TypeJob;

@Repository
public interface TypeJobFilterRepository extends JpaRepository<TypeJob, Long>{
	public Optional<TypeJob> findByName(String name);
	public Page<TypeJob> findAll(Pageable pageable);
	public Optional<TypeJob> findByCode(String code);
}
