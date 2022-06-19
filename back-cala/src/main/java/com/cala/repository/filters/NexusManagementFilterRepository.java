package com.cala.repository.filters;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.filters.NexusManagement;

@Repository
public interface NexusManagementFilterRepository extends JpaRepository<NexusManagement, Long>{
	public Optional<NexusManagement> findByName(String name);
	public Page<NexusManagement> findAll(Pageable pageable);
	public Optional<NexusManagement> findByCode(String code);
}
