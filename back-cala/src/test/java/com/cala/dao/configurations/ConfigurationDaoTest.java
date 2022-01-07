package com.cala.dao.configurations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cala.model.entities.configurations.Configuration;
import com.cala.model.vo.configurations.ConfigurationVo;
import com.cala.model.vo.pagination.PaginationVo;
import com.cala.repository.configurations.ConfigurationRepository;

@SpringBootTest
class ConfigurationDaoTest {
	@Autowired
	private ConfigurationDao dao;
	
	@Autowired
	private ConfigurationRepository repository;
	
	public ConfigurationRepository getRepository() {
		return this.repository;
	}
	
	public ConfigurationDao getDao() {
		return this.dao;
	}
	
	@Test
	void testGetById() {
		getRepository().save(new Configuration("titulo test", "title_main"));
		ConfigurationVo configVo =  getDao().findByName("title_main");
		assertNotNull(configVo);	
		ConfigurationVo configVo1 =  getDao().getConfiguration(configVo.getId());
		assertNotNull(configVo1);
		assertEquals(configVo.getName(), configVo1.getName());
		configVo = getDao().findByName("title_main");
		getRepository().deleteById(configVo.getId());				
	}
	
	@Test
	void testGetAll() {
		getRepository().save(new Configuration("test", "test0"));
		getRepository().save(new Configuration("test", "test1"));
		getRepository().save(new Configuration("test", "test2"));
		getRepository().save(new Configuration("test", "test3"));
		getRepository().save(new Configuration("test", "test4"));
		getRepository().save(new Configuration("test", "test5"));
		getRepository().save(new Configuration("test", "test6"));
		getRepository().save(new Configuration("test", "test7"));
		getRepository().save(new Configuration("test", "test8"));
		getRepository().save(new Configuration("test", "test9"));
		getRepository().save(new Configuration("test", "test10"));
		
		//first case
		PaginationVo pagination = new PaginationVo(0, 10);
		List<ConfigurationVo> list = getDao().getAll(pagination);
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
		Configuration config = getRepository().findByName("test0").get();
		getRepository().delete(config);
		config = getRepository().findByName("test1").get();
		getRepository().delete(config);
		config = getRepository().findByName("test2").get();
		getRepository().delete(config);
		config = getRepository().findByName("test3").get();
		getRepository().delete(config);
		config = getRepository().findByName("test4").get();
		getRepository().delete(config);
		config = getRepository().findByName("test5").get();
		getRepository().delete(config);
		config = getRepository().findByName("test6").get();
		getRepository().delete(config);
		config = getRepository().findByName("test7").get();
		getRepository().delete(config);
		config = getRepository().findByName("test8").get();
		getRepository().delete(config);
		config = getRepository().findByName("test9").get();
		getRepository().delete(config);
		config = getRepository().findByName("test10").get();
		getRepository().delete(config);
	}
	
	@Test
	void testSetValue() {
		getRepository().save(new Configuration("titulo test", "title_main"));
		ConfigurationVo configVo =  getDao().findByName("title_main");
		assertNotNull(configVo);
		
		getDao().setValue("title_main", "test titulo");
		configVo = getDao().findByName("title_main");
		assertEquals(configVo.getValue(), "test titulo");
		assertNotEquals(configVo.getValue(), "titulo test");
		
		getDao().setValue("title_main", "titulo test");
		configVo = getDao().findByName("title_main");
		assertEquals(configVo.getValue(), "titulo test");
		assertNotEquals(configVo.getValue(), "test titulo");
		
		configVo = getDao().findByName("title_main");
		getRepository().deleteById(configVo.getId());		
	}

}
