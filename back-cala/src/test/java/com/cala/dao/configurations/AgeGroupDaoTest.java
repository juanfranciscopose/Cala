package com.cala.dao.configurations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cala.model.entities.configurations.AgeGroup;
import com.cala.model.vo.configurations.AgeGroupVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.configurations.AgeGroupRepository;

@SpringBootTest
class AgeGroupDaoTest {
	@Autowired
	private AgeGroupDao dao;
	
	@Autowired
	private AgeGroupRepository repository;
	
	public AgeGroupDao getDao() {
		return dao;
	}
	
	public AgeGroupRepository getRepository() {
		return repository;
	}
	
	@Test
	void testSetAgeGroup() {
		getDao().store(new AgeGroupVo("test", 16, 24,  true));
		AgeGroupVo config = getDao().findByName("test");
		config.setAgeMax(2);
		config.setAgeMin(1);
		config.setName("test1");
		getDao().setAgeGroup(config);
		config = getDao().findByName("test");
		assertNull(config);
		config = getDao().findByName("test1");
		assertNotNull(config);
		config.setAgeMax(24);
		config.setAgeMin(16);
		config.setName("test");
		getDao().setAgeGroup(config);
		config = getDao().findByName("test");
		assertNotNull(config);
		config = getDao().findByName("test1");
		assertNull(config);
		AgeGroup delete = getRepository().findByName("test").get();
		getRepository().delete(delete);
		
	}
	
	@Test
	void testActive() {
		getDao().store(new AgeGroupVo("test", 16, 24,  true));
		
		AgeGroupVo config = getDao().findByName("test");
		getDao().disable(config.getId());
		config = getDao().findByName("test");
		assertFalse(config.isActive());
		
		getDao().enable(config.getId());
		config = getDao().findByName("test");
		assertTrue(config.isActive());
		
		AgeGroup c = getRepository().findByName("test").get();
		getRepository().delete(c);
	}
	
	@Test
	void testGetAll() {
		getDao().store(new AgeGroupVo("test", 16, 24,  true));
		getDao().store(new AgeGroupVo("test1", 25, 28,  true));
		getDao().store(new AgeGroupVo("test2", 29, 35,  true));
		getDao().store(new AgeGroupVo("test3", 36, 40,  true));
		getDao().store(new AgeGroupVo("test4", 41, 50,  true));
		getDao().store(new AgeGroupVo("test5", 51, 52,  true));
		getDao().store(new AgeGroupVo("test6", 53, 60,  true));
		getDao().store(new AgeGroupVo("test7", 61, 65,  true));
		getDao().store(new AgeGroupVo("test8", 66, 70,  true));
		getDao().store(new AgeGroupVo("test9", 71, 75,  true));
		getDao().store(new AgeGroupVo("test10", 76, 100,  true));
		
		//first case
		PaginationVo pagination = new PaginationVo(0, 10);
		List<AgeGroupVo> list = getDao().getAll(pagination);
		assertEquals(10, list.size());
		pagination.setPage(1);
		list = getDao().getAll(pagination);
		assertEquals(1, list.size());
		
		//second case
		pagination.setPage(0);
		pagination.setSize(5);
		list = getDao().getAll(pagination);
		assertEquals(5, list.size());
		pagination.setPage(1);
		list = getDao().getAll(pagination);
		assertEquals(5, list.size());
		pagination.setPage(2);
		list = getDao().getAll(pagination);
		assertEquals(1, list.size());
		
		//remove all
		AgeGroup delete = getRepository().findByName("test").get();
		getRepository().delete(delete);
		delete = getRepository().findByName("test1").get();
		getRepository().delete(delete);
		delete = getRepository().findByName("test2").get();
		getRepository().delete(delete);
		delete = getRepository().findByName("test3").get();
		getRepository().delete(delete);
		delete = getRepository().findByName("test4").get();
		getRepository().delete(delete);
		delete = getRepository().findByName("test5").get();
		getRepository().delete(delete);
		delete = getRepository().findByName("test6").get();
		getRepository().delete(delete);
		delete = getRepository().findByName("test7").get();
		getRepository().delete(delete);
		delete = getRepository().findByName("test8").get();
		getRepository().delete(delete);
		delete = getRepository().findByName("test9").get();
		getRepository().delete(delete);
		delete = getRepository().findByName("test10").get();
		getRepository().delete(delete);
		
	}
	
	@Test
	void testGetById() {
		getRepository().save(new AgeGroup("jovenes", 16, 24,  true));
		AgeGroupVo configVo =  getDao().findByName("jovenes");
		assertNotNull(configVo);	
		AgeGroupVo configVo1 =  getDao().getAgeGroup(configVo.getId());
		assertNotNull(configVo1);
		assertEquals(configVo.getName(), configVo1.getName());
		configVo = getDao().findByName("jovenes");
		getRepository().deleteById(configVo.getId());			
	}

}
