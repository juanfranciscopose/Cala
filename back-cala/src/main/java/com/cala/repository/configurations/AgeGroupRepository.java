package com.cala.repository.configurations;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.configurations.AgeGroup;

@Repository
public interface AgeGroupRepository extends JpaRepository<AgeGroup, Long>{
	public Optional<AgeGroup> findByName(String name);
	public Page<AgeGroup> findAll(Pageable pageable);
}