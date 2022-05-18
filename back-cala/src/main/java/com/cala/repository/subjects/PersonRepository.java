package com.cala.repository.subjects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.subjects.Person;

@Repository
public interface PersonRepository extends SubjectRepository<Person>, JpaSpecificationExecutor<Person> {
	public Page<Person> findAllOrderByHighlightDescSurnameAscNameAsc(Pageable pageable);
}