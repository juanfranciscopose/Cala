package com.cala.repository.filters;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.filters.Topic;

@Repository
public interface TopicFilterRepository extends JpaRepository<Topic, Long>{
	public Optional<Topic> findByName(String name);
	public Page<Topic> findAll(Pageable pageable);
	public Optional<Topic> findByCode(String code);
}
