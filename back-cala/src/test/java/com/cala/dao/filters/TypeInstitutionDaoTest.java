package com.cala.dao.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cala.dao.filters.generics.FilterDaoTest;
import com.cala.dao.filters.generics.I_FilterDao;
import com.cala.model.entities.filters.TypeInstitution;
import com.cala.model.entities.filters.filterable.Filterable;
import com.cala.model.vo.filters.TypeInstitutionVo;
import com.cala.model.vo.filters.generics.GenericFilterVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.filters.TypeInstitutionFilterRepository;

class TypeInstitutionDaoTest extends FilterDaoTest<TypeInstitutionDao, TypeInstitutionVo>{
	@Autowired
	private TypeInstitutionFilterRepository repository;
	
	@Autowired
	private I_FilterDao<TypeInstitutionVo> dao;
	
	@Override
	public TypeInstitution create(String name, boolean active, String code) {
		return new TypeInstitution(name, active, code);
	}

	@Override
	public TypeInstitutionVo createVo(Filterable filter) {
		return TypeInstitutionVo.createVo(filter);
	}

	@Override
	public void delete(Filterable filter) {
		repository.delete((TypeInstitution) filter);
	}

	@Override
	public List<GenericFilterVo> getAll(PaginationVo pagination) {
		return dao.getAll(pagination);
	}

	@Override
	public Filterable findByName(String name) {
		return repository.findByName(name).get();
	}

}
