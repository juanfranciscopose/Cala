package com.cala.repository.filters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.filters.Gender;
import com.cala.repository.filters.filterable.FilterableRepository;

@Repository
public interface GenderFilterRepository extends JpaRepository<Gender, Long>, FilterableRepository{
}
