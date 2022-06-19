package com.cala.repository.filters;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.filters.Interest;

@Repository
public interface InterestFilterRepository extends JpaRepository<Interest, Long>{
	public Optional<Interest> findByName(String name);
	public Page<Interest> findAll(Pageable pageable);
	public Optional<Interest> findByCode(String code);
}
