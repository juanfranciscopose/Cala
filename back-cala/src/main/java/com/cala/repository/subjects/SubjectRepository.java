package com.cala.repository.subjects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.subjects.Subject;

@Repository
public interface SubjectRepository<T extends Subject> extends JpaRepository<T, Long> {

	public Page<T> findByHighlight(boolean highlight, PageRequest pageRequest);
	
}
