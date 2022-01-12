package com.cala.repository.filters;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.filters.Gender;

@Repository
public interface GenderFilterRepository extends JpaRepository<Gender, Long>{
	public Optional<Gender> findByName(String name);
	public Page<Gender> findAll(Pageable pageable);
}
