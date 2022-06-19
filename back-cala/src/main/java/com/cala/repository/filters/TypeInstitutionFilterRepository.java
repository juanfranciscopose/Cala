package com.cala.repository.filters;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cala.model.entities.filters.TypeInstitution;

@Repository
public interface TypeInstitutionFilterRepository extends JpaRepository<TypeInstitution, Long>{
	public Optional<TypeInstitution> findByName(String name);
	public Page<TypeInstitution> findAll(Pageable pageable);
	public Optional<TypeInstitution> findByCode(String code);
}
