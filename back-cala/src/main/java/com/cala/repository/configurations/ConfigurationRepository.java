package com.cala.repository.configurations;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.configurations.Configuration;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long>{
	public Optional<Configuration> findByName(String name);
	public Page<Configuration> findAll(Pageable pageable);

}
