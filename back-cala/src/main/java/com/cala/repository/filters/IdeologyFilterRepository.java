package com.cala.repository.filters;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.filters.Ideology;

@Repository
public interface IdeologyFilterRepository extends JpaRepository<Ideology, Long>{
	public Optional<Ideology> findByName(String name);
	public Page<Ideology> findAll(Pageable pageable);

}
