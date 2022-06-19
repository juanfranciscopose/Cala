package com.cala.repository.filters;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.filters.TypeParticipation;

@Repository
public interface TypeParticipationFilterRepository extends JpaRepository<TypeParticipation, Long>{
	public Optional<TypeParticipation> findByName(String name);
	public Page<TypeParticipation> findAll(Pageable pageable);
	public Optional<TypeParticipation> findByCode(String code);
}
